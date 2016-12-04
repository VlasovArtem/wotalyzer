package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.MainEntity;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.personal_reserve.Images;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by artemvlasov on 10/10/16.
 * https://developers.wargaming.net/reference/all/wot/encyclopedia/boosters/
 */
@Component
public class PersonalReserve extends MainEntity {

    /* Описание личного резерва */
    private String description;
    /* Время окончания действия личного резерва в формате UTC */
    private LocalDateTime expiresAt;
    /* Флаг автоматической активации личного резерва */
    private boolean isAuto;
    /* Время действия личного резерва */
    private int lifetime;
    /* Название личного резерва */
    private String name;
    /* Ресурс, на который влияет личный резерв. Допустимые значения: credits, experience, crew_experience, free_experience. */
    private Resource resource;
    /* Изображения личного резерва */
    private Images images;

    @Override
    @JsonProperty("booster_id")
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

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public boolean isAuto() {
        return isAuto;
    }

    public void setAuto(boolean auto) {
        isAuto = auto;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}
