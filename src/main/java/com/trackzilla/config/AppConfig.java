package com.trackzilla.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {

    @Bean
    public MongoClient mongo(){
        ConnectionString cs = new ConnectionString("mongodb://localHost:27017/trackzilla");
        MongoClientSettings mcs= MongoClientSettings.builder()
                .applyConnectionString(cs).build();
        return MongoClients.create(mcs);
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongo(),"trackzilla");
    }

}
