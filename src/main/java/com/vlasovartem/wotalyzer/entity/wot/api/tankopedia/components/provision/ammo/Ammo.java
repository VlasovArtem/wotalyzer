package com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.components.provision.ammo;

import java.util.List;

/**
 * Created by artemvlasov on 13/01/16.
 */
public class Ammo {
    private List<Integer> damage;
    private List<Integer> penetration;
    private String type;

    public List<Integer> getDamage() {
        return damage;
    }

    public void setDamage(List<Integer> damage) {
        this.damage = damage;
    }

    public List<Integer> getPenetration() {
        return penetration;
    }

    public void setPenetration(List<Integer> penetration) {
        this.penetration = penetration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
