package com.ing.jangel.virtualthreads;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.ing.jangel.virtualthreads.service.MultipleThreadsTask;

@SpringBootTest
class VirtualThreadsConsoleApplicationTests {
	@Autowired
	@Qualifier("virtualThreadsService")
	private MultipleThreadsTask virtualThreadService;
	
	@Autowired
	@Qualifier("regularThreadsService")
	private MultipleThreadsTask regularThreadService;
	
	@Test
	void testSpeed() {
		long virtual = virtualThreadService.doTask();
		long regular = regularThreadService.doTask();
		
		assertTrue(virtual < regular);
	}

}
