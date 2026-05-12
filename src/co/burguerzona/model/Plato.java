package co.burguerzona.model;

/**
 * Representa un plato disponible en el menú del restaurante BurguerZona.
 */
public class Plato {

    private int    idPlato;
    private String nombrePlato;
    private double precio;
    private String descripcion;

    public Plato() {}

    public Plato(int idPlato, String nombrePlato, double precio, String descripcion) {
        this.idPlato     = idPlato;
        this.nombrePlato = nombrePlato;
        this.precio      = precio;
        this.descripcion = descripcion;
    }

    public int    getIdPlato()     { return idPlato; }
    public String getNombrePlato() { return nombrePlato; }
    public double getPrecio()      { return precio; }
    public String getDescripcion() { return descripcion; }

    public void setIdPlato(int idPlato)            { this.idPlato     = idPlato; }
    public void setNombrePlato(String nombrePlato) { this.nombrePlato = nombrePlato; }
    public void setPrecio(double precio)           { this.precio      = precio; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
