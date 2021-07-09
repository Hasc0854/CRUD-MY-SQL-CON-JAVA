package inicio;

import java.util.Scanner;

public class MensajeService {

private static Scanner sc = new Scanner(System.in);


    public static void crearMensaje(){

        System.out.println("ingrese su mensaje : ");
        String mensaje=sc.nextLine();

        System.out.println("ingrese su nombre : ");
        String nombre=sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor(nombre);

        MensajeDAO.crearMensaje(registro);
    }

    public static void leerMensaje(){
         MensajeDAO.leerMensaje();

    }
    public static void borrarMensaje(){
        System.out.println("ingrese el ID del mensaje a borrar");
        int idABorrar=sc.nextInt();
        MensajeDAO.borrarMensaje(idABorrar);

    }
    public static void editarMensaje(){

        System.out.println("ingrese el nuevo mensaje");
        String mensaje=sc.nextLine();
        System.out.println("ingrese el id del mensaje actualizar");
        int idActualizar=sc.nextInt();

        Mensajes actualizacio = new Mensajes();
        actualizacio.setId(idActualizar);
        actualizacio.setMensaje(mensaje);

        MensajeDAO.editarMensaje(actualizacio);
    }
}
