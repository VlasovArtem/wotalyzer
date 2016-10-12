package com.vlasovartem.wotalyzer.entity.wot.api.clans;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

/**
 * Created by artemvlasov on 07/09/16.
 */
public class Clan {

    @Id
    @JsonProperty("clan_id")
    private long id;
    private String clanName;
    private String clanTag;
    private ClanData battlesCountAvg;
    private ClanData battlesCountAvgDaily;
    private ClanData efficiency;
    private ClanData fbEloRating;
    private ClanData fbEloRating10;
    private ClanData fbEloRating8;
    private ClanData globalRatingAvg;
    private ClanData globalRatingWeightedAvg;
    private ClanData gmEloRating;
    private ClanData gmEloRating10;
    private ClanData gmEloRating8;
    private ClanData gmEloRating6;
    private ClanData ratingFort;
    private ClanData v10lAvg;
    private ClanData winsRatioAvg;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public ClanData getBattlesCountAvg() {
        return battlesCountAvg;
    }

    public void setBattlesCountAvg(ClanData battlesCountAvg) {
        this.battlesCountAvg = battlesCountAvg;
    }

    public ClanData getBattlesCountAvgDaily() {
        return battlesCountAvgDaily;
    }

    public void setBattlesCountAvgDaily(ClanData battlesCountAvgDaily) {
        this.battlesCountAvgDaily = battlesCountAvgDaily;
    }

    public ClanData getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(ClanData efficiency) {
        this.efficiency = efficiency;
    }

    public ClanData getFbEloRating() {
        return fbEloRating;
    }

    public void setFbEloRating(ClanData fbEloRating) {
        this.fbEloRating = fbEloRating;
    }

    public ClanData getFbEloRating10() {
        return fbEloRating10;
    }

    public void setFbEloRating10(ClanData fbEloRating10) {
        this.fbEloRating10 = fbEloRating10;
    }

    public ClanData getFbEloRating8() {
        return fbEloRating8;
    }

    public void setFbEloRating8(ClanData fbEloRating8) {
        this.fbEloRating8 = fbEloRating8;
    }

    public ClanData getGlobalRatingAvg() {
        return globalRatingAvg;
    }

    public void setGlobalRatingAvg(ClanData globalRatingAvg) {
        this.globalRatingAvg = globalRatingAvg;
    }

    public ClanData getGlobalRatingWeightedAvg() {
        return globalRatingWeightedAvg;
    }

    public void setGlobalRatingWeightedAvg(ClanData globalRatingWeightedAvg) {
        this.globalRatingWeightedAvg = globalRatingWeightedAvg;
    }

    public ClanData getGmEloRating() {
        return gmEloRating;
    }

    public void setGmEloRating(ClanData gmEloRating) {
        this.gmEloRating = gmEloRating;
    }

    public ClanData getGmEloRating10() {
        return gmEloRating10;
    }

    public void setGmEloRating10(ClanData gmEloRating10) {
        this.gmEloRating10 = gmEloRating10;
    }

    public ClanData getGmEloRating8() {
        return gmEloRating8;
    }

    public void setGmEloRating8(ClanData gmEloRating8) {
        this.gmEloRating8 = gmEloRating8;
    }

    public ClanData getGmEloRating6() {
        return gmEloRating6;
    }

    public void setGmEloRating6(ClanData gmEloRating6) {
        this.gmEloRating6 = gmEloRating6;
    }

    public ClanData getRatingFort() {
        return ratingFort;
    }

    public void setRatingFort(ClanData ratingFort) {
        this.ratingFort = ratingFort;
    }

    public ClanData getV10lAvg() {
        return v10lAvg;
    }

    public void setV10lAvg(ClanData v10lAvg) {
        this.v10lAvg = v10lAvg;
    }

    public ClanData getWinsRatioAvg() {
        return winsRatioAvg;
    }

    public void setWinsRatioAvg(ClanData winsRatioAvg) {
        this.winsRatioAvg = winsRatioAvg;
    }
}
