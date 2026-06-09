package co.burguerzona.controller;

import co.burguerzona.model.Plato;
import co.burguerzona.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador Spring MVC para la gestion de Platos.
 * Maneja las rutas /platos y sus operaciones CRUD.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA3-EV01
 */
@Controller
@RequestMapping("/platos")
public class PlatoController {

    @Autowired
    private PlatoRepository platoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("platos", platoRepository.findAll());
        return "platos/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("plato", new Plato());
        model.addAttribute("esEdicion", false);
        return "platos/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Plato plato = platoRepository.findById(id).orElse(null);
        model.addAttribute("plato", plato);
        model.addAttribute("esEdicion", true);
        return "platos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Plato plato) {
        platoRepository.save(plato);
        return "redirect:/platos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        platoRepository.deleteById(id);
        return "redirect:/platos";
    }
}