package com.example.reader.config;

import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.time.LocalDateTime;

public class CustomObjectMapper extends ObjectMapper {
    private CustomObjectMapper() {
        this.registerModule(new JavaTimeModule());
    }

    private static class JavaTimeModule extends SimpleModule {
        public JavaTimeModule() {
            super(PackageVersion.VERSION);
            this.addSerializer(LocalDateTime.class, new CustomLocalDateTimeSerializer());
        }
    }

}
