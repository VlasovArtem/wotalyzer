package com.vlasovartem.wotalyzer.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.Nation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Created by artemvlasov on 28/12/2016.
 */
public class NationDeserializer extends JsonDeserializer {

    private static final Logger LOGGER = LogManager.getLogger(NationDeserializer.class);

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String parsedNation = p.getText();
        try {
            return Nation.valueOf(parsedNation.toUpperCase());
        } catch (IllegalArgumentException e) {
            LOGGER.error("Nation {} is not found", parsedNation);
        }
        return null;
    }
}
