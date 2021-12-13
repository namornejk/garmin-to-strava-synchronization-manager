package cz.uhk.garmintostravasynchronizationmanager.errorhandling.exceptions;

public class InternalErrorException extends RuntimeException {
    public InternalErrorException(String message) {
        super(message);
    }
}
