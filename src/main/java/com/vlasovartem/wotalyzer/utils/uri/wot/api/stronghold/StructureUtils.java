package com.vlasovartem.wotalyzer.utils.uri.wot.api.stronghold;

import com.vlasovartem.wotalyzer.entity.wot.api.stronghold.Structure;
import com.vlasovartem.wotalyzer.utils.api.contstans.stronghold.StructureConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class StructureUtils extends MainUtils<Structure> {

    public StructureUtils() {
        super(Structure.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return StructureConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return StructureConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return StructureConstants.REQUIRED_PARAMS;
    }
}
