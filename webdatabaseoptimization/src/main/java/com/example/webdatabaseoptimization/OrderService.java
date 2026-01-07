package com.example.webdatabaseoptimization;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo repo;

    // ❌ N+1 Problem
    public List<String> nPlusOne() {
        return repo.findAll().stream()
                .map(o -> o.getCustomer().getName())
                .toList();
    }

    // ✅ fixed - join fetch
    public List<String> joinFetch() {
        return repo.findAllJoinFetch().stream()
                .map(o -> o.getCustomer().getName())
                .toList();
    }

    // ✅ fixed - entity graph
    public List<String> graphFetch() {
        return repo.findAllBy().stream()
                .map(o -> o.getCustomer().getName())
                .toList();
    }

    // ✅ DTO projection
    public List<OrderView> projection() {
        return repo.findAllProjectedBy();
    }
}

