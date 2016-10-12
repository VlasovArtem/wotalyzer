package com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.booster.components;

/**
 * Created by artemvlasov on 10/10/16.
 * Изображения личного резерва
 */
public class Image {

    /* URL к большому изображению */
    private String large;
    /* URL к малому изображению */
    private String small;

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }
}
