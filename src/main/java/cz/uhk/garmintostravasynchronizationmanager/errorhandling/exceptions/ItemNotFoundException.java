package cz.uhk.garmintostravasynchronizationmanager.errorhandling.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message){
        super(message);
    }
}
