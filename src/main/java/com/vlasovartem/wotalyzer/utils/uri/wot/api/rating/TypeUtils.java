package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.Type;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.TypeConstants;

import java.util.List;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class TypeUtils extends RatingUtils<Type> {

    public TypeUtils() {
        super(Type.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return TypeConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return TypeConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return TypeConstants.REQUIRED_PARAMS;
    }
}
