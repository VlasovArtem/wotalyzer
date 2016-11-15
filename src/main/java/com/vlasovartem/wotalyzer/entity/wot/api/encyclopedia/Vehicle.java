package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.MainEntity;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.crew.Crew;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.Images;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.ModulesTree;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.Profile;

import java.util.List;
import java.util.Map;

/**
 * Created by artemvlasov on 13/01/16.
 */
@JsonAutoDetect
public class Vehicle extends MainEntity {

    private String description;
    private List<Integer> engines;
    private List<Integer> guns;
    private boolean isGift;
    private boolean isPremium;
    private boolean isPremiumIgr;
    private String name;
    private String nation;
    private Map<String, Integer> nextTanks;
    private int priceCredit;
    private int priceGold;
    private Map<String, Integer> pricesXp;
    private List<Integer> provisions;
    private List<Integer> radios;
    private String shortName;
    private List<Integer> suspensions;
    private String tag;
    private int tier;
    private List<Integer> turrets;
    private String type;
    private List<Crew> crew;
    private Profile defaultProfile;
    private Images images;
    private Map<String, ModulesTree> modulesTree;

    @Override
    @JsonProperty("tank_id")
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

    public List<Integer> getEngines() {
        return engines;
    }

    public void setEngines(List<Integer> engines) {
        this.engines = engines;
    }

    public List<Integer> getGuns() {
        return guns;
    }

    public void setGuns(List<Integer> guns) {
        this.guns = guns;
    }

    public boolean isGift() {
        return isGift;
    }

    public void setGift(boolean gift) {
        isGift = gift;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public boolean isPremiumIgr() {
        return isPremiumIgr;
    }

    public void setPremiumIgr(boolean premiumIgr) {
        isPremiumIgr = premiumIgr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Map<String, Integer> getNextTanks() {
        return nextTanks;
    }

    public void setNextTanks(Map<String, Integer> nextTanks) {
        this.nextTanks = nextTanks;
    }

    public int getPriceCredit() {
        return priceCredit;
    }

    public void setPriceCredit(int priceCredit) {
        this.priceCredit = priceCredit;
    }

    public int getPriceGold() {
        return priceGold;
    }

    public void setPriceGold(int priceGold) {
        this.priceGold = priceGold;
    }

    public Map<String, Integer> getPricesXp() {
        return pricesXp;
    }

    public void setPricesXp(Map<String, Integer> pricesXp) {
        this.pricesXp = pricesXp;
    }

    public List<Integer> getProvisions() {
        return provisions;
    }

    public void setProvisions(List<Integer> provisions) {
        this.provisions = provisions;
    }

    public List<Integer> getRadios() {
        return radios;
    }

    public void setRadios(List<Integer> radios) {
        this.radios = radios;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<Integer> getSuspensions() {
        return suspensions;
    }

    public void setSuspensions(List<Integer> suspensions) {
        this.suspensions = suspensions;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public List<Integer> getTurrets() {
        return turrets;
    }

    public void setTurrets(List<Integer> turrets) {
        this.turrets = turrets;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }

    public Profile getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(Profile defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Map<String, ModulesTree> getModulesTree() {
        return modulesTree;
    }

    public void setModulesTree(Map<String, ModulesTree> modulesTree) {
        this.modulesTree = modulesTree;
    }

}
