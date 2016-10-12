package com.vlasovartem.wotalyzer.controller;

import com.vlasovartem.wotalyzer.entity.statistic.Statistic;
import com.vlasovartem.wotalyzer.service.statistic.VehicleStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by artemvlasov on 14/01/16.
 */
@RestController
@RequestMapping("/vehicle/statistic")
public class VehicleStatisticController {
    private final VehicleStatisticsService service;

    @Autowired
    public VehicleStatisticController(VehicleStatisticsService service) {
        this.service = service;
    }

    @RequestMapping("dynamic")
    public Statistic<Double> getBestDynamic() {
        return service.bestVehicleDynamic(true);
    }

}
