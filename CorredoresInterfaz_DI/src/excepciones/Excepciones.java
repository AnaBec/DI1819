/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Annie
 */
public class Excepciones extends Exception {

    public static class CorredorYaInscrito extends Exception {

        public CorredorYaInscrito(String mensaje) {
            super(mensaje);
        }
    }

    public static class NoSeAdmitenMasParticipantes extends Exception {

        public NoSeAdmitenMasParticipantes(String mensaje) {
            super(mensaje);
        }
    }

    public static class CorredorRegistradoCarreras extends Exception {

        public CorredorRegistradoCarreras(String mensaje) {
            super(mensaje);
        }
    }
}

