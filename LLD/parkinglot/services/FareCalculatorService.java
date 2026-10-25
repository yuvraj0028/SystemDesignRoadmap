package SystemDesignRoadmap.LLD.parkinglot.services;

import java.time.Duration;
import java.time.LocalDateTime;

public class FareCalculatorService {
    private static final int RATE_PER_HOUR = 20;
    
    public long calculateFare(LocalDateTime entryTime, LocalDateTime exitTime) {
        if(entryTime == null || exitTime == null) return RATE_PER_HOUR;

        Duration duration = Duration.between(entryTime, exitTime);
        long totalMinutes = duration.toMinutes();

        if(totalMinutes <= 0) return RATE_PER_HOUR;

        double hoursDouble = totalMinutes/60.0;
        long billableHours = (long) Math.ceil(hoursDouble);
        return billableHours * RATE_PER_HOUR;
    }
}
