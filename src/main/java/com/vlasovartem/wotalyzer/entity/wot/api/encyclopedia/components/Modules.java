package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components;

/**
 * Created by artemvlasov on 13/01/16.
 */
public class Modules {
    private int engineId;
    private int gunId;
    private int radioId;
    private int suspensionId;
    private int turretId;

    public int getEngineId() {
        return engineId;
    }

    public void setEngineId(int engineId) {
        this.engineId = engineId;
    }

    public int getGunId() {
        return gunId;
    }

    public void setGunId(int gunId) {
        this.gunId = gunId;
    }

    public int getRadioId() {
        return radioId;
    }

    public void setRadioId(int radioId) {
        this.radioId = radioId;
    }

    public int getSuspensionId() {
        return suspensionId;
    }

    public void setSuspensionId(int suspensionId) {
        this.suspensionId = suspensionId;
    }

    public int getTurretId() {
        return turretId;
    }

    public void setTurretId(int turretId) {
        this.turretId = turretId;
    }
}
