package cz.uhk.garmintostravasynchronizationmanager.model.enums;

public enum ActivityType {
    RUN("Run"),
    RIDE("Ride"),
    SWIM("Swim"),
    WORKOUT("Workout")
    ;

    private final String activityType;

    private ActivityType(String activityType){
        this.activityType = activityType;
    }

    public static Enum stringToEnum(String activityType){
        switch (activityType){
            case "Run":
                return RUN;
            case "Ride":
                return RIDE;
            case "Swim":
                return SWIM;
            case "Workout":
                return WORKOUT;
            default:
                return RIDE;
        }
    }
}
