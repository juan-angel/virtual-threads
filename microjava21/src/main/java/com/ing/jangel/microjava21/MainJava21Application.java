package com.ing.jangel.microjava21;

import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainJava21Application {
	public static void main(String[] args) {
		SpringApplication.run(MainJava21Application.class, args);
	}

	@Bean
    TomcatProtocolHandlerCustomizer<?> protocolHandlerVirtualThreadExecutorCustomizer() {
            return protocolHandler -> {
                    protocolHandler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
            };
    }
	
}