package gestionproyectos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal de gestion de proyectos y equipos
 * @author Marco
 * @version 2.0
 * @since 2.5
 */
public class GestionProyectos {

    private final ArrayList<Proyecto> proyectos;

    public GestionProyectos() {
        this.proyectos = new ArrayList<>();
    }

    /**
     * Metodo para crear un proyecto pidiendo datos al usuario
     * @param reader Scanner para leer los datos del usuario
     */
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

    /**
     * Metodo para eliminar proyecto por el usuario
     * @param reader Scanner del usuario
     */
    public void eliminarProyecto(Scanner reader) {
        int index = getIndiceProyecto(reader);

        this.proyectos.remove(index);
        System.out.println("Proyecto eliminado correctamente");
    }

    /**
     * Metodo para cambiar el estado de un proyecto
     * @param reader Scanner del usuario
     */
    public void cambiarEstado(Scanner reader) {
        int index = getIndiceProyecto(reader);

        System.out.print("Estado del proyecto: ");
        String estado = reader.nextLine();

        this.proyectos.get(index).setEstado(estado);
        System.out.println("Estado actualizado correctamente");

    }

    /**
     * Metodo para agregar un nuevo miembro al proyecto
     * @param reader Scanner del usuario
     */
    public void agregarMiembro(Scanner reader) {
        int index = getIndiceProyecto(reader);

        System.out.print("Nombre/Codigo del miembro: ");
        String miembro = reader.nextLine();
        System.out.print("Responsabilidad del miembro: ");
        String respons = reader.nextLine();

        this.proyectos.get(index).getEquipo().addMiembro(miembro, respons);
    }

    /**
     * Metodo para generar un informe de un proyecto
     * @param reader Scanner del usuario
     */
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

    /**
     * Metodo que muestra los proyectos y permite al usuario seleccionar uno
     * @param reader Scanner del usuario
     * @return int Indice del proyecto seleccionado por el usuario
     */
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

    /**
     * Metodo para comprobar si existe proyecto en un indice
     * @param index Indice a comprobar
     * @return true : si existe proyecot en el indice | false : si no existe proyecto
     */
    private boolean checkIndiceProyecto(int index) {
        return index >= 0 && index <= this.proyectos.size();
    }

    /**
     * Metodo para crear un equipo
     * @param reader Scanner del usuario
     * @return Equipo retorna el equipo creado
     */
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

    /**
     * Metodo para convertir un String en una objeto LocalDate
     * @param f String de la fecha
     * @return LocalDate fecha parseada
     */
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
