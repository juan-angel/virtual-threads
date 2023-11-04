package com.ing.jangel.virtualthreads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ing.jangel.virtualthreads.service.MultipleThreadsTask;

@SpringBootApplication
public class VirtualThreadsConsoleApplication implements CommandLineRunner {
	@Autowired
	@Qualifier("virtualThreadsService")
	private MultipleThreadsTask virtualThreadService;
	
	@Autowired
	@Qualifier("regularThreadsService")
	private MultipleThreadsTask regularThreadService;
	
	private static Logger LOG = LoggerFactory.getLogger(VirtualThreadsConsoleApplication.class);

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(VirtualThreadsConsoleApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }
 
    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
 
        LOG.info("Virtual=> " + virtualThreadService.doTask() + " milliseconds");
        LOG.info("Regular=> " + regularThreadService.doTask() + " milliseconds");
    }
}
