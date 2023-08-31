package com.brianeno.aws;

import com.brianeno.aws.controller.SensorController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author brianeno
 */
@SpringBootApplication
@Import({SensorController.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
