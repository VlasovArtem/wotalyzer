package com.vlasovartem.wotalyzer.entity.statistic;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by artemvlasov on 14/01/16.
 */
@Document(collection = "vehicleModuleInfo")
public class VehicleModuleInfo {
    @Id
    private long tankId;
    private String topModuleUrl;
    private VehicleModuleComponent defaultModules;
    private VehicleModuleComponent topModules;

    public long getTankId() {
        return tankId;
    }

    public void setTankId(long tankId) {
        this.tankId = tankId;
    }

    public String getTopModuleUrl() {
        return topModuleUrl;
    }

    public void setTopModuleUrl(String topModuleUrl) {
        this.topModuleUrl = topModuleUrl;
    }

    public VehicleModuleComponent getDefaultModules() {
        return defaultModules;
    }

    public void setDefaultModules(VehicleModuleComponent defaultModules) {
        this.defaultModules = defaultModules;
    }

    public VehicleModuleComponent getTopModules() {
        return topModules;
    }

    public void setTopModules(VehicleModuleComponent topModules) {
        this.topModules = topModules;
    }
}
