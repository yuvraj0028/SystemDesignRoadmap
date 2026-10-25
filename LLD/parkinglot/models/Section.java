package SystemDesignRoadmap.LLD.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private char sectionId;
    private List<ParkingSlot> parkingSlots;

    public Section(char sectionId) {
        this.sectionId = sectionId;
        this.parkingSlots = new ArrayList<>();
    }

    public char getSectionId() {
        return sectionId;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void addParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlots.add(parkingSlot);
    }
}
