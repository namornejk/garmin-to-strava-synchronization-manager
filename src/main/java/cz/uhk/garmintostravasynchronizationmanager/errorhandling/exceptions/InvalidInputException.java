package cz.uhk.garmintostravasynchronizationmanager.errorhandling.exceptions;

public class InvalidInputException extends  RuntimeException {
    public InvalidInputException(String message){
        super(message);
    }
}
