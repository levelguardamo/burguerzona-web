package co.burguerzona.repository;

import co.burguerzona.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad Usuario.
 * Provee operaciones CRUD automáticas sobre la tabla Usuarios.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA3-EV01
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // JpaRepository provee: findAll, findById, save, deleteById, etc.
}