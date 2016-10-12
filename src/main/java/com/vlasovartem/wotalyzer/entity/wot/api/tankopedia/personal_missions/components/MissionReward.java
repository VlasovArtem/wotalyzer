package com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.personal_missions.components;

import java.util.Map;

/**
 * Created by artemvlasov on 10/10/16.
 */
public class MissionReward {

    /* Места в казарме */
    private int berths;
    /* Условия задачи */
    private String conditions;
    /* Кредиты */
    private int credits;
    /* Свободный опыт */
    private int freeXp;
    /* Список оборудования или расходников в формате идентификатор - количество единиц */
    private Map<String, String> items;
    /* Дни премиум аккаунта */
    private int premium;
    /* Слоты */
    private int slots;
    /* Токены */
    private int tokens;

    public int getBerths() {
        return berths;
    }

    public void setBerths(int berths) {
        this.berths = berths;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getFreeXp() {
        return freeXp;
    }

    public void setFreeXp(int freeXp) {
        this.freeXp = freeXp;
    }

    public Map<String, String> getItems() {
        return items;
    }

    public void setItems(Map<String, String> items) {
        this.items = items;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
}
