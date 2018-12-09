/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Annie
 */
public class Participante {

    private int dorsal;
    private Corredor corredor;
    private int tiempoLlegada;

   /* public Participante() {
    }*/

  /*  public Participante(Corredor corredor) {
        this.corredor = corredor;
    }*/

    
    /*public Participante(int dorsal, Corredor corredor) {
        this.dorsal = dorsal;
        this.corredor = corredor;
    }*/

    public Participante(int dorsal, Corredor corredor, int tiempoLlegada) {
        this.dorsal = dorsal;
        this.corredor = corredor;
        this.tiempoLlegada = tiempoLlegada;
    }

    public double getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }

    @Override
    public String toString() {
        return "Participante{" + "dorsal=" + dorsal + ", corredor=" + corredor + ", tiempoLlegada=" + tiempoLlegada + '}';
    }

}
