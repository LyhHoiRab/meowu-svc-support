package com.meowu.svc.support.commons.config.converter;

import com.google.gson.GsonBuilder;
import com.meowu.starter.commons.utils.GsonUtils;
import com.meowu.starter.commons.utils.adapter.DateAdapter;
import com.meowu.starter.commons.utils.adapter.TypeAdapter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.nio.charset.StandardCharsets;

@Configuration
public class HttpMessageConverterConfig{

    @Bean
    public HttpMessageConverters gsonConverter(){
        // type adapter
        TypeAdapter<?>[] typeAdapters = new TypeAdapter<?>[]{new DateAdapter()};
        // gson builder
        GsonBuilder builder = GsonUtils.getBuilder(true, true, typeAdapters);
        // converter
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        converter.setGson(builder.create());
        return new HttpMessageConverters(converter);
    }
}
