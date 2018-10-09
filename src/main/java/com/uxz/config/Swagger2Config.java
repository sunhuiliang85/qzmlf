package com.uxz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2全局配置
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket config() {
//        //全局参数，会在所有api文档中加上的参数
//        List<Parameter> pars = new ArrayList<Parameter>();  
//        ParameterBuilder tokenPar = new ParameterBuilder();  
//        tokenPar.name("accessToken").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.uxz"))
                .build()
//                .globalOperationParameters(pars)//设置全局参数
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .version("1.0")
                .title("打卡 API文档")
                .build();
    }
}