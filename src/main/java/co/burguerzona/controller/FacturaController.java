package co.burguerzona.controller;

import co.burguerzona.model.Factura;
import co.burguerzona.repository.FacturaRepository;
import co.burguerzona.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador Spring MVC para la gestión de Facturas.
 * Maneja las rutas /facturas y sus operaciones CRUD.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA3-EV01
 */
@Controller
@RequestMapping("/facturas")
public class FacturaController {

    /** Repositorio de facturas inyectado por Spring */
    @Autowired
    private FacturaRepository facturaRepository;

    /** Repositorio de pedidos para los selectores del formulario */
    @Autowired
    private PedidoRepository pedidoRepository;

    /**
     * Lista todas las facturas registradas.
     * @param model Modelo para pasar datos a la vista
     * @return Vista lista de facturas
     */
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("facturas", facturaRepository.findAll());
        return "facturas/lista";
    }

    /**
     * Muestra el formulario para crear una nueva factura.
     * @param model Modelo para pasar datos a la vista
     * @return Vista formulario de factura
     */
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("factura", new Factura());
        model.addAttribute("pedidos", pedidoRepository.findAll());
        model.addAttribute("esEdicion", false);
        return "facturas/formulario";
    }

    /**
     * Muestra el formulario para editar una factura existente.
     * @param id ID de la factura a editar
     * @param model Modelo para pasar datos a la vista
     * @return Vista formulario de factura
     */
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("factura", facturaRepository.findById(id).orElse(null));
        model.addAttribute("pedidos", pedidoRepository.findAll());
        model.addAttribute("esEdicion", true);
        return "facturas/formulario";
    }

    /**
     * Guarda una factura nueva o actualiza una existente.
     * @param factura Objeto factura con los datos del formulario
     * @return Redirección a la lista de facturas
     */
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Factura factura) {
        facturaRepository.save(factura);
        return "redirect:/facturas";
    }

    /**
     * Elimina una factura por su ID.
     * @param id ID de la factura a eliminar
     * @return Redirección a la lista de facturas
     */
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        facturaRepository.deleteById(id);
        return "redirect:/facturas";
    }
}