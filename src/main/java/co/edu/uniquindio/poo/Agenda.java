package co.edu.uniquindio.poo;
import java.util.LinkedList;
import java.time.LocalTime;
import java.time.LocalDate;



public class Agenda {
    /**
     * Atributos
     */
    private String nombre;
    private LinkedList<Contacto> listaContactos;
    private LinkedList<Reunion> reuniones;
    private LinkedList<Grupo> grupos;
   
    /**
     * Constructor de la agenda
     * @param nombre
     */
    public Agenda(String nombre) {
        this.nombre = nombre;
        listaContactos= new LinkedList<>();
        reuniones= new LinkedList<>();
        grupos= new LinkedList<>();
    }

    /**
     * función para acceder al nombre de la agenda
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Función para modificar el nombre de la agenda
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * función para acceder a la lista de contactos de la agenda
     * @return
     */
    public LinkedList<Contacto> getListaContactos() {
        return listaContactos;
    }

    /**
     * función para modificar la lista de contactos de la agenda
     * @param listaContactos
     */
    public void setListaContactos(LinkedList<Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }


    /**
     * función para acceder a la lista reuniones
     * @return
     */
    public LinkedList<Reunion> getReuniones() {
        return reuniones;
    }

    /**
     * función para modificar la lista reuniones
     * @param reuniones
     */
    public void setReuniones(LinkedList<Reunion> reuniones) {
        this.reuniones = reuniones;
    }

    /**
     * función para acceder a la lista de grupos
     * @return
     */
    public LinkedList<Grupo> getGrupos() {
        return grupos;
    }


    /**
     * función para modificar la lista de grupos
     * @param grupos
     */
    public void setGrupos(LinkedList<Grupo> grupos) {
        this.grupos = grupos;
    }


    /**
     * función para poder crear un contacto
     * @param contacto
     */
     public void crearContacto(Contacto contacto){
        if(verificarContactoExiste(contacto.getNombre(), contacto.getTelefono())){ //Llama la función para verificar que el contacto no este en la lista
           //si está añadido imprime este mensaje
           
            System.out.println("error, ya existe el contacto");

        }else{
            //Si no esta contenido lo agrega a la lista
            getListaContactos().add(contacto);
        }
    }


    /**
     * función para verificar que un contacto ya este en la lista de contactos
     * @param nombre
     * @param telefono
     * @return
     */
    public boolean verificarContactoExiste(String nombre, String telefono){
        boolean existe = false;//Supone que no el contacto no está en la lista
        for (Contacto contacto : listaContactos) { 
            //Dentro de la clase Contacto busca que el contacto este contenido en la lista
            if(contacto.getNombre().equals(nombre)&&contacto.getTelefono().equals(telefono)){
                //Si el contacto coincide con alguno de la lista el booleano se vuelve verdadero
                existe=true;
            }
        }
        return existe;
    }

    /**
     * función para modificar un contacto
     * @param nombre
     * @param telefono
     * @param alias
     * @param direccion
     * @param email
     */
    public void actualizarContacto(String nombre, String telefono, String alias, String direccion, String email ){
        for (Contacto contacto : listaContactos) {//Busca el contacto
            if(contacto.getNombre().equals(nombre)&&contacto.getTelefono().equals(telefono)){
                //si coinciden estos parametros permitira actualizar los datos del contacto
                contacto.setAlias(alias);
                contacto.setDireccion(direccion);
                contacto.setEmail(email);
                break;//Detiene el for
            }
        }
        
    }

    /**
     * función para eliminar un contacto
     * @param nombre
     * @param telefono
     */
    public void eliminarContacto(String nombre, String telefono){
        for (Contacto contacto : listaContactos) {
            if(contacto.getNombre().equals(nombre)&&contacto.getTelefono().equals(telefono)){
                //si coinciden estos parametros eliminar actualizar los datos del contacto
                listaContactos.remove(contacto);
                break;//detiene el for
            }
            
        }
    }

