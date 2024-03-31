package gestionproyectos;

import java.time.LocalDate;

/**
 * Clase principal para la encapsulación de los datos de proyectos
 * @version 1.5
 * @since 1.0
 * @author Marco
 */
public class Proyecto {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private Equipo equipo;

    // private ArrayList<Tarea> listaTareas;

    public Proyecto(String nombre, LocalDate fechaInicio,
                    LocalDate fechaFin, String estado,
                    Equipo equipo) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.equipo = equipo;
    }

    public Proyecto(String nombre, LocalDate fechaInicio,
                    String estado, Equipo equipo) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = null;
        this.estado = estado;
        this.equipo = equipo;
    }

    // GETTERS & SETTERS

    public Equipo getEquipo() {
        return equipo;
    }

    protected void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    protected void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "nombre='" + nombre + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", estado='" + estado + '\'' +
                ", equipo=" + equipo +
                '}';
    }
}
