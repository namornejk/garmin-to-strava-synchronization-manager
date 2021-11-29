package cz.uhk.garmintostravasynchronizationmanager.errorhandling.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(){
        super("User session expired, please log in again.");
    }
}
