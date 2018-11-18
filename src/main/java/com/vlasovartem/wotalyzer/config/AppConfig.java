package com.vlasovartem.wotalyzer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;

/**
 * Created by artemvlasov on 13/01/16.
 */
@Configuration
@ComponentScan("com.vlasovartem.wotalyzer")
@EnableMongoRepositories(basePackages = "com.vlasovartem.wotalyzer.repository")
@PropertySource("classpath:api.properties")
public class AppConfig extends AbstractMongoConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder
                .json()
                .autoDetectFields(true)
                .failOnUnknownProperties(false)
                .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd"))
                .build();
    }

    @Override
    protected String getDatabaseName() {
        return "wotalyzer";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(new MongoClientURI("mongodb://localhost"));
    }
}
