package gestionproyectos;

import gestionproyectos.GestionProyectos;

import java.util.Scanner;

/**
 * Clase principal que sirve de punto de entrada del programa
 * @see GestionProyectos
 * @see gestionproyectos.Equipo
 * @see gestionproyectos.Proyecto
 * @author Marco
 * @version 3.0
 */
public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        GestionProyectos gestion = new GestionProyectos();

        int opt = 0;

        do {
            mostrarMenu();
            opt = reader.nextInt();
            reader.nextLine(); // Clear buffer;
            opcionMgr(opt, gestion, reader);
        } while (opt != 6);

        reader.close();
    }

    /**
     * Metodo para manejar las opciones del menú
     * @param opt int Opcion que ha seleccionado el usuario
     * @param gestion GestionProyectos Objeto de gestion de proyectos
     * @param reader Scanner del usuario
     */
    public static void opcionMgr(int opt, GestionProyectos gestion, Scanner reader) {
        switch (opt) {
            case 1:
                gestion.crearProyecto(reader);
                break;
            case 2:
                gestion.eliminarProyecto(reader);
                break;
            case 3:
                gestion.cambiarEstado(reader);
                break;
            case 4:
                gestion.agregarMiembro(reader);
                break;
            case 5:
                gestion.generarInforme(reader);
                break;
            case 6:
                System.out.println("Saliendo...");
                break;
            default:
                System.err.println("OPCION NO RECONOCIDA");
                break;
        }
    }

    /**
     * Metodo basico para mostrar el menú
     */
    public static void mostrarMenu() {
        System.out.println("############################");
        System.out.println("#   GESTION DE PROYECTOS   #");
        System.out.println("############################");
        System.out.println("1. Crear Proyecto");
        System.out.println("2. Eliminar Proyecto");
        System.out.println("3. Cambiar estado del proyecto");
        System.out.println("4. Agregar miembro al proyecto");
        System.out.println("5. Generar informe");
        System.out.println("6. Salir");
        System.out.print("Opcion -> ");
    }

}