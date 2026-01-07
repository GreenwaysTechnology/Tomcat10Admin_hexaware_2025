package com.example.webdatabaseoptimization;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}

