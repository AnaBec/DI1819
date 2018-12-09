/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfieldespia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Annie
 */
public class Espia extends JTextField implements Serializable {

    private List<EspiaInterface> listenersEspia;
    private List<String> palabrasEspiadas;
    private String ficheroLog;
    private File fileLog;

    public Espia() {
        palabrasEspiadas = new ArrayList<>();
        listenersEspia = new ArrayList<>();
        this.ficheroLog = "C:\\Users\\Annie\\Desktop\\PalabraEspiada.txt";

        //Listener
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                validarPalabra();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                validarPalabra();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                validarPalabra();
            }
        });
    }

    /**
     * Comprobamos que la palabra introducida es igual a la palabra que queremos
     * espiar, recorriendo la lista de palabras que queremos espiar
     * (palabrasEspiadas=lista de palabras)
     *
     */
    public void validarPalabra() {

        for (String palabraEspiada : palabrasEspiadas) {
            if (getText().contains(palabraEspiada)) {
                try {
                    guardaPalabrasEspiadas(palabraEspiada);
                } catch (IOException ex) {
                    Logger.getLogger(Espia.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (EspiaInterface espiaInterface : listenersEspia) {
                    espiaInterface.espiar();

                }

            }

        }
    }

    /**
     * Guarda la palabra espiada que introducimos y se encuentra en la lista de
     * palabras espiadas
     *
     * @param palabraEspiada
     * @throws IOException
     */
    public void guardaPalabrasEspiadas(String palabraEspiada) throws IOException {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            File file = new File(getFicheroLog());
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(getFicheroLog(), true);
            pw = new PrintWriter(fw);

            String dateString = new Date().toString();
            pw.write(palabraEspiada + dateString + "\r\n");

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

    public String getFicheroLog() {
        return ficheroLog;
    }

    public void setFicheroLog(String ficheroLog) {
        this.ficheroLog = ficheroLog;
    }

    public List<EspiaInterface> getListenersEspia() {
        return listenersEspia;
    }

    public void setListenersEspia(List<EspiaInterface> listenersEspia) {
        this.listenersEspia = listenersEspia;
    }

    public List<String> getPalabrasEspiadas() {
        return palabrasEspiadas;
    }

    public void setPalabrasEspiadas(List<String> palabrasEspiadas) {
        this.palabrasEspiadas = palabrasEspiadas;
    }

    public File getFileLog() {
        return fileLog;
    }

    public void setFileLog(File fileLog) {
        this.fileLog = fileLog;
    }

    public boolean anhadirPalabra(String palabraEspiada) {
        if (this.palabrasEspiadas.contains(palabraEspiada)) {
            return false;
        } else {
            this.palabrasEspiadas.add(palabraEspiada);
        }
        return true;

    }

    public boolean anhadirListener(EspiaInterface listenerEspia) {
        if (this.listenersEspia.contains(listenerEspia)) {
            return false;
        } else {
            this.listenersEspia.add(listenerEspia);
        }
        return true;

    }

}
