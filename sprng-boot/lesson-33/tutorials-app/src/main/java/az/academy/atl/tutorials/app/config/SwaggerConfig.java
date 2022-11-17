package az.academy.atl.tutorials.app.config;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.singletonList;
import static springfox.documentation.builders.PathSelectors.any;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String TITLE = "TUTORIALS APP REST API";
    private static final String VERSION = "1.0";
    private static final String AUTHORIZATION = "Authorization";
    private static final String HEADER = "header";
    private static final String API_KEY = "apiKey";
    private static final String GLOBAL = "global";
    private static final String ACCESS_EVERYTHING = "accessEverything";

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("az.academy.atl.tutorials.app"))
                .paths(any()).build()
                .securitySchemes(newArrayList(apiKey()))
                .securityContexts(singletonList(securityContext()))
                .apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(TITLE)
                .contact(new Contact("Tutorial MS", "https://www.atltech.az", "Nijat.Dursunlu@atltech.az"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version(VERSION)
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey(API_KEY, AUTHORIZATION, HEADER);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(any())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope(GLOBAL, ACCESS_EVERYTHING);
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return singletonList(new SecurityReference(API_KEY, authorizationScopes));
    }
}