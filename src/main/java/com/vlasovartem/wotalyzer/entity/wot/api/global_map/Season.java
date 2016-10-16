package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import java.util.List;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class Season {

    /* Finishing time */
    private String end;
    /* Season ID */
    private String seasonId;
    /* Season name */
    private String seasonName;
    /* Start time */
    private String start;
    /* Status */
    private String status;
    /* fronts - Fronts. Only season fronts are presented in response. */
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

    public String getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Front> getFronts() {
        return fronts;
    }

    public void setFronts(List<Front> fronts) {
        this.fronts = fronts;
    }
}
