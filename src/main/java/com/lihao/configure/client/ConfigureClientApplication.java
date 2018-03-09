package com.lihao.configure.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
	
	@RequestMapping("/")
    public String home() {
        return "Hello World! " + " " + lihao;
    }
}