    /**
     * función para crear un grupo
     * @param grupo
     */
    public void crearGrupo(Grupo grupo){
      grupos.add(grupo);
    }
    

    /**
     * función para actualizar los datos del grupo
     * @param grupo
     * @param nombre
     * @param categoria
     * @param contactos
     */
    public void actualizarGrupo(Grupo grupo, String nombre, Categoria categoria){
        for (Grupo grupoAux : grupos) {
            if (grupo.equals(grupoAux)){
                //si alguno de los grupos coincide con el grupo auxiliar permitira modificar el grupo de la lista
                grupo.setNombre(nombre);
                grupo.setCategoria(categoria);
            }
        }
    }

    /**
     * Función para agregar contactos a un grupo
     * @param grupo
     * @param contacto
     * @return
     */
    public boolean agregarContactosGrupo(Grupo grupo, Contacto[] contacto){
        boolean anadido = false;
        for (Grupo grupoAux : grupos) {
            // busca dentro de la clase Grupo el grupoAux dentro de la lista de grupos
            if(grupoAux.equals(grupo)){
                if(contacto.length <= 5){
                    //añade el contacto a la lista de contactos del grupo
                    grupoAux.setListaContactos(contacto);
                    anadido = true;
                    break;
                }
            }
        }
        return anadido;
    }

    /**
     * función para eliminar un grupo
     * @param nombre
     * @param categoria
     */
    public void eliminarGrupo(String nombre, Categoria categoria){
        for (Grupo grupo : grupos) {
            if (grupo.getNombre().equals(nombre)&&grupo.getCategoria().equals(categoria)) {
                //si coinciden los parametros se elimina el grupo
                grupos.remove(grupo);                
            }
            
        }
    }


    /**
     * función para crear una reunión
     * @param reunion
     */
    public void crearReunion(Reunion reunion){
        reuniones.add(reunion);
    }

    /**
     * función para añadir un contacto asistente a una reunión
     * @param reunion
     * @param contacto
     */
    public void anadirContacto( Reunion reunion, Contacto contacto){
        for (Reunion reunionAux : reuniones) {
            if(reunionAux.equals(reunion)){
                //llama la función dentro de la clase reunión
                reunionAux.anadirContacto(contacto);
            }
        }
    }

    /**
     * función para eliminar un contacto de la lista de asistentes a una reunión
     * @param reunion
     * @param contacto
     */
    public void eliminarContactoAsis(Reunion reunion, Contacto contacto){
        //busca que el contacto solicitado exista
        if (verificarContactoExiste(contacto.getNombre(), contacto.getTelefono())) {
            //si encuentra el contacto, busca la reunión solicitada
            for (Reunion reunionAux : reuniones) {
                if (reunionAux.equals(reunion)) {
                    //si coincide los parametros elimina el contacto de la reunión
                    reunionAux.eliminarContactoAsis(contacto);
                }
            }
        }else{
            System.out.println("El contacto no existe");
        }

    }

    /**
     * función para poder modificar los datos de una reunión
     * @param reunion
     * @param descripcion
     * @param fecha
     * @param hora
     */
    public void actualizarReunion(Reunion reunion, String descripcion, LocalDate fecha, LocalTime hora){
        //busca la reunión
        for (Reunion reunionAux : reuniones) {
            if (reunion.equals(reunionAux)) {
                //Si coincide los parametros se podrá modificar la reunión
                reunion.setDescripcion(descripcion);
                reunion.setFecha(fecha);
                reunion.setHora(hora);
            }
        }
    }


    /**
     * función para eliminar una reunión
     * @param reunion
     */
    public void eliminarReunion(Reunion reunion){
        //busca la reunión
        for (Reunion reunionAux : reuniones) {
            if (reunion.equals(reunionAux)) {
                //si coinciden los datos se eliminará la reunión
                reuniones.remove(reunionAux);
            }
        }
    }







}
