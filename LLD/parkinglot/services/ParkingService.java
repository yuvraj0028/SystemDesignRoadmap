package SystemDesignRoadmap.LLD.parkinglot.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import SystemDesignRoadmap.LLD.parkinglot.enums.SlotMode;
import SystemDesignRoadmap.LLD.parkinglot.enums.TicketStatus;
import SystemDesignRoadmap.LLD.parkinglot.enums.VehicleType;
import SystemDesignRoadmap.LLD.parkinglot.exceptions.InvalidTicketException;
import SystemDesignRoadmap.LLD.parkinglot.exceptions.NoSpotAvailableException;
import SystemDesignRoadmap.LLD.parkinglot.facade.ParkingLot;
import SystemDesignRoadmap.LLD.parkinglot.models.ParkingSlot;
import SystemDesignRoadmap.LLD.parkinglot.models.Ticket;
import SystemDesignRoadmap.LLD.parkinglot.models.Vehicle;

public class ParkingService {
    private ParkingLot parkingLot;
    private Map<String, Ticket> activeTicketMap;
    private SpotAllocationService spotAllocationService;
    private FareCalculatorService fareCalculatorService;

    public ParkingService(ParkingLot parkingLot) {
        this.activeTicketMap = new HashMap<>();
        this.parkingLot = parkingLot;
        this.spotAllocationService = new SpotAllocationService();
        this.fareCalculatorService = new FareCalculatorService();
    }

    public Ticket parkVehicle(Vehicle vehicle) throws NoSpotAvailableException {
        // 1. get best available spot
        ParkingSlot bestParkingSlot = spotAllocationService.findBestSlot(vehicle, parkingLot.getFloors());

        // 2. generate Ticket
        String ticketId = UUID.randomUUID().toString();
        LocalDateTime entryTime = LocalDateTime.now();
        Ticket ticket = new Ticket(ticketId, bestParkingSlot, entryTime, vehicle);

        // 3. update slot based on the vehicle type
        if(vehicle.getVehicleType() == VehicleType.CAR) {
            bestParkingSlot.setSlotMode(SlotMode.CAR);
            bestParkingSlot.setBikeCount(0);
        } else if(vehicle.getVehicleType() == VehicleType.BIKE) {
            if(bestParkingSlot.getSlotMode() == SlotMode.FREE) {
                bestParkingSlot.setBikeCount(1);
                bestParkingSlot.setSlotMode(SlotMode.BIKE);
            } else if(bestParkingSlot.getSlotMode() == SlotMode.BIKE && bestParkingSlot.getBikeCount() < 4){
                bestParkingSlot.setBikeCount(bestParkingSlot.getBikeCount() + 1);
            }
        }

        activeTicketMap.put(ticketId, ticket);
        return ticket;
    }

    public long unparkVehicle(String ticketId) throws InvalidTicketException {
        // 1. get and check valid ticket
        Ticket ticket = activeTicketMap.getOrDefault(ticketId, null);
        if(ticket == null) throw new InvalidTicketException("Ticket ID " + ticketId + " is invalid or already used");

        // get details
        Vehicle vehicle = ticket.getVehicle();
        ParkingSlot parkingSlot = ticket.getParkingSlot();
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();

        // calculate the fare
        long fare = fareCalculatorService.calculateFare(entryTime, exitTime);

        // free the slot
        if(vehicle.getVehicleType() == VehicleType.CAR) {
            parkingSlot.setSlotMode(SlotMode.FREE);
            parkingSlot.setBikeCount(0);
        } else if(vehicle.getVehicleType() == VehicleType.BIKE) {
            int currentBikeCount = parkingSlot.getBikeCount();
            currentBikeCount-=1;
            parkingSlot.setBikeCount(currentBikeCount);

            if(currentBikeCount == 0) {
                parkingSlot.setSlotMode(SlotMode.FREE);
            }
        }

        ticket.setExitTime(exitTime);
        ticket.setFare(fare);
        ticket.setTicketStatus(TicketStatus.COMPLETED);

        activeTicketMap.remove(ticketId);

        return fare;
    }

}
