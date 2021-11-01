package cz.uhk.garmintostravasynchronizationmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Activity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String type;
    private Long athleteId;
    private float distance;
    private int movingTime;

    public Activity() {
    }

    public Activity(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Activity(Long id, String name, String description, String type, Long athleteId, float distance, int movingTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.athleteId = athleteId;
        this.distance = distance;
        this.movingTime = movingTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getMovingTime() {
        return movingTime;
    }

    public void setMovingTime(int movingTime) {
        this.movingTime = movingTime;
    }
}
