package io.spring.friendsnet.controller.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * The Logger.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Init.
     */
    @PostConstruct
    public void init() {
        logger.info("Initializing SwaggerConfig...");
    }

    /**
     * Api docket.
     *
     * @return the docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.everis.alicante.courses.beca.summer17.friendsnet.controller"))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }

    /**
     * Api info api info.
     *
     * @return the api info
     */
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("Sample Application REST API", "The API exposes common functionallities to " +
                "manage the FirendsNet",
                "API TOS", "Terms of service", "ginxaco@gmail.com", "License of API", "API license URL");
        return apiInfo;
    }
}