package com.vlasovartem.wotalyzer.entity.wot.api.tankopedia;

/**
 * Created by artemvlasov on 10/10/16.
 */
public class VehicleProfiles {

    /* Базовая комплектация */
    private boolean isDefault;
    /* Стоимость в кредитах */
    private int priceCredit;
    /* Идентификатор комплектации техники */
    private String profileId;
    /* Идентификатор техники */
    private int tankId;

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

    public int getTankId() {
        return tankId;
    }

    public void setTankId(int tankId) {
        this.tankId = tankId;
    }
}
