package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.info;

/**
 * Created by artemvlasov on 09/10/16.
 */
public class AchievementSections {

    /*Название раздела наград*/
    private String name;
    /*Порядок раздела наград*/
    private int order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
