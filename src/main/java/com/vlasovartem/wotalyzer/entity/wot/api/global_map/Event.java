package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.EventStatus;

import java.util.List;

/**
 * Created by artemvlasov on 16/10/2016.
 * Events information
 * https://developers.wargaming.net/reference/all/wot/globalmap/events/
 */
public class Event {

    /* Finishing time */
    private String end;
    /* Event ID */
    private String eventId;
    /* Event name */
    private String eventName;
    /* Start time */
    private String start;
    /* Status */
    private EventStatus status;
    /* Fronts. Only event fronts are presented in response. */
    private List<Front> fronts;
    
    private class Front {
        /* Front ID */
        private String frontId;
        /* Front name */
        private String frontName;
        /* Link to Front */
        private String url;

        public String getFrontId() {
            return frontId;
        }

        public void setFrontId(String frontId) {
            this.frontId = frontId;
        }

        public String getFrontName() {
            return frontName;
        }

        public void setFrontName(String frontName) {
            this.frontName = frontName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public List<Front> getFronts() {
        return fronts;
    }

    public void setFronts(List<Front> fronts) {
        this.fronts = fronts;
    }
}
