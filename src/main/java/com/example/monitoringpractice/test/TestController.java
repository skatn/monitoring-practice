package com.example.monitoringpractice.test;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames != null && headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            log.info("{}: {}", headerName, headerValue);
        }

        return "ok";
    }

    @GetMapping("/log")
    public String log() {
        log.trace("log trace");
        log.debug("log debug");
        log.info("log info");
        log.warn("log warn");
        log.error("log error");

        return "ok";
    }

    @GetMapping("/error")
    public void error() {
        throw new RuntimeException("런타임 에러");
    }
}
