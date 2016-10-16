package com.vlasovartem.wotalyzer.utils.validators;

import java.util.Map;
import java.util.Optional;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class ValidatorUtils {

    public static <T> Optional<T> getParameter (Map<String, Object> queryParams, String paramName) {
        return Optional.ofNullable((T) queryParams.get(paramName));
    }

}
