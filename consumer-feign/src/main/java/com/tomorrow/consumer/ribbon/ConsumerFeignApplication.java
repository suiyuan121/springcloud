package com.tomorrow.consumer.ribbon;

import feign.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;


@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ConsumerFeignApplication {

	@Bean
	public static Request.Options requestOptions(ConfigurableEnvironment env) {
		int ribbonReadTimeout = env.getProperty("ribbon.ReadTimeout", int.class, 70000);
		int ribbonConnectionTimeout = env.getProperty("ribbon.ConnectTimeout", int.class, 60000);

		return new Request.Options(ribbonConnectionTimeout, ribbonReadTimeout);
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignApplication.class, args);
	}
}
