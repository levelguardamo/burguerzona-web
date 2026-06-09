package co.burguerzona.controller;

import co.burguerzona.model.Usuario;
import co.burguerzona.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para la gestion de Usuarios.
 * Expone endpoints JSON para el frontend React.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA4-EV03
 */
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioRestController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /** Retorna todos los usuarios */
    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    /** Retorna un usuario por ID */
    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    /** Crea o actualiza un usuario */
    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /** Elimina un usuario por ID */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        usuarioRepository.deleteById(id);
    }
}