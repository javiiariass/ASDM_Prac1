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
    
    
    // Constructor privado que no permita instanciarlo
    private AvionSingleton(){
        avion.asientos = 180;
    }
    
    public static AvionSingleton getAvion(){
        return avion;
    }
    
    
    // ------------------------------------- Metodos -------------------------------------
    
    /**
     * anula N numero de billetes o todos los posibles.
     * @param billetesEliminar indica el numero de billetes a eliminar
     * @return -1 si no hay billetes que anular o el valor pasado es negativo<p>
     * 1 si elimina todos los billetes pasados por parametro
     * n si elimina al menos 1 billete 
     * n -> numero de billetes eliminados
     */
    public int anularVuelos(int billetesEliminar){
        if(asientos == 0 || billetesEliminar < 0)
            return -1;
        
        // Si quiere cancelar mas billetes de los que se pueden
        // elimina todos los posibles
        int aux = asientos;
        asientos += billetesEliminar;
        
        if(asientos > 180){
            asientos = 180;
        }else
            aux = 0;
            
             
        
        return aux;
    }
    
    /**
     * compra N numero de billetes o todos los posibles.
     * @param billetesComprar  indica el numero de billetes a comprar
     * @return -1 si no hay billetes que comprar o el valor pasado es negativo<br>
     * 0 si compra la cantidad de billetes pasada por parametro
     * n si compra menos de la cantidad pasada por parametro<br>
     * n -> numero de billetes comprados
     */
    public int comprarVuelos(int billetesComprar){
        if(asientos == 180 || billetesComprar < 0)
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
