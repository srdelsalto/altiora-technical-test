package com.altiora.backend.altiorabackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {
    @GetMapping("/")
    public RedirectView redirectToHome() {
        // Cambia la URL a la que deseas redirigir
        return new RedirectView("/swagger-ui.html"); // Por ejemplo, redirige a /home
    }
}
