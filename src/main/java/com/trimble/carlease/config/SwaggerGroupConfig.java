package com.trimble.carlease.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:17:27 AM
 * Since: 1.0.0
 * @See #
 */

@Configuration
public class SwaggerGroupConfig {

	@Bean
	public GroupedOpenApi userApiGroup() {
		return GroupedOpenApi.builder().group("User APIs").pathsToMatch("/api/v1/users/**")
				.displayName("User Management").build();
	}

	@Bean
	public GroupedOpenApi leaseApiGroup() {
		return GroupedOpenApi.builder().group("Lease APIs").pathsToMatch("/api/v1/leases/**")
				.displayName("Lease Operations").build();
	}

	@Bean
	public GroupedOpenApi carApiGroup() {
		return GroupedOpenApi.builder().group("Car APIs").pathsToMatch("/api/v1/cars/**").displayName("Car Information")
				.build();
	}

	@Bean
	public GroupedOpenApi adminApiGroup() {
		return GroupedOpenApi.builder().group("Admin APIs").pathsToMatch("/api/v1/admin/**")
				.displayName("Administrative Endpoints").build();
	}
}
