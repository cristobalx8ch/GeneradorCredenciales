package model;

import java.util.List;
import java.util.Scanner;

public class MenuConsola {
    private Scanner scanner = new Scanner(System.in);
    private GeneradorCredenciales generador = GeneradorCredenciales.obtenerInstancia();

    public void mostrarMenu() {
        int option;

        do {
            System.out.println("\n--- Menu generador de Credenciales ---");
            System.out.println("1. Agregar credenciales");
            System.out.println("2. Mostrar credenciales");
            System.out.println("3. Clonar una credencial existente");
            System.out.println("4. Salir");
            System.out.println("Elije una opcion: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    agregarCredencial();
                    break;
                case 2:
                    generador.mostrarCredenciales();
                    break;
                case 3:
                    clonarCredencialesExistente();
                    break;
                case 4:
                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida Intenta de nuevo");
                    break;
            }
        } while (option != 4);
    }

    private void agregarCredencial() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Rut: ");
        String rut = scanner.nextLine();

        Credencial nueva = new Credencial(nombre, cargo, rut);
        generador.agregarCredenciales(nueva);
        System.out.println("Se agrego correctamente");

    }

    private void clonarCredencialesExistente() {
        List<Credencial> lista = generador.obtenerCredenciales();

        if (lista.isEmpty()) {
            System.out.println("no hay credenciales para clonar");
            return;
        }
        System.out.println("Selecciona una credencial para clonar");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print((i + 1) + ". \n" + lista.get(i));
        }
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option < 1 || option > lista.size()){
            System.out.println("opcion invalidad");
            return;
        }
        
        Credencial seleccionado = lista.get(option -1);
        Credencial clon = seleccionado.clonar();
        generador.agregarCredenciales(clon);

        System.out.println("credencial clonada exitosa ");
    }
}
