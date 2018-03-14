package com.lihao.configure.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ContextIdApplicationContextInitializer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigureClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigureClientApplication.class, args);
	}

	@Value("${lihao}")
	String lihao;

	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String home(String key) {
		if (key == null || key.isEmpty())
			key = "spring.cloud.bus.id";
		return "Hello World! " + " " + lihao + " " + key + "=" + env.getProperty(key);
	}
}
