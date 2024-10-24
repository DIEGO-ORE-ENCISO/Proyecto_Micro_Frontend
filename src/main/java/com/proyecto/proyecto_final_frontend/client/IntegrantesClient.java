package com.proyecto.proyecto_final_frontend.client;

import com.proyecto.proyecto_final_frontend.model.Integrante;
import com.proyecto.proyecto_final_frontend.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "integrantesClient", url = "https://proyecto-micro-backend.azurewebsites.net/api")
public interface IntegrantesClient {

    @PostMapping("/autenticar")
    String autenticar(@RequestBody Usuario usuario);

    @GetMapping("/get-integrantes")
    List<Integrante> getIntegrantes();
}