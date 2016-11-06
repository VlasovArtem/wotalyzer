package com.vlasovartem.wotalyzer.utils.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by artemvlasov on 31/10/2016.
 */
public class TimestampToLocalDateTimeConverter extends StdConverter<Long,LocalDateTime> {
    @Override
    public LocalDateTime convert(Long value) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(value), ZoneId.systemDefault());
    }
}
