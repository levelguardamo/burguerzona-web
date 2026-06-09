package co.burguerzona.repository;

import co.burguerzona.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad Pedido.
 * Provee operaciones CRUD automáticas sobre la tabla pedidos.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA3-EV01
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    // JpaRepository provee: findAll, findById, save, deleteById, etc.
}