package co.edu.uniquindio.poo;

public class Contacto {
    private String nombre;
    private String alias;
    private String direccion;
    private String telefono;
    private String email;


    /**
     * constructor para la clase contacto
     * @param nombre
     * @param alias
     * @param direccion
     * @param telefono
     * @param email
     */
    public Contacto(String nombre, String alias, String direccion, String telefono, String email){
        this.nombre= nombre;
        this.alias= alias;
        this.direccion= direccion;
        this.telefono= telefono;
        this.email= email;
    }


    /**
     * función para poder acceder al nombre del contacto 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * función para poder modificar el nombre del contacto
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * función para poder acceder el alias del contacto
     * @return
     */
    public String getAlias() {
        return alias;
    }

    /**
     * función para modificar el alias del contacto
     * @param alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * función para acceder a la dirección del contacto
     * @return
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * función para modificar la dirección del contacto
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * función para acceder al telefono del contacto
     * @return
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * función para modificar el telefono del contacto
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * función para acceder al correo del contacto
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * función para modificar el correo del contacto
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    //se crea un mensaje predeterminado para visualizar los datos del contacto
    @Override
    public String toString() {
        return "Contacto [nombre=" + nombre + ", alias=" + alias + ", direccion=" + direccion + ", telefono=" + telefono
                + ", email=" + email + "]";
    }
    
    
}
