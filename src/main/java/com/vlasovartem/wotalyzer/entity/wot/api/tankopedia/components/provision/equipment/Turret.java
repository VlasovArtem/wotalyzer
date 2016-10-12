package com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.components.provision.equipment;

/**
 * Created by artemvlasov on 13/01/16.
 */
public class Turret {

    private int hp;
    private int traverseLeftArc;
    private int traverseRightArc;
    private int traverseSpeed;
    private int viewRange;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getTraverseLeftArc() {
        return traverseLeftArc;
    }

    public void setTraverseLeftArc(int traverseLeftArc) {
        this.traverseLeftArc = traverseLeftArc;
    }

    public int getTraverseRightArc() {
        return traverseRightArc;
    }

    public void setTraverseRightArc(int traverseRightArc) {
        this.traverseRightArc = traverseRightArc;
    }

    public int getTraverseSpeed() {
        return traverseSpeed;
    }

    public void setTraverseSpeed(int traverseSpeed) {
        this.traverseSpeed = traverseSpeed;
    }

    public int getViewRange() {
        return viewRange;
    }

    public void setViewRange(int viewRange) {
        this.viewRange = viewRange;
    }
}
