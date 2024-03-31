package gestionproyectos;

import java.util.ArrayList;

/**
 * Clase para encapsular los datos de equipo
 * @version 1.0
 * @since 1.0
 * @author Marco
 */
public class Equipo {
    private final String nombre;
    private ArrayList<String> miembros;
    private ArrayList<String> responsabilidades;
    private final int horasTrabajadas;

    public Equipo(String nombre, ArrayList<String> miembros,
                  ArrayList<String> responsabilidades,
                  int horasTrabajadas) {
        this.nombre = nombre;
        this.miembros = miembros;
        this.responsabilidades = responsabilidades;
        this.horasTrabajadas = horasTrabajadas;
    }

    /**
     * Metodo para agregar un miembro nuevo al equipo ademas de su responsabilidad
     * @param miembro Nombre/Codigo del nuevo miembro
     * @param responsabilidad Responsabilidad del nuevo miembro
     */
    protected void addMiembro(String miembro, String responsabilidad) {
        this.miembros.add(miembro);
        this.responsabilidades.add(responsabilidad);
    }

    // GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getMiembros() {
        return miembros;
    }

    public ArrayList<String> getResponsabilidades() {
        return responsabilidades;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", miembros=" + miembros +
                ", responsabilidades=" + responsabilidades +
                ", horasTrabajadas=" + horasTrabajadas +
                '}';
    }
}
