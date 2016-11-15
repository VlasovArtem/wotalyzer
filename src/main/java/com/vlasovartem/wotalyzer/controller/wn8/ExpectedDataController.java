package com.vlasovartem.wotalyzer.controller.wn8;

import com.vlasovartem.wotalyzer.entity.wn8.ExpectedData;
import com.vlasovartem.wotalyzer.entity.wn8.TankExpectedData;
import com.vlasovartem.wotalyzer.service.wn8.impl.TankExpectedDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by artemvlasov on 01/11/2016.
 */
@RestController
@RequestMapping("/wn8/expected")
public class ExpectedDataController {

    private final TankExpectedDataServiceImpl dataService;

    @Autowired
    public ExpectedDataController(TankExpectedDataServiceImpl dataService) {
        this.dataService = dataService;
    }

    @RequestMapping("/get")
    public ExpectedData findById(@RequestParam long tankId) {
        return dataService.findById(tankId);
    }

    @RequestMapping("/get/filtered")
    public List<TankExpectedData> findByIds(@RequestParam List<Integer> tankIds) {
        return dataService.findByIds(tankIds);
    }
}
