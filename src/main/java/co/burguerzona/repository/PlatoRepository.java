package co.burguerzona.repository;

import co.burguerzona.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad Plato.
 * Provee operaciones CRUD automáticas sobre la tabla Platos.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA3-EV01
 */
@Repository
public interface PlatoRepository extends JpaRepository<Plato, Integer> {
    // JpaRepository provee: findAll, findById, save, deleteById, etc.
}