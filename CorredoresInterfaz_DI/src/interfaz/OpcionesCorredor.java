/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Component;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;
import logica.LogicaNegocio;
import modelo.Carrera;
import modelo.Corredor;
import modelo.Participante;
import modelo.TableModelCorredores;

/**
 *
 * @author Annie
 */
public class OpcionesCorredor extends javax.swing.JDialog {

    private LogicaNegocio logicaNegocio;
    private Carrera carrera;
    Participante participante;
    List<Corredor> corredoresCarrera;

    public OpcionesCorredor(java.awt.Frame parent, boolean modal, LogicaNegocio logicaNegocio, Carrera carrera) {
        super(parent, modal);
        this.logicaNegocio = logicaNegocio;
        this.carrera = carrera;
        this.participante = participante;
        this.corredoresCarrera = logicaNegocio.getListaCorredores();
        initComponents();
        setTitle("Opciones");
        this.setLocationRelativeTo(null);
        rellenarTablaCorredores();
        this.setResizable(false);
        ponLaAyuda();
    }

    /**
     * Constructor
     *
     * @param parent Padre
     * @param modal modal
     * @param logicaNegocio logicaNegocio
     */
    public OpcionesCorredor(java.awt.Frame parent, boolean modal, LogicaNegocio logicaNegocio) {
        super(parent, modal);
        this.logicaNegocio = logicaNegocio;

        initComponents();
        setTitle("Opciones");
        this.setLocationRelativeTo(null);
        rellenarTablaCorredores();

        /*HACER LA VENTANA DE UN TAMAÑO FIJO*/
        //this.setSize(600, 600);
        this.setResizable(false);
        ponLaAyuda();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBotones = new javax.swing.JPanel();
        jButtonDarAlta = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jScrollPaneTablaCorredores = new javax.swing.JScrollPane();
        jTableCorredores = new javax.swing.JTable();
        jLabelListaCorredores = new javax.swing.JLabel();
        jButtonAnhadirAcarrera = new javax.swing.JButton();
        jButtonAbrirCsv = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelBotones.setBorder(javax.swing.BorderFactory.createTitledBorder("Elige una opción"));

        jButtonDarAlta.setText("DAR ALTA ");
        jButtonDarAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDarAltaActionPerformed(evt);
            }
        });

        jButtonModificar.setText("MODIFICAR");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonGuardar.setText("GUARDAR");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonBorrar.setText("BORRAR");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jButtonDarAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(jButtonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(jButtonBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(jButtonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDarAlta)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonBorrar)
                    .addComponent(jButtonGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPaneTablaCorredores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableCorredores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneTablaCorredores.setViewportView(jTableCorredores);

        jLabelListaCorredores.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jLabelListaCorredores.setText("LISTA DE CORREDORES");

        jButtonAnhadirAcarrera.setText("AÑADIR CORREDOR A LA CARRERA");
        jButtonAnhadirAcarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnhadirAcarreraActionPerformed(evt);
            }
        });

        jButtonAbrirCsv.setText("ABRIR LISTADO DE CORREDORES");
        jButtonAbrirCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirCsvActionPerformed(evt);
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
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAbrirCsv, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAnhadirAcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPaneTablaCorredores)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabelListaCorredores)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelListaCorredores)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneTablaCorredores, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnhadirAcarrera)
                    .addComponent(jButtonAbrirCsv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Lee el csv guardado previamente
     *
     * @param evt Evento AbrirCsv
     */
    private void jButtonAbrirCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirCsvActionPerformed

        logicaNegocio.leerCsvCorredores();
        rellenarTablaCorredores();
        logicaNegocio.ordenarCorredores();

    }//GEN-LAST:event_jButtonAbrirCsvActionPerformed
//GEN-FIRST:event_jButtonBorrarActionPerformed

