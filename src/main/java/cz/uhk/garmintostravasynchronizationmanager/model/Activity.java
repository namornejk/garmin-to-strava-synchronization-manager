package cz.uhk.garmintostravasynchronizationmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Activity {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    private String name;
    private String description;
    private String type;
    private float distance;
    private int movingTime;
    private String startDateLocal;
    private boolean isPrivate;

    public Activity() {
    }

    public Activity(String name){
        this.id = id;
        this.name = name;
    }

    public Activity(User user, String name){
        this.id = id;
        this.user = user;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getStartDateLocal() {
        return startDateLocal;
    }

    public void setStartDateLocal(String startDateLocal) {
        this.startDateLocal = startDateLocal;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }
}
