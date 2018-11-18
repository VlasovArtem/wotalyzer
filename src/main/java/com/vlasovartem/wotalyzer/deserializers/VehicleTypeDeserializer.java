package com.vlasovartem.wotalyzer.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.VehicleType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by artemvlasov on 28/12/2016.
 */
public class VehicleTypeDeserializer extends JsonDeserializer {

    private static final Logger LOGGER = LogManager.getLogger(VehicleTypeDeserializer.class);

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String parsedVehicleType = p.getText();
        Optional<VehicleType> vehicleType = Arrays
                .stream(VehicleType.values())
                .filter(type -> type.getValue().equalsIgnoreCase(parsedVehicleType))
                .findFirst();
        if (vehicleType.isPresent()) {
            return vehicleType.get();
        } else {
            LOGGER.warn("Vehicle type {} could not be found", parsedVehicleType);
            return null;
        }
    }
}
