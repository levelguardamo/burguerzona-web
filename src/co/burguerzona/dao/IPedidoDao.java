package co.burguerzona.dao;

import co.burguerzona.model.Pedido;
import java.sql.SQLException;
import java.util.List;

/**
 * Contrato CRUD para la entidad Pedido.
 */
public interface IPedidoDao {
    void          insertar(Pedido pedido)   throws SQLException;
    List<Pedido>  consultarTodos()          throws SQLException;
    Pedido        consultarPorId(int id)    throws SQLException;
    void          actualizar(Pedido pedido) throws SQLException;
    void          eliminar(int id)          throws SQLException;
}
