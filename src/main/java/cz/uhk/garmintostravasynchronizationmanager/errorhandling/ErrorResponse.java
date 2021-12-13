package cz.uhk.garmintostravasynchronizationmanager.errorhandling;

import lombok.Data;

@Data
public class ErrorResponse {

    final String message;
    final int status;
}
