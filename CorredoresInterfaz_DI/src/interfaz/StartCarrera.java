/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import cronometroana.Meta;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;
import logica.LogicaNegocio;
import modelo.Carrera;
import modelo.Participante;
import modelo.TableModelParticipantes;

/**
 *
 * @author Annie
 */
public class StartCarrera extends javax.swing.JDialog {

    private LogicaNegocio logicaNegocio;
    private Carrera carrera;
    private List<Carrera> resultadosCarrera = new ArrayList<>();
    private List<Integer> dorsales = new ArrayList<>();
    private int tiempoLlegadaPorPersona;
    private int tiempoTotalCarrera;
    private int contadorParticipantes = 0;

    public StartCarrera(java.awt.Dialog parent, boolean modal, Carrera carrera, LogicaNegocio logicaNegocio) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.carrera = carrera;
        this.setLocationRelativeTo(null);
        ponLaAyuda();

        cronometroAna.iniciar();

        cronometroAna.addMetaListener(new Meta() {
            @Override
            public void ejecutar(int dorsal, int tiempoLlegadaPorPersona) {
              
                String pregunta = JOptionPane.showInputDialog("¿Qué participante ha llegado "
                        + "con ese tiempo a la meta? Introduzca su dorsal, por favor");
                int dorsalParticipante = Integer.parseInt(pregunta);

                for (int i = 0; i < carrera.getListaParticipantes().size(); i++) {
                   Participante participante= carrera.getListaParticipantes().get(i);

                    if (participante.getDorsal() == dorsalParticipante) {

                        if (participante.getTiempoLlegada() == 0.0) {
                           participante.setTiempoLlegada(tiempoLlegadaPorPersona);

                            jTableMeta.setModel(new TableModelParticipantes(
                                    carrera.getListaParticipantes()));

                            JOptionPane.showMessageDialog(null, "El participante con dorsal: "
                                    + dorsal + ", ha llegado a la meta con un tiempo de : " + tiempoLlegadaPorPersona);

                            contadorParticipantes++;
                            if (contadorParticipantes == carrera.getListaParticipantes().size()) {
                                JOptionPane.showMessageDialog(null, "Ya han llegado "
                                        + "todos los participantes.");
                                tiempoTotalCarrera = tiempoLlegadaPorPersona;
                                cronometroAna.detenerse();

                                jTableMeta.setModel(new TableModelParticipantes(
                                        carrera.getListaParticipantes()));

                                JOptionPane.showMessageDialog(null, "FIN DE LA CARRERA!! Tiempo total: "
                                        + tiempoTotalCarrera);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR. Este participante ya ha llegado a la meta.");

                        }
                    }

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
            hb.enableHelpOnButton(jMenuItemAyuda, "startCarrera", helpset);//Hay q pasarle un boton, nunca otra cosa. habilita la ayuda en un boton o en un elemento.
            //Cuando te hagan click en ayudamenuitem, abre ventana principal.
            hb.enableHelpKey(getRootPane(), "startCarrera", helpset);//lo q pasa cuando hacemos "f1".getrootpane: si esta en una pantalla y hace f1, sale la pantalla. Si
            //esta el foco en jButton1 y hace "f1", salta la ayuda ahi.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonFinCarrera = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMeta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cronometroAna = new cronometroana.CronometroAna();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText(org.openide.util.NbBundle.getMessage(StartCarrera.class, "StartCarrera.jLabel1.text")); // NOI18N

        jButtonFinCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imgs/bandera.png"))); // NOI18N
        jButtonFinCarrera.setText(org.openide.util.NbBundle.getMessage(StartCarrera.class, "StartCarrera.jButtonFinCarrera.text")); // NOI18N
        jButtonFinCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinCarreraActionPerformed(evt);
            }
        });

        jTableMeta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableMeta);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText(org.openide.util.NbBundle.getMessage(StartCarrera.class, "StartCarrera.jLabel2.text")); // NOI18N

        jMenuAyuda.setText(org.openide.util.NbBundle.getMessage(StartCarrera.class, "StartCarrera.jMenuAyuda.text")); // NOI18N
        jMenuAyuda.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jMenuItemAyuda.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItemAyuda.setText(org.openide.util.NbBundle.getMessage(StartCarrera.class, "StartCarrera.jMenuItemAyuda.text")); // NOI18N
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
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButtonFinCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(cronometroAna, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cronometroAna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFinCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFinCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinCarreraActionPerformed
        cronometroAna.detenerse();
        JOptionPane.showMessageDialog(this, "FIN DE LA CARRERA");


    }//GEN-LAST:event_jButtonFinCarreraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cronometroana.CronometroAna cronometroAna;
    private javax.swing.JButton jButtonFinCarrera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAyuda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMeta;
    // End of variables declaration//GEN-END:variables
}
