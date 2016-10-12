package com.vlasovartem.wotalyzer.utils.uri.wot.api;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 09/10/16.
 */
public class DataUtils <T, U extends BasicAPIConstants> extends MainUtils<T> {

    private final Class<U> constants;

    public DataUtils(Class<T> type, Class<U> constants) {
        super(type);
        this.constants = constants;
    }

    @Override
    public String getAPIBaseUrl() {
        return ConstantUtils.getAPIBaseUrl(constants);
    }

    @Override
    public List<String> getAPIConstants() {
        return ConstantUtils.getAPIConstants(constants);
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ConstantUtils.getRequiredAPIParams(constants);
    }
}
