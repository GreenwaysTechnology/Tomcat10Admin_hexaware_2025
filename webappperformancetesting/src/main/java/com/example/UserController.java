package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/api")
public class UserController {

    //    @GetMapping("/slow")
//    public String slow() throws Exception {
//        Thread.sleep(10000); // simulate slow IO
//        return Thread.currentThread().getName();
//    }
// Define the ExecutorService (Thread Pool)
    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    //this code is optimized code
    @GetMapping("/slow")
    public CompletableFuture<String> slowAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return Thread.currentThread().getName();
        }, executor); // offload work to our specific thread pool
    }

//    @GetMapping("/slow")
//    public Callable<String> slowAsync() {
//        return () -> {
//            Thread.sleep(10000);
//            return Thread.currentThread().getName();
//        };
//    }
//    @GetMapping("/slow")
//    public CompletableFuture<String> slow() {
//        return CompletableFuture.supplyAsync(() -> "Hello");
//    }

    @GetMapping("/fast")
    public String fast() {
        return "OK";
    }

    @GetMapping("/json")
    public Map<String, Object> json() throws Exception {
        Thread.sleep(1000);
        Map<String, Object> data = new HashMap<>();
        data.put("msg", "hello");
        data.put("size", 100000);
        data.put("blob", "x".repeat(5000000));
        return data;
    }

}

