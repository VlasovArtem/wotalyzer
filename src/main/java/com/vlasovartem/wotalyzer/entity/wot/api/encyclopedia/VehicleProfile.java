package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.MainEntity;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.*;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.provision.ammo.Ammo;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.provision.equipment.*;

import java.util.List;

/**
 * Created by artemvlasov on 13/01/16.
 */
@JsonAutoDetect
public class VehicleProfile extends MainEntity {

    private int hp;
    private int hullHp;
    private int hullWeight;
    @JsonProperty("is_default")
    private boolean isDefault;
    private int maxAmmo;
    private int maxWeight;
    private int speedBackward;
    private int speedForward;
    private int weight;
    private List<Ammo> ammo;
    private Armor armor;
    private Engine engine;
    private Gun gun;
    private Modules modules;
    private Radio radio;
    private Suspension suspension;
    private Turret turret;

    @Override
    @JsonProperty("tank_id")
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHullHp() {
        return hullHp;
    }

    public void setHullHp(int hullHp) {
        this.hullHp = hullHp;
    }

    public int getHullWeight() {
        return hullWeight;
    }

    public void setHullWeight(int hullWeight) {
        this.hullWeight = hullWeight;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public void setMaxAmmo(int maxAmmo) {
        this.maxAmmo = maxAmmo;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getSpeedBackward() {
        return speedBackward;
    }

    public void setSpeedBackward(int speedBackward) {
        this.speedBackward = speedBackward;
    }

    public double getSpeedForward() {
        return speedForward;
    }

    public void setSpeedForward(int speedForward) {
        this.speedForward = speedForward;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Ammo> getAmmo() {
        return ammo;
    }

    public void setAmmo(List<Ammo> ammo) {
        this.ammo = ammo;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public Modules getModules() {
        return modules;
    }

    public void setModules(Modules modules) {
        this.modules = modules;
    }

    public Radio getRadio() {
        return radio;
    }

    public void setRadio(Radio radio) {
        this.radio = radio;
    }

    public Suspension getSuspension() {
        return suspension;
    }

    public void setSuspension(Suspension suspension) {
        this.suspension = suspension;
    }

    public Turret getTurret() {
        return turret;
    }

    public void setTurret(Turret turret) {
        this.turret = turret;
    }

}
