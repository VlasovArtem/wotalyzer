package com.vlasovartem.wotalyzer.entity.statistic;

/**
 * Created by artemvlasov on 14/01/16.
 */
public class VehicleModuleComponent {
    private Long turretId;
    private Long gunId;
    private Long radioId;
    private Long engineId;
    private Long suspensionId;

    public Long getTurretId() {
        return turretId;
    }

    public void setTurretId(Long turretId) {
        this.turretId = turretId;
    }

    public Long getGunId() {
        return gunId;
    }

    public void setGunId(Long gunId) {
        this.gunId = gunId;
    }

    public Long getRadioId() {
        return radioId;
    }

    public void setRadioId(Long radioId) {
        this.radioId = radioId;
    }

    public Long getEngineId() {
        return engineId;
    }

    public void setEngineId(Long engineId) {
        this.engineId = engineId;
    }

    public Long getSuspensionId() {
        return suspensionId;
    }

    public void setSuspensionId(Long suspensionId) {
        this.suspensionId = suspensionId;
    }
}
