package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalTime;


public class App {
  public static void main(String[] args) {
    Agenda agenda = new Agenda("No se");
    Contacto contacto = new Contacto("Pepe", "Papas", "Casa", "312321314", "hola@a.");
    agenda.crearContacto(contacto);
    Reunion reunion = new Reunion("Wonito", null, null);
    agenda.crearReunion(reunion);
    System.out.println(agenda.getReuniones().get(0));
    agenda.anadirContacto(reunion, contacto);
    LocalDate fecha = LocalDate.now();
    LocalTime time = LocalTime.now();
    System.out.println(agenda.getReuniones());
    agenda.eliminarContactoAsis(reunion, contacto);
    System.out.println(agenda.getReuniones());
    agenda.actualizarReunion(reunion, "feito",fecha, time);
    System.out.println(agenda.getReuniones().get(0));
    agenda.eliminarReunion(reunion);
    System.out.println(agenda.getReuniones().size());
  }


  public static void crearContacto(){
    Agenda agenda = new Agenda("No se");
    Contacto contacto = new Contacto("Pepe", "Papas", "Casa", "312321314", "hola@a.");
    Contacto contacto1 = new Contacto("Juan", "Papas", "Casa", "312321314", "hola@a.");
    agenda.crearContacto(contacto);
    System.out.println(agenda.getListaContactos().size());
    agenda.crearContacto(contacto);
    agenda.crearContacto(contacto1);
    System.out.println(agenda.getListaContactos().size());
  }

  public static void actualizarELiminar(){
    Agenda agenda = new Agenda("No se");
    Contacto contacto = new Contacto("Pepe", "Papas", "Casa", "312321314", "hola@a.");
    agenda.crearContacto(contacto);
    System.out.println(agenda.getListaContactos().get(0));
    agenda.actualizarContacto("Pepe", "312321314", "Pepas", "Apartamento", "adios@");
    System.out.println(agenda.getListaContactos().get(0));
    agenda.eliminarContacto("Pepe", "312321314");
    System.out.println(agenda.getListaContactos().size());
  }

  public static void test(){
    Agenda agenda= new Agenda("pito");
    Grupo grupo= new Grupo("musica", Categoria.oficina);
    Contacto contacto = new Contacto("Pepe", "Papas", "Casa", "312321314", "hola@a.");
    Contacto contacto1 = new Contacto("Juan", "Papas", "Casa", "312321314", "hola@a.");
    grupo.getListaContactos()[0]=contacto;
    grupo.getListaContactos()[1]=contacto1;
    agenda.crearGrupo(grupo);
    System.out.println(agenda.getGrupos().get(0));
    Contacto[]listaContactos= new Contacto[5];
    listaContactos[0]= contacto1;
    agenda.actualizarGrupo(grupo, "musica", Categoria.fiesta);
    System.out.println(agenda.getGrupos().get(0));
    agenda.eliminarGrupo("musica", Categoria.fiesta);
    System.out.println(agenda.getGrupos().size());
  }


  public static void aja(){
    Agenda agenda = new Agenda("No se");
    Contacto contacto = new Contacto("Pepe", "Papas", "Casa", "312321314", "hola@a.");
    agenda.crearContacto(contacto);
    Reunion reunion = new Reunion("Wonito", null, null);
    agenda.crearReunion(reunion);
    agenda.anadirContacto(reunion, contacto);
    System.out.println(agenda.getReuniones().get(0).getListaContactosAsistentes().get(0));
    agenda.eliminarContactoAsis(reunion, contacto);
    System.out.println(agenda.getReuniones().get(0).getListaContactosAsistentes().size());


  }
}
