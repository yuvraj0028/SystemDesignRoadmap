package SystemDesignRoadmap.LLD.parkinglot.models;

import java.time.LocalDateTime;

import SystemDesignRoadmap.LLD.parkinglot.enums.TicketStatus;

public class Ticket {
    private String ticketId;
    private TicketStatus ticketStatus;
    private ParkingSlot parkingSlot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Vehicle vehicle;
    private long fare;

    public Ticket
    (
        String ticketId,
        ParkingSlot parkingSlot,
        LocalDateTime entryTime,
        Vehicle vehicle
    ) 
    {
        this.ticketId = ticketId;
        this.ticketStatus = TicketStatus.ACTIVE;
        this.parkingSlot = parkingSlot;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.fare = 0;
        this.exitTime = null;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public long getFare() {
        return fare;
    }

    public void setFare(long fare) {
        this.fare = fare;
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    
}
