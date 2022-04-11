/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vistas.DialogoRegistroJugadores;
import Vistas.VentanaJugadores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;
import modelo.Jugadores;

/**
 *
 * @author Brandon Rogerio Aguirre Mendoza bran1189@gmail.com
 */
public class OyenteJugadores extends WindowAdapter implements ActionListener {

    private final Jugadores jugadores;
    private final VentanaJugadores ventana;
    private final DialogoRegistroJugadores dialogoRegistroJugadores;
    private final DefaultTableModel defaultTableModel;

    public OyenteJugadores(Jugadores jugadores, VentanaJugadores ventana) {
        this.jugadores = jugadores;
        this.ventana = ventana;
        this.dialogoRegistroJugadores = ventana.getDialogo();
        this.defaultTableModel = ventana.getDatosTabla();
    }
    
    /*
    Se quedo el video en el minuto 30:15
    */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

}
