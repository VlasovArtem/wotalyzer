package com.vlasovartem.wotalyzer.entity.wot.api.tankopedia;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.components.Profile;

/**
 * Created by artemvlasov on 11/10/16.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Module {

    /* Ссылка на изображение */
    private String image;
    /* Идентификатор модуля */
    private int moduleId;
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
    /* default_profile - Базовые технические характеристики модуля. Дополнительное поле. */
    private Profile defaultProfile;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
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
