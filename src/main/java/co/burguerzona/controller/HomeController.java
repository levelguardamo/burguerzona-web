package co.burguerzona.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador principal que maneja la página de inicio de BurguerZona.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA3-EV01
 */
@Controller
public class HomeController {

    /**
     * Redirige la raíz del sitio a la página de inicio.
     * @return Vista index
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
}