package com.vlasovartem.wotalyzer.entity.wn8.increase;

import static com.vlasovartem.wotalyzer.entity.wn8.increase.WN8IncreaseIndicator.IndicatorImpact.*;
import static com.vlasovartem.wotalyzer.entity.wn8.increase.WN8IncreaseIndicator.IndicatorType.*;

/**
 * Created by artemvlasov on 12/11/2016.
 * Tank WN8 Increase Indicator Builder
 */
public class TankWN8IncreaseIndicatorBuilder {

    private TankWN8IncreaseIndicator indicator;
    private long battles;

    private TankWN8IncreaseIndicatorBuilder(int tankId, long battles) {
        indicator = new TankWN8IncreaseIndicator();
        indicator.setTankId(tankId);
        this.battles = battles;
    }

    public static TankWN8IncreaseIndicatorBuilder getInstance(int tankId, long battles) {
        return new TankWN8IncreaseIndicatorBuilder(tankId, battles);
    }

    /**
     * Check Tank damage. If Damage per one battle is greater than expected data by 3 times, then it will have high effect on WN8
     * If damage per one battle is greater than expected data by 2 times, then it will have medium effect on WN8
     * Otherwise it will have low effect on WN8
     *
     * @param tankDamage Tank caused damage in all battles
     * @param expectedDamage Expected caused damage by the tank
     * @return builder
     */
    public TankWN8IncreaseIndicatorBuilder checkDamage(long tankDamage, float expectedDamage) {
        if ((expectedDamage * 3) > (tankDamage / battles)) {
            indicator.addWn8IncreaseIndicator(new WN8IncreaseIndicator(DAMAGE, HIGH));
        } else if ((expectedDamage * 2) > (tankDamage / battles)) {
            indicator.addWn8IncreaseIndicator(new WN8IncreaseIndicator(DAMAGE, MEDIUM));
        } else {
            indicator.addWn8IncreaseIndicator(new WN8IncreaseIndicator(DAMAGE, LOW));
        }
        return this;
    }

    /**
     * Check Tank frags. If frags per one battle is greater than expected data by 2 times, then it will have no effect on WN8
     * Otherwise it will have low effect on WN8
     *
     * @param frags Tank caused frags in all battles
     * @param expectedFrags Expected caused damage by the tank
     * @return builder
     */
    public TankWN8IncreaseIndicatorBuilder checkFrags(long frags, float expectedFrags) {
        if (Float.compare(frags / battles, expectedFrags * 2) == 1) {
            indicator.addWn8IncreaseIndicator(new WN8IncreaseIndicator(FRAGS, NONE));
        } else {
            indicator.addWn8IncreaseIndicator(new WN8IncreaseIndicator(FRAGS, LOW));
        }
        return this;
    }

    /**
     * Check Spotted tanks. If spotted tanks per one battle is greater than expected data on 10%, then it will have no effect on WN8
     * Otherwise it will have low effect on WN8
     *
     * @param spotted Spotted tanks in all battles
     * @param expectedSpotted Expected spotted tanks by the tank
     * @return builder
     */
    public TankWN8IncreaseIndicatorBuilder checkSpotted(long spotted, float expectedSpotted) {
        if (Float.compare(spotted / battles, (float) (expectedSpotted + (expectedSpotted * 0.1))) == 1) {
            indicator.addWn8IncreaseIndicator(new WN8IncreaseIndicator(SPOTTED, NONE));
        } else {
            indicator.addWn8IncreaseIndicator(new WN8IncreaseIndicator(SPOTTED, LOW));
        }
        return this;
    }

    /**
     * Check dropped capture points. If dropped capture points (defence) is greater then expected data on 10%, then it will have no effect on WN8
     * Otherwise it will have low effect on WN8
     *
     * @param defence Dropped capture points in all battles
     * @param expectedDefence Expected dropped capture point by the tank
     * @return builder
     */
    public TankWN8IncreaseIndicatorBuilder checkDefence(long defence, float expectedDefence) {
        if (Float.compare(defence / battles, (float) (expectedDefence + (expectedDefence * 0.1))) == 1) {
            indicator.addWn8IncreaseIndicator(new WN8IncreaseIndicator(DEFENCE, NONE));
        } else {
            indicator.addWn8IncreaseIndicator(new WN8IncreaseIndicator(DEFENCE, LOW));
        }
        return this;
    }

    /**
     * Check Win Rate. If win rate is greater then expected data on 12%, then it will have no effect on WN8
     * Otherwise it will have low effect on WN8
     *
     * @param wins Tank wins in all battles
     * @param expectedWinRate Expected win rate by the tank
     * @return builder
     */
    public TankWN8IncreaseIndicatorBuilder checkWinRate(long wins, float expectedWinRate) {
        if (Float.compare(((float) (wins / battles) * 100), (float) (expectedWinRate + (expectedWinRate * 0.12))) == 1) {
            indicator.addWn8IncreaseIndicator(new WN8IncreaseIndicator(WIN_RATE, NONE));
        } else {
            indicator.addWn8IncreaseIndicator(new WN8IncreaseIndicator(WIN_RATE, LOW));
        }
        return this;
    }

    /**
     * Build indicator
     * @return created {@link TankWN8IncreaseIndicator}
     */
    public TankWN8IncreaseIndicator build() {
        return indicator;
    }

}
