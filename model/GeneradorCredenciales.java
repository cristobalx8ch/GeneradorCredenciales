package model;

import java.util.ArrayList;
import java.util.List;

public class GeneradorCredenciales {
    // instancia unica de las clases
    private static GeneradorCredenciales instancia;
    // lista que alamacena las credenciales
    private List<Credencial> credenciales;

    // constructor privado para evitar instanciacion directa
    private GeneradorCredenciales() {
        this.credenciales = new ArrayList<>();
    }

    // metodo estatico que retorna la unica instancia de la clase
    // si no existe la crea
    public static GeneradorCredenciales obtenerInstancia() {
        if (instancia == null) {
            instancia = new GeneradorCredenciales();
        }
        return instancia;
    }

    // agrega una nueva credencial a la lista se utiliza el metodo clonar
    public void agregarCredenciales(Credencial c) {
        credenciales.add(c.clonar());
    }

    public void mostrarCredenciales() {
        if (credenciales.isEmpty()) {
            System.out.println("no hay credenciales generada");
        } else {
            System.out.println("Credenciales generadas");
            for (Credencial c : credenciales) {
                System.out.println(c);
            }
        }
    }

    public List<Credencial> obtenerCredenciales() {
        return credenciales;
    }
}
