package com.brianeno.aws.controller;

/**
 * @author brianeno
 */

import com.brianeno.aws.data.InboundSensor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class SensorController {

    @GetMapping(value = "sensor", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<InboundSensor> getSensor() {
        return List.of(new InboundSensor("123456", "New Sensor Value 1", "OPEN"),
                new InboundSensor("654321", "New Sensor Value 1", "PENDING"));
    }

    @PutMapping(value = "sensor/{key}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> processSensor(@PathVariable String key) {
        // parse key
        // read from S3 and process accordingly
        return new ResponseEntity<>(
                "Processing Incoming Sensor Info " + key,
                HttpStatus.OK);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public void handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        System.out.println(name + " parameter is missing");
    }
}
