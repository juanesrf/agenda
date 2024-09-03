package co.edu.uniquindio.poo;


public class Grupo {
    private String nombre;
    private Contacto[] listaContactos;//se limita para que maximo puedan haber 5 contactos
    private Categoria categoria;
    
    /**
     * constructor de la clase grupo
     * @param nombre
     * @param categoria
     */
    public Grupo(String nombre, Categoria categoria) {
        this.nombre = nombre;
        this.listaContactos = new Contacto[5];
        this.categoria = categoria;
    }

    /**
     * función para acceder al nombre del grupo
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * función para modificar el nombre del grupo
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * función para acceder a la lista de contactos
     * @return
     */
    public Contacto[] getListaContactos() {
        return listaContactos;
    }

    /**
     * función para modificar la lista de contactos
     * @param listaContactos
     */
    public void setListaContactos(Contacto[] listaContactos) {
        this.listaContactos = listaContactos;
    }

    /**
     * función para acceder a las categorias
     * @return
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * función para modificar la categoria
     * @param categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    //se crea un mensaje predeterminado para visualizar los datos del grupo
    @Override
    public String toString() {
        return "Grupo [nombre=" + nombre + ", listaContactos=" + listaContactos + ", categoria=" + categoria + "]";
    }

    
    
}
