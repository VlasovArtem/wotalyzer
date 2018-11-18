package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.PersonalReserve;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.PersonalReserveConstants;
import com.vlasovartem.wotalyzer.utils.response.APIResponseUtils;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by artemvlasov on 11/10/16.
 */
@Component
public class PersonalReserveUtils extends MainUtils<PersonalReserve> {

    public List<PersonalReserve> getPersonalReserves() {
        return APIResponseUtils.convertMapToList(getApiResponseMap(Collections.emptyMap()));
    }

    @Override
    protected Class<PersonalReserve> getType() {
        return PersonalReserve.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return PersonalReserveConstants.getInstance();
    }

}
