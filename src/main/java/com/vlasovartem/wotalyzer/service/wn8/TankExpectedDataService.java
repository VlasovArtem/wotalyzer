package com.vlasovartem.wotalyzer.service.wn8;

import com.vlasovartem.wotalyzer.entity.wn8.TankExpectedData;

import java.util.List;

/**
 * Created by artemvlasov on 01/11/2016.
 */
public interface TankExpectedDataService {

    TankExpectedData findById(long tankId);
    List<TankExpectedData> findByIds(List<Integer> tankIds);
    List<TankExpectedData> findUserVehicleExpectedData(int accountId);
}
