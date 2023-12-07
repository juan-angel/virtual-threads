package com.ing.jangel.virtualthreads;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.ing.jangel.comparison.service.MultipleThreadsTask;


@SpringBootTest
class VirtualThreadsConsoleApplicationTests {
	@Autowired
	@Qualifier("virtualThreadsService")
	private MultipleThreadsTask virtualThreadService;
	
	@Autowired
	@Qualifier("regularThreadsService")
	private MultipleThreadsTask regularThreadService;
	
	@Test
	void testSpeed() throws InterruptedException {
		long virtual = virtualThreadService.doTask();
		long regular = regularThreadService.doTask();
		
		assertTrue(virtual < regular);
	}

}
