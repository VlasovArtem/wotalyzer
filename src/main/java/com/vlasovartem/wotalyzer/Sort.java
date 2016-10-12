package com.vlasovartem.wotalyzer;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class Sort {


    public static void main(String[] args) throws IOException {
        String fieldsPattern = "String %s_PARAM = \"%s;\"";
        List<String> collect = Stream.of("application_id", "language", "fields", "tier", "order_by", "engine_id", "gun_id", "suspension_id", "turret_id", "radio_id", "profile_id", "provision_id", "campaign_id", "operation_id", "set_id", "tag", "nation", "module_id", "access_token", "extra", "search", "tank_id", "clan_id", "rank_field", "limit", "page_no", "account_id", "type", "battle_type", "date")
                .sorted()
                .map(s -> String.format(fieldsPattern, s.toUpperCase(), s))
                .collect(Collectors.toList());
        File file = new File("sorted.txt");
        file.createNewFile();
        FileUtils.writeLines(file, collect);
    }

}
