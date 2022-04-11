/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Controlador.OyenteJugadores;
import Vistas.VentanaJugadores;
import java.awt.Color;
import javax.swing.JFrame;
import modelo.Jugadores;

/**
 *
 * @author Brandon Rogerio Aguirre Mendoza bran1189@gmail.com
 */
public class ClasePrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jugadores jugadores = new Jugadores();
        VentanaJugadores ventana = new VentanaJugadores(jugadores);
        OyenteJugadores oyente = new OyenteJugadores(jugadores, ventana);
        ventana.addEventos(oyente);
        ventana.setTitle("Control de jugadores");
        ventana.setSize(600, 800);
        ventana.setLocation(50, 50);
        ventana.setBackground(Color.yellow);
        ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ventana.setVisible(true);

        /*
    Se quedo el video en el minuto 30:15
        En el OyenteJugadores
        
         */
    }

}
