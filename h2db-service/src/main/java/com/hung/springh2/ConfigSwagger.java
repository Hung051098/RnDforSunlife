package com.hung.springh2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
@Configuration
public class ConfigSwagger {
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // Thiết lập các server dùng để test api
                .servers(Lists.newArrayList(
                        new Server().url("http://localhost:10005"),
                        new Server().url("http://localhost:22001")
                ))
                // info
                .info(new Info().title("Loda Application API")
                                .description("Sample OpenAPI 3.0"));
    }
}
