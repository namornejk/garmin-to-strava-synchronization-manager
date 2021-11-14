package cz.uhk.garmintostravasynchronizationmanager.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class WebhookEvent {

    @JsonProperty("owner_id")
    final long ownerId;

    @JsonProperty("object_type")
    final String objectType;

    @JsonProperty("aspect_type")
    final String eventType;

    @JsonProperty("object_type")
    final String action;

    @JsonProperty("updated")
    final HashMap<String, String> updates;

    public WebhookEvent(long ownerId, String objectType, String eventType, String action, HashMap<String, String> updates) {
        this.ownerId = ownerId;
        this.objectType = objectType;
        this.eventType = eventType;
        this.action = action;
        this.updates = updates;
    }
}
