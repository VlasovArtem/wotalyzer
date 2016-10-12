package com.vlasovartem.wotalyzer.utils.api.contstans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 14/01/16.
 */
public interface BasicAPIConstants {

    String BASIC_URL = "";
    List<String> BASIC_API_CONSTANTS = new ArrayList<>(Arrays.asList(APPLICATION_ID_PARAM, LANGUAGE_PARAM, FIELDS_PARAM));
    List<String> REQUIRED_PARAMS = Collections.emptyList();

}
