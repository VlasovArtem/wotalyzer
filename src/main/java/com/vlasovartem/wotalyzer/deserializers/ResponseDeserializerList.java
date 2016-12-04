package com.vlasovartem.wotalyzer.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artemvlasov on 19/11/2016.
 */
public class ResponseDeserializerList<T> extends JsonDeserializer {

    private Class<T> tClass;

    public  ResponseDeserializerList(Class<T> type) {
        tClass = type;
    }


    @Override
    public List<T> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        TreeNode treeNode = p.getCodec().readTree(p);
        TreeNode data = treeNode.get("data");
        CollectionType collectionType = ctxt.getTypeFactory().constructCollectionType(ArrayList.class, tClass);
        return ctxt.readValue(data.traverse(), collectionType);
    }
}
