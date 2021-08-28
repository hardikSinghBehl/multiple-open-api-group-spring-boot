package com.behl.agares.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

	@Bean
	public GroupedOpenApi nsfwOpenApi() {
		String packagesToscan[] = { "com.behl.agares.controller.nsfw" };
		return GroupedOpenApi.builder().group("nsfw").packagesToScan(packagesToscan).build();
	}

	@Bean
	public GroupedOpenApi sfwOpenApi() {
		String packagesToscan[] = { "com.behl.agares.controller.sfw" };
		return GroupedOpenApi.builder().group("sfw").packagesToScan(packagesToscan).build();
	}

}
