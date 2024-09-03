package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class Reunion {
    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;
    private LinkedList<Contacto> listaContactosAsistentes;

    /**
     * constructor de la clase reunión
     * @param descripcion
     * @param fecha
     * @param hora
     */
    public Reunion(String descripcion, LocalDate fecha, LocalTime hora) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.listaContactosAsistentes = new LinkedList<>();
    }

    /**
     * función para acceder a la descripción de la reunión
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * función para modificar la descripción de la reunión
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * función para acceder a la fecha de la reunión
     * @return
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * función para modificar la fecha de la reunión
     * @param fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * función para acceder a la hora de la reunión
     * @return
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * función para modificar la fecha de la reunión
     * @param hora
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * función para acceder a la lista ede contactos que van a asistir a la reunión
     * @return
     */
    public LinkedList<Contacto> getListaContactosAsistentes() {
        return listaContactosAsistentes;
    }

    /**
     * función para modificar la lista de contactos asistentes 
     * @param listaContactosAsistentes
     */
    public void setListaContactosAsistentes(LinkedList<Contacto> listaContactosAsistentes) {
        this.listaContactosAsistentes = listaContactosAsistentes;
    }

    //se crea un mensaje predeterminado para ver los datos de la reunión
    @Override
    public String toString() {
        return "Reunion [descripcion=" + descripcion + ", fecha=" + fecha + ", hora=" + hora
                + ", listaContactosAsistentes=" + listaContactosAsistentes + "]";
    }

    /**
     * función para añadir un contacto a la lista de asistentes 
     * @param contacto
     */
    public void anadirContacto(Contacto contacto) {
        // llama la función para verficar que el contacto este dentro de la lista 
        if(verificarContAsis(contacto.getNombre(),contacto.getTelefono())){
            System.out.println("error, el contacto ya está añadido");
        }else{
            getListaContactosAsistentes().add(contacto);
        }
    }
    /**
     * función para verificar que el contacto no este añadido en la lista
     * @param nombre
     * @param telefono
     * @return
     */
    public boolean verificarContAsis(String nombre, String telefono){
        boolean añadido= false;//supone que no está añadido
        for (Contacto contacto : listaContactosAsistentes) {
            //busca el contacto dentro de la lista
            if(contacto.getNombre().equals(nombre)&&contacto.getTelefono().equals(telefono)){
                //si el contacto ya está añadido el booleano e convierte en verdadero
                añadido= true;
            }
        }
        return añadido;
    }


    /**
     * función para eliminar un contacto que este en la lista de asistentes
     * @param contacto
     */
    public void eliminarContactoAsis(Contacto contacto) {
        for (Contacto contactoAux : listaContactosAsistentes) {
            //busca el contacto en la lista de asistenetes
            if (contacto.getNombre().equals(contactoAux.getNombre())&&contacto.getTelefono().equals(contactoAux.getTelefono())){
                //si lo encuentra lo elimina y detiene el loop
                listaContactosAsistentes.remove(contactoAux);
                break;
            }
        }
    }

}
