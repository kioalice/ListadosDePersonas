import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasAPP {
    public static void main(String[] args) {
        Scanner sclistado = new Scanner(System.in);
        //Definimos la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();
        //menu
        var salir = false;

        while (!salir){
            mostrarMenu();
            try {
                salir = ejecutarOperacion(sclistado, personas);
            }catch (Exception e){
                System.out.println("Ocurrió un error: " + e.getMessage());
            }


            System.out.println();
        }





    }



    private static void mostrarMenu() {
        //Mostramos opciones
        System.out.print("""
                *** Listado de Personas ***
                1. Agregar
                2. Listar
                3.Salir
                """);
        System.out.print("Ingrese la opción: ");


    }

    private static boolean ejecutarOperacion(Scanner sclistado, List<Persona> personas) {
        var opcion = Integer.parseInt(sclistado.nextLine());
        var salir = false;
        //Revisamos la opcion proporcionada
        switch (opcion){
           case 1 -> { // Agregar personas a la lista
               System.out.print("Ingrese el nombre: ");
               var nombre = sclistado.nextLine();
               System.out.print("Ingrese el telefono: ");
               var tel = sclistado.nextLine();
               System.out.print("Ingrese correo: ");
               var correo = sclistado.nextLine();
               // Crear el objeto persona
               var persona = new Persona(nombre,tel,correo);
               //Lo agregamos a la lista
               personas.add(persona);
               System.out.println("La lista tiene: " + personas.size() + " elementos.");
           } //fin caso 1
            case 2 -> { // Listar personas
                System.out.println("Listado de personas: ");
                //Mejora usando lambda y metodo de referencia
                //personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println); //metodo de referencia se infiere que queremos pasar en cada parametro



            }//fin caso 2
            case 3 -> { // Salimos del ciclo
                System.out.println("Hasta Pronto...");
                salir = true;

            }//fin caso 3
            default -> System.out.println("Opción errónea: " + opcion);
        }//fin switch
        return salir;
    }
}


















