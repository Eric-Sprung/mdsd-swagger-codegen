package com.ecommerce.microcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//localhost:9090/v2/api-docs http://localhost:9090/swagger-ui.html

@EnableSwagger2
@SpringBootApplication
public class MicrocommerceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicrocommerceApplication.class, args);
    }

}