//GEN-LAST:event_jButtonBorrarActionPerformed
    /**
     * Al pulsar el botón "guardar". Se graban los corredores en un csv
     *
     * @param evt Evento guardar
     */
    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed

        logicaNegocio.grabarCsvCorredores();
        JOptionPane.showMessageDialog(this, "Corredor guardado con éxito", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    /**
     * Al pulsar el botón "modificar". Seleccionamos un corredor de los que ya
     * están en la lista y lo modificamos. Si no seleccionamos nada, sale una
     * ventana advirtiéndonos
     *
     * @param evt Evento Modificar
     */
    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

        int elegido = jTableCorredores.getSelectedRow();
        if (elegido == -1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un corredor", "Information", JOptionPane.INFORMATION_MESSAGE);

        } else {

            Corredor corredorElegido = logicaNegocio.getListaCorredores().get(elegido); //Selecciona la posicion del corredor en la lista de corredores

            AltaCorredor modificarDialog = new AltaCorredor(this, true, corredorElegido);
            modificarDialog.setLocationRelativeTo(null);
            modificarDialog.setVisible(true);
            rellenarTablaCorredores();
            logicaNegocio.ordenarCorredores();
        }
        dispose();
    }//GEN-LAST:event_jButtonModificarActionPerformed

    /**
     * Al pulsar el botón "dar Alta". Añadimos un nuevo corredor
     *
     * @param evt Evento Dar Alta
     */
    private void jButtonDarAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDarAltaActionPerformed

        AltaCorredor altaCorredor = new AltaCorredor(this, true, logicaNegocio);
        altaCorredor.setVisible(true);
        rellenarTablaCorredores();
        logicaNegocio.ordenarCorredores();
    }//GEN-LAST:event_jButtonDarAltaActionPerformed
/**
 * Añadimos corredores a la carrera. Se rellenará la tabla de participantes. Si ya hay un 
 * corredor inscrito, no nos dejará añadirlo (se diferencian por el dni) y si el número
 * de participantes que queremos inscribir excede el num max permitido de la carrera, nos
 * saltará otro error, no dejándonos añadir mas corredores
 * @param evt 
 */
    private void jButtonAnhadirAcarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnhadirAcarreraActionPerformed
        if (jTableCorredores.getSelectedRowCount() > 0) {

            Corredor corredor = corredoresCarrera.get(jTableCorredores.getSelectedRow());
            boolean correcto = true;
            if (carrera.getNumMaxCorredores() == carrera.getListaParticipantes().size()) {
                correcto = false;
                JOptionPane.showMessageDialog(this, "No se admiten más participantes en la carrera");

            }
            if (correcto) {
                for (Participante participante : carrera.getListaParticipantes()) {
                    if (corredor.getDni().equals(participante.getCorredor().getDni())) {
                       JOptionPane.showMessageDialog(this, "El participante ya está inscrito");
                        correcto = false;
                        break; //le ordena que ya no siga recorriendo el for
                    }

                }
                if (correcto) { //sólo si hasta aquí nada ha cambiado la variable correcto
            //el dorsal y el tiempo va gestionado en logicaNegocio en este metodo "anhadirCorredorAcarrera
                    logicaNegocio.anhadirCorredorAcarrera(corredor, carrera);
                }
            }
            // Refresca tabla participantes
            jTableCorredores.setModel(new TableModelCorredores(corredoresCarrera));
            // }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un corredor");
        }
        dispose();

    }//GEN-LAST:event_jButtonAnhadirAcarreraActionPerformed

    /**
     * Al pulsar el boton "eliminar", borramos el corredor que hemos
     * seleccionado. Si no seleccionamos ninguno y damos al boton eliminar, nos
     * saldra un mensaje de error
     *
     * @param evt
     */
    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {
        int seleccionado = jTableCorredores.getSelectedRow();

        if (seleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un corredor", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Corredor corredorSeleccionado = logicaNegocio.getListaCorredores().get(seleccionado); //Seleccion la posicion del corredor en la lista de corredores
            logicaNegocio.borrarCorredor(corredorSeleccionado);

            JOptionPane.showMessageDialog(this, "Corredor borrado", "Information", JOptionPane.INFORMATION_MESSAGE);
            rellenarTablaCorredores();
            logicaNegocio.ordenarCorredores();
        }
        dispose();
    }

    /**
     * Método que nos muestra todos los corredores añadidos
     */
    private void rellenarTablaCorredores() {
        jTableCorredores.setModel(new TableModelCorredores(logicaNegocio.getListaCorredores()));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrirCsv;
    private javax.swing.JButton jButtonAnhadirAcarrera;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonDarAlta;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabelListaCorredores;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAyuda;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JScrollPane jScrollPaneTablaCorredores;
    private javax.swing.JTable jTableCorredores;
    // End of variables declaration//GEN-END:variables
}
