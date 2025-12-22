package com.example.heapdump;

public class MemoryLeak {
    static Object1 object1 = new Object1();

    public static void start() {
        try {
            object1.grow();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}
