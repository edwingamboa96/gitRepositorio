package com.geekshirt.orderservice.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwagqerConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).
				select().apis(RequestHandlerSelectors.any()).
				paths(PathSelectors.any()).
				build().globalOperationParameters(crearParamaetrosHeaderCanonico()).apiInfo(getApi());

	}
	
	private ApiInfo getApi() {
		return new ApiInfoBuilder().title("GeekShirt Oder service API  ").
				version("1.0").contact(new Contact("Edwin", "http://edwin.gamboa.com", "abc@gmail.com"))
				.description("This API provides all methods required for order management").build();
				
	}
	
	private ArrayList<Parameter> crearParamaetrosHeaderCanonico()
	{
		ArrayList<Parameter> parametros = new ArrayList<Parameter>();
		
		String paramType = "header";
		parametros.add( new ParameterBuilder()
                .name("header")
                .description("Header con mis parametros {\\\"nombre\\\":\\\"\\\",\\\"tipo\\\":\\\"\\\",\\\"valor\\\":\\\"\\\"}")
                .modelRef(new ModelRef("string"))
                .parameterType(paramType)
                .required(true)
                .build() );
		
		parametros.add( new ParameterBuilder()
                .name("Authorization")
                .description("algoooooooooooooooo")
                .modelRef(new ModelRef("string"))
                .parameterType(paramType)
                .required(true)
                .build() );
		
		return parametros;
	}

}
