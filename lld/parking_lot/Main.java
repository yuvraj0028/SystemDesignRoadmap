package SystemDesignRoadmap.lld.parking_lot;

import SystemDesignRoadmap.lld.parking_lot.facade.ParkingLot;
import SystemDesignRoadmap.lld.parking_lot.models.Bike;
import SystemDesignRoadmap.lld.parking_lot.models.Car;
import SystemDesignRoadmap.lld.parking_lot.models.Ticket;

public class Main {
    public static void main(String[] args) {
        try {
            ParkingLot parkingLot = ParkingLot.getInstance();

            Bike bike = new Bike("BIKE-001");
            Ticket bikeTicket = parkingLot.park(bike);
            System.out.println("Bike parked at: " + bikeTicket.getParkingSlot().getSlotId()
                    + " | Mode: " + bikeTicket.getParkingSlot().getSlotMode()
                    + " | bikeCount: " + bikeTicket.getParkingSlot().getBikeCount());

            Car car = new Car("DL01AB1234");
            Ticket carTicket = parkingLot.park(car);
            System.out.println("Car parked at: " + carTicket.getParkingSlot().getSlotId()
                    + " | Mode: " + carTicket.getParkingSlot().getSlotMode());
        } catch (Exception exception) {
            System.out.println("Exception: " + exception.getClass().getSimpleName()
                    + " -> " + exception.getMessage());
        }
    }
}
