package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.MainEntityExt;

/**
 * Created by artemvlasov on 10/10/16.
 */
public class Provision extends MainEntityExt {

    /* Идентификатор оборудования или снаряжения */
    @JsonProperty("provision_id")
    private long id;
    /* Описание достижения */
    private String description;
    /* Ссылка на изображение */
    private String image;
    /* Стоимость в кредитах */
    private int priceCredit;
    /* Стоимость в золоте */
    private int priceGold;
    /* Тип: снаряжение или оборудование */
    private String type;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPriceCredit() {
        return priceCredit;
    }

    public void setPriceCredit(int priceCredit) {
        this.priceCredit = priceCredit;
    }

    public int getPriceGold() {
        return priceGold;
    }

    public void setPriceGold(int priceGold) {
        this.priceGold = priceGold;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
