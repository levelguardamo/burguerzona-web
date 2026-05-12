package co.burguerzona.dao.impl;

import co.burguerzona.connection.ConexionDB;
import co.burguerzona.dao.IPedidoDao;
import co.burguerzona.model.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación JDBC del contrato IPedidoDao.
 * Realiza operaciones CRUD sobre la tabla pedidos en SQL Server.
 *
 * @author Equipo BurguerZona
 * @version 1.0
 */
public class PedidoDaoImpl implements IPedidoDao {

    @Override
    public void insertar(Pedido p) throws SQLException {
        String sql = "INSERT INTO pedidos (IdUser, IdPlato, Fecha_pedido, Cantidad) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, p.getIdUser());
            ps.setInt(2, p.getIdPlato());
            ps.setString(3, p.getFechaPedido());
            ps.setInt(4, p.getCantidad());
            ps.executeUpdate();
        }
    }

    @Override
    public List<Pedido> consultarTodos() throws SQLException {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT IdPedido, IdUser, IdPlato, " +
                     "CONVERT(varchar,Fecha_pedido,23) AS Fecha_pedido, Cantidad FROM pedidos";
        try (Connection con = ConexionDB.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Pedido(
                    rs.getInt("IdPedido"),
                    rs.getInt("IdUser"),
                    rs.getInt("IdPlato"),
                    rs.getString("Fecha_pedido"),
                    rs.getInt("Cantidad")
                ));
            }
        }
        return lista;
    }

    @Override
    public Pedido consultarPorId(int id) throws SQLException {
        String sql = "SELECT IdPedido, IdUser, IdPlato, " +
                     "CONVERT(varchar,Fecha_pedido,23) AS Fecha_pedido, Cantidad " +
                     "FROM pedidos WHERE IdPedido = ?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Pedido(
                        rs.getInt("IdPedido"),
                        rs.getInt("IdUser"),
                        rs.getInt("IdPlato"),
                        rs.getString("Fecha_pedido"),
                        rs.getInt("Cantidad")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public void actualizar(Pedido p) throws SQLException {
        String sql = "UPDATE pedidos SET IdUser=?, IdPlato=?, Fecha_pedido=?, Cantidad=? WHERE IdPedido=?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, p.getIdUser());
            ps.setInt(2, p.getIdPlato());
            ps.setString(3, p.getFechaPedido());
            ps.setInt(4, p.getCantidad());
            ps.setInt(5, p.getIdPedido());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM pedidos WHERE IdPedido = ?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
