package co.burguerzona.model;

/**
 * Representa a un usuario del sistema (cliente o empleado).
 */
public class Usuario {

    private int    idUser;
    private String nombre;
    private String apellidos;
    private String tipoDocumento;
    private String documento;
    private String telefono;
    private String email;
    private String fechaRegistro;
    private int    idCargo;
    private int    idGenero;

    public Usuario() {}

    public Usuario(int idUser, String nombre, String apellidos,
                   String tipoDocumento, String documento, String telefono,
                   String email, String fechaRegistro, int idCargo, int idGenero) {
        this.idUser        = idUser;
        this.nombre        = nombre;
        this.apellidos     = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.documento     = documento;
        this.telefono      = telefono;
        this.email         = email;
        this.fechaRegistro = fechaRegistro;
        this.idCargo       = idCargo;
        this.idGenero      = idGenero;
    }

    public int    getIdUser()        { return idUser; }
    public String getNombre()        { return nombre; }
    public String getApellidos()     { return apellidos; }
    public String getTipoDocumento() { return tipoDocumento; }
    public String getDocumento()     { return documento; }
    public String getTelefono()      { return telefono; }
    public String getEmail()         { return email; }
    public String getFechaRegistro() { return fechaRegistro; }
    public int    getIdCargo()       { return idCargo; }
    public int    getIdGenero()      { return idGenero; }

    public void setIdUser(int idUser)             { this.idUser        = idUser; }
    public void setNombre(String nombre)           { this.nombre        = nombre; }
    public void setApellidos(String apellidos)     { this.apellidos     = apellidos; }
    public void setTipoDocumento(String tipo)      { this.tipoDocumento = tipo; }
    public void setDocumento(String documento)     { this.documento     = documento; }
    public void setTelefono(String telefono)       { this.telefono      = telefono; }
    public void setEmail(String email)             { this.email         = email; }
    public void setFechaRegistro(String fecha)     { this.fechaRegistro = fecha; }
    public void setIdCargo(int idCargo)            { this.idCargo       = idCargo; }
    public void setIdGenero(int idGenero)          { this.idGenero      = idGenero; }
}
