package com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.components;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.ExcludeReason;
import com.vlasovartem.wotalyzer.entity.wot.api.rating.components.RatingData;

import java.util.Map;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public abstract class BasicClanRating {

    /* Идентификатор клана */
    private int clanId;
    /* Название клана */
    private String clanName;
    /* Тег клана */
    private String clanTag;
    /* exclude_reasons - Причины, по которым не были рассчитаны определённые категории рейтингов. Содержит данные в формате ключ-значение, где ключом является название категории, а значением причина. Возможные причины: inactivity - Неактивность на протяжении 28 дней newbies_measure - В клане меньше десяти игроков limits - Условия ранка не выполнены blocked - Клан заблокирован other - Технические причины */
    private Map<ExcludeReason, String> excludeReasons;
    /* Среднее количество боёв */
    private RatingData battlesCountAvg;
    /* Среднее количество боёв в день */
    private RatingData battlesCountAvgDaily;
    /* Показатель клановой эффективности */
    private RatingData efficiency;
    /* Эло-рейтинг клана в Битвах за Укрепрайон */
    private RatingData fbEloRating;
    /* Эло-рейтинг клана в Битвах за Укрепрайон в абсолютном дивизионе */
    private RatingData fbEloRating10;
    /* Эло-рейтинг клана в Битвах за Укрепрайон в чемпионском дивизионе */
    private RatingData fbEloRating8;
    /* Среднее значение глобального рейтинга */
    private RatingData globalRatingAvg;
    /* Средневзвешенное значение глобального рейтинга */
    private RatingData globalRatingWeightedAvg;
    /* Эло-рейтинг на Глобальной карте */
    private RatingData gmEloRating;
    /* Эло-рейтинг на Глобальной карте в абсолютном дивизионе */
    private RatingData gmEloRating10;
    /* Эло-рейтинг на Глобальной карте в среднем дивизионе */
    private RatingData gmEloRating6;
    /* Эло-рейтинг на Глобальной карте в чемпионском дивизионе */
    private RatingData gmEloRating8;
    /* Рейтинг в Битвах за Укрепрайон */
    private RatingData ratingFort;
    /* Среднее количество техники 10 уровня на игрока клана */
    private RatingData v10lAvg;
    /* Средний процент побед */
    private RatingData winsRatioAvg;

    public int getClanId() {
        return clanId;
    }

    public void setClanId(int clanId) {
        this.clanId = clanId;
    }

    public String getClanName() {
        return clanName;
    }

    public void setClanName(String clanName) {
        this.clanName = clanName;
    }

    public String getClanTag() {
        return clanTag;
    }

    public void setClanTag(String clanTag) {
        this.clanTag = clanTag;
    }

    public Map<ExcludeReason, String> getExcludeReasons() {
        return excludeReasons;
    }

    public void setExcludeReasons(Map<ExcludeReason, String> excludeReasons) {
        this.excludeReasons = excludeReasons;
    }

    public RatingData getBattlesCountAvg() {
        return battlesCountAvg;
    }

    public void setBattlesCountAvg(RatingData battlesCountAvg) {
        this.battlesCountAvg = battlesCountAvg;
    }

    public RatingData getBattlesCountAvgDaily() {
        return battlesCountAvgDaily;
    }

    public void setBattlesCountAvgDaily(RatingData battlesCountAvgDaily) {
        this.battlesCountAvgDaily = battlesCountAvgDaily;
    }

    public RatingData getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(RatingData efficiency) {
        this.efficiency = efficiency;
    }

    public RatingData getFbEloRating() {
        return fbEloRating;
    }

    public void setFbEloRating(RatingData fbEloRating) {
        this.fbEloRating = fbEloRating;
    }

    public RatingData getFbEloRating10() {
        return fbEloRating10;
    }

    public void setFbEloRating10(RatingData fbEloRating10) {
        this.fbEloRating10 = fbEloRating10;
    }

    public RatingData getFbEloRating8() {
        return fbEloRating8;
    }

    public void setFbEloRating8(RatingData fbEloRating8) {
        this.fbEloRating8 = fbEloRating8;
    }

    public RatingData getGlobalRatingAvg() {
        return globalRatingAvg;
    }

    public void setGlobalRatingAvg(RatingData globalRatingAvg) {
        this.globalRatingAvg = globalRatingAvg;
    }

    public RatingData getGlobalRatingWeightedAvg() {
        return globalRatingWeightedAvg;
    }

    public void setGlobalRatingWeightedAvg(RatingData globalRatingWeightedAvg) {
        this.globalRatingWeightedAvg = globalRatingWeightedAvg;
    }

    public RatingData getGmEloRating() {
        return gmEloRating;
    }

    public void setGmEloRating(RatingData gmEloRating) {
        this.gmEloRating = gmEloRating;
    }

    public RatingData getGmEloRating10() {
        return gmEloRating10;
    }

    public void setGmEloRating10(RatingData gmEloRating10) {
        this.gmEloRating10 = gmEloRating10;
    }

    public RatingData getGmEloRating6() {
        return gmEloRating6;
    }

    public void setGmEloRating6(RatingData gmEloRating6) {
        this.gmEloRating6 = gmEloRating6;
    }

    public RatingData getGmEloRating8() {
        return gmEloRating8;
    }

    public void setGmEloRating8(RatingData gmEloRating8) {
        this.gmEloRating8 = gmEloRating8;
    }

    public RatingData getRatingFort() {
        return ratingFort;
    }

    public void setRatingFort(RatingData ratingFort) {
        this.ratingFort = ratingFort;
    }

    public RatingData getV10lAvg() {
        return v10lAvg;
    }

    public void setV10lAvg(RatingData v10lAvg) {
        this.v10lAvg = v10lAvg;
    }

    public RatingData getWinsRatioAvg() {
        return winsRatioAvg;
    }

    public void setWinsRatioAvg(RatingData winsRatioAvg) {
        this.winsRatioAvg = winsRatioAvg;
    }

}
