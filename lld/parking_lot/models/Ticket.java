package SystemDesignRoadmap.lld.parking_lot.models;

import java.time.LocalDateTime;

import SystemDesignRoadmap.lld.parking_lot.enums.TicketStatus;

public class Ticket {
    private final String ticketId;
    private final ParkingSlot parkingSlot;
    private final LocalDateTime entryTime;
    private final Vehicle vehicle;

    private TicketStatus ticketStatus;
    private LocalDateTime exitTime;
    private long fare;

    public Ticket(String ticketId, ParkingSlot parkingSlot, LocalDateTime entryTime, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.parkingSlot = parkingSlot;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.ticketStatus = TicketStatus.ACTIVE;
        this.exitTime = null;
        this.fare = 0;
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
}
