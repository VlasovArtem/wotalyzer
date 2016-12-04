package com.vlasovartem.wotalyzer.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.vlasovartem.wotalyzer.deserializers.utils.DeserializerUtils;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.personal_mission.Operation;

import java.io.IOException;
import java.util.List;

/**
 * Created by artemvlasov on 21/11/2016.
 */
public class OperationDeserializer extends JsonDeserializer {

    @Override
    public List<Operation> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return DeserializerUtils.getListFromMap(p, ctxt, Operation.class);
    }

}
