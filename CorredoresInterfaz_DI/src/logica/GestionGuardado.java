/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import org.openide.util.Exceptions;




/**
 *
 * @author Annie
 */
public class GestionGuardado implements Serializable {

    private LogicaNegocio logicaNegocio=new LogicaNegocio();
   
private GestionGuardado() {
     
    }
 
    public static void salvarCambios() {
        ObjectOutputStream oos = null;
        try {
            File archivo = new File("LogicaNegocio.dat");
            oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(LogicaNegocio.class);
        } catch (FileNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } finally {
            try {
                oos.flush();
                oos.close();

            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    public static LogicaNegocio cargarInstancia() throws ClassNotFoundException {
        File archivo = new File("LogicaNegocio.dat");
        LogicaNegocio logicaNegocio = null;
        if (archivo.exists()) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));

                logicaNegocio = (LogicaNegocio) ois.readObject();
            } catch (FileNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        } else {
            logicaNegocio = new LogicaNegocio();
        }

        return logicaNegocio;

    }

}
