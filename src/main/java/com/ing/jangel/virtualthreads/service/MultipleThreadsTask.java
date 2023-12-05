package com.ing.jangel.virtualthreads.service;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class MultipleThreadsTask {
	protected static final int AMOUNT_TASKS = 100_000;
	
	protected abstract ExecutorService performTask();
	
	/**
	 * Does a task and return the time taken in milliseconds
	 * @return
	 * @throws InterruptedException 
	 */
	public long doTask() throws InterruptedException {
		var startTime = Instant.now();
		
		var executor = performTask();
		
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.SECONDS);
		
		var endTime = Instant.now();
		
		return Duration.between(startTime, endTime).toMillis();
	}
}
