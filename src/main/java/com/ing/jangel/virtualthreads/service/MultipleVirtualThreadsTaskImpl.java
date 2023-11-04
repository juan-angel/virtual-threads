package com.ing.jangel.virtualthreads.service;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("virtualThreadsService")
public class MultipleVirtualThreadsTaskImpl extends MultipleThreadsTask {
	@Override
	protected void performTask() {
		try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
		    IntStream.range(0, 10_000).forEach(i -> {
		        executor.submit(() -> {
		            Thread.sleep(Duration.ofSeconds(1));
		            System.out.println("" + i);
		            return i;
		        });
		    });
		}
	}
}
