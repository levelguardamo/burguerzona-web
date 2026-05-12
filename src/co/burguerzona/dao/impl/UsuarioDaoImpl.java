package co.burguerzona.dao.impl;

import co.burguerzona.connection.ConexionDB;
import co.burguerzona.dao.IUsuarioDao;
import co.burguerzona.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación JDBC del contrato IUsuarioDao.
 * Realiza operaciones CRUD sobre la tabla Usuarios en SQL Server.
 *
 * @author Equipo BurguerZona
 * @version 1.0
 */
public class UsuarioDaoImpl implements IUsuarioDao {

    @Override
    public void insertar(Usuario u) throws SQLException {
        String sql = "INSERT INTO Usuarios (Nombre, Aprellidos, Tipo_de_documento, Documento, " +
                     "Telefono, Email, Fecha_de_registro, IdCargo, IdGenero) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellidos());
            ps.setString(3, u.getTipoDocumento());
            ps.setString(4, u.getDocumento());
            ps.setString(5, u.getTelefono());
            ps.setString(6, u.getEmail());
            ps.setString(7, u.getFechaRegistro());
            ps.setInt(8, u.getIdCargo());
            ps.setInt(9, u.getIdGenero());
            ps.executeUpdate();
        }
    }

    @Override
    public List<Usuario> consultarTodos() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT IdUser, Nombre, Aprellidos, Tipo_de_documento, Documento, " +
                     "Telefono, Email, CONVERT(varchar,Fecha_de_registro,23) AS Fecha_de_registro, " +
                     "IdCargo, IdGenero FROM Usuarios";
        try (Connection con = ConexionDB.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(mapearUsuario(rs));
            }
        }
        return lista;
    }

    @Override
    public Usuario consultarPorId(int id) throws SQLException {
        String sql = "SELECT IdUser, Nombre, Aprellidos, Tipo_de_documento, Documento, " +
                     "Telefono, Email, CONVERT(varchar,Fecha_de_registro,23) AS Fecha_de_registro, " +
                     "IdCargo, IdGenero FROM Usuarios WHERE IdUser = ?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapearUsuario(rs);
            }
        }
        return null;
    }

    @Override
    public void actualizar(Usuario u) throws SQLException {
        String sql = "UPDATE Usuarios SET Nombre=?, Aprellidos=?, Tipo_de_documento=?, " +
                     "Documento=?, Telefono=?, Email=?, IdCargo=?, IdGenero=? WHERE IdUser=?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellidos());
            ps.setString(3, u.getTipoDocumento());
            ps.setString(4, u.getDocumento());
            ps.setString(5, u.getTelefono());
            ps.setString(6, u.getEmail());
            ps.setInt(7, u.getIdCargo());
            ps.setInt(8, u.getIdGenero());
            ps.setInt(9, u.getIdUser());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM Usuarios WHERE IdUser = ?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        return new Usuario(
            rs.getInt("IdUser"),
            rs.getString("Nombre"),
            rs.getString("Aprellidos"),
            rs.getString("Tipo_de_documento"),
            rs.getString("Documento"),
            rs.getString("Telefono"),
            rs.getString("Email"),
            rs.getString("Fecha_de_registro"),
            rs.getInt("IdCargo"),
            rs.getInt("IdGenero")
        );
    }
}
