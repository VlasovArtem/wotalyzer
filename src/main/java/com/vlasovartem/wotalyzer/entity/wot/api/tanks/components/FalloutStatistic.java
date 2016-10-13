package com.vlasovartem.wotalyzer.entity.wot.api.tanks.components;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class FalloutStatistic extends ClanStatistic {

    /* Damage caused by Combat Reserves */
    private int avatarDamageDealt;
    /* Destroyed by Combat Reserves */
    private int avatarFrags;
    /* Average damage caused with your assistance */
    private float avgDamageAssisted;
    /* Average damage upon your spotting */
    private float avgDamageAssistedRadio;
    /* Average damage upon your shooting the track */
    private float avgDamageAssistedTrack;
    /* Average damage blocked by armor per battle. Damage blocked by armor is damage received from shells (AP, HEAT and APCR) that hit a vehicle but caused no damage. Value is calculated starting from version 9.0. */
    private float avgDamageBlocked;
    /* Deaths */
    private int deathCount;
    /* Direct hits received */
    private int directHitsReceived;
    /* Hits on enemy as a result of splash damage */
    private int explosionHits;
    /* Hits received as a result of splash damage */
    private int explosionHitsReceived;
    /* Flags captured in platoon */
    private int flagCapture;
    /* Flags captured as solo player */
    private int flagCaptureSolo;
    /* Maximum damage caused in one battle including damage from avatar */
    private int maxDamageWithAvatar;
    /* Maximum destroyed in one battle including vehicles destroyed by avatar */
    private int maxFragsWithAvatar;
    /* Maximum Victory points earned in Fallout */
    private int maxWinPoints;
    /* Direct hits received that caused no damage */
    private int noDamageDirectHitsReceived;
    /* Penetrations */
    private int piercings;
    /* Penetrations received */
    private int piercingsReceived;
    /* Resources captured at resource points */
    private int resourceAbsorbed;
    /* Ratio of damage blocked by armor from AP, HEAT, and APCR shells to damage received from these types of shells. Value is calculated starting from version 9.0. */
    private float tankingFactor;
    /* Victory points */
    private int winPoints;

    public int getAvatarDamageDealt() {
        return avatarDamageDealt;
    }

    public void setAvatarDamageDealt(int avatarDamageDealt) {
        this.avatarDamageDealt = avatarDamageDealt;
    }

    public int getAvatarFrags() {
        return avatarFrags;
    }

    public void setAvatarFrags(int avatarFrags) {
        this.avatarFrags = avatarFrags;
    }

    public float getAvgDamageAssisted() {
        return avgDamageAssisted;
    }

    public void setAvgDamageAssisted(float avgDamageAssisted) {
        this.avgDamageAssisted = avgDamageAssisted;
    }

    public float getAvgDamageAssistedRadio() {
        return avgDamageAssistedRadio;
    }

    public void setAvgDamageAssistedRadio(float avgDamageAssistedRadio) {
        this.avgDamageAssistedRadio = avgDamageAssistedRadio;
    }

    public float getAvgDamageAssistedTrack() {
        return avgDamageAssistedTrack;
    }

    public void setAvgDamageAssistedTrack(float avgDamageAssistedTrack) {
        this.avgDamageAssistedTrack = avgDamageAssistedTrack;
    }

    public float getAvgDamageBlocked() {
        return avgDamageBlocked;
    }

    public void setAvgDamageBlocked(float avgDamageBlocked) {
        this.avgDamageBlocked = avgDamageBlocked;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }

    public int getDirectHitsReceived() {
        return directHitsReceived;
    }

    public void setDirectHitsReceived(int directHitsReceived) {
        this.directHitsReceived = directHitsReceived;
    }

    public int getExplosionHits() {
        return explosionHits;
    }

    public void setExplosionHits(int explosionHits) {
        this.explosionHits = explosionHits;
    }

    public int getExplosionHitsReceived() {
        return explosionHitsReceived;
    }

    public void setExplosionHitsReceived(int explosionHitsReceived) {
        this.explosionHitsReceived = explosionHitsReceived;
    }

    public int getFlagCapture() {
        return flagCapture;
    }

    public void setFlagCapture(int flagCapture) {
        this.flagCapture = flagCapture;
    }

    public int getFlagCaptureSolo() {
        return flagCaptureSolo;
    }

    public void setFlagCaptureSolo(int flagCaptureSolo) {
        this.flagCaptureSolo = flagCaptureSolo;
    }

    public int getMaxDamageWithAvatar() {
        return maxDamageWithAvatar;
    }

    public void setMaxDamageWithAvatar(int maxDamageWithAvatar) {
        this.maxDamageWithAvatar = maxDamageWithAvatar;
    }

    public int getMaxFragsWithAvatar() {
        return maxFragsWithAvatar;
    }

    public void setMaxFragsWithAvatar(int maxFragsWithAvatar) {
        this.maxFragsWithAvatar = maxFragsWithAvatar;
    }

    public int getMaxWinPoints() {
        return maxWinPoints;
    }

    public void setMaxWinPoints(int maxWinPoints) {
        this.maxWinPoints = maxWinPoints;
    }

    public int getNoDamageDirectHitsReceived() {
        return noDamageDirectHitsReceived;
    }

    public void setNoDamageDirectHitsReceived(int noDamageDirectHitsReceived) {
        this.noDamageDirectHitsReceived = noDamageDirectHitsReceived;
    }

    public int getPiercings() {
        return piercings;
    }

    public void setPiercings(int piercings) {
        this.piercings = piercings;
    }

    public int getPiercingsReceived() {
        return piercingsReceived;
    }

    public void setPiercingsReceived(int piercingsReceived) {
        this.piercingsReceived = piercingsReceived;
    }

    public int getResourceAbsorbed() {
        return resourceAbsorbed;
    }

    public void setResourceAbsorbed(int resourceAbsorbed) {
        this.resourceAbsorbed = resourceAbsorbed;
    }

    public float getTankingFactor() {
        return tankingFactor;
    }

    public void setTankingFactor(float tankingFactor) {
        this.tankingFactor = tankingFactor;
    }

    public int getWinPoints() {
        return winPoints;
    }

    public void setWinPoints(int winPoints) {
        this.winPoints = winPoints;
    }
}
