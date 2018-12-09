/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Annie
 */
public class ImagenFondoPanel extends javax.swing.JPanel {

    /**
     * Creates new form ImagenFondoPanel
     */
    public ImagenFondoPanel() {
        initComponents();
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
        jTextFieldRuta = new javax.swing.JTextField();
        jButtonAbirRuta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSliderOpacidad = new javax.swing.JSlider();

        jLabel1.setText("Imagen:");

        jTextFieldRuta.setEditable(false);

        jButtonAbirRuta.setText("...");
        jButtonAbirRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbirRutaActionPerformed(evt);
            }
        });

        jLabel2.setText("Opacidad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAbirRuta))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSliderOpacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAbirRuta))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jSliderOpacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(195, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAbirRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbirRutaActionPerformed
        JFileChooser chooser=new JFileChooser();
        int resultado=chooser.showOpenDialog(this);//se abre un dialogo de selecionar un archivo
        
        if(resultado==JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            jTextFieldRuta.setText(file.getAbsolutePath());
        }
        
    }//GEN-LAST:event_jButtonAbirRutaActionPerformed
//metodo que devuelve lo que el usuario ha seleccionado (la imagen y la opacidad)
    public ImagenFondo getSelectedValue(){
        File f = new File(jTextFieldRuta.getText());
        Float opacidad=jSliderOpacidad.getValue()/100f;//f para convertirlo a decimal-->float
        return new ImagenFondo(f,opacidad);
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbirRuta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSlider jSliderOpacidad;
    private javax.swing.JTextField jTextFieldRuta;
    // End of variables declaration//GEN-END:variables
}
