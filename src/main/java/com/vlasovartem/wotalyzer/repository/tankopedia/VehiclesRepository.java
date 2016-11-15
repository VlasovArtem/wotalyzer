package com.vlasovartem.wotalyzer.repository.tankopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by artemvlasov on 09/08/16.
 */
@Repository
public interface VehiclesRepository extends MongoRepository<Vehicle, Long> {
}
