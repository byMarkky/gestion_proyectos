import gestionproyectos.GestionProyectos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        GestionProyectos gestion = new GestionProyectos();

        gestion.crearProyecto(reader);

        System.out.println(gestion.toString());
    }
}