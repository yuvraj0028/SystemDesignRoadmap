package SystemDesignRoadmap.LLD.parkinglot.models;

import SystemDesignRoadmap.LLD.parkinglot.enums.SlotMode;

public class ParkingSlot {
    private String slotId;
    private int floorNumber;
    private char sectionId;
    private int slotNumber;
    private SlotMode slotMode;
    private int bikeCount;

    public ParkingSlot(int floorNumber, char sectionId, int slotNumber) {
        this.floorNumber = floorNumber;
        this.sectionId = sectionId;
        this.slotNumber = slotNumber;
        this.slotId = "F" + floorNumber + " - " + sectionId + " - " + String.format("%02d", slotNumber); 
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

    public int getBikeCount() {
        return bikeCount;
    }

    public void setSlotMode(SlotMode slotMode) {
        this.slotMode = slotMode;
    }

    public void setBikeCount(int bikeCount) {
        this.bikeCount = bikeCount;
    }

    
}
