package co.burguerzona.model;

import jakarta.persistence.*;

/**
 * Entidad que representa un Usuario del sistema BurguerZona.
 * Mapeada a la tabla Usuarios de SQL Server.
 *
 * @author Daniel Restrepo
 * @version 1.0
 * Evidencia: GA7-220501096-AA3-EV01
 */
@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUser")
    private int idUser;

    @Column(name = "Nombre", nullable = false, length = 90)
    private String nombre;

    @Column(name = "Aprellidos", nullable = false, length = 90)
    private String apellidos;

    @Column(name = "Tipo_de_documento", length = 10)
    private String tipoDocumento;

    @Column(name = "Documento", length = 10)
    private String documento;

    @Column(name = "Telefono", length = 15)
    private String telefono;

    @Column(name = "Email", nullable = false, length = 100)
    private String email;

    @Column(name = "Fecha_de_registro")
    private String fechaRegistro;

    @Column(name = "IdCargo", nullable = false)
    private int idCargo;

    @Column(name = "IdGenero", nullable = false)
    private int idGenero;

    public Usuario() {}

    public Usuario(int idUser, String nombre, String apellidos, String tipoDocumento,
                   String documento, String telefono, String email,
                   String fechaRegistro, int idCargo, int idGenero) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.telefono = telefono;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.idCargo = idCargo;
        this.idGenero = idGenero;
    }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(String fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public int getIdCargo() { return idCargo; }
    public void setIdCargo(int idCargo) { this.idCargo = idCargo; }
    public int getIdGenero() { return idGenero; }
    public void setIdGenero(int idGenero) { this.idGenero = idGenero; }
}