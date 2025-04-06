/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm_prac1;

import Aerolinea.AvionSingleton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author javi
 */
public class canvasAvion extends JPanel {
    int numAsiOcupados;

    private BufferedImage avionImagen = null;
 
    
    public canvasAvion(BufferedImage imagen) {

        //Parámetros canvas
//        setPreferredSize(dim);
//        setSize(dim);
//        setBackground(Color.lightGray);
        numAsiOcupados = 0;
        // avion = AvionSingleton.getAvion(); // No hacemos uso del objeto
        //Imagenes
        avionImagen = imagen;

    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        //Redimensionado imagen avion manteniendo la proporcion
        int escaladoX = avionImagen.getWidth(this)*2/7;
        int escaladoY = avionImagen.getHeight(this)*2/7;
        
        // Pintamos avion
        g.drawImage(avionImagen, 0, 0,escaladoX,escaladoY ,null);
        
        // Pintamos asientos
        // 180 asientos -> 30 filas de 6 asientos, 3 a cada lado 
        int posX,posY,contadorAsientos;
        posY = 70;
        contadorAsientos = 0;
           
        // Empezamos pintando los asientos disponibles
        g.setColor(Color.green); 
        for(int i=0;i<30;i++){
            posY += 7;
            posX = 102;
            for(int j = 0; j<6;j++){
                
                // Espacio del pasillo cuando se han pintado los asientos
                if(j ==3)
                    posX += 12; 
                // Cuando lleguemos al final de los asientos disponibles -> pintamos en rojo
                if(contadorAsientos == AvionSingleton.getAsientos()) 
                    g.setColor(Color.red); 
                g.fillRect(posX, posY, 7, 5);
                posX+=9;
                contadorAsientos++;
            }
            
            
            
        }
    }
    
    public void pintaAsientos(int numAsiOcupados){
        repaint();
    }

}
