package com.vlasovartem.wotalyzer.entity.wot.api.account.player.private_pack;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Created by artemvlasov on 10/09/16.
 * private Приватные данные игрока
 */
public class Private {

    /* Общее время в бою до уничтожения в секундах */
    private int battleLifeTime;
    /* Кредиты */
    private int credits;
    /* Свободный опыт */
    private int freeXp;
    /* Идентификаторы аккаунтов друзей игрокаВнимание! Поле будет отключено. */
    private List<Integer> friends;
    /* Техника в Ангаре. Дополнительное поле. */
    private List<Integer> garage;
    /* Золото */
    private int gold;
    /* Показывает, привязан ли аккаунт к номеру мобильного телефона */
    private boolean isBoundToPhone;
    /* Показывает, является ли аккаунт премиум аккаунтом */
    private boolean isPremium;
    /* Миссии */
    private Map<String, PersonalMissionsStatus> personalMissions;
    /* Срок действия премиум аккаунта */
    private LocalDateTime premiumExpiresAt;
    /* Личные резервы. */
    private Boosters boosters;
    /* Группы контактов */
    private GroupedContacts groupedContacts;
    /* Аренда техники */
    private Rented rented;
    /* Ограничения аккаунта */
    private Restrictions restrictions;

    public int getBattleLifeTime() {
        return battleLifeTime;
    }

    public void setBattleLifeTime(int battleLifeTime) {
        this.battleLifeTime = battleLifeTime;
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

    public List<Integer> getFriends() {
        return friends;
    }

    public void setFriends(List<Integer> friends) {
        this.friends = friends;
    }

    public List<Integer> getGarage() {
        return garage;
    }

    public void setGarage(List<Integer> garage) {
        this.garage = garage;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public boolean isBoundToPhone() {
        return isBoundToPhone;
    }

    public void setBoundToPhone(boolean boundToPhone) {
        isBoundToPhone = boundToPhone;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public Map<String, PersonalMissionsStatus> getPersonalMissions() {
        return personalMissions;
    }

    public void setPersonalMissions(Map<String, PersonalMissionsStatus> personalMissions) {
        this.personalMissions = personalMissions;
    }

    public LocalDateTime getPremiumExpiresAt() {
        return premiumExpiresAt;
    }

    public void setPremiumExpiresAt(LocalDateTime premiumExpiresAt) {
        this.premiumExpiresAt = premiumExpiresAt;
    }

    public Boosters getBoosters() {
        return boosters;
    }

    public void setBoosters(Boosters boosters) {
        this.boosters = boosters;
    }

    public GroupedContacts getGroupedContacts() {
        return groupedContacts;
    }

    public void setGroupedContacts(GroupedContacts groupedContacts) {
        this.groupedContacts = groupedContacts;
    }

    public Rented getRented() {
        return rented;
    }

    public void setRented(Rented rented) {
        this.rented = rented;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }
}
