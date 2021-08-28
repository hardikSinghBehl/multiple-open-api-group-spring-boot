## Multiple Open-API groups: Spring boot
#### POC showing how to divide endpoint(s) among different Open-API screens
#### [Demo Link (Select definition from top right corner)](https://x2-open-api-groups-spring-boot.herokuapp.com/swagger-ui.html)
---

https://user-images.githubusercontent.com/69693621/131207157-e017fc2d-631a-4df5-9063-21d3520df48a.mov

---
## Steps 
1. Put the below mentioned property in the application.properties file
```
springdoc.api-docs.groups.enabled=true
```
2. Divide the controller endpoint(s) of each group in a distinct base package
```
- com.behl.controller.nsfw
  - put endpoint(s) that belong in 'nsfw' group here
- com.behl.controller.sfw
  - put endpoint(s) that belong in 'sfw' group here
```
3. Define Bean of type GroupedOpenApi for each group and specify the package to scan 
```
@Bean
public GroupedOpenApi nsfwOpenApi() {
	String packagesToscan[] = { "com.behl.agares.controller.nsfw" };
	return GroupedOpenApi.builder().group("nsfw")
			.packagesToScan(packagesToscan).build();
}
```
4. (Optional) To customize the Open-API defintion including info, contact, security etc implement OpenApiCustomiser interface and override customize() containing your custom configurations
```
@Configuration
public class NsfwOpenApiCustomizer implements OpenApiCustomiser {

	@Override
	public void customise(final OpenAPI openApi) {
		final var info = new Info().title("Not Safe For Work Joke API").version("1.0")
				.description("Endpoint(s) to expose to mature audience")
				.contact(new Contact().email("hardik.behl7444@gmail.com").name("Hardik Singh Behl")
						.url("https://www.linkedin.com/in/hardiksinghbehl/"));
		openApi.info(info);
	}

}

```
Pass the class implementing OpenApiCustomizer in the .addOpenApiCustomiser(OpenApiCustomizer) method in the earlier created GroupedOpenApi Bean
```
@Bean
public GroupedOpenApi sfwOpenApi() {
	String packagesToscan[] = { "com.behl.agares.controller.sfw" };
	return GroupedOpenApi.builder().group("sfw").addOpenApiCustomiser(nsfwOpenApiCustomizer)
			.packagesToScan(packagesToscan).build();
}
```
5. Access the swagger-ui at the below URI containing multiple configured definition/groups
```
http://server:port/swagger-ui.html
```
```
http://localhost:8080/swagger-ui.html
```
