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
import modelo.Corredor;
import org.netbeans.validation.api.builtin.stringvalidation.MayusculaValidator;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author Annie
 */
public class AltaCorredor extends javax.swing.JDialog {

    private OpcionesCorredor opcionesCorredor;
    private LogicaNegocio logicaNegocio;
    private Corredor corredorModificar;

    /**
     * Primer constructor (Para el botón "aceptar") donde no aparecece como
     * parámetros el corredor sino la LogicaNegocio.
     *
     * @param parent El padre es el dialog "opciones corredor"
     * @param modal Para dejar fija la pantalla secundaria o no
     * @param logicaNegocio clase logicaNegocio donde gestionamos todo
     */
    public AltaCorredor(java.awt.Dialog parent, boolean modal, LogicaNegocio logicaNegocio) {
        super(parent, modal);
        this.logicaNegocio = logicaNegocio;
        setTitle("Formulario");
        initComponents();
        this.setLocationRelativeTo(null);
        ponLaAyuda();

        /*HACER LA VENTANA DE UN TAMAÑO FIJO*/
        // this.setSize(600, 600);
        this.setResizable(false);
        /**
         * VALIDACIONES
         */

        jButtonAceptar.setEnabled(false);
        ValidationGroup group = validationPanel.getValidationGroup();
        group.add(jTextFieldNombre, StringValidators.REQUIRE_NON_EMPTY_STRING, new MayusculaValidator());
        group.add(jTextFieldDni, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.NO_WHITESPACE);
        group.add(jTextFieldDireccion, StringValidators.REQUIRE_NON_EMPTY_STRING, new MayusculaValidator());
        group.add(jTextFieldTlfno, StringValidators.REQUIRE_VALID_NUMBER);

        validationPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanel.getProblem() == null) {
                    jButtonAceptar.setEnabled(true);
                } else {
                    jButtonAceptar.setEnabled(false);
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
            hb.enableHelpOnButton(jMenuItemAyuda, "altaCorredor", helpset);//Hay q pasarle un boton, nunca otra cosa. habilita la ayuda en un boton o en un elemento.
            //Cuando te hagan click en ayudamenuitem, abre ventana principal.
            hb.enableHelpKey(getRootPane(), "altaCorredor", helpset);//lo q pasa cuando hacemos "f1".getrootpane: si esta en una pantalla y hace f1, sale la pantalla. Si
            //esta el foco en jButton1 y hace "f1", salta la ayuda ahi.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Segundo constructor(Para el botón "modificar") donde aparece como
     * parámetro el corredor que queremos modificar y en el desarrollo del
     * método, rellenamos cada campo con los datos del corredor(nombre, tlfno,
     * etc).
     *
     * @param parent El padre es el dialogo "opciones corredor"
     * @param modal Para dejar por detras la ventana secundaria o no
     * @param logicaNegocio Donde gestinamos todo
     * @param corredorSeleccionar (Corredor que vamos a modificar)
     */
    ////////////////modifico java.awt.frame por .dialog
    public AltaCorredor(java.awt.Dialog parent, boolean modal, Corredor corredorModificar) {
        super(parent, modal);
        this.logicaNegocio = logicaNegocio;
        this.corredorModificar = corredorModificar;
        initComponents();

        jTextFieldNombre.setText(this.corredorModificar.getNombre());
        jTextFieldDni.setText(this.corredorModificar.getDni());
        jTextFieldDireccion.setText(this.corredorModificar.getDireccion());
        jTextFieldTlfno.setText(Integer.toString(this.corredorModificar.getTlfno()));
        jSpinnerFechaNacimiento.setValue(this.corredorModificar.getFechaNacimiento());

         /**
         * VALIDACIONES
         */

        jButtonAceptar.setEnabled(false);
        ValidationGroup group = validationPanel.getValidationGroup();
        group.add(jTextFieldNombre, StringValidators.REQUIRE_NON_EMPTY_STRING, new MayusculaValidator());
        group.add(jTextFieldDni, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.NO_WHITESPACE);
        group.add(jTextFieldDireccion, StringValidators.REQUIRE_NON_EMPTY_STRING, new MayusculaValidator());
        group.add(jTextFieldTlfno, StringValidators.REQUIRE_VALID_NUMBER);

        validationPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanel.getProblem() == null) {
                    jButtonAceptar.setEnabled(true);
                } else {
                    jButtonAceptar.setEnabled(false);
                }
            }
        });
    }

    /**
     * Al pulsar el botón "Limpiar" en "dar de alta/modificar" corredores. Borra
     * lo que hemos escrito en los campos nombre, direccion, etc.
     */
    public void limpiar() {

        jTextFieldNombre.setText("");
        jTextFieldDni.setText("");
        jTextFieldDireccion.setText("");
        jTextFieldTlfno.setText("");
        jSpinnerFechaNacimiento.setName("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelDni = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelTlfno = new javax.swing.JLabel();
        jLabelFechaNacimiento = new javax.swing.JLabel();
        jTextFieldTlfno = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldDni = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jSpinnerFechaNacimiento = new javax.swing.JSpinner();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonLimpiar = new javax.swing.JButton();
        validationPanel = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNombre.setText("                Nombre");

        jLabelDni.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDni.setText("                Dni");

        jLabelDireccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDireccion.setText("               Dirección");

        jLabelTlfno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTlfno.setText("Teléfono");

        jLabelFechaNacimiento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelFechaNacimiento.setText("Fecha Nacimiento");

        jTextFieldTlfno.setName("Teléfono"); // NOI18N

        jTextFieldDireccion.setName("Dirección"); // NOI18N

        jTextFieldDni.setName("Dni"); // NOI18N

        jTextFieldNombre.setName("Nombre"); // NOI18N

        jSpinnerFechaNacimiento.setModel(new javax.swing.SpinnerDateModel());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTlfno, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDni, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSpinnerFechaNacimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jTextFieldDni, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTlfno, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDni)
                    .addComponent(jTextFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDireccion)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTlfno)
                    .addComponent(jTextFieldTlfno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaNacimiento)
                    .addComponent(jSpinnerFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButtonAceptar.setText("ACEPTAR");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("CANCELAR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jLabel1.setText("              DAR ALTA O MODIFICAR CORREDOR");

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
                    .addComponent(validationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonLimpiar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Al pulsar el botón "Aceptar" en "dar de alta/modificar" corredores. El
     * teléfono lo parseamos de Int a String La fecha de nacimiento la casteamos
     * (no hace falta usar el "sdf"). If: corredorModificar==null --> es que
     * queremos "dar de alta" en vez de "modificar". Entonces creamos un nuevo
     * corredor con el método "anhadirCorredor". Else: es que queremos
     * "modificar", entonces introducimos los datos con el ".set"
     *
     * @param evt Evento Aceptar
     *
     * El metodo limpiar()borra lo escrito de cada campo (nombre, direccion,
     * etc) El método dispose() cierra lapantalla secundaria
     */
    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed

        String nombre = jTextFieldNombre.getText();
        String dni = jTextFieldDni.getText();
        String direccion = jTextFieldDireccion.getText();
        int tlfno = Integer.parseInt(jTextFieldTlfno.getText());
        Date fechaNacimiento = (Date) jSpinnerFechaNacimiento.getValue();

        if (corredorModificar == null) {
            Corredor c = new Corredor(nombre, dni, direccion, tlfno, fechaNacimiento);
            logicaNegocio.anhadirCorredor(c);
            JOptionPane.showMessageDialog(this, "Corredor dado de alta con éxito", "Resultado:", JOptionPane.INFORMATION_MESSAGE);
        } else {
            corredorModificar.setNombre(nombre);
            corredorModificar.setDni(dni);
            corredorModificar.setDireccion(direccion);
            corredorModificar.setTlfno(tlfno);
            corredorModificar.setFechaNacimiento(fechaNacimiento);
            JOptionPane.showMessageDialog(this, "Corredor modificado", "Resultado: ", JOptionPane.INFORMATION_MESSAGE);
        }

        limpiar();
        dispose();

    }//GEN-LAST:event_jButtonAceptarActionPerformed

    /**
     * Al pulsar el botón "cancelar" en "dar de alta/modificar" corredores.
     * Cancela lo que estamos haciendo y regresa a la pantalla principal
     *
     * @param evt Evento Cancelar
     */
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        JOptionPane.showMessageDialog(this, "No se ha dado de alta ningún corredor", "Resultado: ", JOptionPane.ERROR_MESSAGE);
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /**
     * Al pulsar el botón "limpiar". Tiene el método limpiar() que borra todo lo
     * escrito en los campos
     *
     * @param evt Evento Limpiar
     */

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiar();
        JOptionPane.showMessageDialog(this, "Se han borrado todos los campos. Introduzca de nuevo", "Resultado: ", JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_jButtonLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelFechaNacimiento;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTlfno;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAyuda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinnerFechaNacimiento;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTlfno;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanel;
    // End of variables declaration//GEN-END:variables
}
