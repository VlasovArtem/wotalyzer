package com.vlasovartem.wotalyzer.repository.statistic;

import com.vlasovartem.wotalyzer.entity.statistic.VehicleModuleInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by artemvlasov on 14/01/16.
 */
@Repository
public interface VehicleModuleInfoRepository extends MongoRepository<VehicleModuleInfo, Long> {
    List<VehicleModuleInfo> findByTankIdIn(List<Long> tanksIds);
}
