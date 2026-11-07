package SystemDesignRoadmap.lld.parking_lot.models;

import SystemDesignRoadmap.lld.parking_lot.enums.SlotMode;

public class ParkingSlot {
    public static final int MAX_BIKES = 4;

    private final String slotId;
    private final int floorNumber;
    private final char sectionId;
    private final int slotNumber;
    private SlotMode slotMode;
    private int bikeCount;

    public ParkingSlot(int floorNumber, char sectionId, int slotNumber) {
        this.floorNumber = floorNumber;
        this.sectionId = sectionId;
        this.slotNumber = slotNumber;
        this.slotId = String.format("F%d-%c-%02d", floorNumber, sectionId, slotNumber);
        this.bikeCount = 0;
        this.slotMode = SlotMode.FREE;
    }

    public String getSlotId() {
        return slotId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public char getSectionId() {
        return sectionId;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public SlotMode getSlotMode() {
        return slotMode;
    }

    public void setSlotMode(SlotMode slotMode) {
        this.slotMode = slotMode;
    }

    public int getBikeCount() {
        return bikeCount;
    }

    public void setBikeCount(int bikeCount) {
        this.bikeCount = bikeCount;
    }
}
