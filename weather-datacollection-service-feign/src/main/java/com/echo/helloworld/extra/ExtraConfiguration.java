package com.echo.helloworld.extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Configuration
public class ExtraConfiguration {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate restTemplate() {
//            RestTemplate restTemplate = new RestTemplate(
//                    new HttpComponentsClientHttpRequestFactory()); // 使用HttpClient，支持GZIP
//            restTemplate.getMessageConverters().set(1,
//                    new StringHttpMessageConverter(StandardCharsets.UTF_8)); // 支持中文编码
        return restTemplateBuilder.build();
    }
}
