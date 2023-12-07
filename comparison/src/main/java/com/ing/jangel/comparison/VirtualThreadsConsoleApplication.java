package com.ing.jangel.comparison;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ing.jangel.comparison.service.MultipleThreadsTask;

@SpringBootApplication
public class VirtualThreadsConsoleApplication implements CommandLineRunner {
	@Autowired
	@Qualifier("virtualThreadsService")
	private MultipleThreadsTask virtualThreadService;

	@Autowired
	@Qualifier("regularThreadsService")
	private MultipleThreadsTask regularThreadService;

	private static final Logger LOG = LoggerFactory.getLogger(VirtualThreadsConsoleApplication.class);

	public static void main(String[] args) {
		VirtualThreadsConsoleApplication.LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(VirtualThreadsConsoleApplication.class, args);
		VirtualThreadsConsoleApplication.LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) {
		VirtualThreadsConsoleApplication.LOG.info("EXECUTING : command line runner");

		try {
			TimeUnit.SECONDS.sleep(30);
			runServices();
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			VirtualThreadsConsoleApplication.LOG.error(e.getMessage(), e);
		}
	}
	
	private void runServices() throws InterruptedException {
		VirtualThreadsConsoleApplication.LOG.info("Regular=> " + regularThreadService.doTask() + " milliseconds");
		TimeUnit.SECONDS.sleep(10);
		VirtualThreadsConsoleApplication.LOG.info("Virtual=> " + virtualThreadService.doTask() + " milliseconds");
	}
}
