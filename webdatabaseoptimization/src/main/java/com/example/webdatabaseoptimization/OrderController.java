package com.example.webdatabaseoptimization;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping("/n1")
    public List<String> nPlusOne() {
        return service.nPlusOne();
    }

    @GetMapping("/join")
    public List<String> joinFetch() {
        return service.joinFetch();
    }

    @GetMapping("/graph")
    public List<String> graphFetch() {
        return service.graphFetch();
    }

    @GetMapping("/projection")
    public List<OrderView> projection() {
        return service.projection();
    }
}
