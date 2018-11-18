package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleProfile;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.provision.ammo.Ammo;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.provision.equipment.*;

import java.util.List;

/**
 * Created by artemvlasov on 13/01/16.
 */
public class Profile {
    @JsonUnwrapped
    private VehicleProfile vehicle;
    private List<Ammo> ammo;
    private Armor armor;
    private Engine engine;
    private Gun gun;
    private Modules modules;
    private Radio radio;
    private Suspension suspension;
    private Turret turret;

    public VehicleProfile getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleProfile vehicle) {
        this.vehicle = vehicle;
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
