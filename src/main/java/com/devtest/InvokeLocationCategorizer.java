package com.devtest;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InvokeLocationCategorizer {
    public static void main(String[] args) throws Exception {
	Logger logger = Logger.getLogger(InvokeLocationCategorizer.class);

	logger.info("Running [" + InvokeLocationCategorizer.class.getSimpleName() + "]");
	SpringApplication.run(InvokeLocationCategorizer.class, args);
    }
}
