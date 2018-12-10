/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.File;
import java.net.URL;
import java.util.Date;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import logica.LogicaNegocio;
import modelo.Carrera;
import org.netbeans.validation.api.builtin.stringvalidation.MayusculaValidator;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author Annie
 */
public class AltaCarrera extends javax.swing.JDialog {

    private LogicaNegocio logicaNegocio;
    private Carrera carreraModificar;
    private Carrera carrera;

    /**
     * Primer constructor (Para el botón "aceptar") donde no aparecece como
     * parámetros la carrera sino la LogicaNegocio.
     *
     * @param parent El padre es el dialog "opciones carrera"
     * @param modal Para dejar fija la pantalla secundaria o no
     * @param logicaNegocio clase logicaNegocio donde gestionamos todo
     */
    public AltaCarrera(java.awt.Dialog parent, boolean modal, LogicaNegocio logicaNegocio) {
        super(parent, modal);
        this.logicaNegocio = logicaNegocio;
        setTitle("Formulario");
        initComponents();
        this.setLocationRelativeTo(null);

        /*HACER LA VENTANA DE UN TAMAÑO FIJO*/
        // this.setSize(600, 600);
        this.setResizable(false);
        ponLaAyuda();

        /**
         * VALIDACIONES
         */
        jButtonAceptarCa.setEnabled(false);
        ValidationGroup group = validationPanelCarrera.getValidationGroup();
        group.add(jTextFieldNombreCa, StringValidators.REQUIRE_NON_EMPTY_STRING, new MayusculaValidator());

        validationPanelCarrera.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanelCarrera.getProblem() == null) {
                    jButtonAceptarCa.setEnabled(true);
                } else {
                    jButtonAceptarCa.setEnabled(false);
                }
            }
        });
    }

    private void ponLaAyuda() {
        try {
            // Carga el fichero de ayuda. Si tenemos la carpeta "help" en el directorio de paquetes del proyecto donde build, src, etc
            File fichero = new File("help" + File.separator + "help_set.hs");//no poner ruta absoluta
            URL hsURL = fichero.toURI().toURL();
            //Carga el ficheor de ayuda si la carpeta "help" la metemos dentro del jar.Entonces hacemos una ruta relativa al jar
            //URL ayuda=  getClass().getResource("/help/help_set.hs");//me devuelve una ayuda

            // Crea el HelpSet y el HelpBroker
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();//

            // Pone ayuda a item de menu al pulsarlo y a F1 en ventana
            // principal y secundaria.
            hb.enableHelpOnButton(jMenuItemAyuda, "altaCarrera", helpset);//Hay q pasarle un boton, nunca otra cosa. habilita la ayuda en un boton o en un elemento.
            //Cuando te hagan click en ayudamenuitem, abre ventana principal.
            hb.enableHelpKey(getRootPane(), "altaCarrera", helpset);//lo q pasa cuando hacemos "f1".getrootpane: si esta en una pantalla y hace f1, sale la pantalla. Si
            //esta el foco en jButton1 y hace "f1", salta la ayuda ahi.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Al pulsar el botón "Limpiar" en "dar de alta/modificar" carreras. Borra
     * lo que hemos escrito en los campos nombre, lugar, etc.
     */
    public void limpiar() {

        jTextFieldNombreCa.setText("");
        jSpinnerFechaCa.setName("");
        jComboBoxLugar.setName("");
        jComboBoxMaxCorredores.setName("");
    }

    /**
     * Segundo constructor(Para el botón "modificar") donde aparece como
     * parámetro la carrera que queremos modificar y en el desarrollo del
     * método, rellenamos cada campo con los datos de la carrera(nombre,fecha,
     * etc).
     *
     * @param parent El padre es el dialogo "opciones carrera"
     * @param modal Para dejar por detras la ventana secundaria o no
     * @param logicaNegocio Donde gestionamos todo
     * @param corredorSeleccionar (Carrera que vamos a modificar)
     */
    ////////////////modifico java.awt.frame por .dialog
    public AltaCarrera(java.awt.Dialog parent, boolean modal, Carrera carreraModificar) {
        super(parent, modal);
        this.logicaNegocio = logicaNegocio;
        this.carreraModificar = carreraModificar;
        initComponents();
        this.setLocationRelativeTo(null);

        jTextFieldNombreCa.setText(this.carreraModificar.getNombreCarrera());
        jSpinnerFechaCa.setValue(this.carreraModificar.getFechaCarrera());
        jComboBoxLugar.setActionCommand(this.carreraModificar.getLugar());
        jComboBoxMaxCorredores.setSelectedIndex(this.carreraModificar.getNumMaxCorredores() + 1);
        /**
         * VALIDACIONES
         */
        jButtonAceptarCa.setEnabled(false);
        ValidationGroup group = validationPanelCarrera.getValidationGroup();
        group.add(jTextFieldNombreCa, StringValidators.REQUIRE_NON_EMPTY_STRING, new MayusculaValidator());

        validationPanelCarrera.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanelCarrera.getProblem() == null) {
                    jButtonAceptarCa.setEnabled(true);
                } else {
                    jButtonAceptarCa.setEnabled(false);
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCarreras = new javax.swing.JPanel();
        jLabelNombreCa = new javax.swing.JLabel();
        jLabelFechaCa = new javax.swing.JLabel();
        jLabelLugarCa = new javax.swing.JLabel();
        jLabelMaxCa = new javax.swing.JLabel();
        jTextFieldNombreCa = new javax.swing.JTextField();
        jSpinnerFechaCa = new javax.swing.JSpinner();
        jComboBoxLugar = new javax.swing.JComboBox<>();
        jComboBoxMaxCorredores = new javax.swing.JComboBox<>();
        jButtonAceptarCa = new javax.swing.JButton();
        jButtonCancelarCa = new javax.swing.JButton();
        jLabelCarreras = new javax.swing.JLabel();
        validationPanelCarrera = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jButtonLimpiar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanelCarreras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelNombreCa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNombreCa.setText("       Nombre carrera");

        jLabelFechaCa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelFechaCa.setText("                        Fecha");

        jLabelLugarCa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLugarCa.setText("                        Lugar");

        jLabelMaxCa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelMaxCa.setText("Nº Max. Corredores");

        jTextFieldNombreCa.setName("Nombre carrera"); // NOI18N

        jSpinnerFechaCa.setModel(new javax.swing.SpinnerDateModel());

        jComboBoxLugar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oviedo", "Gijón", "Langreo", "Llanes", "Avilés" }));
        jComboBoxLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLugarActionPerformed(evt);
            }
        });

        jComboBoxMaxCorredores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        javax.swing.GroupLayout jPanelCarrerasLayout = new javax.swing.GroupLayout(jPanelCarreras);
        jPanelCarreras.setLayout(jPanelCarrerasLayout);
        jPanelCarrerasLayout.setHorizontalGroup(
            jPanelCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCarrerasLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelMaxCa)
                    .addComponent(jLabelLugarCa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombreCa)
                    .addComponent(jLabelFechaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCarrerasLayout.createSequentialGroup()
                        .addComponent(jTextFieldNombreCa)
                        .addGap(15, 15, 15))
                    .addGroup(jPanelCarrerasLayout.createSequentialGroup()
                        .addGroup(jPanelCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerFechaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBoxLugar, javax.swing.GroupLayout.Alignment.LEADING, 0, 125, Short.MAX_VALUE)
                                .addComponent(jComboBoxMaxCorredores, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(166, Short.MAX_VALUE))))
        );
        jPanelCarrerasLayout.setVerticalGroup(
            jPanelCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCarrerasLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanelCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNombreCa)
                    .addComponent(jTextFieldNombreCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerFechaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFechaCa))
                .addGap(20, 20, 20)
                .addGroup(jPanelCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLugarCa)
                    .addComponent(jComboBoxLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMaxCa)
                    .addComponent(jComboBoxMaxCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonAceptarCa.setText("ACEPTAR");
        jButtonAceptarCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarCaActionPerformed(evt);
            }
        });

        jButtonCancelarCa.setText("CANCELAR");
        jButtonCancelarCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarCaActionPerformed(evt);
            }
        });

        jLabelCarreras.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jLabelCarreras.setText("              DAR ALTA O MODIFICAR CARRERA");

        jButtonLimpiar.setText("LIMPIAR");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jMenuAyuda.setText("Ayuda");
        jMenuAyuda.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jMenuItemAyuda.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItemAyuda.setText("Ver ayuda");
        jMenuAyuda.add(jMenuItemAyuda);

        jMenuBar1.add(jMenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(validationPanelCarrera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabelCarreras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButtonAceptarCa, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelarCa, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCarreras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validationPanelCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptarCa)
                    .addComponent(jButtonCancelarCa)
                    .addComponent(jButtonLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Al pulsar el botón "Aceptar" en "dar de alta/modificar" carreras. El
     * nummaxCorredores lo parseamos de Int a String. La fecha la casteamos (no
     * hace falta usar el "sdf").
     *
     * @param evt Evento Aceptar
     *
     */
    private void jButtonAceptarCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarCaActionPerformed

        String nombreCarrera = jTextFieldNombreCa.getText();
        Date fechaCarrera = (Date) jSpinnerFechaCa.getValue();
        String lugar = (String) jComboBoxLugar.getSelectedItem();
        String comboNumMax = "";
        comboNumMax = jComboBoxMaxCorredores.getSelectedItem().toString();
        int numMaxCorredores = Integer.parseInt(comboNumMax);

        if (carreraModificar == null) {
            Carrera ca = new Carrera(nombreCarrera, fechaCarrera, lugar, numMaxCorredores);
            logicaNegocio.anhadirCarrera(ca);
            JOptionPane.showMessageDialog(this, "Carrera dada de alta");
        } else {
            carreraModificar.setNombreCarrera(nombreCarrera);
            carreraModificar.setFechaCarrera(fechaCarrera);
            carreraModificar.setLugar(lugar);
            carreraModificar.setNumMaxCorredores(numMaxCorredores);

            JOptionPane.showMessageDialog(this, "Carrera modificada");

        }
        dispose();

    }//GEN-LAST:event_jButtonAceptarCaActionPerformed

    /**
     * Al pulsar el botón "cancelar" en "dar de alta/modificar" carreras.
     * Cancela lo que estamos haciendo y regresa a la pantalla principal
     *
     * @param evt Evento Cancelar
     */
    private void jButtonCancelarCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCaActionPerformed
        JOptionPane.showMessageDialog(this, "No se ha dado de alta ninguna carrera", "Resultado: ", JOptionPane.ERROR_MESSAGE);
        dispose();
    }//GEN-LAST:event_jButtonCancelarCaActionPerformed

    private void jComboBoxLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLugarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiar();
        JOptionPane.showMessageDialog(this, "Se han borrado todos los campos. Introduzca de nuevo", "Resultado: ", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButtonLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptarCa;
    private javax.swing.JButton jButtonCancelarCa;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JComboBox<String> jComboBoxLugar;
    private javax.swing.JComboBox<String> jComboBoxMaxCorredores;
    private javax.swing.JLabel jLabelCarreras;
    private javax.swing.JLabel jLabelFechaCa;
    private javax.swing.JLabel jLabelLugarCa;
    private javax.swing.JLabel jLabelMaxCa;
    private javax.swing.JLabel jLabelNombreCa;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAyuda;
    private javax.swing.JPanel jPanelCarreras;
    private javax.swing.JSpinner jSpinnerFechaCa;
    private javax.swing.JTextField jTextFieldNombreCa;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelCarrera;
    // End of variables declaration//GEN-END:variables
}
