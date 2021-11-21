package cz.uhk.garmintostravasynchronizationmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;

@Data
public class AthleteActivityResponse {

    private double id;

    private String name;
    private double distance;

    @JsonProperty("moving_time")
    private double movingTime;

    @JsonProperty("elapsed_time")
    private double elapsedTime;

    @JsonProperty("start_date")
    private Date startDate;

    @JsonProperty("upload_id")
    private long uploadId;

    @JsonProperty("total_elevation_gain")
    private float totalElevationGain;

    @JsonProperty("private")
    private boolean privateActivity;

    private boolean commute;

    private boolean manual;

}
