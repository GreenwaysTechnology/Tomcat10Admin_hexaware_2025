package com.example.webdatabaseoptimization;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {

    // ❌ Causes N+1 (used in lab)
    List<Order> findAll();

    // ✅ Fix using join fetch
    @Query("select o from Order o join fetch o.customer")
    List<Order> findAllJoinFetch();

    // ✅ Fix using EntityGraph
    @EntityGraph(attributePaths = "customer")
    List<Order> findAllBy();

    // ✅ DTO Projection
    List<OrderView> findAllProjectedBy();
}

