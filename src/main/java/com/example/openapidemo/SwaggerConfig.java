package com.example.openapidemo;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Predicate<String> postPaths() {
        return or(regex("/api/posts.*"), regex("/api/demo.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("openApi").description("Open Api Desc").contact("contact")
                .license("shivaraj@gmail.com").licenseUrl("shivaraj@gmail.com").version("1.0.0").build();
    }


    @Bean
    public Docket postApi() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.groupName("open-api").apiInfo(apiInfo()).select().paths(postPaths()).build();


//        docket.globalResponseMessage(RequestMethod.GET, ImmutableList.of(new ResponseMessageBuilder()
//                .code(400)
//                .message("Bad Request")
//                .responseModel(new ModelRef("Error")).build(), new ResponseMessageBuilder()
//                .code(500)
//                .message("Internal Server Error")
//                .responseModel(new ModelRef("Error")).build()));

        return docket;

    }
}