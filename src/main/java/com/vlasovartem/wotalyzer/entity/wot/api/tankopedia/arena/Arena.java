package com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.arena;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by artemvlasov on 09/10/16.
 */
public class Arena {

    /*Идентификатор карты*/
    @JsonProperty("arena_id")
    private String id;
    /*Тип карты*/
    private String camouflageType;
    /*Краткое описание карты*/
    private String description;
    /*Локализованное название карты*/
    private String nameI18n;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
