package com.irshita.patel.config;

import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenTelemetryConfiguration {

    @Bean
    public MeterProvider meterProvider() {
        SdkMeterProvider meterProvider = SdkMeterProvider.builder().build();
        // Additional configuration for MeterProvider if needed
        return meterProvider;
    }
}

