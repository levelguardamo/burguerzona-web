package co.burguerzona.controller;

import co.burguerzona.model.Plato;
import co.burguerzona.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para la gestion de Platos.
 * Expone endpoints JSON para el frontend React.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA4-EV03
 */
@RestController
@RequestMapping("/api/platos")
@CrossOrigin(origins = "http://localhost:3000")
public class PlatoRestController {

    @Autowired
    private PlatoRepository platoRepository;

    /** Retorna todos los platos */
    @GetMapping
    public List<Plato> listar() {
        return platoRepository.findAll();
    }

    /** Retorna un plato por ID */
    @GetMapping("/{id}")
    public Plato obtenerPorId(@PathVariable int id) {
        return platoRepository.findById(id).orElse(null);
    }

    /** Crea o actualiza un plato */
    @PostMapping
    public Plato guardar(@RequestBody Plato plato) {
        return platoRepository.save(plato);
    }

    /** Elimina un plato por ID */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        platoRepository.deleteById(id);
    }
}