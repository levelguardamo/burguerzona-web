package co.burguerzona.dao;

import co.burguerzona.model.Plato;
import java.sql.SQLException;
import java.util.List;

/**
 * Contrato CRUD para la entidad Plato.
 */
public interface IPlatoDao {
    void         insertar(Plato plato)     throws SQLException;
    List<Plato>  consultarTodos()          throws SQLException;
    Plato        consultarPorId(int id)    throws SQLException;
    void         actualizar(Plato plato)   throws SQLException;
    void         eliminar(int id)          throws SQLException;
}
