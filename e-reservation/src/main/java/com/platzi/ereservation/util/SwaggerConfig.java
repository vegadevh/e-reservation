package com.platzi.ereservation.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuracion de Swagger
 * 
 * @author vegad
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public Docket documentation() {
		return new Docket(DocumentationType.SWAGGER_2).select() //Especificar donde se va a enlazar la documentacion
			.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)) //Las peticiones se van a mananejar por medio de requesthandler - Swagger revisara la configuracion respectiva del RestController
			.paths(PathSelectors.any())
			.build();
	}
}
