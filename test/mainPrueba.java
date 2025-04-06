
import java.util.Scanner;
import Aerolinea.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author javiiariass
 */
public class mainPrueba {
    public static void main(String[] args) throws InterruptedException {
        // Declaraciones
        int billetes, opcion;
        boolean salir = false;
        Scanner bi = new Scanner(System.in);
        Usuario user = new Usuario();
        Agencia iberia = new Agencia();
        AvionSingleton avion = AvionSingleton.getAvion();

        do {
            System.out.println("Hay " + avion.getAsientos());
            System.out.println("""
                               1. Comprar billetes
                               2. Cancelar billetes
                               0. Salir 
                               """);
            opcion = bi.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("¿Cuántos billetes quiere comprar?: ");
                    billetes = bi.nextInt();
                    user.comprarVuelos(billetes);
                    break;
                case 2:
                    System.out.println("¿Cuántos billetes quiere cancelar?: ");
                    billetes = bi.nextInt();
                    iberia.eliminarAsientos(billetes);
                    break;
                case 0:
                    salir = true;
                    break;

                default:
                    System.out.println("Instroduzca opcion válida");
                    Thread.sleep(1500);
            }
        } while (!salir);
    }
}
