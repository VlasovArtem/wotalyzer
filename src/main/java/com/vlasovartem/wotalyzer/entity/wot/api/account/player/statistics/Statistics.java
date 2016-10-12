package com.vlasovartem.wotalyzer.entity.wot.api.account.player.statistics;

import java.util.Map;

/**
 * Created by artemvlasov on 10/09/16.
 * Статистика игрока
 */
public class Statistics {

    /* statistics.frags Количество и модели уничтоженной игроком техники. Приватные данные игрока. */
    private Map<String, String> frags;
    /* Количество поваленных деревьев */
    private long treesCut;
    /* Суммарная статистика по Случайным, Ротным и клановым боям без учёта статистики боёв на Глобальной Карте 2.0 */
    private MaxStatisticsData all;
    /* Статистика боёв в составе клана */
    private AverageStatisticsData clan;
    /* Статистика боёв в составе роты */
    private AverageStatisticsData company;
    /* Статистика в режиме «Бой до последнего» */
    private Fallout fallout;
    /* Статистика боёв на Глобальной карте в Абсолютном дивизионе */
    private AverageStatisticsData globalmapAbsolute;
    /* Статистика боёв на Глобальной карте в Чемпионском дивизионе */
    private AverageStatisticsData globalmapChampion;
    /* Статистика боёв на Глобальной карте в Среднем дивизионе*/
    private AverageStatisticsData globalmapMiddle;
    /* Статистика исторических боёв */
    private MaxStatisticsData historical;
    /* Статистика случайных боёв*/
    private AverageStatisticsData random;
    /* Статистика командных боёв постоянных команд */
    private MaxStatisticsData regularTeam;
    /* Общая по всем кланам статистика боёв игрока в режиме обороны Укрепрайона */
    private StrongholdStatistics strongholdDefense;
    /* stronghold_skirmish Общая по всем кланам статистика боёв игрока в режиме вылазок Укрепрайона */
    private StrongholdStatistics strongholdSkirmish;
    /* statistics.team Статистика командных боёв */
    private AverageStatisticsData team;

    public Map<String, String> getFrags() {
        return frags;
    }

    public void setFrags(Map<String, String> frags) {
        this.frags = frags;
    }

    public long getTreesCut() {
        return treesCut;
    }

    public void setTreesCut(long treesCut) {
        this.treesCut = treesCut;
    }

    public MaxStatisticsData getAll() {
        return all;
    }

    public void setAll(MaxStatisticsData all) {
        this.all = all;
    }

    public AverageStatisticsData getClan() {
        return clan;
    }

    public void setClan(AverageStatisticsData clan) {
        this.clan = clan;
    }

    public AverageStatisticsData getCompany() {
        return company;
    }

    public void setCompany(AverageStatisticsData company) {
        this.company = company;
    }

    public Fallout getFallout() {
        return fallout;
    }

    public void setFallout(Fallout fallout) {
        this.fallout = fallout;
    }

    public AverageStatisticsData getGlobalmapAbsolute() {
        return globalmapAbsolute;
    }

    public void setGlobalmapAbsolute(AverageStatisticsData globalmapAbsolute) {
        this.globalmapAbsolute = globalmapAbsolute;
    }

    public AverageStatisticsData getGlobalmapChampion() {
        return globalmapChampion;
    }

    public void setGlobalmapChampion(AverageStatisticsData globalmapChampion) {
        this.globalmapChampion = globalmapChampion;
    }

    public AverageStatisticsData getGlobalmapMiddle() {
        return globalmapMiddle;
    }

    public void setGlobalmapMiddle(AverageStatisticsData globalmapMiddle) {
        this.globalmapMiddle = globalmapMiddle;
    }

    public MaxStatisticsData getHistorical() {
        return historical;
    }

    public void setHistorical(MaxStatisticsData historical) {
        this.historical = historical;
    }

    public AverageStatisticsData getRandom() {
        return random;
    }

    public void setRandom(AverageStatisticsData random) {
        this.random = random;
    }

    public MaxStatisticsData getRegularTeam() {
        return regularTeam;
    }

    public void setRegularTeam(MaxStatisticsData regularTeam) {
        this.regularTeam = regularTeam;
    }

    public StrongholdStatistics getStrongholdDefense() {
        return strongholdDefense;
    }

    public void setStrongholdDefense(StrongholdStatistics strongholdDefense) {
        this.strongholdDefense = strongholdDefense;
    }

    public StrongholdStatistics getStrongholdSkirmish() {
        return strongholdSkirmish;
    }

    public void setStrongholdSkirmish(StrongholdStatistics strongholdSkirmish) {
        this.strongholdSkirmish = strongholdSkirmish;
    }

    public AverageStatisticsData getTeam() {
        return team;
    }

    public void setTeam(AverageStatisticsData team) {
        this.team = team;
    }
}
