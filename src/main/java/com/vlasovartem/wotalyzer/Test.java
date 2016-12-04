package com.vlasovartem.wotalyzer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by artemvlasov on 16/11/2016.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/artemvlasov/git/WOT Analyzer/test.json");
        ObjectMapper build = Jackson2ObjectMapperBuilder
                .json()
                .autoDetectFields(true)
                .failOnUnknownProperties(false)
                .propertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd"))
                .featuresToEnable(DeserializationFeature.UNWRAP_ROOT_VALUE)
                .build();
        if (file.exists()) {
//            Player player = build.reader().forType(PlayerResponse.class).readValue(file);
            System.out.println("Test");
        }

        //My account id = 231523158888
        //Second user = 6831042
        //Tank = 2417
        //font id = campaign_05_ru_east
        //clan_id = 68851
        //season_id = fourth_season
        //event id = steel_corrida_second_step
        //Rating types 1,7,28,all
        //rating type - survived_ratio
    }

}
