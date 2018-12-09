/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componente;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Annie
 */
public class BotonHora extends JButton implements Serializable {

    private String guardarHoraCadaVezQuePulsas;

    public BotonHora() {
        super();
        setText("Dame Click y dime la hora!");
        this.guardarHoraCadaVezQuePulsas = "C:\\Users\\Annie\\Desktop\\horaCadaVezQuePulsas.txt";

       this.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    muestraHoraPulsacionEnJPane();
                    guardarHorasEnFicheroTexto();

                } catch (IOException ex) {
                    Logger.getLogger(BotonHora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public String getGuardarHoraCadaVezQuePulsas() {
        return guardarHoraCadaVezQuePulsas;
    }

    public void setGuardarHoraCadaVezQuePulsas(String guardarHoraCadaVezQuePulsas) {
        this.guardarHoraCadaVezQuePulsas = guardarHoraCadaVezQuePulsas;
    }

    public void muestraHoraPulsacionEnJPane() {
        String date = new Date().toString();

        JOptionPane.showMessageDialog(this, "Has pulsado el botón a las: " + date);

    }

    public void guardarHorasEnFicheroTexto() throws IOException {

        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            File file = new File(getGuardarHoraCadaVezQuePulsas());
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(getGuardarHoraCadaVezQuePulsas(), true);
            pw = new PrintWriter(fw);

            String dateString = new Date().toString();
            pw.write(dateString + "\r\n");

        } catch (IOException ex) {
            System.out.println("IO Error");;

        } finally {
            try {

                fw.flush();
                fw.close();
                pw.flush();
                pw.close();
            } catch (IOException ex) {
                System.out.println("IOError");
            }
        }
    }
}
