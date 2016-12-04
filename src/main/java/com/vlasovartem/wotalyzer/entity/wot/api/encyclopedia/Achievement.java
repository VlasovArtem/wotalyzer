package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by artemvlasov on 07/10/16.
 * https://developers.wargaming.net/reference/all/wot/encyclopedia/achievements/
 */
@Document
public class Achievement {

    /* Условие */
    private String condition;
    /* Описание достижения */
    private String description;
    /* Историческая справка */
    private String heroInfo;
    /* Ссылка на изображение */
    private String image;
    /* Изображение 180x180px */
    private String imageBig;
    /* Название достижения */
    private String name;
    /* Локализованное поле name */
    private String nameI18n;
    /* Порядок сортировки */
    private int order;
    /* Показывает, если достижение устарело и больше не может быть получено */
    private boolean outdated;
    /* Раздел */
    private String section;
    /* Порядок отображения раздела */
    private int sectionOrder;
    /* Тип */
    private String type;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeroInfo() {
        return heroInfo;
    }

    public void setHeroInfo(String heroInfo) {
        this.heroInfo = heroInfo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageBig() {
        return imageBig;
    }

    public void setImageBig(String imageBig) {
        this.imageBig = imageBig;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameI18n() {
        return nameI18n;
    }

    public void setNameI18n(String nameI18n) {
        this.nameI18n = nameI18n;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOutdated() {
        return outdated;
    }

    public void setOutdated(boolean outdated) {
        this.outdated = outdated;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getSectionOrder() {
        return sectionOrder;
    }

    public void setSectionOrder(int sectionOrder) {
        this.sectionOrder = sectionOrder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
