package com.vlasovartem.wotalyzer.utils.uri.wot.api.tankopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.info.TankopediaInfo;
import com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia.TankopediaInfoConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;

/**
 * Created by artemvlasov on 09/10/16.
 */
public class TankopediaInfoUtils extends MainUtils<TankopediaInfo> {

    TankopediaInfoUtils() {
        super(TankopediaInfo.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return TankopediaInfoConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return TankopediaInfoConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return TankopediaInfoConstants.REQUIRED_PARAMS;
    }
}
