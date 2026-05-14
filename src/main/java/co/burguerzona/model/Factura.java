package co.burguerzona.model;

import jakarta.persistence.*;

/**
 * Entidad que representa una Factura en BurguerZona.
 * Mapeada a la tabla factura de SQL Server.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA3-EV01
 */
@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdFactura")
    private int idFactura;

    @Column(name = "IdPedido")
    private Integer idPedido;

    @Column(name = "Fecha_factura", nullable = false)
    private String fechaFactura;

    @Column(name = "Total", nullable = false)
    private double total;

    public Factura() {}

    public Factura(int idFactura, Integer idPedido, String fechaFactura, double total) {
        this.idFactura = idFactura;
        this.idPedido = idPedido;
        this.fechaFactura = fechaFactura;
        this.total = total;
    }

    public int getIdFactura() { return idFactura; }
    public void setIdFactura(int idFactura) { this.idFactura = idFactura; }
    public Integer getIdPedido() { return idPedido; }
    public void setIdPedido(Integer idPedido) { this.idPedido = idPedido; }
    public String getFechaFactura() { return fechaFactura; }
    public void setFechaFactura(String fechaFactura) { this.fechaFactura = fechaFactura; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}