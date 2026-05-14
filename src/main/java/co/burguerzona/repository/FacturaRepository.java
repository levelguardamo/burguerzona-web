package co.burguerzona.repository;

import co.burguerzona.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad Factura.
 * Provee operaciones CRUD automáticas sobre la tabla factura.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA3-EV01
 */
@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    // JpaRepository provee: findAll, findById, save, deleteById, etc.
}