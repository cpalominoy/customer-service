package com.pandero.customerservice.config;

import com.pandero.customerservice.config.properties.OpenApiProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/** Esta clase contiene configuraciones de OpenApi 3 para esta aplicación. */
@Configuration
@RequiredArgsConstructor
@OpenAPIDefinition(
    servers = {
      @Server(url = "http://localhost:8081", description = "local"),
      @Server(url = "http://dev3-ginni.pandero.com.pe", description = "dev3"),
      @Server(url = "https://int-ginni.pandero.com.pe", description = "integración")
    })
public class OpenApi30Config {

  private final OpenApiProperties properties;

  @Bean
  public OpenAPI customOpenAPI() {
    final String securitySchemeName = "bearerAuth";
    final String apiTitle = String.format("%s", StringUtils.capitalize(properties.getName()));

    var info =
        new Info()
            .title(apiTitle)
            .version(properties.getVersion())
            .description(properties.getDescription());

    var securityScheme =
        new SecurityScheme()
            .name(securitySchemeName)
            .type(Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT");

    var components = new Components().addSecuritySchemes(securitySchemeName, securityScheme);

    return new OpenAPI()
        .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
        .components(components)
        .info(info);
  }
}
