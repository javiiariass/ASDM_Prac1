/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aerolinea;

/**
 *
 * @author javiiariass
 */
public class Usuario {
    private AvionSingleton avion;
    
    public Usuario(){
        avion = AvionSingleton.getAvion();
    }
    
    public int comprarVuelos(int numBilletes){
        return avion.comprarVuelos(numBilletes);
    }
    
}
