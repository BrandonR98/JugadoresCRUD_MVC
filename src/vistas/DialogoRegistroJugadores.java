/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.OyenteJugadores;
import javax.swing.JFrame;

/**
 *
 * @author Brandon Rogerio Aguirre Mendoza bran1189@gmail.com
 */
public class DialogoRegistroJugadores extends javax.swing.JDialog {

    /**
     * Creates new form DialogoRegistroJugadores
     *
     * @param parent
     * @param modal
     */
    public DialogoRegistroJugadores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(400, 300);
    }
    
    public void addEventos(OyenteJugadores oyente) {
        this.botonAceptar.addActionListener(oyente);
        this.botonCancelar.addActionListener(oyente);
        this.addWindowListener(oyente);
        
        this.botonAceptar.setName("actualizar");
        this.botonCancelar.setName("cancelar");
        this.setName("dialogo");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorte = new javax.swing.JPanel();
        etiquetaNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        panelCentro = new javax.swing.JPanel();
        etiquetaPronosticos = new javax.swing.JLabel();
        comboBoxPronostico = new javax.swing.JComboBox<>();
        etiquetaTemperatura = new javax.swing.JLabel();
        comboBoxTemperatura = new javax.swing.JComboBox<>();
        etiquetaHumedad = new javax.swing.JLabel();
        comboBoxHumedad = new javax.swing.JComboBox<>();
        etiquetaViento = new javax.swing.JLabel();
        comboBoxViento = new javax.swing.JComboBox<>();
        etiquetaJugara = new javax.swing.JLabel();
        comboBoxJugara = new javax.swing.JComboBox<>();
        panelSur = new javax.swing.JPanel();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelNorte.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del jugador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        etiquetaNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        etiquetaNombre.setText("Nombre: ");
        panelNorte.add(etiquetaNombre);

        campoNombre.setColumns(30);
        panelNorte.add(campoNombre);

        getContentPane().add(panelNorte, java.awt.BorderLayout.NORTH);

        panelCentro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Panel Centro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 14))); // NOI18N
        panelCentro.setLayout(new java.awt.GridLayout(5, 2));

        etiquetaPronosticos.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        etiquetaPronosticos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiquetaPronosticos.setText("Pronostico: ");
        panelCentro.add(etiquetaPronosticos);

        comboBoxPronostico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soleado", "Lluvioso", "Nublado" }));
        panelCentro.add(comboBoxPronostico);

        etiquetaTemperatura.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        etiquetaTemperatura.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiquetaTemperatura.setText("Temperatura: ");
        panelCentro.add(etiquetaTemperatura);

        comboBoxTemperatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Caluroso", "Templado", "Frío" }));
        panelCentro.add(comboBoxTemperatura);

        etiquetaHumedad.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        etiquetaHumedad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiquetaHumedad.setText("Humedad: ");
        panelCentro.add(etiquetaHumedad);

        comboBoxHumedad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alta", "Baja" }));
        panelCentro.add(comboBoxHumedad);

        etiquetaViento.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        etiquetaViento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiquetaViento.setText("Viento: ");
        panelCentro.add(etiquetaViento);

        comboBoxViento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        panelCentro.add(comboBoxViento);

        etiquetaJugara.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        etiquetaJugara.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiquetaJugara.setText("¿Jugará? ");
        panelCentro.add(etiquetaJugara);

        comboBoxJugara.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        panelCentro.add(comboBoxJugara);

        getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);

        botonAceptar.setText("Aceptar");
        panelSur.add(botonAceptar);

        botonCancelar.setText("Cancelar");
        panelSur.add(botonCancelar);

        getContentPane().add(panelSur, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JComboBox<String> comboBoxHumedad;
    private javax.swing.JComboBox<String> comboBoxJugara;
    private javax.swing.JComboBox<String> comboBoxPronostico;
    private javax.swing.JComboBox<String> comboBoxTemperatura;
    private javax.swing.JComboBox<String> comboBoxViento;
    private javax.swing.JLabel etiquetaHumedad;
    private javax.swing.JLabel etiquetaJugara;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaPronosticos;
    private javax.swing.JLabel etiquetaTemperatura;
    private javax.swing.JLabel etiquetaViento;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelSur;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the botonAceptar
     */
    public javax.swing.JButton getBotonAceptar() {
        return botonAceptar;
    }
    
    public void setComponentes(String[] valores) {
        this.campoNombre.setText(valores[0]);
        this.comboBoxPronostico.setSelectedItem(valores[1]);
        this.comboBoxTemperatura.setSelectedItem(valores[2]);
        this.comboBoxHumedad.setSelectedItem(valores[3]);
        this.comboBoxViento.setSelectedItem(valores[4]);
        this.comboBoxJugara.setSelectedItem(valores[5]);
    }
    
    public String[] getComponentes() {
        return new String[]{
            this.campoNombre.getText(),
            (String) this.comboBoxPronostico.getSelectedItem(),
            (String) this.comboBoxTemperatura.getSelectedItem(),
            (String) this.comboBoxHumedad.getSelectedItem(),
            (String) this.comboBoxViento.getSelectedItem(),
            (String) this.comboBoxJugara.getSelectedItem()
        };
    }
    
    public void show(String textoTitulo, String textoBoton,
            boolean estadoNombre, boolean estadoCombos) {
        
        setTitle(textoTitulo);
        botonAceptar.setText(textoBoton);
        campoNombre.setEnabled(estadoCombos);
        comboBoxPronostico.setEnabled(estadoCombos);
        comboBoxTemperatura.setEnabled(estadoCombos);
        comboBoxHumedad.setEnabled(estadoCombos);
        comboBoxViento.setEnabled(estadoCombos);
        comboBoxJugara.setEnabled(estadoCombos);
        JFrame padre = (JFrame) this.getParent();
        setLocation(100, 100);
        setVisible(true);        
    }
    
}