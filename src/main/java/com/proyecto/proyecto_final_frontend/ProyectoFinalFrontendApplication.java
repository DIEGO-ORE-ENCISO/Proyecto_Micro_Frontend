package com.proyecto.proyecto_final_frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProyectoFinalFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoFinalFrontendApplication.class, args);
    }

}
