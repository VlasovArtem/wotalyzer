package com.vlasovartem.wotalyzer.entity.wot.api.account;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.account.components.private_pack.Private;
import com.vlasovartem.wotalyzer.entity.wot.api.account.components.statistics.Statistics;

import java.time.LocalDateTime;

/**
 * Created by artemvlasov on 07/09/16.
 */
@JsonAutoDetect
public class Player {

    /* Идентификатор аккаунта игрока */
    @JsonProperty("account_id")
    private long id;
    /* Информация о блокировке аккаунта */
    private String banInfo;
    /* Время окончания блокировки аккаунта */
    private LocalDateTime banTime;
    /* Идентификатор клана */
    private long clanId;
    /* Язык, выбранный в клиенте игры */
    private String clientLanguage;
    /* Дата создания аккаунта игрока */
    private LocalDateTime createdAt;
    /* Личный рейтинг */
    private long globalRating;
    /* Время последнего боя */
    private LocalDateTime lastBattleTime;
    /* Время окончания последней игровой сессии */
    private LocalDateTime logoutAt;
    /* Имя игрока */
    private String nickname;
    /* Дата обновления информации об игроке */
    private LocalDateTime updatedAt;
    /* Приватные данные игрока */
    @JsonProperty("private")
    private Private privateData;
    /* Статистика игрока */
    private Statistics statistics;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBanInfo() {
        return banInfo;
    }

    public void setBanInfo(String banInfo) {
        this.banInfo = banInfo;
    }

    public LocalDateTime getBanTime() {
        return banTime;
    }

    public void setBanTime(LocalDateTime banTime) {
        this.banTime = banTime;
    }

    public long getClanId() {
        return clanId;
    }

    public void setClanId(long clanId) {
        this.clanId = clanId;
    }

    public String getClientLanguage() {
        return clientLanguage;
    }

    public void setClientLanguage(String clientLanguage) {
        this.clientLanguage = clientLanguage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public long getGlobalRating() {
        return globalRating;
    }

    public void setGlobalRating(long globalRating) {
        this.globalRating = globalRating;
    }

    public LocalDateTime getLastBattleTime() {
        return lastBattleTime;
    }

    public void setLastBattleTime(LocalDateTime lastBattleTime) {
        this.lastBattleTime = lastBattleTime;
    }

    public LocalDateTime getLogoutAt() {
        return logoutAt;
    }

    public void setLogoutAt(LocalDateTime logoutAt) {
        this.logoutAt = logoutAt;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Private getPrivateData() {
        return privateData;
    }

    public void setPrivateData(Private privateData) {
        this.privateData = privateData;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
}
