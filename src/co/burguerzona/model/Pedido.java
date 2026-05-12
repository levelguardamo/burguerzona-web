package co.burguerzona.model;

/**
 * Representa un pedido realizado en el restaurante BurguerZona.
 */
public class Pedido {

    private int    idPedido;
    private int    idUser;
    private int    idPlato;
    private String fechaPedido;
    private int    cantidad;

    public Pedido() {}

    public Pedido(int idPedido, int idUser, int idPlato,
                  String fechaPedido, int cantidad) {
        this.idPedido    = idPedido;
        this.idUser      = idUser;
        this.idPlato     = idPlato;
        this.fechaPedido = fechaPedido;
        this.cantidad    = cantidad;
    }

    public int    getIdPedido()    { return idPedido; }
    public int    getIdUser()      { return idUser; }
    public int    getIdPlato()     { return idPlato; }
    public String getFechaPedido() { return fechaPedido; }
    public int    getCantidad()    { return cantidad; }

    public void setIdPedido(int idPedido)     { this.idPedido    = idPedido; }
    public void setIdUser(int idUser)         { this.idUser      = idUser; }
    public void setIdPlato(int idPlato)       { this.idPlato     = idPlato; }
    public void setFechaPedido(String fecha)  { this.fechaPedido = fecha; }
    public void setCantidad(int cantidad)     { this.cantidad    = cantidad; }
}
