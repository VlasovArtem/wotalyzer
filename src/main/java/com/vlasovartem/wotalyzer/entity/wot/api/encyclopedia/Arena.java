package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by artemvlasov on 09/10/16.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Arena {

    /* Map ID */
    private String arenaId;
    /* Map type */
    private String camouflageType;
    /* Short map description */
    private String description;
    /* Localized map name */
    private String nameI18n;

    public String getArenaId() {
        return arenaId;
    }

    public void setArenaId(String arenaId) {
        this.arenaId = arenaId;
    }

    public String getCamouflageType() {
        return camouflageType;
    }

    public void setCamouflageType(String camouflageType) {
        this.camouflageType = camouflageType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameI18n() {
        return nameI18n;
    }

    public void setNameI18n(String nameI18n) {
        this.nameI18n = nameI18n;
    }
}
