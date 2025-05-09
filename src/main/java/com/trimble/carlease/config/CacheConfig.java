package com.trimble.carlease.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

/**
 * Author: PARAMESHWARAN PV
 * Date: 06-May-2025 : 9:14:28 AM
 * Since: 1.0.0
 * @See #
 */

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public CacheManager cacheManager() {
		CaffeineCacheManager cacheManager = new CaffeineCacheManager("cars", "leases", "users");
		cacheManager.setCaffeine(caffeineCacheBuilder());
		return cacheManager;
	}

	Caffeine<Object, Object> caffeineCacheBuilder() {
		return Caffeine.newBuilder().initialCapacity(100).maximumSize(500).expireAfterWrite(10, TimeUnit.MINUTES)
				.recordStats();
	}
}
