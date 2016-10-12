package com.vlasovartem.wotalyzer.entity.wot.api.account.player.private_pack;

import java.util.List;
import java.util.Map;

/**
 * Created by artemvlasov on 10/09/16.
 * Группы контактов
 */
public class GroupedContacts {

    /* Заблокированные */
    private List<Long> blocked;
    /* Группы */
    private Map<String, String> groups;
    /* Игнорируемые */
    private List<Long> ignored;
    /* Отключён звук */
    private List<Long> muted;
    /* Не сгруппированные */
    private List<Long> ungrouped;

    public List<Long> getBlocked() {
        return blocked;
    }

    public void setBlocked(List<Long> blocked) {
        this.blocked = blocked;
    }

    public Map<String, String> getGroups() {
        return groups;
    }

    public void setGroups(Map<String, String> groups) {
        this.groups = groups;
    }

    public List<Long> getIgnored() {
        return ignored;
    }

    public void setIgnored(List<Long> ignored) {
        this.ignored = ignored;
    }

    public List<Long> getMuted() {
        return muted;
    }

    public void setMuted(List<Long> muted) {
        this.muted = muted;
    }

    public List<Long> getUngrouped() {
        return ungrouped;
    }

    public void setUngrouped(List<Long> ungrouped) {
        this.ungrouped = ungrouped;
    }
}
