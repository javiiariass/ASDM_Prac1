/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aerolinea;

/**
 *
 * @author javiiariass
 */
public final class AvionSingleton {
    // Unica instancia de AvionSingleton
    private static final AvionSingleton avion = new AvionSingleton();
    
    // Atributos de clase
    private static int asientos;
    private static final int ASIENTOS_MAXIMOS = 180;
    
    
    // Constructor privado que no permita instanciarlo
    private AvionSingleton(){
        asientos = ASIENTOS_MAXIMOS;
    }
    
    public static AvionSingleton getAvion(){
        return avion;
    }
    
    
    // ------------------------------------- Metodos -------------------------------------
    
    public static int getAsientos(){
        return asientos;
    }
    
    /**
     * anula N numero de billetes o todos los posibles.
     * @param billetesEliminar indica el numero de billetes a eliminar
     * @return -1 si no hay billetes que anular o el valor pasado es negativo<p>
     * 0 si elimina todos los billetes pasados por parametro
     * n si elimina al menos 1 billete 
     * n -> numero de billetes eliminados
     */
    protected int anularVuelos(int billetesEliminar){
        if(asientos == ASIENTOS_MAXIMOS || billetesEliminar < 0)
            return -1;
        
        // Si quiere cancelar mas billetes de los que se pueden
        // elimina todos los posibles
        
        int aux;
        if(billetesEliminar > (ASIENTOS_MAXIMOS -asientos)){ // Si quiere eliminar mas billetes de los restantes
            aux = ASIENTOS_MAXIMOS - asientos;
            asientos = ASIENTOS_MAXIMOS;
        }else{  // Si quiere eliminar menos o los que quedan
            asientos += billetesEliminar;
            aux = 0;
        }
        
        return aux;
    }
    
    /**
     * compra N numero de billetes o todos los posibles.
     * @param billetesComprar  indica el numero de billetes a comprar
     * @return -1 si no hay billetes que comprar o el valor pasado es negativo<br>
     * 0 si compra la cantidad de billetes pasada por parametro
     * n si compra menos de la cantidad pasada por parametro (no hay suficientes)<br>
     * n -> numero de billetes comprados
     */
    protected int comprarVuelos(int billetesComprar){
        if(asientos == 0 || billetesComprar < 0)
            return -1;
        
        int aux;
        // Si quiere comprar mas billetes de los disponibles
        // solo compra los disponibles
        if(billetesComprar > asientos){
            aux = asientos;
            asientos = 0;
        }else{
            asientos -= billetesComprar;
            aux = 0;
        }
        
        return aux;
    }
    
}
