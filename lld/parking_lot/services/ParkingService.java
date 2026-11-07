package SystemDesignRoadmap.lld.parking_lot.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import SystemDesignRoadmap.lld.parking_lot.enums.SlotMode;
import SystemDesignRoadmap.lld.parking_lot.enums.TicketStatus;
import SystemDesignRoadmap.lld.parking_lot.enums.VehicleType;
import SystemDesignRoadmap.lld.parking_lot.exceptions.InvalidTicketException;
import SystemDesignRoadmap.lld.parking_lot.exceptions.NoSpotAvailableException;
import SystemDesignRoadmap.lld.parking_lot.facade.ParkingLot;
import SystemDesignRoadmap.lld.parking_lot.models.ParkingSlot;
import SystemDesignRoadmap.lld.parking_lot.models.Ticket;
import SystemDesignRoadmap.lld.parking_lot.models.Vehicle;

public class ParkingService {
    private final ParkingLot parkingLot;
    private final Map<String, Ticket> activeTicketMap;
    private final SpotAllocationService spotAllocationService;
    private final FareCalculatorService fareCalculatorService;

    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.activeTicketMap = new HashMap<>();
        this.spotAllocationService = new SpotAllocationService();
        this.fareCalculatorService = new FareCalculatorService();
    }

    public Ticket parkVehicle(Vehicle vehicle) throws NoSpotAvailableException {
        ParkingSlot parkingSlot = spotAllocationService.findBestSlot(vehicle, parkingLot.getFloors());
        String ticketId = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketId, parkingSlot, LocalDateTime.now(), vehicle);

        occupySlot(parkingSlot, vehicle.getVehicleType());
        activeTicketMap.put(ticketId, ticket);
        return ticket;
    }

    public long unparkVehicle(String ticketId) throws InvalidTicketException {
        Ticket ticket = activeTicketMap.get(ticketId);
        if (ticket == null) {
            throw new InvalidTicketException("Ticket ID " + ticketId + " is invalid or already used");
        }

        LocalDateTime exitTime = LocalDateTime.now();
        long fare = fareCalculatorService.calculateFare(ticket.getEntryTime(), exitTime);

        releaseSlot(ticket.getParkingSlot(), ticket.getVehicle().getVehicleType());

        ticket.setExitTime(exitTime);
        ticket.setFare(fare);
        ticket.setTicketStatus(TicketStatus.COMPLETED);
        activeTicketMap.remove(ticketId);

        return fare;
    }

    private void occupySlot(ParkingSlot parkingSlot, VehicleType vehicleType) {
        if (vehicleType == VehicleType.CAR) {
            parkingSlot.setSlotMode(SlotMode.CAR);
            parkingSlot.setBikeCount(0);
        } else if (vehicleType == VehicleType.BIKE) {
            if (parkingSlot.getSlotMode() == SlotMode.FREE) {
                parkingSlot.setBikeCount(1);
                parkingSlot.setSlotMode(SlotMode.BIKE);
            } else if (parkingSlot.getSlotMode() == SlotMode.BIKE
                    && parkingSlot.getBikeCount() < ParkingSlot.MAX_BIKES) {
                parkingSlot.setBikeCount(parkingSlot.getBikeCount() + 1);
            }
        }
    }

    private void releaseSlot(ParkingSlot parkingSlot, VehicleType vehicleType) {
        if (vehicleType == VehicleType.CAR) {
            parkingSlot.setSlotMode(SlotMode.FREE);
            parkingSlot.setBikeCount(0);
        } else if (vehicleType == VehicleType.BIKE) {
            int remainingBikes = parkingSlot.getBikeCount() - 1;
            parkingSlot.setBikeCount(remainingBikes);
            if (remainingBikes == 0) {
                parkingSlot.setSlotMode(SlotMode.FREE);
            }
        }
    }
}
