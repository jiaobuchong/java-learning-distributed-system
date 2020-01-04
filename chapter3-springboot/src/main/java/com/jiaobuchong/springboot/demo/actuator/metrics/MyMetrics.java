package com.jiaobuchong.springboot.demo.actuator.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class MyMetrics {

    private final List<String> words = new CopyOnWriteArrayList<>();

    public MyMetrics(MeterRegistry meterRegistry) {
        meterRegistry.gaugeCollectionSize("dictionary.size", Tags.empty(), this.words);
    }
}
