package com.vlasovartem.wotalyzer.utils.query.builder;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.RankField;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.RatingType;
import org.junit.Test;

import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.RANK_FIELD_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TYPE_PARAM;
import static com.vlasovartem.wotalyzer.utils.query.builder.RatingParamBuilder.newBuilder;
import static org.junit.Assert.assertEquals;

/**
 * Created by artemvlasov on 11/12/2016.
 */
public class RatingParamBuilderTest {

    @Test
    public void withTypeTest() {
        Map<String, Object> queryParams = newBuilder().withType(RatingType.TYPE_ALL).build();
        assertEquals(RatingType.TYPE_ALL.getValue(), queryParams.get(TYPE_PARAM));
    }

    @Test
    public void withRankFieldTest() {
        Map<String, Object> queryParams = newBuilder().withRankField(RankField.BATTLES_COUNT).build();
        assertEquals(RankField.BATTLES_COUNT.getValue(), queryParams.get(RANK_FIELD_PARAM));
    }
}
