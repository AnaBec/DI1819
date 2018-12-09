/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 * Para enlazar el panel con el editor de propiedades
 * @author Annie
 */
public class ImagenFondoPropertyEditorSupport extends PropertyEditorSupport {

    private ImagenFondoPanel imagenFondoPanel=new ImagenFondoPanel();
    
    @Override
    public boolean supportsCustomEditor() {
        return true; //devuelve true en el caso de q sea un editor de propiedades personalizado
    }

    @Override
    public Component getCustomEditor() {//Pide el panel, lo q el tiene que insertar en el editor de propiedades que nosotros diseñamos
        return imagenFondoPanel; 
    }

    @Override
    public String getJavaInitializationString() {
        ImagenFondo imagenFondo=imagenFondoPanel.getSelectedValue();
        String ruta = imagenFondo.getRutaImagen().getAbsolutePath();
        ruta = ruta.replace("\\","\\\\");//para que genere las 2 barras que necesita una ruta en Windows
        return "new componentes.ImagenFondo(new java.io.File(\""+ruta+"\","+imagenFondo.getOpacidad()+"f))"; 
    }

    @Override
    public Object getValue() { //una vez q ya se mostró el panel en el editor de prop. y se pulsa aceptar (seleccionamos el archivo y la opacidad damos a aceptar), nos
                                //da cuál es el valor de eso
        return imagenFondoPanel.getSelectedValue(); 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
