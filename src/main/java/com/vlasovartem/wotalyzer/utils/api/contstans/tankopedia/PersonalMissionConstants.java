package com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 10/10/16.
 */
public interface PersonalMissionConstants extends BasicAPIConstants {

    /* numeric, list Идентификатор кампании */
    String CAMPAIGN_ID = "campaign_id";
    /* numeric, list Идентификатор операции */
    String OPERATION_ID = "operation_id";
    /* numeric, list Идентификатор ветки задач */
    String SET_ID = "set_id";
    /* string, list Тег задачи */
    String TAG = "tag";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, CAMPAIGN_ID, OPERATION_ID, SET_ID, TAG);

}
