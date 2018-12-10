/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometroana;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Annie
 */
public class CronometroAna extends JButton implements ActionListener, Serializable  {
   

    private Timer timer;
    private int segundos = 0;
    private int minutos = 0;
    private int horas=0;
    private boolean parado = false;
  
    private Meta meta;

    public CronometroAna() {
        super();
        timer = new Timer(1000, this);
        this.setText("0" + ":" + "0" + ":" + "0");
        this.setEnabled(true);
        this.setForeground(Color.BLACK);
        this.setBackground(Color.WHITE);
        Font fuente = new Font("Agency FB", Font.BOLD, 30);
        this.setFont(fuente);
        this.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

               String pregunta = JOptionPane.showInputDialog("¿Qué participante ha llegado "
                        + "con ese tiempo a la meta? Introduzca su dorsal, por favor");
                int dorsalParticipante = Integer.parseInt(pregunta);
            
                int tiempo = horas*3600+minutos*60+segundos;
                
                meta.ejecutar(dorsalParticipante, tiempo);
                
              
            }
        });
    }
    
    public void addMetaListener(Meta meta)
    {//en el swing, tenemos que poner este listener y añadir el meta.ejecutar. esto seria que al pulsar,
        //se detecta y nos pide el dorsal y el tiempo, osea, al pulsar, se registra la llegada
        this.meta= meta;
    }

    public void setMinuto(int min) {
        this.minutos = min;
    }

    public void setSegundo(int seg) {
        this.segundos = seg;
    }
public void setHoras(int horas) {
        this.horas = horas;
    }

    public void iniciar() {
        if (parado) {

        } else {

            timer.start();
        }
    }

    public boolean estaCorriendo() {
        return timer.isRunning();
    }

    public void detenerse() {

        timer.stop();
    }

    public void reiniciar() {
        timer.stop();
        segundos = 0;
        minutos = 0;
        horas=0;
        this.setText("0" + ":" + "0" + ":" + "0");

    }

    public int obtenerMinuto() {
        return this.minutos;

    }

    public int obtenerSegundo() {
        return this.segundos;
    }
    public int obtenerHora(){
        return this.horas;
    }

    public void actionPerformed(ActionEvent e) {
        segundos++;

        if (segundos <= 60) {
            this.setText(horas + ":" + minutos + ":" + segundos);
        } else {
            minutos++;
            segundos = 0;

        }
    }
}
