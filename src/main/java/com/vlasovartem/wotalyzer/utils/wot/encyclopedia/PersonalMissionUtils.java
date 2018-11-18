package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.PersonalMission;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.PersonalMissionConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToList;

/**
 * Created by artemvlasov on 10/10/16.
 */
@Component
public class PersonalMissionUtils extends MainUtils<PersonalMission> {

    public List<PersonalMission> getPersonalMissions() {
        return convertMapToList(getApiResponseMap(""));
    }

    @Override
    protected Class<PersonalMission> getType() {
        return PersonalMission.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return PersonalMissionConstants.getInstance();
    }
}
