package com.example.heapdump;

import java.util.HashMap;

public class MapManager {
    HashMap<Object, Object> myMap = new HashMap<>();

    public void grow() {
        try {
            long counter = 0;
            while (true) {
                myMap.put("key", counter + "Large stringggggggggg" + " " +
                        "gggggggggggggggggggggggggggg" +
                        "gggggggggggggggggggggggggggg" +
                        "gggggggggggggggggggggggggggg" +
                        "gggggggggggggggggggggggggggg" +
                        "gggggggggggggggggggggggggggg" +
                        "gggggggggggggggggggggggggggg" +
                        "gggggggggggggggggggggggggggg" +
                        "gggggggggggggggggggggggggggg" +
                        "gggggggggggggggggggggggggggg" +
                        "gggggggggggggggggggggggggggg" +
                        "gggggggggggggggggggggggggggg" + counter
                );
                System.out.println("Adding....");
                counter++;
            }
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}
