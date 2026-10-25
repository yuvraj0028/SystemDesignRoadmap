package SystemDesignRoadmap.LLD.parkinglot;

import SystemDesignRoadmap.LLD.parkinglot.facade.ParkingLot;
import SystemDesignRoadmap.LLD.parkinglot.models.Bike;
import SystemDesignRoadmap.LLD.parkinglot.models.Car;
import SystemDesignRoadmap.LLD.parkinglot.models.Ticket;
import SystemDesignRoadmap.LLD.parkinglot.models.Vehicle;

public class Main {
    public static void main(String[] args) {
        try {
            ParkingLot parkingLot = ParkingLot.getInstance();

            // Park 1 bike in F1-A-01
            Bike bike = new Bike("BIKE-001");
            Ticket bikeTicket = parkingLot.park(bike);
            System.out.println("Bike parked at: " + bikeTicket.getParkingSlot().getSlotId() + 
                               " | Mode: " + bikeTicket.getParkingSlot().getSlotMode() + 
                               " | bikeCount: " + bikeTicket.getParkingSlot().getBikeCount());

            // Now park a car -> must skip F1-A-01
            Car car = new Car("DL01AB1234");
            Ticket carTicket = parkingLot.park(car);
            System.out.println("Car parked at: " + carTicket.getParkingSlot().getSlotId() + 
                               " | Mode: " + carTicket.getParkingSlot().getSlotMode());

        } catch (Exception e) {
            System.out.println("Exception: " + e.getClass().getSimpleName() + " -> " + e.getMessage());
        }

    }
}
