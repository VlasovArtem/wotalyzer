package com.vlasovartem.wotalyzer.service.wn8.impl;

import com.vlasovartem.wotalyzer.entity.wn8.ExpectedData;
import com.vlasovartem.wotalyzer.entity.wn8.RatioData;
import com.vlasovartem.wotalyzer.entity.wot.api.account.Player;
import com.vlasovartem.wotalyzer.entity.wot.api.account.components.statistics.AllStatisticsData;
import com.vlasovartem.wotalyzer.service.wn8.ExpectedDataService;
import com.vlasovartem.wotalyzer.service.wn8.RatioDataService;
import com.vlasovartem.wotalyzer.utils.wot.account.PlayerUtils;
import com.vlasovartem.wotalyzer.utils.wn8.RatioDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public RatioData getAccountRatioData(long accountId) {
        ExpectedData accountExpectedData = expectedDataService.getAccountExpectedData(accountId);
        Optional<Player> playerData = utils.getPlayer(accountId);
        if (playerData.isPresent()) {
            AllStatisticsData allStatisticsData = playerData.get().getStatistics().getAll();
            return RatioDataUtils.calculateAccountRationData(allStatisticsData, accountExpectedData);
        }
        return null;
    }

    @Override
    public RatioData getAccountRatioDataZeroPoint(long accountId) {
        RatioData accountRatioData = getAccountRatioData(accountId);
        return RatioDataUtils.calculateZeroRatioData(accountRatioData);
    }

    @Override
    public Optional<RatioData> getAccountRatioDataByTankId(int accountId, int tankId) {
        Optional<ExpectedData> expectedData = expectedDataService.getAccountExpectedDataByTankId(accountId, tankId);
        if (expectedData.isPresent()) {

        }
        return Optional.empty();
    }

    @Override
    public RatioData getAccountRatioDataByTankIds(int accountId, List<Integer> tankIds) {
        return null;
    }

    @Override
    public RatioData getAccountRatioDataByTier(int account, int tier) {
        return null;
    }

    @Override
    public RatioData getAccountRatioDataByTierBetween(int account, int minTier, int maxTier) {
        return null;
    }
}
