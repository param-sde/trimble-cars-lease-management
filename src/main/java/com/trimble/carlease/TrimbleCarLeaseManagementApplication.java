package com.trimble.carlease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication(scanBasePackages = "com.trimble")
@EnableJpaAuditing
@EnableCaching
@OpenAPIDefinition(info = @Info(title = "Trimble Cars", version = "v1", description = "Tribmle Cars Lease Management API Document."))
@ComponentScan(basePackages = "com.trimble.carlease.mapper")
public class TrimbleCarLeaseManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrimbleCarLeaseManagementApplication.class, args);
	}

}
