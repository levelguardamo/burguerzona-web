package co.burguerzona.model;

import jakarta.persistence.*;

/**
 * Entidad que representa un Pedido en BurguerZona.
 * Mapeada a la tabla pedidos de SQL Server.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA3-EV01
 */
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPedido")
    private int idPedido;

    @Column(name = "IdUser")
    private Integer idUser;

    @Column(name = "IdPlato")
    private Integer idPlato;

    @Column(name = "Fecha_pedido", nullable = false)
    private String fechaPedido;

    @Column(name = "Cantidad", nullable = false)
    private int cantidad;

    public Pedido() {}

    public Pedido(int idPedido, Integer idUser, Integer idPlato, String fechaPedido, int cantidad) {
        this.idPedido = idPedido;
        this.idUser = idUser;
        this.idPlato = idPlato;
        this.fechaPedido = fechaPedido;
        this.cantidad = cantidad;
    }

    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }
    public Integer getIdUser() { return idUser; }
    public void setIdUser(Integer idUser) { this.idUser = idUser; }
    public Integer getIdPlato() { return idPlato; }
    public void setIdPlato(Integer idPlato) { this.idPlato = idPlato; }
    public String getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(String fechaPedido) { this.fechaPedido = fechaPedido; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}