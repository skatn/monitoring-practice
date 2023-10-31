package com.example.monitoringpractice.order;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@Timed("app.order")
public class OrderService {

    private final AtomicInteger stock = new AtomicInteger(100);

    public void order() {
        log.info("주문");
        stock.decrementAndGet();
        sleep(500);
        log.info("주문 완료");
    }

    public void cancel() {
        log.info("주문 취소");
        stock.incrementAndGet();
        sleep(200);
        log.info("주문 취소 완료");
    }

    public int getStock() {
        return stock.get();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis + new Random().nextInt(200));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
