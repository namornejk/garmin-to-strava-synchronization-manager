package cz.uhk.garmintostravasynchronizationmanager.model.webhook;

public enum EventType {

    UPDATE("update"),
    DELETE("delete"),
    CREATE("create");

    private final String value;

    EventType(String value) {
        this.value = value;
    }
}