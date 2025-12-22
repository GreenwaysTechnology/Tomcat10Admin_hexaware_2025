package com.example.heapdump;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HeapdumpApplication {
	static List<byte[]> leak = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(HeapdumpApplication.class, args);
		long counter=1;
		while (true) {
			leak.add(new byte[1024 * 1024]); // 1 MB
//			Thread.sleep(200);
			System.out.println("adding...");
			counter++;
		}
	}

}
