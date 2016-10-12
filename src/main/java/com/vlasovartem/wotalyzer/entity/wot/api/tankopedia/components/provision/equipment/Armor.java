package com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.components.provision.equipment;

/**
 * Created by artemvlasov on 13/01/16.
 */
public class Armor {
    private ComponentArmor hull;
    private ComponentArmor turret;

    public ComponentArmor getHull() {
        return hull;
    }

    public void setHull(ComponentArmor hull) {
        this.hull = hull;
    }

    public ComponentArmor getTurret() {
        return turret;
    }

    public void setTurret(ComponentArmor turret) {
        this.turret = turret;
    }
}
