/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;
import logica.LogicaNegocio;
import modelo.*;

/**
 *
 * @author Annie
 */
public class OpcionesCarrera_Participantes extends javax.swing.JDialog {

    private LogicaNegocio logicaNegocio;
    private AltaCarrera altaCarrera;
    private Carrera carrera;
    private Participante participante;

    /**
     * Constructor
     *
     * @param parent Padre
     * @param modal modal
     * @param logicaNegocio logicaNegocio
     *
     */
    public OpcionesCarrera_Participantes(java.awt.Frame parent, boolean modal, LogicaNegocio logicaNegocio) {
        super(parent, modal);
        this.logicaNegocio = logicaNegocio;
        initComponents();
        setTitle("Opciones");
        this.setLocationRelativeTo(null);
        rellenarTablaCarreras();
        ponLaAyuda();
       


        /*HACER LA VENTANA DE UN TAMAÑO FIJO*/
        // this.setSize(600, 600);
        this.setResizable(false);
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
            hb.enableHelpOnButton(jMenuItemAyuda, "opcionesCarreraParticipantes", helpset);//Hay q pasarle un boton, nunca otra cosa. habilita la ayuda en un boton o en un elemento.
            //Cuando te hagan click en ayudamenuitem, abre ventana principal.
            hb.enableHelpKey(getRootPane(), "opcionesCarreraParticipantes", helpset);//lo q pasa cuando hacemos "f1".getrootpane: si esta en una pantalla y hace f1, sale la pantalla. Si
            //esta el foco en jButton1 y hace "f1", salta la ayuda ahi.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBotonesCarreras = new javax.swing.JPanel();
        jButtonAnhadirParticip = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jButtonGuardarInscripcion = new javax.swing.JButton();
        jLabelListaCarreras = new javax.swing.JLabel();
        jScrollPaneCarrreras = new javax.swing.JScrollPane();
        jTableCarreras = new javax.swing.JTable();
        jScrollPaneParticipantes = new javax.swing.JScrollPane();
        jTableParticipantes = new javax.swing.JTable();
        jPanelOpcionesCarrera = new javax.swing.JPanel();
        jButtonCrearCarrera = new javax.swing.JButton();
        jButtonModificarCarrera = new javax.swing.JButton();
        jButtonBorrarCarrera = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonIniciarCarrera = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelBotonesCarreras.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones Participantes"));

        jButtonAnhadirParticip.setText("AÑADIR");
        jButtonAnhadirParticip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnhadirParticipActionPerformed(evt);
            }
        });

        jButtonBorrar.setText("BORRAR");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jButtonGuardarInscripcion.setText("GUARDAR INSCRIPCION");
        jButtonGuardarInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarInscripcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesCarrerasLayout = new javax.swing.GroupLayout(jPanelBotonesCarreras);
        jPanelBotonesCarreras.setLayout(jPanelBotonesCarrerasLayout);
        jPanelBotonesCarrerasLayout.setHorizontalGroup(
            jPanelBotonesCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesCarrerasLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButtonAnhadirParticip, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotonesCarrerasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonGuardarInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        jPanelBotonesCarrerasLayout.setVerticalGroup(
            jPanelBotonesCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesCarrerasLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanelBotonesCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnhadirParticip)
                    .addComponent(jButtonBorrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGuardarInscripcion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelListaCarreras.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jLabelListaCarreras.setText("LISTA DE CARRERAS");

        jTableCarreras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableCarreras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneCarrreras.setViewportView(jTableCarreras);

        jTableParticipantes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableParticipantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneParticipantes.setViewportView(jTableParticipantes);

        jPanelOpcionesCarrera.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones Carrera"));

        jButtonCrearCarrera.setText("CREAR/NUEVA");
        jButtonCrearCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearCarreraActionPerformed(evt);
            }
        });

        jButtonModificarCarrera.setText("MODIFICAR");
        jButtonModificarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarCarreraActionPerformed(evt);
            }
        });

        jButtonBorrarCarrera.setText("ELIMINAR ");
        jButtonBorrarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarCarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOpcionesCarreraLayout = new javax.swing.GroupLayout(jPanelOpcionesCarrera);
        jPanelOpcionesCarrera.setLayout(jPanelOpcionesCarreraLayout);
        jPanelOpcionesCarreraLayout.setHorizontalGroup(
            jPanelOpcionesCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesCarreraLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButtonCrearCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButtonModificarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jButtonBorrarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanelOpcionesCarreraLayout.setVerticalGroup(
            jPanelOpcionesCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesCarreraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOpcionesCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCrearCarrera)
                    .addComponent(jButtonModificarCarrera)
                    .addComponent(jButtonBorrarCarrera))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jLabel1.setText("LISTA DE PARTICIPANTES");

        jButtonIniciarCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imgs/pistola.png"))); // NOI18N
        jButtonIniciarCarrera.setText("¡ ¡ INICIAR CARRERA ! !");
        jButtonIniciarCarrera.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 255, 255), new java.awt.Color(255, 255, 0)));
        jButtonIniciarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarCarreraActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(315, 315, 315)
                                .addComponent(jLabelListaCarreras))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(281, 281, 281)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneCarrreras)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelOpcionesCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPaneParticipantes)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanelBotonesCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonIniciarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelListaCarreras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneCarrreras, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanelOpcionesCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonIniciarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addComponent(jPanelBotonesCarreras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Botón "Participantes" donde se abre el dialogo de la tabla de corredores
     * para seleccionar uno y añadirlo a la tabla de participantes
     *
     * @param evt
     */
    private void jButtonAnhadirParticipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnhadirParticipActionPerformed

        int carreraSeleccionada = jTableCarreras.getSelectedRow();
        if (carreraSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una carrera", "Information", JOptionPane.INFORMATION_MESSAGE);

        } else {
            Carrera carreraModificar = logicaNegocio.getListaCarreras().get(carreraSeleccionada);

            OpcionesCorredor opcionesCorredor = new OpcionesCorredor(new javax.swing.JFrame(), true, logicaNegocio, carreraModificar);
            opcionesCorredor.setLocationRelativeTo(null);
            opcionesCorredor.setVisible(true);

            //Refrescar tabla participantes:
            TableModelParticipantes tablaParticipantes = new TableModelParticipantes(carreraModificar.getListaParticipantes());
            jTableParticipantes.setModel(tablaParticipantes);
        }

    }//GEN-LAST:event_jButtonAnhadirParticipActionPerformed

    /**
     * Borramos una carrera al seleccionarla. Si no la seleccionamos, nos salta
     * un error
     *
     * @param evt
     */
    private void jButtonBorrarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarCarreraActionPerformed
        int seleccionada = jTableCarreras.getSelectedRow();

        if (seleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una carrera", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Carrera carreraSeleccionada = logicaNegocio.getListaCarreras().get(seleccionada); //Seleccion la posicion de la carrera en la lista de carreras
            logicaNegocio.borrarCarrera(carreraSeleccionada);
            JOptionPane.showMessageDialog(this, "Carrera borrada", "Information", JOptionPane.INFORMATION_MESSAGE);
            rellenarTablaCarreras();

        }
    }//GEN-LAST:event_jButtonBorrarCarreraActionPerformed

    /**
     * Al pulsar el botón "Iniciar Carrera".
     *
     * @param evt
     */
    private void jButtonIniciarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarCarreraActionPerformed
        int seleccionada = jTableCarreras.getSelectedRow();

        if (seleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una carrera", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Carrera carreraSeleccionada = logicaNegocio.getListaCarreras().get(seleccionada);

            StartCarrera start = new StartCarrera(this, true, carreraSeleccionada, logicaNegocio);
            start.setLocationRelativeTo(null);
            start.setVisible(true);
        }


    }//GEN-LAST:event_jButtonIniciarCarreraActionPerformed
    /**
     * Crar una nueva carrera
     *
     * @param evt
     */
    private void jButtonCrearCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearCarreraActionPerformed
        altaCarrera = new AltaCarrera(this, true, logicaNegocio);
        altaCarrera.setVisible(true);
        rellenarTablaCarreras();
    }//GEN-LAST:event_jButtonCrearCarreraActionPerformed
    /**
     * Modifica la carrera
     *
     * @param evt
     */
    private void jButtonModificarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarCarreraActionPerformed

        int elegida = jTableCarreras.getSelectedRow();
        if (elegida == -1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar una carrera", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Carrera carreraElegida = logicaNegocio.getListaCarreras().get(elegida);

            AltaCarrera modificarCarrera = new AltaCarrera(this, true, carreraElegida);
            modificarCarrera.setLocationRelativeTo(null);
            modificarCarrera.setVisible(true);
            rellenarTablaCarreras();

        }


    }//GEN-LAST:event_jButtonModificarCarreraActionPerformed
    /**
     * Borrar Participante de la carrera
     *
     * @param evt
     */
    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed

        int seleccionado = jTableParticipantes.getSelectedRow();
        for (Carrera estaCarrera : logicaNegocio.getListaCarreras()) {

            if (seleccionado == -1) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un participante", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {

                Participante participanteSeleccionado = estaCarrera.getListaParticipantes().get(seleccionado); //Seleccion la posicion del participante en la lista de corredores

                estaCarrera.getListaParticipantes().remove(participanteSeleccionado);

                JOptionPane.showMessageDialog(this, "Participante borrado", "Information", JOptionPane.INFORMATION_MESSAGE);

                TableModelParticipantes tablaParticipantes = new TableModelParticipantes(estaCarrera.getListaParticipantes());
                jTableParticipantes.setModel(tablaParticipantes);
            }
        }

    }//GEN-LAST:event_jButtonBorrarActionPerformed
    /**
     * Graba csv de carreras con sus participantes (solo la inscripcion, no el
     * resultado)
     *
     * @param evt
     */
    private void jButtonGuardarInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarInscripcionActionPerformed
        logicaNegocio.grabarCsvCarrerasIncripcionSolo();
    }//GEN-LAST:event_jButtonGuardarInscripcionActionPerformed

    /**
     * Al pulsar botón "Modificar". Modificamos la carrera que seleccionamos
     *
     * @param evt
     *//**/
    /**
     * Método que nos muestra todas las carreras añadidas
     */
    private void rellenarTablaCarreras() {
        jTableCarreras.setModel(new TableModelCarreras(logicaNegocio.getListaCarreras()));

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnhadirParticip;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonBorrarCarrera;
    private javax.swing.JButton jButtonCrearCarrera;
    private javax.swing.JButton jButtonGuardarInscripcion;
    private javax.swing.JButton jButtonIniciarCarrera;
    private javax.swing.JButton jButtonModificarCarrera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelListaCarreras;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAyuda;
    private javax.swing.JPanel jPanelBotonesCarreras;
    private javax.swing.JPanel jPanelOpcionesCarrera;
    private javax.swing.JScrollPane jScrollPaneCarrreras;
    private javax.swing.JScrollPane jScrollPaneParticipantes;
    private javax.swing.JTable jTableCarreras;
    private javax.swing.JTable jTableParticipantes;
    // End of variables declaration//GEN-END:variables
}
