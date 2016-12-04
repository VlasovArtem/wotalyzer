package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.MainEntityExt;

/**
 * Created by artemvlasov on 10/10/16.
 * https://developers.wargaming.net/reference/all/wot/encyclopedia/provisions/
 */
public class Provision extends MainEntityExt {

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

    @Override
    @JsonProperty("provision_id")
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

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
