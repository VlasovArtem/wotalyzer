package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by artemvlasov on 16/10/2016.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Front {

    /* Average clans rating */
    private int avgClansRating;
    /* Average minimum bid */
    private int avgMinBet;
    /* Average winning bid */
    private int avgWonBet;
    /* Maximum battle duration in minutes */
    private int battleTimeLimit;
    /* Division cost */
    private int divisionCost;
    /* Division daily upkeep costWarning. The field will be disabled. */
    private int divisionWage;
    /* Indicates presence of Fog of War */
    private boolean fogOfWar;
    /* Front ID */
    private String frontId;
    /* Front name */
    private String frontName;
    /* Indicates if a map is active */
    private boolean isActive;
    /* Indicates the map type: regular map or events map */
    private boolean isEvent;
    /* Maximum number of vehicles in division */
    private int maxTanksPerDivision;
    /* Maximum vehicle Tier */
    private int maxVehicleLevel;
    /* Minimum number of vehicles in division */
    private int minTanksPerDivision;
    /* Minimum vehicle Tier */
    private int minVehicleLevel;
    /* Amount of Provinces */
    private int provincesCount;
    /* Indicates if vehicles blocking is active */
    private boolean vehicleFreeze;
    /* Available modules */
    private List<AvailableExtension> availableExtensions;

    private class AvailableExtension {
        /* Cost of modules */
        private int cost;
        /* Localized description of strategic effect */
        private String descriptionStrategic;
        /* Localized description of tactical effect */
        private String descriptionTactical;
        /* Consumable ID */
        private String extensionId;
        /* Localized consumable name */
        private String name;
        /* Modules upkeep cost */
        private int wage;

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public String getDescriptionStrategic() {
            return descriptionStrategic;
        }

        public void setDescriptionStrategic(String descriptionStrategic) {
            this.descriptionStrategic = descriptionStrategic;
        }

        public String getDescriptionTactical() {
            return descriptionTactical;
        }

        public void setDescriptionTactical(String descriptionTactical) {
            this.descriptionTactical = descriptionTactical;
        }

        public String getExtensionId() {
            return extensionId;
        }

        public void setExtensionId(String extensionId) {
            this.extensionId = extensionId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWage() {
            return wage;
        }

        public void setWage(int wage) {
            this.wage = wage;
        }
    }

    public int getAvgClansRating() {
        return avgClansRating;
    }

    public void setAvgClansRating(int avgClansRating) {
        this.avgClansRating = avgClansRating;
    }

    public int getAvgMinBet() {
        return avgMinBet;
    }

    public void setAvgMinBet(int avgMinBet) {
        this.avgMinBet = avgMinBet;
    }

    public int getAvgWonBet() {
        return avgWonBet;
    }

    public void setAvgWonBet(int avgWonBet) {
        this.avgWonBet = avgWonBet;
    }

    public int getBattleTimeLimit() {
        return battleTimeLimit;
    }

    public void setBattleTimeLimit(int battleTimeLimit) {
        this.battleTimeLimit = battleTimeLimit;
    }

    public int getDivisionCost() {
        return divisionCost;
    }

    public void setDivisionCost(int divisionCost) {
        this.divisionCost = divisionCost;
    }

    public int getDivisionWage() {
        return divisionWage;
    }

    public void setDivisionWage(int divisionWage) {
        this.divisionWage = divisionWage;
    }

    public boolean isFogOfWar() {
        return fogOfWar;
    }

    public void setFogOfWar(boolean fogOfWar) {
        this.fogOfWar = fogOfWar;
    }

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isEvent() {
        return isEvent;
    }

    public void setEvent(boolean event) {
        isEvent = event;
    }

    public int getMaxTanksPerDivision() {
        return maxTanksPerDivision;
    }

    public void setMaxTanksPerDivision(int maxTanksPerDivision) {
        this.maxTanksPerDivision = maxTanksPerDivision;
    }

    public int getMaxVehicleLevel() {
        return maxVehicleLevel;
    }

    public void setMaxVehicleLevel(int maxVehicleLevel) {
        this.maxVehicleLevel = maxVehicleLevel;
    }

    public int getMinTanksPerDivision() {
        return minTanksPerDivision;
    }

    public void setMinTanksPerDivision(int minTanksPerDivision) {
        this.minTanksPerDivision = minTanksPerDivision;
    }

    public int getMinVehicleLevel() {
        return minVehicleLevel;
    }

    public void setMinVehicleLevel(int minVehicleLevel) {
        this.minVehicleLevel = minVehicleLevel;
    }

    public int getProvincesCount() {
        return provincesCount;
    }

    public void setProvincesCount(int provincesCount) {
        this.provincesCount = provincesCount;
    }

    public boolean isVehicleFreeze() {
        return vehicleFreeze;
    }

    public void setVehicleFreeze(boolean vehicleFreeze) {
        this.vehicleFreeze = vehicleFreeze;
    }

    public List<AvailableExtension> getAvailableExtensions() {
        return availableExtensions;
    }

    public void setAvailableExtensions(List<AvailableExtension> availableExtensions) {
        this.availableExtensions = availableExtensions;
    }
}
