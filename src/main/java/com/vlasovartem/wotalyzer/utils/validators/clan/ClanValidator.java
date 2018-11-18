package com.vlasovartem.wotalyzer.utils.validators.clan;

import com.vlasovartem.wotalyzer.exception.wot.api.WotAPIValidationException;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * Created by artemvlasov on 25/12/2016.
 */
public class ClanValidator {

    private static final Logger LOGGER = LogManager.getLogger(ClanValidator.class);

    public static Function<Map<String, Object>, Boolean> validateName() {
        return t -> {
            String name = (String) t.get(WOTAPIConstants.SEARCH_PARAM);
            if (Objects.nonNull(name) && !name.isEmpty() && name.length() < 2) {
                String error = "Search name minimal length is 2 symbols";
                LOGGER.warn(error);
                throw new WotAPIValidationException(error);
            }
            return true;
        };
    }
}
