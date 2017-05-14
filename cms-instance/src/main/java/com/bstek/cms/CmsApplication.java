package com.bstek.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}
}
