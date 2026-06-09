package co.burguerzona.controller;

import co.burguerzona.model.Pedido;
import co.burguerzona.repository.PedidoRepository;
import co.burguerzona.repository.UsuarioRepository;
import co.burguerzona.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador Spring MVC para la gestion de Pedidos.
 * Maneja las rutas /pedidos y sus operaciones CRUD.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA3-EV01
 */
@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PlatoRepository platoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", pedidoRepository.findAll());
        return "pedidos/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("platos", platoRepository.findAll());
        model.addAttribute("esEdicion", false);
        return "pedidos/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("pedido", pedidoRepository.findById(id).orElse(null));
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("platos", platoRepository.findAll());
        model.addAttribute("esEdicion", true);
        return "pedidos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Pedido pedido) {
        pedidoRepository.save(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        pedidoRepository.deleteById(id);
        return "redirect:/pedidos";
    }
}