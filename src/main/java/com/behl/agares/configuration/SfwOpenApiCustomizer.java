package com.behl.agares.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SfwOpenApiCustomizer implements OpenApiCustomiser {

	@Override
	public void customise(final OpenAPI openApi) {
		final var info = new Info().title("Safe For Work Joke API").version("1.0")
				.description("Endpoint(s) to expose to non-mature audience")
				.contact(new Contact().email("hardik.behl7444@gmail.com").name("Hardik Singh Behl")
						.url("https://www.linkedin.com/in/hardiksinghbehl/"));
		openApi.info(info);
	}

}