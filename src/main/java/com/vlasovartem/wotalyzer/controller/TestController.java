package com.vlasovartem.wotalyzer.controller;

import com.vlasovartem.wotalyzer.entity.wot.api.APIResponse;
import com.vlasovartem.wotalyzer.entity.wot.api.account.Players;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.account.PlayersUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by artemvlasov on 18/10/2016.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final PlayersUtils playersUtils;

    @Autowired
    public TestController(PlayersUtils playersUtils) {
        this.playersUtils = playersUtils;
    }

    @RequestMapping("/get")
    public void test() {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put(WOTAPIConstants.TYPE_PARAM, "exact");
        objectMap.put(WOTAPIConstants.SEARCH_PARAM, "Martens");
        APIResponse<List<Players>> apiResponse = playersUtils.getApiResponseList(objectMap);
        System.out.println("Test");
    }

}
