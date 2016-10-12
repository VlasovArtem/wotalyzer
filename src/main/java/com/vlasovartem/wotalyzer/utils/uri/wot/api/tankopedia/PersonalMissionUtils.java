package com.vlasovartem.wotalyzer.utils.uri.wot.api.tankopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.personal_missions.PersonalMission;
import com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia.PersonalMissionConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by artemvlasov on 10/10/16.
 */
@Component
public class PersonalMissionUtils extends MainUtils<PersonalMission> {

    public PersonalMissionUtils() {
        super(PersonalMission.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return PersonalMissionConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return PersonalMissionConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return PersonalMissionConstants.REQUIRED_PARAMS;
    }
}
