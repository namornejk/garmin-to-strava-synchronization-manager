package cz.uhk.garmintostravasynchronizationmanager.model.filters;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity
public class FilterDetail {
    
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ActivityFilter activityFilter;

    private String name;
    private boolean isEnabled;

    private int movingTimeFrom;
    private int movingTimeTo;
    private float distanceFrom;
    private float distanceTo;
    private float totalElevationFrom;
    private float totalElevationTo;
    private Timestamp startDateFrom;
    private Timestamp startDateTo;
    private boolean commute;
    private boolean manual;
    private float avgSpeedFrom;
    private float avgSpeedTo;
    private float caloriesFrom;
    private float caloriesTo;

    public ActivityFilter getActivityFilter() {
        return activityFilter;
    }

    public void setActivityFilter(ActivityFilter activityFilter) {
        this.activityFilter = activityFilter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public int getMovingTimeFrom() {
        return movingTimeFrom;
    }

    public void setMovingTimeFrom(int movingTimeFrom) {
        this.movingTimeFrom = movingTimeFrom;
    }

    public int getMovingTimeTo() {
        return movingTimeTo;
    }

    public void setMovingTimeTo(int movingTimeTo) {
        this.movingTimeTo = movingTimeTo;
    }

    public float getDistanceFrom() {
        return distanceFrom;
    }

    public void setDistanceFrom(float distanceFrom) {
        this.distanceFrom = distanceFrom;
    }

    public float getDistanceTo() {
        return distanceTo;
    }

    public void setDistanceTo(float distanceTo) {
        this.distanceTo = distanceTo;
    }

    public float getTotalElevationFrom() {
        return totalElevationFrom;
    }

    public void setTotalElevationFrom(float totalElevationFrom) {
        this.totalElevationFrom = totalElevationFrom;
    }

    public float getTotalElevationTo() {
        return totalElevationTo;
    }

    public void setTotalElevationTo(float totalElevationTo) {
        this.totalElevationTo = totalElevationTo;
    }

    public Timestamp getStartDateFrom() {
        return startDateFrom;
    }

    public void setStartDateFrom(Timestamp startDateFrom) {
        this.startDateFrom = startDateFrom;
    }

    public Timestamp getStartDateTo() {
        return startDateTo;
    }

    public void setStartDateTo(Timestamp startDateTo) {
        this.startDateTo = startDateTo;
    }

    public boolean isCommute() {
        return commute;
    }

    public void setCommute(boolean commute) {
        this.commute = commute;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public float getAvgSpeedFrom() {
        return avgSpeedFrom;
    }

    public void setAvgSpeedFrom(float avgSpeedFrom) {
        this.avgSpeedFrom = avgSpeedFrom;
    }

    public float getAvgSpeedTo() {
        return avgSpeedTo;
    }

    public void setAvgSpeedTo(float avgSpeedTo) {
        this.avgSpeedTo = avgSpeedTo;
    }

    public float getCaloriesFrom() {
        return caloriesFrom;
    }

    public void setCaloriesFrom(float caloriesFrom) {
        this.caloriesFrom = caloriesFrom;
    }

    public float getCaloriesTo() {
        return caloriesTo;
    }

    public void setCaloriesTo(float caloriesTo) {
        this.caloriesTo = caloriesTo;
    }
}
