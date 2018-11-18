package com.vlasovartem.wotalyzer.utils.wot.stronghold;

import com.vlasovartem.wotalyzer.entity.wot.api.stronghold.Structure;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.stronghold.StructureConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class StructureUtils extends MainUtils<Structure> {

    @Override
    protected Class<Structure> getType() {
        return Structure.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return StructureConstants.getInstance();
    }

}
