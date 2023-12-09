package com.ing.jangel.microjava21.controller;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicroJava21Controller {

	@GetMapping("/")
	public ResponseEntity<String> main() {
		var s = String.valueOf(this.randomChar());
		var n = (System.currentTimeMillis() % 1000) + 10000;
		
		for (int i = 0; i < n; i++) {
			BigInteger.valueOf(System.nanoTime());
			s += this.randomChar();
			BigInteger.valueOf(System.nanoTime());
		}

		return ResponseEntity.ok(Thread.currentThread().toString());
	}
	
	private char randomChar () {
	    int rnd = (int) (Math.random() * 52);
	    char base = (rnd < 26) ? 'A' : 'a';
	    
	    return (char) (base + rnd % 26);
	}
}
