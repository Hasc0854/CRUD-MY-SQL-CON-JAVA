package inicio;

import java.util.Scanner;

public class Inicio {
    public static void main(String args[]) {
        int opcion=0 ;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("______________________");
            System.out.println("Aplicacion de mensajes ");
            System.out.println("1. para ingresar un mensaje");
            System.out.println("2. para listar los mensajes");
            System.out.println("3. para editar un mensaje");
            System.out.println("4. para eliminar un mensaje");
            System.out.println("5. para salir del menu");
            System.out.println("______________________");
            opcion=sc.nextInt();



            switch (opcion){
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.leerMensaje();
                    break;
                case 3:
                    MensajeService.editarMensaje();
                    break;
                case 4:
                    MensajeService.borrarMensaje();
                    break;
                default:

            }

        } while (opcion != 5);

    }
}
