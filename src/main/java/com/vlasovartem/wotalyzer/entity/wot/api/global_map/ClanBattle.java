package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import java.time.LocalDateTime;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class ClanBattle {

    /* Attack Type: ground, auction, tournament */
    private String attackType;
    /* Enemy clan ID */
    private int competitorId;
    /* Front ID */
    private String frontId;
    /* Front name */
    private String frontName;
    /* Province ID */
    private String provinceId;
    /* Province name */
    private String provinceName;
    /* Battle date and time */
    private LocalDateTime time;
    /* Battle type: attack or defense */
    private String type;
    /* Vehicle Tier */
    private int vehicleLevel;

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public int getCompetitorId() {
        return competitorId;
    }

    public void setCompetitorId(int competitorId) {
        this.competitorId = competitorId;
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

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVehicleLevel() {
        return vehicleLevel;
    }

    public void setVehicleLevel(int vehicleLevel) {
        this.vehicleLevel = vehicleLevel;
    }
}
