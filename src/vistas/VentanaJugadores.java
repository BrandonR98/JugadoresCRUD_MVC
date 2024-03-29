/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.OyenteJugadores;
import javax.swing.table.DefaultTableModel;
import modelo.Jugadores;

/**
 *
 * @author Brandon Rogerio Aguirre Mendoza bran1189@gmail.com
 */
public class VentanaJugadores extends javax.swing.JFrame {

    private final Jugadores jugadores;
    private final DialogoRegistroJugadores dialogo;

    /**
     * Creates new form VentanaJugadores
     */
    public VentanaJugadores(Jugadores jugadores) {
        this.jugadores = jugadores;
        initComponents();
        actualizarEtiquetas();
        dialogo = new DialogoRegistroJugadores(this, true);
    }

    public void addEventos(OyenteJugadores oyente) {
        this.opcionAbrir.addActionListener(oyente);
        this.opcionGuardarArchivo.addActionListener(oyente);
        this.opcionSalir.addActionListener(oyente);
        this.opcionRegistrar.addActionListener(oyente);
        this.opcionEditar.addActionListener(oyente);
        this.opcionEliminar.addActionListener(oyente);
        this.opcionInicializar.addActionListener(oyente);
        this.addWindowListener(oyente);
        this.dialogo.addEventos(oyente);

        this.opcionAbrir.setName("abrir");
        this.opcionGuardarArchivo.setName("guardar");
        this.opcionSalir.setName("salir");
        this.opcionRegistrar.setName("registrar");
        this.opcionEditar.setName("editar");
        this.opcionEliminar.setName("eliminar");
        this.opcionInicializar.setName("inicializar");
        this.setName("ventana");
    }

    public final void actualizarEtiquetas() {
        String archivo = jugadores.getNombreArchivo();
        archivo = archivo == null ? " " : archivo;

        etiquetaArchivo.setText(
                "<html><b>Archivo: </b>" + archivo + "</html>");
        etiquetaTotalJugadores.setText(
                "<html><b>Total jugadores: </b>" + jugadores.getTotalJugadores() + "</html>");
        etiquetaTotalJugando.setText(
                "<html><b>Total jugando: </b>" + jugadores.getTotalJugando() + "</html>");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaTitulo = new javax.swing.JLabel();
        panelCentro = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        etiquetaArchivo = new javax.swing.JLabel();
        etiquetaTotalJugadores = new javax.swing.JLabel();
        etiquetaTotalJugando = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        opcionAbrir = new javax.swing.JMenuItem();
        opcionGuardarArchivo = new javax.swing.JMenuItem();
        opcionSalir = new javax.swing.JMenuItem();
        menuOpciones = new javax.swing.JMenu();
        opcionRegistrar = new javax.swing.JMenuItem();
        opcionEditar = new javax.swing.JMenuItem();
        opcionEliminar = new javax.swing.JMenuItem();
        separadorOpciones = new javax.swing.JPopupMenu.Separator();
        opcionInicializar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etiquetaTitulo.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        etiquetaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTitulo.setText("Lista jugadores");
        getContentPane().add(etiquetaTitulo, java.awt.BorderLayout.NORTH);

        panelCentro.setForeground(getForeground());
        panelCentro.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelCentro.setToolTipText("");
        panelCentro.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablaJugadores.setBorder(javax.swing.BorderFactory.createLineBorder(getBackground(), 2));
        tablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Pronosticos", "Temperatura", "Humedad", "Viento", "Jugando"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panelCentro.setViewportView(tablaJugadores);

        getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(1, 3));

        etiquetaArchivo.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        etiquetaArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaArchivo.setText("Archivo: ");
        jPanel1.add(etiquetaArchivo);

        etiquetaTotalJugadores.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        etiquetaTotalJugadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTotalJugadores.setText("Jugadores:");
        jPanel1.add(etiquetaTotalJugadores);

        etiquetaTotalJugando.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        etiquetaTotalJugando.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTotalJugando.setText("Jugando:");
        jPanel1.add(etiquetaTotalJugando);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        menuArchivo.setText("Archivo");

        opcionAbrir.setText("Abrir archivo");
        menuArchivo.add(opcionAbrir);

        opcionGuardarArchivo.setText("Guardar archivo");
        menuArchivo.add(opcionGuardarArchivo);

        opcionSalir.setText("Salir del programa");
        menuArchivo.add(opcionSalir);

        barraMenu.add(menuArchivo);

        menuOpciones.setText("Edit");

        opcionRegistrar.setText("Registrar");
        menuOpciones.add(opcionRegistrar);

        opcionEditar.setText("Editar");
        menuOpciones.add(opcionEditar);

        opcionEliminar.setText("Eliminar");
        menuOpciones.add(opcionEliminar);
        menuOpciones.add(separadorOpciones);

        opcionInicializar.setText("Inicializar");
        menuOpciones.add(opcionInicializar);

        barraMenu.add(menuOpciones);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JLabel etiquetaArchivo;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JLabel etiquetaTotalJugadores;
    private javax.swing.JLabel etiquetaTotalJugando;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JMenuItem opcionAbrir;
    private javax.swing.JMenuItem opcionEditar;
    private javax.swing.JMenuItem opcionEliminar;
    private javax.swing.JMenuItem opcionGuardarArchivo;
    private javax.swing.JMenuItem opcionInicializar;
    private javax.swing.JMenuItem opcionRegistrar;
    private javax.swing.JMenuItem opcionSalir;
    private javax.swing.JScrollPane panelCentro;
    private javax.swing.JPopupMenu.Separator separadorOpciones;
    private javax.swing.JTable tablaJugadores;
    // End of variables declaration//GEN-END:variables

    public DefaultTableModel getDatosTabla() {
        return (DefaultTableModel) getTablaJugadores().getModel();
    }

    /**
     * @return the tablaJugadores
     */
    public javax.swing.JTable getTablaJugadores() {
        return tablaJugadores;
    }

    /**
     * @return the dialogo
     */
    public DialogoRegistroJugadores getDialogo() {
        return dialogo;
    }

}
