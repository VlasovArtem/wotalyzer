package com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.info;

import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.info.components.AchievementSections;

import java.util.List;
import java.util.Map;

/**
 * Created by artemvlasov on 14/01/16.
 */
public class TankopediaInfo {
    private String gameVersion;
    private int tanksUpdatedAt;
    private Map<String, String> languages;
    private Map<String, String> vehicleTypes;
    private Map<String, String> vehicleNations;
    private Map<String, String> vehicleCrewRoles;
    private List<AchievementSections> achievementSections;

    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

    public int getTanksUpdatedAt() {
        return tanksUpdatedAt;
    }

    public void setTanksUpdatedAt(int tanksUpdatedAt) {
        this.tanksUpdatedAt = tanksUpdatedAt;
    }

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

    public Map<String, String> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(Map<String, String> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public Map<String, String> getVehicleNations() {
        return vehicleNations;
    }

    public void setVehicleNations(Map<String, String> vehicleNations) {
        this.vehicleNations = vehicleNations;
    }

    public Map<String, String> getVehicleCrewRoles() {
        return vehicleCrewRoles;
    }

    public void setVehicleCrewRoles(Map<String, String> vehicleCrewRoles) {
        this.vehicleCrewRoles = vehicleCrewRoles;
    }

    public List<AchievementSections> getAchievementSections() {
        return achievementSections;
    }

    public void setAchievementSections(List<AchievementSections> achievementSections) {
        this.achievementSections = achievementSections;
    }
}
