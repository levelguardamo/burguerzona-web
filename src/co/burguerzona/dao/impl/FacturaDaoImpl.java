package co.burguerzona.dao.impl;

import co.burguerzona.connection.ConexionDB;
import co.burguerzona.dao.IFacturaDao;
import co.burguerzona.model.Factura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación JDBC del contrato IFacturaDao.
 * Realiza operaciones CRUD sobre la tabla factura en SQL Server.
 *
 * @author Equipo BurguerZona
 * @version 1.0
 */
public class FacturaDaoImpl implements IFacturaDao {

    @Override
    public void insertar(Factura f) throws SQLException {
        String sql = "INSERT INTO factura (IdPedido, Fecha_factura, Total) VALUES (?, ?, ?)";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, f.getIdPedido());
            ps.setString(2, f.getFechaFactura());
            ps.setDouble(3, f.getTotal());
            ps.executeUpdate();
        }
    }

    @Override
    public List<Factura> consultarTodos() throws SQLException {
        List<Factura> lista = new ArrayList<>();
        String sql = "SELECT IdFactura, IdPedido, " +
                     "CONVERT(varchar,Fecha_factura,23) AS Fecha_factura, Total FROM factura";
        try (Connection con = ConexionDB.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Factura(
                    rs.getInt("IdFactura"),
                    rs.getInt("IdPedido"),
                    rs.getString("Fecha_factura"),
                    rs.getDouble("Total")
                ));
            }
        }
        return lista;
    }

    @Override
    public Factura consultarPorId(int id) throws SQLException {
        String sql = "SELECT IdFactura, IdPedido, " +
                     "CONVERT(varchar,Fecha_factura,23) AS Fecha_factura, Total " +
                     "FROM factura WHERE IdFactura = ?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Factura(
                        rs.getInt("IdFactura"),
                        rs.getInt("IdPedido"),
                        rs.getString("Fecha_factura"),
                        rs.getDouble("Total")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public void actualizar(Factura f) throws SQLException {
        String sql = "UPDATE factura SET IdPedido=?, Fecha_factura=?, Total=? WHERE IdFactura=?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, f.getIdPedido());
            ps.setString(2, f.getFechaFactura());
            ps.setDouble(3, f.getTotal());
            ps.setInt(4, f.getIdFactura());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM factura WHERE IdFactura = ?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
