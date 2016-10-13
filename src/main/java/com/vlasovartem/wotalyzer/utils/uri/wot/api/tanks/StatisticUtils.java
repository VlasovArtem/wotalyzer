package com.vlasovartem.wotalyzer.utils.uri.wot.api.tanks;

import com.vlasovartem.wotalyzer.entity.wot.api.tanks.Statistic;
import com.vlasovartem.wotalyzer.utils.api.contstans.tanks.StatisticConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class StatisticUtils extends MainUtils<Statistic> {

    public StatisticUtils() {
        super(Statistic.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return StatisticConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return StatisticConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return StatisticConstants.REQUIRED_PARAMS;
    }
}
