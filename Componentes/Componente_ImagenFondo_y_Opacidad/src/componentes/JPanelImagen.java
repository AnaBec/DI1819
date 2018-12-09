/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Annie
 */
public class JPanelImagen extends JPanel implements Serializable {

    private ImagenFondo imagenFondo;

    //constructor sin parametros
    public JPanelImagen() {
    }

    public ImagenFondo getImagenFondo() {
        return imagenFondo;
    }

    public void setImagenFondo(ImagenFondo imagenFondo) {
        this.imagenFondo = imagenFondo;
    }

//Metodo redefinidoo (override) que pinta una imagen. Coge la imagen, la dibuja con una 
    //opacidad que elegimos en el slider de opacidad
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imagenFondo != null) {
            if (imagenFondo.getRutaImagen() != null && imagenFondo.getRutaImagen().exists()) {

                ImageIcon imageIcon = new ImageIcon(imagenFondo.getRutaImagen().getAbsolutePath());
                Graphics2D g2d = (Graphics2D) g;   //cambiar la opacidad con la que dibujamos
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, imagenFondo.getOpacidad()));
                g.drawImage(imageIcon.getImage(), 0, 0, null);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));

            }
        }
    }
}
