package co.burguerzona.model;

/**
 * Representa una factura generada a partir de un pedido en BurguerZona.
 */
public class Factura {

    private int    idFactura;
    private int    idPedido;
    private String fechaFactura;
    private double total;

    public Factura() {}

    public Factura(int idFactura, int idPedido, String fechaFactura, double total) {
        this.idFactura    = idFactura;
        this.idPedido     = idPedido;
        this.fechaFactura = fechaFactura;
        this.total        = total;
    }

    public int    getIdFactura()    { return idFactura; }
    public int    getIdPedido()     { return idPedido; }
    public String getFechaFactura() { return fechaFactura; }
    public double getTotal()        { return total; }

    public void setIdFactura(int idFactura)   { this.idFactura    = idFactura; }
    public void setIdPedido(int idPedido)     { this.idPedido     = idPedido; }
    public void setFechaFactura(String fecha) { this.fechaFactura = fecha; }
    public void setTotal(double total)        { this.total        = total; }
}
