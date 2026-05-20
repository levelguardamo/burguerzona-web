package co.burguerzona.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Controlador principal que maneja la pagina de inicio de BurguerZona.
 * Tambien configura CORS para permitir peticiones desde React.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA4-EV03
 */
@Controller
public class HomeController {

    /**
     * Redirige la raiz del sitio a la pagina de inicio.
     * @return Vista index
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
}

/**
 * Configuracion global de CORS para permitir
 * peticiones desde el frontend React en localhost:3000.
 */
@Configuration
class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}