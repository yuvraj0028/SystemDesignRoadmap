package SystemDesignRoadmap.lld.parking_lot.facade;

import java.util.ArrayList;
import java.util.List;

import SystemDesignRoadmap.lld.parking_lot.exceptions.InvalidTicketException;
import SystemDesignRoadmap.lld.parking_lot.exceptions.NoSpotAvailableException;
import SystemDesignRoadmap.lld.parking_lot.models.Floor;
import SystemDesignRoadmap.lld.parking_lot.models.ParkingSlot;
import SystemDesignRoadmap.lld.parking_lot.models.Section;
import SystemDesignRoadmap.lld.parking_lot.models.Ticket;
import SystemDesignRoadmap.lld.parking_lot.models.Vehicle;
import SystemDesignRoadmap.lld.parking_lot.services.ParkingService;

public class ParkingLot {
    private static final int FLOOR_COUNT = 5;
    private static final int SLOTS_PER_SECTION = 10;
    private static final char[] SECTION_IDS = {'A', 'B', 'C', 'D'};

    private static volatile ParkingLot instance;

    private final List<Floor> floors;
    private final ParkingService parkingService;

    private ParkingLot() {
        floors = new ArrayList<>();
        initializeParkingLot();
        parkingService = new ParkingService(this);
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    private void initializeParkingLot() {
        for (int floorNumber = 1; floorNumber <= FLOOR_COUNT; floorNumber++) {
            Floor floor = new Floor(floorNumber);
            for (char sectionId : SECTION_IDS) {
                Section section = new Section(sectionId);
                for (int slotNumber = 1; slotNumber <= SLOTS_PER_SECTION; slotNumber++) {
                    section.addParkingSlot(new ParkingSlot(floorNumber, sectionId, slotNumber));
                }
                floor.addSection(section);
            }
            floors.add(floor);
        }
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Ticket park(Vehicle vehicle) throws NoSpotAvailableException {
        return parkingService.parkVehicle(vehicle);
    }

    public long unpark(String ticketId) throws InvalidTicketException {
        return parkingService.unparkVehicle(ticketId);
    }
}
