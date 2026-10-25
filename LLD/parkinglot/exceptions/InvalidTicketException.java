package SystemDesignRoadmap.LLD.parkinglot.exceptions;

public class InvalidTicketException extends RuntimeException{
    public InvalidTicketException(String message) {
        super(message);
    }
}
