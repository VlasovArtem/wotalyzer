package com.vlasovartem.wotalyzer.entity.statistic;

/**
 * Created by artemvlasov on 14/01/16.
 */
public class Statistic<T> {

    private Type type;
    private RangeType rangeType;
    private int totalCollectedTanks;
    private TankStatistic<T> searchedTank;
    private TankStatistic<T> bestIndicator;
    private TankStatistic<T> worthIndicator;

    public Statistic() {
    }

    public Statistic(Type type, RangeType rangeType, int totalCollectedTanks) {
        this.type = type;
        this.rangeType = rangeType;
        this.totalCollectedTanks = totalCollectedTanks;
    }

    public Statistic(Type type, RangeType rangeType) {
        this.type = type;
        this.rangeType = rangeType;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public RangeType getRangeType() {
        return rangeType;
    }

    public void setRangeType(RangeType rangeType) {
        this.rangeType = rangeType;
    }

    public int getTotalCollectedTanks() {
        return totalCollectedTanks;
    }

    public void setTotalCollectedTanks(int totalCollectedTanks) {
        this.totalCollectedTanks = totalCollectedTanks;
    }

    public TankStatistic<T> getSearchedTank() {
        return searchedTank;
    }

    public void setSearchedTank(TankStatistic<T> searchedTank) {
        this.searchedTank = searchedTank;
    }

    public TankStatistic<T> getBestIndicator() {
        return bestIndicator;
    }

    public void setBestIndicator(TankStatistic<T> bestIndicator) {
        bestIndicator.setPositionInSearchData(1);
        this.bestIndicator = bestIndicator;
    }

    public TankStatistic<T> getWorthIndicator() {
        return worthIndicator;
    }

    public void setWorthIndicator(TankStatistic<T> worthIndicator) {
        this.worthIndicator = worthIndicator;
    }

    public enum Type {
        PENETRATION(Integer.class), VIEW_RANGE(Integer.class), WT_RATIO(Double.class);

        private Class aClass;

        Type(Class aClass) {
            this.aClass = aClass;
        }

        public Class getaClass() {
            return aClass;
        }
    }
    public enum RangeType {
        ALL, TYPE, TIER, TIRE_AND_TYPE
    }
}
