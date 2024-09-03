/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    private Agenda agenda = new Agenda("Mi agenda");

    @Test
    public void testCrearContacto(){
        Contacto contacto = new Contacto("Pepe", "Pepito", "Casa", "312321314", "hola@a.");
        agenda.crearContacto(contacto);
        assertEquals(contacto.getNombre(), agenda.getListaContactos().get(0).getNombre());
    }

    @Test
    public void testCrearContactoRepetido(){
        Contacto contacto = new Contacto("Pepe", "Pepito", "Casa", "312321314", "hola@a.");
        agenda.crearContacto(contacto);
        Contacto contacto2 = new Contacto("Pepe", "Juanito", "Apartamento", "312321314", "adios@a.");
        agenda.crearContacto(contacto2);
        assertEquals(1,agenda.getListaContactos().size());
    }

    @Test
    public void testActualizarContacto(){
        Contacto contacto = new Contacto("Pepe", "Pepito", "Casa", "312321314", "hola@a.");
        agenda.crearContacto(contacto);
        agenda.actualizarContacto("Pepe", "312321314", "fulanito", "choza", "pepe@.com");
        assertEquals("fulanito choza pepe@.com" , agenda.getListaContactos().get(0).getAlias()+" "+agenda.getListaContactos().get(0).getDireccion()+" "+agenda.getListaContactos().get(0).getEmail());
    }

    @Test 
    public void testEliminarContacto(){
        Contacto contacto = new Contacto("Pepe", "Pepito", "Casa", "312321314", "hola@a.");
        agenda.crearContacto(contacto);
        agenda.eliminarContacto("Pepe", "312321314");
        assertEquals(0, agenda.getListaContactos().size());
    }

    @Test
    public void testCrearGrupo(){ 
        Grupo grupo= new Grupo("musica", Categoria.fiesta);
        agenda.crearGrupo(grupo);
        assertEquals(1, agenda.getGrupos().size());
    }

    @Test
    public void testActualizarGrupo(){
        Grupo grupo= new Grupo("musica", Categoria.fiesta);
        agenda.crearGrupo(grupo);
        agenda.actualizarGrupo(grupo, "musica", Categoria.oficina);
        assertEquals(Categoria.oficina, agenda.getGrupos().get(0).getCategoria());
    }

    @Test
    public void testEliminarGrupo(){
        Grupo grupo= new Grupo("musica", Categoria.fiesta);
        agenda.crearGrupo(grupo);
        agenda.eliminarGrupo("musica", Categoria.fiesta);
        assertEquals(0, agenda.getGrupos().size());
    }


    @Test

    public void testAgregarContactoGrupo(){
        Contacto contacto = new Contacto("Pepe", "Pepito", "Casa", "312321314", "hola@a.");
        agenda.crearContacto(contacto);
        Grupo grupo= new Grupo("musica", Categoria.fiesta);
        agenda.crearGrupo(grupo);
        Contacto[] contactos = new Contacto[5];
        contactos[0] = contacto;

        assertTrue(agenda.agregarContactosGrupo(grupo, contactos));
    }

    @Test
    public void testAgregarContactoGrupoFallido(){
        Contacto contacto = new Contacto("Pepe", "Pepito", "Casa", "312321314", "hola@a.");
        agenda.crearContacto(contacto);
        Grupo grupo= new Grupo("musica", Categoria.fiesta);
        agenda.crearGrupo(grupo);
        Contacto[] contactos = new Contacto[6];
        contactos[0] = contacto;

        assertFalse( agenda.agregarContactosGrupo(grupo, contactos));
    }

    @Test
    public void testCrearReunion(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        Reunion reunion= new Reunion("salida", localDate, localTime);
        agenda.crearReunion(reunion);
        assertEquals(1, agenda.getReuniones().size());
    }

    @Test 
    public void testActualizarReunion(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        Reunion reunion= new Reunion("salida", localDate, localTime);
        agenda.crearReunion(reunion);
        agenda.actualizarReunion(reunion, "compromiso", localDate, localTime);
        assertEquals("compromiso", agenda.getReuniones().get(0).getDescripcion());
    }

    @Test

    public void testEliminarReunion(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        Reunion reunion= new Reunion("salida", localDate, localTime);
        agenda.crearReunion(reunion);
        agenda.eliminarReunion(reunion);
        assertEquals(0, agenda.getReuniones().size());
    }


    @Test
   
    public void testAnadirContactoAsistente(){
        Contacto contacto = new Contacto("Pepe", "Pepito", "Casa", "312321314", "hola@a.");
        agenda.crearContacto(contacto);
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        Reunion reunion= new Reunion("salida", localDate, localTime);
        agenda.crearReunion(reunion);
        agenda.anadirContacto(reunion,contacto);
        assertEquals(1, agenda.getReuniones().get(0).getListaContactosAsistentes().size());
    }

    @Test

    public void testEliminarContactoAsistente(){
        
    }
}
