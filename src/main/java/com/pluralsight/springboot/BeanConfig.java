package com.pluralsight.springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean @Qualifier("bean")
    public ProductDao simpleDao() {
        return new SimpleProductDao();
    }
}
