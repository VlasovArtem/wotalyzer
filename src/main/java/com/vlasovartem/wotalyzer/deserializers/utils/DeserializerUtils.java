package com.vlasovartem.wotalyzer.deserializers.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by artemvlasov on 21/11/2016.
 */
public class DeserializerUtils {

    public static <F> List<F> getListFromMap(JsonParser p, DeserializationContext ctxt, Class<F> fClass) throws IOException {
        TreeNode treeNode = p.getCodec().readTree(p);
        if (!treeNode.isArray()) {
            List<String> keys = StreamSupport
                    .stream(Spliterators.spliteratorUnknownSize(treeNode.fieldNames(), Spliterator.ORDERED), true)
                    .collect(Collectors.toList());

            if (keys.stream().anyMatch(DeserializerUtils::isInteger)) {
                keys = keys.stream().sorted(Comparator.comparingInt(Integer::valueOf)).collect(Collectors.toList());

            }
            return keys
                    .stream()
                    .map(s -> {
                        try {
                            JsonParser traverse = treeNode.get(s).traverse(p.getCodec());
                            JsonToken currentToken = traverse.getCurrentToken();
                            if (Objects.isNull(currentToken))
                                currentToken = traverse.nextToken();
                            if (Objects.nonNull(currentToken))
                                return ctxt.readValue(traverse, fClass);
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                        return null;
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private static boolean isInteger(String s) {
        return isInteger(s, 10);
    }

    private static boolean isInteger(String s, int radix) {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) return false;
                else continue;
            }
            if (Character.digit(s.charAt(i), radix) < 0) return false;
        }
        return true;
    }

}
