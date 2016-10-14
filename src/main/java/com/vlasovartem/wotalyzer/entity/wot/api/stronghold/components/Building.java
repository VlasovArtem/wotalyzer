package com.vlasovartem.wotalyzer.entity.wot.api.stronghold.components;

import java.util.List;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class Building {

    /* Number of players attached to the structure */
    private int attachedAccountCount;
    /* List of IDs of players attached to the structure */
    private List<Integer> attachedAccountIds;
    /* Zone name. Value '–-' is used for Command Center only. */
    private String directionName;
    /* Structure level */
    private int level;
    /* Structure type */
    private int type;

    public int getAttachedAccountCount() {
        return attachedAccountCount;
    }

    public void setAttachedAccountCount(int attachedAccountCount) {
        this.attachedAccountCount = attachedAccountCount;
    }

    public List<Integer> getAttachedAccountIds() {
        return attachedAccountIds;
    }

    public void setAttachedAccountIds(List<Integer> attachedAccountIds) {
        this.attachedAccountIds = attachedAccountIds;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
