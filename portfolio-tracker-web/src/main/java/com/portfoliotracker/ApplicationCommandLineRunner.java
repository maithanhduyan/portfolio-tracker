package com.portfoliotracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * This CommandLineRunner fires off at runtime and boots up our GUI.
 */
@Component
public class ApplicationCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ApplicationCommandLineRunner.class);

	@Autowired
	public ApplicationCommandLineRunner() {
		log.info("ApplicationCommandLineRunner Contructor");
	}

	@Override
	public void run(String... args) {
		try {
			log.info("Command Line Starting...");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

}
