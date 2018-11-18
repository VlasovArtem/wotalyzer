package com.vlasovartem.wotalyzer.utils.query.builder;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;
import static com.vlasovartem.wotalyzer.utils.query.builder.QueryParamBuilder.newBuilder;
import static org.junit.Assert.assertEquals;

/**
 * Created by artemvlasov on 11/12/2016.
 */
public class QueryParamBuilderTest {

    @Test
    public void customParamTest() {
        String customParam = "test_custom_param";
        Map<String, Object> queryParams = newBuilder().customParam(ARENA_ID_PARAM, customParam).build();
        assertEquals(customParam, queryParams.get(ARENA_ID_PARAM));
    }

    @Test
    public void withDateTest() {
        LocalDateTime today = LocalDateTime.now();
        Map<String, Object> queryParams = newBuilder().withDate(today).build();
        assertEquals(today.truncatedTo(ChronoUnit.SECONDS).toString(), queryParams.get(DATE_PARAM));
    }

    @Test
    public void withFieldsTest() {
        List<String> testFields = Arrays.asList("test_field1", "test_field2", "test_field3");
        Map<String, Object> queryParams = newBuilder().withFields(testFields).build();
        assertEquals(testFields.stream().collect(Collectors.joining(",")), queryParams.get(FIELDS_PARAM));
    }

//    @Test
//    public void withAccountIdTest() {
//        long accountId = 999;
//        Map<String, Object> queryParams = newBuilder().withAccountId(accountId).build();
//        assertEquals(accountId, queryParams.get(ACCOUNT_ID_PARAM));
//    }
//
//    @Test
//    public void withBattleTypeTest() {
//        Map<String, Object> queryParams = newBuilder().withBattleType(BattleType.RANDOM).build();
//        assertEquals(BattleType.RANDOM.getValue(), queryParams.get(BATTLE_TYPE_PARAM));
//    }

}
