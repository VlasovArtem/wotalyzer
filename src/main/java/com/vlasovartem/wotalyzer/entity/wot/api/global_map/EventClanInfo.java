package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vlasovartem.wotalyzer.deserializers.EventClanInfoDeserializer;

import java.util.List;

/**
 * Created by artemvlasov on 15/10/2016.
 * https://developers.wargaming.net/reference/all/wot/globalmap/eventclaninfo/
 */
public class EventClanInfo {
    
    /* events - Clan info by events and Fronts */
    @JsonDeserialize(using = EventClanInfoDeserializer.class)
    private List<Event> events;
    
    private class Event {
        /* Battles fought */
        private int battles;
        /* Event ID */
        private String eventId;
        /* Fame points */
        private int famePoints;
        /* Change of Fame points since last turn calculation */
        private int famePointsSinceTurn;
        /* Front ID */
        private String frontId;
        /* Current rating */
        private int rank;
        /* Rating changes during previous turn */
        private int rankDelta;
        /* Link to Front */
        private String url;
        /* Victories */
        private int wins;

        public int getBattles() {
            return battles;
        }

        public void setBattles(int battles) {
            this.battles = battles;
        }

        public String getEventId() {
            return eventId;
        }

        public void setEventId(String eventId) {
            this.eventId = eventId;
        }

        public int getFamePoints() {
            return famePoints;
        }

        public void setFamePoints(int famePoints) {
            this.famePoints = famePoints;
        }

        public int getFamePointsSinceTurn() {
            return famePointsSinceTurn;
        }

        public void setFamePointsSinceTurn(int famePointsSinceTurn) {
            this.famePointsSinceTurn = famePointsSinceTurn;
        }

        public String getFrontId() {
            return frontId;
        }

        public void setFrontId(String frontId) {
            this.frontId = frontId;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getRankDelta() {
            return rankDelta;
        }

        public void setRankDelta(int rankDelta) {
            this.rankDelta = rankDelta;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWins() {
            return wins;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
