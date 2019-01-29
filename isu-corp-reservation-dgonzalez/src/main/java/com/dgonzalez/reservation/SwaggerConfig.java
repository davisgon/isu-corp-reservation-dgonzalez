package com.dgonzalez.reservation;

/**
 * Expert system of management of reservations of places of interest, this
 * application is made based on the requirements and points of pain exposed by
 * the Client. As part of the technical test.
 *
 * @version 1.00.0
 * @autor David Gonzalez
 * @client ISUCorp
 * Implement Swagger
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.dgonzalez.reservation.controller"))
                .paths(PathSelectors.any()).build();
    }

}
