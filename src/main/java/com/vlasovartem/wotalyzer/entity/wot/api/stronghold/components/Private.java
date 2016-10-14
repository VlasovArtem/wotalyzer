package com.vlasovartem.wotalyzer.entity.wot.api.stronghold.components;

import java.util.List;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class Private {

    /* Total amount of Industrial Resource in the Stronghold */
    private int totalResourceAmount;
    /* Restricted information on structures by unique type keys */
    private List<Building> buildings;
    /* Private data on Defense Period. */
    private Defense defense;
    /* Restricted information on Skirmishes */
    private Skirmish skirmish;

    private class Building {
        /* Amount of Industrial Resource in the structure */
        private int resourceAmount;
        /* Structure type */
        private int type;

        public int getResourceAmount() {
            return resourceAmount;
        }

        public void setResourceAmount(int resourceAmount) {
            this.resourceAmount = resourceAmount;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    private class Defense {
        /* Total amount of Industrial Resource earned during Defense PeriodWarning. The field will be disabled. */
        private int resourceCaptureCount;
        /* Total amount of Industrial Resource lost during Defense PeriodWarning. The field will be disabled. */
        private int resourceLossCount;

        public int getResourceCaptureCount() {
            return resourceCaptureCount;
        }

        public void setResourceCaptureCount(int resourceCaptureCount) {
            this.resourceCaptureCount = resourceCaptureCount;
        }

        public int getResourceLossCount() {
            return resourceLossCount;
        }

        public void setResourceLossCount(int resourceLossCount) {
            this.resourceLossCount = resourceLossCount;
        }
    }

    private class Skirmish {
        /* Number of Skirmishes in Absolute division */
        private int absoluteBattlesCount;
        /* Industrial Resource earned in Skirmishes of Absolute division */
        private int absoluteResourceCapture;
        /* Number of Skirmishes in Champion division */
        private int championBattlesCount;
        /* Industrial Resource earned in Skirmishes of Champion division */
        private int championResourceCapture;
        /* Number of Skirmishes in Medium division */
        private int middleBattlesCount;
        /* Industrial Resource earned in Skirmishes of Medium division */
        private int middleResourceCapture;

        public int getAbsoluteBattlesCount() {
            return absoluteBattlesCount;
        }

        public void setAbsoluteBattlesCount(int absoluteBattlesCount) {
            this.absoluteBattlesCount = absoluteBattlesCount;
        }

        public int getAbsoluteResourceCapture() {
            return absoluteResourceCapture;
        }

        public void setAbsoluteResourceCapture(int absoluteResourceCapture) {
            this.absoluteResourceCapture = absoluteResourceCapture;
        }

        public int getChampionBattlesCount() {
            return championBattlesCount;
        }

        public void setChampionBattlesCount(int championBattlesCount) {
            this.championBattlesCount = championBattlesCount;
        }

        public int getChampionResourceCapture() {
            return championResourceCapture;
        }

        public void setChampionResourceCapture(int championResourceCapture) {
            this.championResourceCapture = championResourceCapture;
        }

        public int getMiddleBattlesCount() {
            return middleBattlesCount;
        }

        public void setMiddleBattlesCount(int middleBattlesCount) {
            this.middleBattlesCount = middleBattlesCount;
        }

        public int getMiddleResourceCapture() {
            return middleResourceCapture;
        }

        public void setMiddleResourceCapture(int middleResourceCapture) {
            this.middleResourceCapture = middleResourceCapture;
        }
    }

}
