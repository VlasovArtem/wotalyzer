package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.provision.equipment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.MainEntityExt;

import java.util.List;

/**
 * Created by artemvlasov on 13/01/16.
 */
public class Gun extends MainEntityExt {
    @JsonProperty("module_id")
    private long id;
    private List<Integer> damage;
    private int level;
    private String nation;
    private List<Integer> piercingPower;
    private int priceCredit;
    private int priceGold;
    private float aimTime;
    private int caliber;
    private float dispersion;
    private float fireRate;
    private int moveDownArc;
    private int moveUpArc;
    private float reloadTime;
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Integer> getDamage() {
        return damage;
    }

    public void setDamage(List<Integer> damage) {
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public List<Integer> getPiercingPower() {
        return piercingPower;
    }

    public void setPiercingPower(List<Integer> piercingPower) {
        this.piercingPower = piercingPower;
    }

    public int getPriceCredit() {
        return priceCredit;
    }

    public void setPriceCredit(int priceCredit) {
        this.priceCredit = priceCredit;
    }

    public int getPriceGold() {
        return priceGold;
    }

    public void setPriceGold(int priceGold) {
        this.priceGold = priceGold;
    }

    public float getAimTime() {
        return aimTime;
    }

    public void setAimTime(float aimTime) {
        this.aimTime = aimTime;
    }

    public int getCaliber() {
        return caliber;
    }

    public void setCaliber(int caliber) {
        this.caliber = caliber;
    }

    public float getDispersion() {
        return dispersion;
    }

    public void setDispersion(float dispersion) {
        this.dispersion = dispersion;
    }

    public float getFireRate() {
        return fireRate;
    }

    public void setFireRate(float fireRate) {
        this.fireRate = fireRate;
    }

    public int getMoveDownArc() {
        return moveDownArc;
    }

    public void setMoveDownArc(int moveDownArc) {
        this.moveDownArc = moveDownArc;
    }

    public int getMoveUpArc() {
        return moveUpArc;
    }

    public void setMoveUpArc(int moveUpArc) {
        this.moveUpArc = moveUpArc;
    }

    public float getReloadTime() {
        return reloadTime;
    }

    public void setReloadTime(float reloadTime) {
        this.reloadTime = reloadTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
