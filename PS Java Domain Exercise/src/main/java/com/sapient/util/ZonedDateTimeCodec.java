package com.sapient.util;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class ZonedDateTimeCodec implements Codec<ZonedDateTime> {

    @Override
    public void encode(final BsonWriter writer, final ZonedDateTime value, final EncoderContext encoderContext) {
        writer.writeDateTime(value.toInstant().toEpochMilli());
    }

    @Override
    public ZonedDateTime decode(final BsonReader reader, final DecoderContext decoderContext) {
        long epochMilli = reader.readDateTime();
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneOffset.UTC);
    }

    @Override
    public Class<ZonedDateTime> getEncoderClass() {
        return ZonedDateTime.class;
    }
}
