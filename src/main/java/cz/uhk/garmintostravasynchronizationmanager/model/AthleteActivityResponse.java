package cz.uhk.garmintostravasynchronizationmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

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

    public AthleteActivityResponse(double id, String name, double distance, double movingTime, double elapsedTime, Date startDate, long uploadId, float totalElevationGain, boolean privateActivity, boolean commute, boolean manual) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.movingTime = movingTime;
        this.elapsedTime = elapsedTime;
        this.startDate = startDate;
        this.uploadId = uploadId;
        this.totalElevationGain = totalElevationGain;
        this.privateActivity = privateActivity;
        this.commute = commute;
        this.manual = manual;
    }

    public AthleteActivityResponse() {
    }

    public double getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getMovingTime() {
        return movingTime;
    }

    public void setMovingTime(double movingTime) {
        this.movingTime = movingTime;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(double elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public boolean isPrivateActivity() {
        return privateActivity;
    }

    public void setPrivateActivity(boolean privateActivity) {
        this.privateActivity = privateActivity;
    }
}
