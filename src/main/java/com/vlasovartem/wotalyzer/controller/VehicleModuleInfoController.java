package com.vlasovartem.wotalyzer.controller;

import com.vlasovartem.wotalyzer.repository.statistic.VehicleModuleInfoRepository;
import com.vlasovartem.wotalyzer.service.statistic.VehicleModuleInfoService;
import com.vlasovartem.wotalyzer.service.wot.api.tankopedia.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TANK_ID_PARAM;

/**
 * Created by artemvlasov on 09/08/16.
 */
@RestController
@RequestMapping("/vehicle/info")
public class VehicleModuleInfoController {

    private final VehicleModuleInfoService vehicleModuleInfoService;

    private final VehicleModuleInfoRepository vehicleModuleInfoRepository;

    private final VehiclesService vehiclesService;

    @Autowired
    public VehicleModuleInfoController(VehiclesService vehiclesService, VehicleModuleInfoService vehicleModuleInfoService, VehicleModuleInfoRepository vehicleModuleInfoRepository) {
        this.vehiclesService = vehiclesService;
        this.vehicleModuleInfoService = vehicleModuleInfoService;
        this.vehicleModuleInfoRepository = vehicleModuleInfoRepository;
    }

    @RequestMapping("update/{id}")
    public String updateModulesInfo(@PathVariable long id) {
        vehicleModuleInfoRepository.save(vehicleModuleInfoService.findVehicleComponentInfoData(id));
        return "VehicleUtils with id = " + id + " successfully updated!";
    }

    /**
     * Request to update all vehicle
     * @TODO Add only Admin permission, Add week scheduler.
     * @return ResponseEntity
     */
    @RequestMapping("update")
    public ResponseEntity<String> update() {
        AtomicInteger updatedVehicles = new AtomicInteger();
        AtomicInteger newVehicles = new AtomicInteger();
        vehiclesService.findAll(Collections.singletonList(TANK_ID_PARAM)).forEach(vehicleBaseInfo -> {
            if (vehicleModuleInfoRepository.exists(vehicleBaseInfo.getId())) {
                updatedVehicles.incrementAndGet();
            } else {
                newVehicles.incrementAndGet();
            }
            updateModulesInfo(vehicleBaseInfo.getId());
        });
        return ResponseEntity.ok(String.format("%d vehicles was successfully updated and %d was newly added", updatedVehicles.get(), newVehicles.get()));
    }


}
