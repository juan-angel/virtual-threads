package com.ing.jangel.comparison.service;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("regularThreadsService")
public class MultipleRegularThreadsTaskImpl extends MultipleThreadsTask {
	@Override
	protected ExecutorService performTask() {
		try (var executor = Executors.newCachedThreadPool()) {
		    IntStream.range(0, MultipleThreadsTask.AMOUNT_TASKS).forEach(i -> {
		        executor.submit(() -> {
		            Thread.sleep(Duration.ofSeconds(1));
		            System.out.println(i);
		            return 0;
		        });
		    });
		    
		    return executor;
		}
	}
}
