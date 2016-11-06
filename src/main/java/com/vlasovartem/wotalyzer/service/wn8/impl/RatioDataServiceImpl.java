package com.vlasovartem.wotalyzer.service.wn8.impl;

import com.vlasovartem.wotalyzer.entity.wn8.ExpectedData;
import com.vlasovartem.wotalyzer.entity.wn8.RationData;
import com.vlasovartem.wotalyzer.entity.wot.api.account.Player;
import com.vlasovartem.wotalyzer.entity.wot.api.account.components.statistics.AllStatisticsData;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponseMap;
import com.vlasovartem.wotalyzer.service.wn8.ExpectedDataService;
import com.vlasovartem.wotalyzer.service.wn8.RatioDataService;
import com.vlasovartem.wotalyzer.utils.QueryParamBuilder;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.account.PlayerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by artemvlasov on 03/11/2016.
 */
@Service
public class RatioDataServiceImpl implements RatioDataService {

    private final ExpectedDataService expectedDataService;
    private final PlayerUtils utils;

    @Autowired
    public RatioDataServiceImpl(ExpectedDataService expectedDataService, PlayerUtils utils) {
        this.expectedDataService = expectedDataService;
        this.utils = utils;
    }

    @Override
    public RationData getAccountRatioData(long accountId) {
        ExpectedData accountExpectedData = expectedDataService.getAccountExpectedData(accountId);
        APIResponseMap<Player> apiResponseMap = utils.getApiResponseMap(QueryParamBuilder.newBuilder().withAccountId(accountId).build());
        List<Player> content = apiResponseMap.getContent();
        if(!content.isEmpty()) {
            Player player = content.get(0);
            AllStatisticsData all = player.getStatistics().getAll();
            RationData rationData = new RationData();
            rationData.setDamage(all.getDamageDealt() / accountExpectedData.getExpDamage());
            rationData.setFrag(all.getFrags() / accountExpectedData.getExpFrag());
            rationData.setSpot(all.getSpotted() / accountExpectedData.getExpSpot());
            rationData.setWinRate(all.getWins() / accountExpectedData.getExpWin());
            rationData.setDef(all.getDroppedCapturePoints() / accountExpectedData.getExpDef());
            return rationData;
        }
        return null;
    }

    @Override
    public RationData getAccountRatioDataZeroPoint(long accountId) {
        RationData accountRatioData = getAccountRatioData(accountId);
        RationData zeroRatioData = new RationData();
        zeroRatioData.setWinRate(Double.max(0, (accountRatioData.getWinRate() - 0.71) / (1 - 0.71)));
        zeroRatioData.setDamage(Double.max(0, (accountRatioData.getDamage() - 0.22) / (1 - 0.22)));
        zeroRatioData.setFrag(Double.max(0, Double.min(zeroRatioData.getDamage() + 0.2, (accountRatioData.getFrag() - 0.12) / (1 - 0.12))));
        zeroRatioData.setSpot(Double.max(0, Double.min(zeroRatioData.getDamage() + 0.1, (accountRatioData.getSpot() - 0.38) / (1 - 0.38))));
        zeroRatioData.setDef(Double.max(0, Double.min(zeroRatioData.getDamage() + 0.1, (accountRatioData.getDef() - 0.10) / (1 - 0.10))));
        return zeroRatioData;
    }
}
