package gestionproyectos;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionProyectos {

    private final ArrayList<Proyecto> proyectos;

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
    public void eliminarProyecto(Scanner reader) {
        int index = getIndiceProyecto(reader);

        this.proyectos.remove(index);
        System.out.println("Proyecto eliminado correctamente");
    }
    public void cambiarEstado(Scanner reader) {
        int index = getIndiceProyecto(reader);

        System.out.print("Estado del proyecto: ");
        String estado = reader.nextLine();

        this.proyectos.get(index).setEstado(estado);
        System.out.println("Estado actualizado correctamente");

    }
    public void agregarMiembro(Scanner reader) {
        int index = getIndiceProyecto(reader);

        System.out.print("Nombre/Codigo del miembro: ");
        String miembro = reader.nextLine();
        System.out.print("Responsabilidad del miembro: ");
        String respons = reader.nextLine();

        this.proyectos.get(index).getEquipo().addMiembro(miembro, respons);
    }
    public void generarInforme(Scanner reader) {

        int index = getIndiceProyecto(reader);

        Proyecto proyecto = this.proyectos.get(index);
        System.out.println("###############" + "\n#   INFORME   #" + "\n###############");
        System.out.println("Proyecto: " + proyecto.getNombre() +
                "\n" + proyecto.getFechaInicio().toString() +
                " - " + proyecto.getFechaFin().toString() +
                "\nEstado: " + proyecto.getEstado() +
                "\nMiembros y responsabilidades: ");

        for (int i = 0; i < proyecto.getEquipo().getMiembros().size(); i++) {
            System.out.println(proyecto.getEquipo().getMiembros().get(i) +
                    "\t" + proyecto.getEquipo().getResponsabilidades().get(i));
        }

    }

    // UTILS
    // Solo para la clase propia
    private int getIndiceProyecto(Scanner reader) {

        // Si no hay proyectos abortamos el metodo
        if (this.proyectos.isEmpty()) {
            System.out.println("NO HAY PROYECTOS");
            System.out.println("Creando uno...");
            this.crearProyecto(reader);
            return 0;
        }

        for (int i = 0; i < this.proyectos.size(); i++) {
            System.out.println((i+1) + ". " + this.proyectos.get(i).getNombre());
        }
        System.out.print("Indice del proyecto: ");
        int index = reader.nextInt();
        reader.nextLine();  // Clear buffer

        if (!checkIndiceProyecto(index)) {
            System.err.println("INDICE INVALIDO");
        }

        return index - 1;
    }
    private boolean checkIndiceProyecto(int index) {
        return index >= 0 && index <= this.proyectos.size();
    }
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
