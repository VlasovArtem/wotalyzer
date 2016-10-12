package com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.booster;

import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.booster.components.Image;
import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.booster.emuns.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by artemvlasov on 10/10/16.
 */
@Component
public class Booster {

    /* Идентификатор личного резерва */
    private int boosterId;
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
    private List<Image> images;

    public int getBoosterId() {
        return boosterId;
    }

    public void setBoosterId(int boosterId) {
        this.boosterId = boosterId;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
