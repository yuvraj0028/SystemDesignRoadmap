package SystemDesignRoadmap.LLD.parkinglot.facade;

import java.util.ArrayList;
import java.util.List;

import SystemDesignRoadmap.LLD.parkinglot.exceptions.InvalidTicketException;
import SystemDesignRoadmap.LLD.parkinglot.exceptions.NoSpotAvailableException;
import SystemDesignRoadmap.LLD.parkinglot.models.Floor;
import SystemDesignRoadmap.LLD.parkinglot.models.ParkingSlot;
import SystemDesignRoadmap.LLD.parkinglot.models.Section;
import SystemDesignRoadmap.LLD.parkinglot.models.Ticket;
import SystemDesignRoadmap.LLD.parkinglot.models.Vehicle;
import SystemDesignRoadmap.LLD.parkinglot.services.ParkingService;

public class ParkingLot {
    private static ParkingLot instance;
    private ParkingService parkingService;
    private List<Floor> floors;

    private ParkingLot() {
        floors = new ArrayList<>();
        initializeParkingLot();
        parkingService = new ParkingService(this);

    }

    public static ParkingLot getInstance() {
        if(instance == null) {
            synchronized (ParkingLot.class) {
                if(instance == null) {
                    instance = new ParkingLot();
                }
            }
        }

        return instance;
    }

    private void initializeParkingLot() {
        for(int floorNumber = 1; floorNumber<=5; floorNumber++) {
            Floor floor = new Floor(floorNumber);
            char []sections = {'A', 'B', 'C', 'D'};
            for(char sectionValue: sections) {
                Section section = new Section(sectionValue);
                for(int slotNumber = 1; slotNumber<=10; slotNumber++) {
                    ParkingSlot parkingSlot = new ParkingSlot(floorNumber, sectionValue, slotNumber);
                    section.addParkingSlot(parkingSlot);
                }
                floor.addSection(section);
            }
            floors.add(floor);
        }
    }

    public List<Floor> getFloors() {
        return this.floors;
    }

    public Ticket park(Vehicle vehicle) throws NoSpotAvailableException {
        return parkingService.parkVehicle(vehicle);
    }

    public long unpark(String ticketId) throws InvalidTicketException {
        return  parkingService.unparkVehicle(ticketId);
    }
}
