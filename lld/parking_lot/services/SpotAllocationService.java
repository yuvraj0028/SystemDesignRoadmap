package SystemDesignRoadmap.lld.parking_lot.services;

import java.util.List;

import SystemDesignRoadmap.lld.parking_lot.enums.SlotMode;
import SystemDesignRoadmap.lld.parking_lot.enums.VehicleType;
import SystemDesignRoadmap.lld.parking_lot.exceptions.NoSpotAvailableException;
import SystemDesignRoadmap.lld.parking_lot.models.Floor;
import SystemDesignRoadmap.lld.parking_lot.models.ParkingSlot;
import SystemDesignRoadmap.lld.parking_lot.models.Section;
import SystemDesignRoadmap.lld.parking_lot.models.Vehicle;

public class SpotAllocationService {
    public ParkingSlot findBestSlot(Vehicle vehicle, List<Floor> floors) throws NoSpotAvailableException {
        for (Floor floor : floors) {
            for (Section section : floor.getSections()) {
                for (ParkingSlot parkingSlot : section.getParkingSlots()) {
                    if (isSlotEligible(parkingSlot, vehicle.getVehicleType())) {
                        return parkingSlot;
                    }
                }
            }
        }

        throw new NoSpotAvailableException(
                "No spot available for " + vehicle.getVehicleType()
                        + " [" + vehicle.getVehicleNumber() + "]");
    }

    private boolean isSlotEligible(ParkingSlot parkingSlot, VehicleType vehicleType) {
        if (vehicleType == VehicleType.CAR) {
            return parkingSlot.getSlotMode() == SlotMode.FREE;
        }
        if (vehicleType == VehicleType.BIKE) {
            return parkingSlot.getSlotMode() == SlotMode.FREE
                    || (parkingSlot.getSlotMode() == SlotMode.BIKE
                            && parkingSlot.getBikeCount() < ParkingSlot.MAX_BIKES);
        }
        return false;
    }
}
