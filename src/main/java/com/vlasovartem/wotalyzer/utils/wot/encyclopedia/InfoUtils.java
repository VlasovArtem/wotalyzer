package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Info;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.InfoConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

/**
 * Created by artemvlasov on 09/10/16.
 */
@Component
public class InfoUtils extends MainUtils<Info> {

    public Optional<Info> getInfo() {
        APIResponse<Info> informationAPIResponse = getApiResponse(Collections.emptyMap());
        return informationAPIResponse.getContent();
    }

    @Override
    protected Class<Info> getType() {
        return Info.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return InfoConstants.getInstance();
    }
}
