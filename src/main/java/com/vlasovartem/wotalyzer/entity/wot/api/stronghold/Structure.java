package com.vlasovartem.wotalyzer.entity.wot.api.stronghold;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class Structure {

    /* Localized full description */
    private String description;
    /* Image link */
    private String imageUrl;
    /* Localized short description */
    private String shortDescription;
    /* Localized name */
    private String title;
    /* Unique type */
    private int type;
    /* Reserve information */
    private Reserve reserve;
    
    private class Reserve {
        /* Localized description */
        private String description;
        /* Image link */
        private String imageUrl;
        /* Localized name */
        private String title;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
    
}
