package org.utn.marvellator.config;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.utn.marvellator.repository.UserRepository;

@Configuration
@EnableMongoRepositories
@ComponentScan(basePackageClasses = { UserRepository.class })
public class MarvellatorTestConfig extends AbstractMongoConfiguration {

    @Bean
    @Override
    protected String getDatabaseName() {
        return "test-db";
    }

    @Bean
    @Override
    public Mongo mongo() {
        return new Fongo("test").getMongo();
    }

    @Bean
    @Override
    protected String getMappingBasePackage() {
        return "org.utn.marvellator";
    }
}