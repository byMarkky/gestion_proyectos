package gestionproyectos;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<String> miembros;
    private ArrayList<String> responsabilidades;
    private int horasTrabajadas;

    public Equipo(String nombre, ArrayList<String> miembros,
                  ArrayList<String> responsabilidades,
                  int horasTrabajadas) {
        this.nombre = nombre;
        this.miembros = miembros;
        this.responsabilidades = responsabilidades;
        this.horasTrabajadas = horasTrabajadas;
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
}
