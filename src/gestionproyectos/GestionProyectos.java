package gestionproyectos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionProyectos {

    private ArrayList<Proyecto> proyectos;

    public GestionProyectos() {
        this.proyectos = new ArrayList<>();
    }

    public void crearProyecto(Scanner reader) {


        System.out.print("Nombre del proyecto: ");
        String nombre = reader.nextLine();

        System.out.print("Fecha de inicio (dd/mm/yyyy): ");
        String fechaIniString = reader.next();

        System.out.print("Fecha prevista de fin (dd/mm/yyyy): ");
        String fechaFinString = reader.next();

        reader.nextLine(); // --- clear buffer ---

        System.out.print("Estado del proyecto: ");
        String estado = reader.nextLine();

        LocalDate fechaIni = parseDate(fechaIniString);
        LocalDate fechaFin = parseDate(fechaFinString);

        Equipo equipo = crearEquipo(reader);

        Proyecto proyecto = new Proyecto(nombre, fechaIni, fechaFin, estado, equipo);

        this.proyectos.add(proyecto);

    }

    // UTILS
    // Solo para la clase propia
    private Equipo crearEquipo(Scanner reader) {

        System.out.print("Nombre del equipo: ");
        String nombre = reader.nextLine();

        System.out.print("Con cuantos miembros desea empezar: ");
        int nMiembros = reader.nextInt();
        reader.nextLine(); // Clear buffer

        ArrayList<String> miembros = new ArrayList<>();
        ArrayList<String> respons = new ArrayList<>();
        for (int i = 0; i < nMiembros; i++) {
            System.out.print("Nombre/Codigo del miembro " + (i+1) + ": ");
            miembros.add(reader.nextLine());
            System.out.print("Responsabilidad del miembro: ");
            respons.add(reader.nextLine());
        }

        System.out.print("Horas trabajadas: ");
        int horas = reader.nextInt();

        reader.nextLine(); // Clean buffer

        return new Equipo(nombre, miembros, respons, horas);
    }

    private LocalDate parseDate(String f) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(f, formatter);
    }

    @Override
    public String toString() {
        return "GestionProyectos{" +
                "proyectos=" + proyectos +
                '}';
    }

    // GETTERS & SETTERS
    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }
}
