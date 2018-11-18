package com.vlasovartem.wotalyzer.utils.wot.stronghold;

import com.vlasovartem.wotalyzer.entity.wot.api.stronghold.ClanStronghold;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.stronghold.ClanStrongholdConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class ClanStrongholdUtils extends MainUtils<ClanStronghold> {

    @Override
    protected Class<ClanStronghold> getType() {
        return ClanStronghold.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return ClanStrongholdConstants.getInstance();
    }
}
