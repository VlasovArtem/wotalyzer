package com.vlasovartem.wotalyzer.entity.wn8;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by artemvlasov on 02/11/2016.
 */
@Document(collection = "expectedData")
public class TankExpectedData extends ExpectedData {

    @Id
    private long tankId;

    public long getTankId() {
        return tankId;
    }

    public void setTankId(long tankId) {
        this.tankId = tankId;
    }

}
