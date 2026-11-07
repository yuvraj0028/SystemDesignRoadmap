package SystemDesignRoadmap.lld.parking_lot.exceptions;

public class NoSpotAvailableException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoSpotAvailableException(String message) {
        super(message);
    }
}
