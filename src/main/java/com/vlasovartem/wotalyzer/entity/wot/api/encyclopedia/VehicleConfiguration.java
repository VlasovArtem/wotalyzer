package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.MainEntity;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.personal_reserve.Images;

/**
 * Created by artemvlasov on 10/10/16.
 * https://developers.wargaming.net/reference/all/wot/encyclopedia/vehicleprofiles/
 */
public class VehicleConfiguration extends MainEntity {

    /* Базовая комплектация */
    private boolean isDefault;
    /* Стоимость в кредитах */
    private int priceCredit;
    /* Идентификатор комплектации техники */
    private String profileId;
    private Images images;

    @Override
    @JsonProperty("tank_id")
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public int getPriceCredit() {
        return priceCredit;
    }

    public void setPriceCredit(int priceCredit) {
        this.priceCredit = priceCredit;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

}
