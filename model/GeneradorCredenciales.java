package model;

import java.util.ArrayList;
import java.util.List;

public class GeneradorCredenciales {
    private static GeneradorCredenciales instancia;
    private List<Credencial> credenciales;


    private GeneradorCredenciales() {
        this.credenciales = new ArrayList<>();
    }

    public static GeneradorCredenciales obtenerInstancia() {
        if (instancia == null) {
            instancia = new GeneradorCredenciales();
        }
        return instancia;
    }

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
