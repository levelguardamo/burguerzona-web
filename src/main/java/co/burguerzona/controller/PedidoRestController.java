package co.burguerzona.controller;

import co.burguerzona.model.Pedido;
import co.burguerzona.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para la gestion de Pedidos.
 * Expone endpoints JSON para el frontend React.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA4-EV03
 */
@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "http://localhost:3000")
public class PedidoRestController {

    @Autowired
    private PedidoRepository pedidoRepository;

    /** Retorna todos los pedidos */
    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    /** Retorna un pedido por ID */
    @GetMapping("/{id}")
    public Pedido obtenerPorId(@PathVariable int id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    /** Crea o actualiza un pedido */
    @PostMapping
    public Pedido guardar(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    /** Elimina un pedido por ID */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        pedidoRepository.deleteById(id);
    }
}