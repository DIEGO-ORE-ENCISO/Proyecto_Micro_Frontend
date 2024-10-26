package com.proyecto.proyecto_final_frontend.controller;

import com.proyecto.proyecto_final_frontend.client.IntegrantesClient;
import com.proyecto.proyecto_final_frontend.model.Integrante;
import com.proyecto.proyecto_final_frontend.model.Usuario;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private IntegrantesClient integrantesClient;

    @GetMapping("/login")
    public String login() {
        return "login"; // Vista de inicio de sesión
    }

    @PostMapping("/login")
    public String authenticate(@ModelAttribute Usuario usuario, Model model) {
        try {
            String respuesta = integrantesClient.autenticar(usuario);
            if ("Autenticación exitosa".equals(respuesta)) {
                return "redirect:/detalle";
            } else {
                model.addAttribute("error", "Problemas en la autenticación");
                return "login";
            }
        } catch (FeignException.Unauthorized e) {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }

    @GetMapping("/detalle")
    public String detalle(Model model) {
        List<Integrante> integrantes = integrantesClient.getIntegrantes();
        model.addAttribute("integrantes", integrantes);
        return "detalle"; // Vista de detalle
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }


}