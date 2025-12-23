package com.example.threaddemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NioTestController {

    // SCENARIO A: Test many connections (Poller)
    @GetMapping("/fast")
    public String fast() {
        return "Poller caught me! Thread: " + Thread.currentThread().getName();
    }

    // SCENARIO B: Test thread exhaustion (Worker Pool)
    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        // Blocks this worker thread for 10 seconds
        Thread.sleep(10000);
        return "Worker finally free! Thread: " + Thread.currentThread().getName();
    }
}