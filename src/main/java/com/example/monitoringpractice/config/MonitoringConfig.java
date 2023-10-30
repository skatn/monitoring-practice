package com.example.monitoringpractice.config;

import com.example.monitoringpractice.order.OrderService;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonitoringConfig {

    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

    @Bean
    public MeterBinder stockSize(OrderService orderService) {
        return registry -> Gauge.builder("app.stock", orderService, OrderService::getStock)
                .register(registry);
    }
}
