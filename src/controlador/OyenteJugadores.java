/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Component;
import vistas.DialogoRegistroJugadores;
import vistas.VentanaJugadores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Jugador;
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
        Component origen = (Component) e.getSource();
        switch (origen.getName()) {
            case "abrir":
                abrirArchivo();
                break;
            case "guardar":
                guardarArchivo();
                break;
            case "salir":
                salirPrograma();
                break;
            /*case "":
                break;
            case "":
                break;*/
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Component origen = (Component) e.getSource();
        switch (origen.getName()) {
            case "salir":
                System.out.println("Salir del programa");
                salirPrograma();
                break;
            case "dialogo":
                dialogoRegistroJugadores.setVisible(false);
                break;
        }
    }

    public void salirPrograma() {
        int seleccion = this.mostrarMensajeSeleccion("Salir del programa",
                "¿Desea salir del programa?");

        if (seleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void mostrarMensajeError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje, titulo, JOptionPane.OK_OPTION);
    }

    public int mostrarMensajeSeleccion(String titulo, String mensaje) {
        return JOptionPane.showConfirmDialog(ventana, mensaje, titulo, JOptionPane.YES_NO_OPTION);
    }

    private void abrirArchivo() {
        JFileChooser ventanaArchivo = new JFileChooser();
        int opcion = ventanaArchivo.showOpenDialog(ventana);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            jugadores.leerJugadores(ventanaArchivo.getSelectedFile());
            defaultTableModel.setRowCount(0);
            Iterator<Jugador> iterador = jugadores.values().iterator();
            while (iterador.hasNext()) {
                Jugador jugador = iterador.next();
                defaultTableModel.addRow(jugador.getJugador());

            }
            ventana.actualizarEtiquetas();
        }
    }

    private void guardarArchivo() {
        JFileChooser ventanaChooser = new JFileChooser();
        int opcion = ventanaChooser.showSaveDialog(ventana);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            jugadores.grabarJugadores(ventanaChooser.getSelectedFile());
            ventana.actualizarEtiquetas();
        }
    }

}
