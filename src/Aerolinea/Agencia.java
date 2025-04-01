/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aerolinea;

/**
 *
 * @author javiiariass
 */
public class Agencia {
    private AvionSingleton avion;
    
    public Agencia(){
        avion = AvionSingleton.getAvion();
    }
    
    public int eliminarAsientos(int numAsientos){
        return avion.anularVuelos(numAsientos);
    }
}
