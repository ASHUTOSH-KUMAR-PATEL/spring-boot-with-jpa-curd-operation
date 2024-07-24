package com.irshita.patel.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.Duration;

@Component
public class MetricsService {

    private final Timer saveIrshitaTimer;

    private final Counter saveIrshitaCounter;

    public MetricsService(MeterRegistry meterRegistry) {
        this.saveIrshitaTimer = Timer.builder("api.saveIrshita.timer")
                .description("Time taken to save Irshita")
                .register(meterRegistry);

        this.saveIrshitaCounter = io.micrometer.core.instrument.Counter.builder("api.saveIrshita.counter")
                .description("Number of create/save Irshita requests")
                .register(meterRegistry);
    }

    public void incrementSaveIrshitaCounter() {
        saveIrshitaCounter.increment();
    }

    public void recordSaveIrshitaTime(Duration duration) {
        saveIrshitaTimer.record(duration);
    }
}
