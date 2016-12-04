package com.vlasovartem.wotalyzer.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.vlasovartem.wotalyzer.deserializers.utils.DeserializerUtils;
import com.vlasovartem.wotalyzer.entity.wot.api.teams.components.Emblem;

import java.io.IOException;
import java.util.List;

/**
 * Created by artemvlasov on 04/12/2016.
 */
public class EmblemDeserializer extends JsonDeserializer<List<Emblem>> {
    @Override
    public List<Emblem> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return DeserializerUtils.getListFromMap(p, ctxt, Emblem.class);
    }
}
