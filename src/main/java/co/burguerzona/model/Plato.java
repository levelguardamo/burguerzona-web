package co.burguerzona.model;

import jakarta.persistence.*;

/**
 * Entidad que representa un Plato del menú de BurguerZona.
 * Mapeada a la tabla Platos de SQL Server.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA3-EV01
 */
@Entity
@Table(name = "Platos")
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPlato")
    private int idPlato;

    @Column(name = "Nombre_plato", nullable = false, length = 50)
    private String nombrePlato;

    @Column(name = "Precio", nullable = false)
    private double precio;

    @Column(name = "Descripcion", length = 255)
    private String descripcion;

    public Plato() {}

    public Plato(int idPlato, String nombrePlato, double precio, String descripcion) {
        this.idPlato = idPlato;
        this.nombrePlato = nombrePlato;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public int getIdPlato() { return idPlato; }
    public void setIdPlato(int idPlato) { this.idPlato = idPlato; }
    public String getNombrePlato() { return nombrePlato; }
    public void setNombrePlato(String nombrePlato) { this.nombrePlato = nombrePlato; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}