package com.example.monitoringpractice.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 테스트 편의룰 위해 GET 사용
    @GetMapping("/order")
    public String order() {
        log.info("주문 요청");
        orderService.order();
        return "ok";
    }

    @GetMapping("/cancel")
    public String cancel() {
        log.info("주문 취소 요청");
        orderService.cancel();
        return "ok";
    }

    @GetMapping("/stock")
    public int stock() {
        log.info("재고 수량 요청");
        return orderService.getStock();
    }


}
