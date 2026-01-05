package com.example.clusterdemo;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionTestController {

    @GetMapping("/session-test")
    public String testSession(HttpSession session) {

        // 1️⃣ Read the value from session
        Integer count = (Integer) session.getAttribute("count");

        // 2️⃣ Initialize if first request
        if (count == null) {
            count = 0;
        }

        // 3️⃣ Increment counter
        count++;

        // 4️⃣ WRITE BACK to session (THIS triggers replication)
        session.setAttribute("count", count);

        // 5️⃣ Identify which Tomcat node served the request
        String node = System.getProperty("catalina.base");

        return "NODE = " + node +
                " | Session ID = " + session.getId();
    }

}
