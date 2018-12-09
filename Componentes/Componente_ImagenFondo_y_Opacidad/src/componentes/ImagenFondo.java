/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Annie
 */
public class ImagenFondo  implements Serializable{
    //En un JPanel vamos a meter una imagen de fondo pero ademas, vamos
    //a jugar con la opacidad de ésta

    private File rutaImagen;
    private Float opacidad;

    public ImagenFondo(File rutaImagen, Float opacidad) {
        this.rutaImagen = rutaImagen;
        this.opacidad = opacidad;
    }

  
    public File getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(File rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Float getOpacidad() {
        return opacidad;
    }

    public void setOpacidad(Float opacidad) {
        this.opacidad = opacidad;
    }

}
