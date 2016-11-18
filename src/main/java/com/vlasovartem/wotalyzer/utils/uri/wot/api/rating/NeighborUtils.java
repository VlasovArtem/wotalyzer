package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.Neighbor;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.NeighborConstants;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator.validateBattleType;
import static com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator.validateDate;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class NeighborUtils extends RatingUtils<Neighbor> {

    private static final Logger LOGGER = LogManager.getLogger(NeighborUtils.class);

    @Override
    protected Class getType() {
        return Neighbor.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return NeighborConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return NeighborConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return NeighborConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validateBattleType(), validateDate(), MainValidator.validateLimit(0, 50, 5));
    }

}
