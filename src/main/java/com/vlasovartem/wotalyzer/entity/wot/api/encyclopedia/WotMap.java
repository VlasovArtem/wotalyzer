package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.MainEntity;

/**
 * Created by artemvlasov on 09/10/16.
 * https://developers.wargaming.net/reference/all/wot/encyclopedia/arenas/
 */
public class WotMap extends MainEntity {

    /* WotMap type */
    private String camouflageType;
    /* Short map description */
    private String description;
    /* Localized map name */
    private String nameI18n;


    @Override
    @JsonProperty("arena_id")
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
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
