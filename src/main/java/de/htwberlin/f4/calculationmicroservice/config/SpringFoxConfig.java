package de.htwberlin.f4.calculationmicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket swaggerConfiguration() {
        // return a prepared Docket instance
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/v1/calculator/calculatemehrwertsteuer"))
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Calculate Mehrwertsteuer API",
                "Calculate the 'Merwertsteuer' of a given price",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Gleb & Linda", "https://github.com/GlebTanaka/kbe-calculation-microservice", "gleb5655@gmail.com"),
                "API License",
                "https://github.com/GlebTanaka/kbe-calculation-microservice",
                Collections.emptyList()
        );
    }
}
