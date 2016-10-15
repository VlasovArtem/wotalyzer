package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating;

import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public abstract class RatingUtils<T> extends MainUtils<T> {

    private static final Logger LOGGER = LogManager.getLogger(RatingUtils.class);

    public RatingUtils(Class<T> type) {
        super(type);
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(RatingValidator.validateBattleType());
    }

}
