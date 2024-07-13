package com.example.crawlerjdbc;

import com.example.crawlerjdbc.config.SqlConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class CrawlerjdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrawlerjdbcApplication.class, args);
	}

}
