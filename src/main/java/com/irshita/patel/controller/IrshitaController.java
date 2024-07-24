package com.irshita.patel.controller;

import com.irshita.patel.exception.ResourceNotFoundException;
import com.irshita.patel.metrics.MetricsService;
import com.irshita.patel.model.IrshitaModel;
import com.irshita.patel.service.IrshitaService;
import io.micrometer.core.annotation.Timed;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.metrics.LongCounter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.time.Duration;
import java.time.Instant;

@RestController
@RequestMapping("/api")
@Slf4j
public class IrshitaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IrshitaController.class);

    private static final AttributeKey<String> ENDPOINT_KEY = AttributeKey.stringKey("endpoint");

    @Autowired
    private IrshitaService irshitaService;

   /* @Autowired
    private MetricsService metricsService;*/

    private final LongCounter requestCounter;

    @Autowired
    public IrshitaController(final MeterProvider meterProvider) {
        Meter meter = meterProvider.get("my-meter");
        requestCounter = meter.counterBuilder("my_requests_total")
                .setDescription("Total number of requests")
                .setUnit("1")
                .build();
    }

    @GetMapping(path = "/irshita")
    public String getMessage(){
        processRequest();
        return "Hello, Irshita!!";
    }

    public void processRequest() {
        requestCounter.add(1, Attributes.of(ENDPOINT_KEY, "/irshita"));
    }

    @PostMapping(path = "/saveIrshita")
    //@Timed(value = "api.saveIrshita.post.requests", description = "Total number of POST requests to /api/saveIrshita")
    public ResponseEntity<IrshitaModel> createIrshita(@RequestBody IrshitaModel irshitaModel){
        LOGGER.info("Inside createIrshita() method: Started");
        //Instant startTime = Instant.now();
        try {
            IrshitaModel savedIrshita = irshitaService.saveIrshita(irshitaModel);
            //Instant endTime = Instant.now();
            //metricsService.incrementSaveIrshitaCounter(); // Increment counter
            //metricsService.recordSaveIrshitaTime(Duration.between(startTime, endTime)); // Record duration
            LOGGER.info("Inside createIrshita() method: Completed");
            return ResponseEntity.ok().body(savedIrshita);
        } catch (ResourceNotFoundException rs) {
            LOGGER.error("Error occurred in createIrshita() method: {}", rs.getMessage(), rs);
            throw new ResourceNotFoundException("Resource Not Found: " + rs.getLocalizedMessage());
        }
    }


    @PutMapping(path = "/updateIrshita/{id}")
    public ResponseEntity<IrshitaModel> updateIrshita(@PathVariable Integer id, @RequestBody IrshitaModel model) throws IllegalAccessException {
        model.setIshId(id);
        return ResponseEntity.ok().body(this.irshitaService.updateIrshitaObjectById(model));
    }

    @GetMapping(path = "/getIrshita/{id}")
    public ResponseEntity<IrshitaModel> getIrshitaById(@PathVariable Integer id) throws IllegalAccessException {
        return ResponseEntity.ok().body(this.irshitaService.getSingleIrshitaObjectById(id));
    }

    @DeleteMapping(path = "/delete/{id}")
    public HttpStatus deleteIrshita(@PathVariable Integer id){
        this.irshitaService.deleteIrshitaObjectById(id);
        return HttpStatus.OK;
    }

}