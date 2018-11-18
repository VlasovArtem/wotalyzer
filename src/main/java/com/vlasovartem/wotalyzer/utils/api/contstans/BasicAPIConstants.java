package com.vlasovartem.wotalyzer.utils.api.contstans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 14/01/16.
 */
public abstract class BasicAPIConstants {

    private String basicUrl = "";
    private List<String> basicApiConstants;
    private List<String> requiredParams = Collections.emptyList();

    protected BasicAPIConstants(String basicUrl) {
        this.basicUrl = basicUrl;
        basicApiConstants = new ArrayList<>(Arrays.asList(APPLICATION_ID_PARAM, LANGUAGE_PARAM, FIELDS_PARAM));
        requiredParams = Collections.emptyList();
    }

    public String getBasicUrl() {
        return basicUrl;
    }

    public List<String> getBasicApiConstants() {
        return basicApiConstants;
    }

    public List<String> getRequiredParams() {
        return requiredParams;
    }

    protected void addBasicApiConstants(List<String> additionalBasicApiConstants) {
        basicApiConstants.addAll(additionalBasicApiConstants);
    }

    protected void addRequiredParams(List<String> additionalRequiredParams) {
        if (requiredParams.isEmpty()) {
            requiredParams = additionalRequiredParams;
        } else {
            requiredParams.addAll(additionalRequiredParams);
        }
    }
}
