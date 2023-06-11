package com.sapient.kafka.config;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

@Configuration
public class MongoConfig {

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        List<Converter<?, ?>> converters = Arrays.asList(
            new ZonedDateTimeReadConverter(),
            new ZonedDateTimeWriteConverter()
        );
        return new MongoCustomConversions(converters);
    }

    private static class ZonedDateTimeReadConverter implements Converter<Long, ZonedDateTime> {
        @Override
        public ZonedDateTime convert(Long epochMilli) {
            return ZonedDateTime.ofInstant(java.time.Instant.ofEpochMilli(epochMilli), ZoneOffset.UTC);
        }
    }

    private static class ZonedDateTimeWriteConverter implements Converter<ZonedDateTime, Long> {
        @Override
        public Long convert(ZonedDateTime zonedDateTime) {
            return zonedDateTime.toInstant().toEpochMilli();
        }
    }
}
