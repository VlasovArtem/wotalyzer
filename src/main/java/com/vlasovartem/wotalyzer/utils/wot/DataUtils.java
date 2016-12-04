package com.vlasovartem.wotalyzer.utils.wot;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 09/10/16.
 */
public class DataUtils <T, U extends BasicAPIConstants> extends MainUtils<T> {

    private final Class<U> constants;
    private final Class<T> type;

    public DataUtils(Class<T> type, Class<U> constants) {
        this.constants = constants;
        this.type = type;
    }

    @Override
    protected Class getType() {
        return type;
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
