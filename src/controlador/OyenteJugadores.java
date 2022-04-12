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

    public static final boolean NOMBRE_ON = true;
    public static final boolean NOMBRE_OFF = false;
    public static final boolean COMBOS_ON = true;
    public static final boolean COMBOS_OFF = false;

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
            case "registrar":
                registrarJugador();
                break;
            case "editar":
                editarJugar();
                break;
            case "eliminar":
                eliminarJugador();
                break;
            case "inicializar":
                inicializarJugadores();
                break;
            case "actualizar":
                actualizarJugador();
                break;
            case "cancelar":
                dialogoRegistroJugadores.setVisible(false);
                break;
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

    public void registrarJugador() {
        String[] valores = {"", "Soleado", "Caluroso", "Alta", "Sí", "Sí"};
        dialogoRegistroJugadores.setComponentes(valores);
        dialogoRegistroJugadores.show("Registrar jugador", "Adicionar", NOMBRE_ON, COMBOS_ON);
    }

    public void editarJugar() {
        if (validarJugador()) {
            dialogoRegistroJugadores.show("Modificar jugador", "Modificar", NOMBRE_OFF, COMBOS_ON);
        }
    }

    public void eliminarJugador() {
        if (validarJugador()) {
            dialogoRegistroJugadores.show("Eliminar jugador", "Eliminar", NOMBRE_OFF, COMBOS_OFF);
        }
    }

    public void inicializarJugadores() {
        int seleccion = mostrarMensajeSeleccion("Inicializar jugadores",
                "¿Desea eliminar todos los jugadores?");
        if (seleccion == JOptionPane.YES_OPTION) {
            jugadores.inicializarJugadores();
            defaultTableModel.setRowCount(0);
            ventana.actualizarEtiquetas();
        }
    }

    public boolean validarJugador() {
        int renglon = ventana.getTablaJugadores().getSelectedRow();
        if (renglon != -1) {
            String[] valores = {
                (String) defaultTableModel.getValueAt(renglon, 0),
                (String) defaultTableModel.getValueAt(renglon, 1),
                (String) defaultTableModel.getValueAt(renglon, 2),
                (String) defaultTableModel.getValueAt(renglon, 3),
                (String) defaultTableModel.getValueAt(renglon, 4),
                (String) defaultTableModel.getValueAt(renglon, 5)
            };
            dialogoRegistroJugadores.setComponentes(valores);
        } else {
            this.mostrarMensajeError("Error al registrar", "Debes seleccionar un registro de la tabla");
            return false;
        }
        return true;
    }

    private void actualizarJugador() {
        Jugador jugador = new Jugador(dialogoRegistroJugadores.getComponentes());
        String nombre = jugador.getNombre();
        String accion = dialogoRegistroJugadores.getBotonAceptar().getText();
        switch (accion) {
            case "Adicionar":
                System.out.println("Se agrego un registro");
                adicionar(nombre, jugador);
                break;
            case "Modificar":
                modificar(nombre, jugador);
                break;
            case "Eliminar":
                break;
        }
    }

    private void adicionar(String nombre, Jugador jugador/*, String accion*/) {
        if (!jugadores.containsKey(nombre)) {
            jugadores.adicionarJugador(jugador);
            defaultTableModel.addRow(jugador.getJugador());
            ventana.actualizarEtiquetas();
            dialogoRegistroJugadores.setVisible(false);
        } else {
            mostrarMensajeError("Error de registro", "El jugador ya esta registrado");
        }
    }

    private void modificar(String nombre, Jugador jugador/*, String accion*/) {
        if (jugadores.containsKey(nombre)) {
            jugadores.modificarJugador(jugador);
            ventana.actualizarEtiquetas();
            dialogoRegistroJugadores.setVisible(false);
        } else {
            mostrarMensajeError("Error de registro", "El jugador no esta registrado");
        }
    }
}
