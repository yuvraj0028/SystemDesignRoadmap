package SystemDesignRoadmap.LLD.parkinglot.services;

import java.util.List;

import SystemDesignRoadmap.LLD.parkinglot.enums.SlotMode;
import SystemDesignRoadmap.LLD.parkinglot.enums.VehicleType;
import SystemDesignRoadmap.LLD.parkinglot.exceptions.NoSpotAvailableException;
import SystemDesignRoadmap.LLD.parkinglot.models.Floor;
import SystemDesignRoadmap.LLD.parkinglot.models.ParkingSlot;
import SystemDesignRoadmap.LLD.parkinglot.models.Section;
import SystemDesignRoadmap.LLD.parkinglot.models.Vehicle;

public class SpotAllocationService {
    public ParkingSlot findBestSlot(Vehicle vehicle, List<Floor> floors) throws NoSpotAvailableException {
        for(Floor floor : floors) {
            for(Section section : floor.getSections()) {
                for(ParkingSlot parkingSlot: section.getParkingSlots()) {
                    if(isSlotEligible(parkingSlot, vehicle.getVehicleType())) {
                        return parkingSlot;
                    }
                }
            }
        }

        throw new NoSpotAvailableException("No Spot Available for " + vehicle.getVehicleType() + " [ " + vehicle.getVehicleNumber() + " ] ");
    }

    private boolean isSlotEligible(ParkingSlot slot, VehicleType vehicleType) {
        if (vehicleType == VehicleType.CAR) {
            return slot.getSlotMode() == SlotMode.FREE;
        } else if (vehicleType == VehicleType.BIKE) {

            if (slot.getSlotMode() == SlotMode.FREE) {
                return true;
            }

            if (slot.getSlotMode() == SlotMode.BIKE && slot.getBikeCount() < 4) {
                return true;
            }
        }
        return false;
    } 
}