package co.burguerzona.controller;

import co.burguerzona.model.Usuario;
import co.burguerzona.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador Spring MVC para la gestión de Usuarios.
 * Maneja las rutas /usuarios y sus operaciones CRUD.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA3-EV01
 */
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    /** Repositorio de usuarios inyectado por Spring */
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Lista todos los usuarios registrados.
     * @param model Modelo para pasar datos a la vista
     * @return Vista lista de usuarios
     */
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuarios/lista";
    }

    /**
     * Muestra el formulario para crear un nuevo usuario.
     * @param model Modelo para pasar datos a la vista
     * @return Vista formulario de usuario
     */
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("esEdicion", false);
        return "usuarios/formulario";
    }

    /**
     * Muestra el formulario para editar un usuario existente.
     * @param id ID del usuario a editar
     * @param model Modelo para pasar datos a la vista
     * @return Vista formulario de usuario
     */
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        model.addAttribute("usuario", usuario);
        model.addAttribute("esEdicion", true);
        return "usuarios/formulario";
    }

    /**
     * Guarda un usuario nuevo o actualiza uno existente.
     * @param usuario Objeto usuario con los datos del formulario
     * @return Redirección a la lista de usuarios
     */
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }

    /**
     * Elimina un usuario por su ID.
     * @param id ID del usuario a eliminar
     * @return Redirección a la lista de usuarios
     */
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        usuarioRepository.deleteById(id);
        return "redirect:/usuarios";
    }
}