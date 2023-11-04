package com.ing.jangel.virtualthreads.service;

import java.time.Duration;
import java.time.Instant;

public abstract class MultipleThreadsTask {
	
	protected abstract void performTask();
	
	/**
	 * Does a task and return the time taken in milliseconds
	 * @return
	 */
	public long doTask() {
		var startTime = Instant.now();
		
		performTask();
		
		var endTime = Instant.now();
		
		return Duration.between(startTime, endTime).toMillis();
	}
}
