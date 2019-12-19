package com.cloud.yanger.commons.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.IOException;
import java.util.Date;

public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        super();

        SimpleModule module = new SimpleModule("v3", new Version(3, 0, 0, null));

        module.addSerializer(Date.class, new JsonSerializer<Date>() {
            @Override
            public void serialize(Date value,
                                  JsonGenerator jsonGenerator,
                                  SerializerProvider provider)
                    throws IOException {
                jsonGenerator.writeString(
                        value != null ? DateFormatUtils.format(value.getTime(), "yyyy-MM-dd HH:mm:ss") : null
                );
            }
        });
        module.addDeserializer(Date.class, new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonParser jp, DeserializationContext ctxt)
                    throws IOException {
                try {
                    if (jp.getText() != null)
                        return new Date(DateUtils.parseDate(jp.getText(), "yyyy-MM-dd HH:mm:ss").getTime());
                } catch (Exception e) {
                    return null;
                }
                return null;
            }
        });
        getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {

            @Override
            public void serialize(
                    Object value,
                    JsonGenerator jg,
                    SerializerProvider sp) throws IOException {
                jg.writeString("");
            }
        });

        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.registerModule(module);

    }
}
