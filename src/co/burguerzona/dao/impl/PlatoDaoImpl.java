package co.burguerzona.dao.impl;

import co.burguerzona.connection.ConexionDB;
import co.burguerzona.dao.IPlatoDao;
import co.burguerzona.model.Plato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación JDBC del contrato IPlatoDao.
 * Realiza operaciones CRUD sobre la tabla Platos en SQL Server.
 *
 * @author Equipo BurguerZona
 * @version 1.0
 */
public class PlatoDaoImpl implements IPlatoDao {

    @Override
    public void insertar(Plato plato) throws SQLException {
        String sql = "INSERT INTO Platos (Nombre_plato, Precio, Descripcion) VALUES (?, ?, ?)";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, plato.getNombrePlato());
            ps.setDouble(2, plato.getPrecio());
            ps.setString(3, plato.getDescripcion());
            ps.executeUpdate();
        }
    }

    @Override
    public List<Plato> consultarTodos() throws SQLException {
        List<Plato> lista = new ArrayList<>();
        String sql = "SELECT IdPlato, Nombre_plato, Precio, Descripcion FROM Platos";
        try (Connection con = ConexionDB.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Plato(
                    rs.getInt("IdPlato"),
                    rs.getString("Nombre_plato"),
                    rs.getDouble("Precio"),
                    rs.getString("Descripcion")
                ));
            }
        }
        return lista;
    }

    @Override
    public Plato consultarPorId(int id) throws SQLException {
        String sql = "SELECT IdPlato, Nombre_plato, Precio, Descripcion FROM Platos WHERE IdPlato = ?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Plato(
                        rs.getInt("IdPlato"),
                        rs.getString("Nombre_plato"),
                        rs.getDouble("Precio"),
                        rs.getString("Descripcion")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public void actualizar(Plato plato) throws SQLException {
        String sql = "UPDATE Platos SET Nombre_plato = ?, Precio = ?, Descripcion = ? WHERE IdPlato = ?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, plato.getNombrePlato());
            ps.setDouble(2, plato.getPrecio());
            ps.setString(3, plato.getDescripcion());
            ps.setInt(4, plato.getIdPlato());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM Platos WHERE IdPlato = ?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
