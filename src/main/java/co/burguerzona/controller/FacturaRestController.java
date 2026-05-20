package co.burguerzona.controller;

import co.burguerzona.model.Factura;
import co.burguerzona.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para la gestion de Facturas.
 * Expone endpoints JSON para el frontend React.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA4-EV03
 */
@RestController
@RequestMapping("/api/facturas")
@CrossOrigin(origins = "http://localhost:3000")
public class FacturaRestController {

    @Autowired
    private FacturaRepository facturaRepository;

    /** Retorna todas las facturas */
    @GetMapping
    public List<Factura> listar() {
        return facturaRepository.findAll();
    }

    /** Retorna una factura por ID */
    @GetMapping("/{id}")
    public Factura obtenerPorId(@PathVariable int id) {
        return facturaRepository.findById(id).orElse(null);
    }

    /** Crea o actualiza una factura */
    @PostMapping
    public Factura guardar(@RequestBody Factura factura) {
        return facturaRepository.save(factura);
    }

    /** Elimina una factura por ID */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        facturaRepository.deleteById(id);
    }
}