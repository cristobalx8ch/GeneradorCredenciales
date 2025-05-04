package model;

public class Credencial implements Prototype {
    private String nombre;
    private String cargo;
    private String rut;

    @Override
    public Credencial clonar() {
        return new Credencial(this.nombre, this.cargo, this.rut);
    }

    public Credencial(String nombre, String cargo, String rut) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public String getRut() {
        return rut;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String border = "+-----------------------------------------+\n";

        sb.append(border);
        sb.append(String.format("| %-8s: %-29s |\n", "Nombre", nombre));
        sb.append(String.format("| %-8s: %-29s |\n", "Cargo", cargo));
        sb.append(String.format("| %-8s: %-29s |\n", "RUT", rut));
        sb.append(border);
        return sb.toString();

    }
}
