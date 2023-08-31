package com.brianeno.aws.controller;

/**
 * @author brianeno
 */

import com.brianeno.aws.data.InboundCase;
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
public class CaseController {

    @GetMapping(value = "case", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<InboundCase> getCase() {
        return List.of(new InboundCase("123456", "New Case 1", "OPEN"),
                new InboundCase("654321", "New Case 2", "PENDING"));
    }

    @PutMapping(value = "case/{key}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> processCase(@PathVariable String key) {
        // parse key
        // read from S3 and process accordingly
        return new ResponseEntity<>(
                "Processing Incoming EDI file " + key,
                HttpStatus.OK);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public void handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        System.out.println(name + " parameter is missing");
    }
}
