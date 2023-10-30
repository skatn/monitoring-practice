package com.example.monitoringpractice.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 테스트 편의룰 위해 GET 사용
    @GetMapping("/order")
    public String order() {
        orderService.order();
        return "ok";
    }

    @GetMapping("/cancel")
    public String cancel() {
        orderService.cancel();
        return "ok";
    }
}
