package com.vlasovartem.wotalyzer.utils.converter;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by artemvlasov on 11/12/2016.
 */
public class TimestampToLocalDateTimeConverterTest {

    @Test
    public void convertTest() {
        LocalDate today = LocalDate.now();
        TimestampToLocalDateTimeConverter converter = new TimestampToLocalDateTimeConverter();
        LocalDateTime convert = converter.convert(today.atStartOfDay(ZoneId.systemDefault()).toEpochSecond());
        Assert.assertTrue(convert.toLocalDate().equals(today));
    }


}
