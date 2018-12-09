/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Annie
 */
public class Temporizador extends JLabel implements Serializable {

    private  double segundos;
    private  double contador;
    private String textoFin = "B O O O O M ! ! !";
    private Color colorFin;
    private boolean decimales;
    private File imagenFin;//es una ruta tipo file

    private List<CuentaAtrasFinalizada> listeners = new ArrayList<>();//para tener varios listeners

    public Temporizador() {
    }

    /**
     * metodo para si quiere, que haga lo q kiera
     *
     * @param listener
     */
    public void addCuentaAtrasFinalizadaListener(CuentaAtrasFinalizada listener) {
        this.listeners.add(listener);
    }

    public double getSegundos() {
        return segundos;
    }

    public void setSegundos(double segundos) {
        this.segundos = segundos;
    }

  

    public String getTextoFin() {
        return textoFin;
    }

    public void setTextoFin(String textoFin) {
        this.textoFin = textoFin;
    }

    public Color getColorFin() {
        return colorFin;
    }

    public void setColorFin(Color colorFin) {
        this.colorFin = colorFin;
    }

    public boolean isDecimales() {
        return decimales;
    }

    public void setDecimales(boolean decimales) {
        this.decimales = decimales;
    }

    public File getImagenFin() {
        return imagenFin;
    }

    public void setImagenFin(File imagenFin) {
        this.imagenFin = imagenFin;
    }

    public void start() {

        contador = segundos;
        setText(Double.toString(segundos));

        Timer timer = new Timer();//para hacer que algo se ejecute cada cierto tiempo. Usar el java.util.Timer en el import
        timer.schedule(new TimerTask() {//schedule: planificar. task: que tarea vamos a ejecutar. time: cuando
            @Override
            public void run() {

                if (segundos >= 0) {

                    /* propiedad "poner o no decimales" */
                    if (decimales == true) {
                        setText(String.format("%.1f", segundos-=0.1));
                    } else {
                        setText(Integer.toString((int)segundos--)); //restar de 1 en 1
                    }
                } else {

                    setText(textoFin);//propiedad "añadir un texto"

                    setForeground(colorFin);//propiedad "añadir color"

                    ImageIcon imageIcon = new ImageIcon(imagenFin.getAbsolutePath());//ruta de la imagen
                    setIcon(imageIcon);//añadir imagen
                    cancel();

                    if (listeners != null) {
                        for (CuentaAtrasFinalizada l : listeners) {
                            l.ejecutar();
                        }
                    }
                }
            }
        }, 0, 800);//velocidad a la que descuenta los segundos

    }
}
