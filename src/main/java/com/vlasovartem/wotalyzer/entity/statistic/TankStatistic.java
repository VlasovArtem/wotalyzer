package com.vlasovartem.wotalyzer.entity.statistic;

/**
 * Created by artemvlasov on 15/01/16.
 */
public class TankStatistic<T> {
    private long tankId;
    private int positionInSearchData;
    private T data;

    public TankStatistic(long tankId, T data) {
        this.tankId = tankId;
        this.data = data;
    }

    public long getTankId() {
        return tankId;
    }

    public void setTankId(long tankId) {
        this.tankId = tankId;
    }

    public int getPositionInSearchData() {
        return positionInSearchData;
    }

    public void setPositionInSearchData(int positionInSearchData) {
        this.positionInSearchData = positionInSearchData;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
