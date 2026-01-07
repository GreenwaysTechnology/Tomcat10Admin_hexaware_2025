package com.example.webdatabaseoptimization;

public interface OrderView {
    String getProduct();
    CustomerInfo getCustomer();

    interface CustomerInfo {
        String getName();
    }
}

