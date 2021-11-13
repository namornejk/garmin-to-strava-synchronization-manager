package cz.uhk.garmintostravasynchronizationmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AthleteActivityResponse {

    private double id;

    private String name;
    private double distance;

    @JsonProperty("moving_time")
    private double movingTime;

    @JsonProperty("elapsed_time")
    private double elapsedTime;

    @JsonProperty("private")
    private boolean privateActivity;

    public AthleteActivityResponse(double id, String name, double distance, double movingTime, double elapsedTime, boolean privateActivity) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.movingTime = movingTime;
        this.elapsedTime = elapsedTime;
        this.privateActivity = privateActivity;
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
