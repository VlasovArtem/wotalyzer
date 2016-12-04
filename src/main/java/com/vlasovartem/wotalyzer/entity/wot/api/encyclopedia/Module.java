package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.MainEntity;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.Profile;

/**
 * Created by artemvlasov on 11/10/16.
 * https://developers.wargaming.net/reference/all/wot/encyclopedia/modules/
 */
public class Module extends MainEntity {

    /* Ссылка на изображение */
    private String image;
    /* Название модуля */
    private String name;
    /* Нация */
    private String nation;
    /* Стоимость в кредитах */
    private int priceCredit;
    /* Уровень */
    private int tier;
    /* Тип модуля */
    private String type;
    /* Масса (кг) */
    private int weight;
    /* Базовые технические характеристики модуля. Дополнительное поле. */
    private Profile defaultProfile;

    @Override
    @JsonProperty("module_id")
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getPriceCredit() {
        return priceCredit;
    }

    public void setPriceCredit(int priceCredit) {
        this.priceCredit = priceCredit;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Profile getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(Profile defaultProfile) {
        this.defaultProfile = defaultProfile;
    }
}
