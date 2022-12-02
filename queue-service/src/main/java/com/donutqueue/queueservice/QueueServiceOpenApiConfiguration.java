package com.donutqueue.queueservice;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bl4kee
 * @since 02.12.2022
 */
@Configuration
public class QueueServiceOpenApiConfiguration {

  @Value("${api.common.version}")
  String apiVersion;

  @Value("${api.common.title}")
  String apiTitle;

  @Value("${api.common.description}")
  String apiDescription;

  @Bean
  public OpenAPI getOpenApiDocumentation() {
    return new OpenAPI()
        .info(new Info().title(apiTitle)
            .description(apiDescription)
            .version(apiVersion));
  }
}
