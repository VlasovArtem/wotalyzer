package com.vlasovartem.wotalyzer.utils.uri.wot.api.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Arena;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.ArenaConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by artemvlasov on 10/10/16.
 */
@Component
public class ArenaUtils extends MainUtils<Arena> {

    ArenaUtils() {
        super(Arena.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return ArenaConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ArenaConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ArenaConstants.REQUIRED_PARAMS;
    }
}
