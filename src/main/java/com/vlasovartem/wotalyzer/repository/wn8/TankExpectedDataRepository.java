package com.vlasovartem.wotalyzer.repository.wn8;

import com.vlasovartem.wotalyzer.entity.wn8.TankExpectedData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by artemvlasov on 01/11/2016.
 */
@Repository
public interface TankExpectedDataRepository extends MongoRepository<TankExpectedData, Long> {

    List<TankExpectedData> findByTankIdIn(List<Integer> tankIds);

}
