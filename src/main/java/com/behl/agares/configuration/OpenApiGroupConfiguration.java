package com.behl.agares.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class OpenApiGroupConfiguration {

	private final NsfwOpenApiCustomizer nsfwOpenApiCustomizer;
	private final SfwOpenApiCustomizer sfwOpenApiCustomizer;

	@Bean
	public GroupedOpenApi nsfwOpenApi() {
		String packagesToscan[] = { "com.behl.agares.controller.nsfw" };
		return GroupedOpenApi.builder().group("nsfw").addOpenApiCustomiser(nsfwOpenApiCustomizer)
				.packagesToScan(packagesToscan).build();
	}

	@Bean
	public GroupedOpenApi sfwOpenApi() {
		String packagesToscan[] = { "com.behl.agares.controller.sfw" };
		return GroupedOpenApi.builder().group("sfw").addOpenApiCustomiser(sfwOpenApiCustomizer)
				.packagesToScan(packagesToscan).build();
	}

}
