package co.burguerzona.dao;

import co.burguerzona.model.Factura;
import java.sql.SQLException;
import java.util.List;

/**
 * Contrato CRUD para la entidad Factura.
 */
public interface IFacturaDao {
    void           insertar(Factura factura)   throws SQLException;
    List<Factura>  consultarTodos()            throws SQLException;
    Factura        consultarPorId(int id)      throws SQLException;
    void           actualizar(Factura factura) throws SQLException;
    void           eliminar(int id)            throws SQLException;
}
