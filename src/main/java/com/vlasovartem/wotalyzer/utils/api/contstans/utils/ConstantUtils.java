package com.vlasovartem.wotalyzer.utils.api.contstans.utils;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/**
 * Created by artemvlasov on 28/09/16.
 */
public class ConstantUtils {

    public static List<String> generate(List<String> params, String... newParams) {
        Collections.addAll(params, newParams);
        return params;
    }

    public static <T extends BasicAPIConstants> String getAPIBaseUrl(Class<T> type) {
        return getData(type, "BASIC_URL");
    }

    public static <T extends BasicAPIConstants> List<String> getAPIConstants(Class<T> type) {
        return getData(type, "BASIC_API_CONSTANTS");
    }

    public static <T extends BasicAPIConstants> List<String> getRequiredAPIParams(Class<T> type) {
        return getData(type, "REQUIRED_PARAMS");
    }

    private static <U, T extends BasicAPIConstants> U getData(Class<T> type, String fieldName) {
        try {
            Field basic_url = type.getDeclaredField(fieldName);
            return (U) basic_url.get(basic_url.getType().newInstance());
        } catch (NoSuchFieldException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
