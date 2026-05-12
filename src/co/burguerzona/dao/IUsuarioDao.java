package co.burguerzona.dao;

import co.burguerzona.model.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 * Contrato CRUD para la entidad Usuario.
 */
public interface IUsuarioDao {
    void           insertar(Usuario usuario)   throws SQLException;
    List<Usuario>  consultarTodos()            throws SQLException;
    Usuario        consultarPorId(int id)      throws SQLException;
    void           actualizar(Usuario usuario) throws SQLException;
    void           eliminar(int id)            throws SQLException;
}
