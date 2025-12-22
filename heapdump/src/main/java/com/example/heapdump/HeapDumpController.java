package com.example.heapdump;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/heapdump")
public class HeapDumpController {
    private static final List<byte[]> leak = new ArrayList<>();

    @GetMapping
    public String getHeatDump() {
        while (true) {
            leak.add(new byte[10 * 1024 * 1024]); // 10 MB
            System.out.println("Adding....");
        }
    }

    @GetMapping("/info")
    public String getInfo() {
        return "Info";
    }
}
