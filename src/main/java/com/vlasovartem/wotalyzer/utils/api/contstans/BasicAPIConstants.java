package com.vlasovartem.wotalyzer.utils.api.contstans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by artemvlasov on 14/01/16.
 */
public interface BasicAPIConstants {
    String BASIC_URL = "";
    //Application id provided by Wargaming. Required
    String APPLICATION_ID_PARAM = "application_id";
    /*
        For localization, possible values:
        "en" — English
        "ru" — Русский (используется по умолчанию)
        "pl" — Polski
        "de" — Deutsch
        "fr" — Français
        "es" — Español
        "zh-cn" — 简体中文
        "tr" — Türkçe
        "cs" — Čeština
        "th" — ไทย
        "vi" — Tiếng Việt
        "ko" — 한국어
    */
    String LANGUAGE_PARAM = "language";
    // List of fields or field that should be returned by API (String or List) devided by ,.
    // To Exclude fields should be used "-" in front of field
    String FIELDS_PARAM = "fields";
    List<String> BASIC_API_CONSTANTS = new ArrayList<>(Arrays.asList(APPLICATION_ID_PARAM, LANGUAGE_PARAM, FIELDS_PARAM));
    List<String> REQUIRED_PARAMS = Collections.emptyList();
}
