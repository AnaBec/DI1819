/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase carrera con una colección de dorsales
 *
 * @author Annie
 */
public class Carrera {

    private String nombreCarrera;
    private Date fechaCarrera;
    private String lugar;
    private int numMaxCorredores;
    private List<Participante> listaParticipantes;

   /* public Carrera() {

    }*/

    /**
     * Método constructor donde ya creamos la coleccion de dorsales
     *
     * @param nombreCarrera nombre de la carrera
     * @param fechaCarrera Fecha de la carrera
     * @param lugar Lugar de la carrera
     * @param numMaxCorredores Num max de corredores
     */
    public Carrera(String nombreCarrera, Date fechaCarrera, String lugar, int numMaxCorredores) {
        this.nombreCarrera = nombreCarrera;
        this.fechaCarrera = fechaCarrera;
        this.lugar = lugar;
        this.numMaxCorredores = numMaxCorredores;
        this.listaParticipantes = new ArrayList<>();

    }

   /**
     * Método getter
     *
     * @return nombreCarrera
     */
    public String getNombreCarrera() {
        return nombreCarrera;
    }

    /**
     * Método setter
     *
     * @param nombreCarrera Nombre de la carrera
     */
    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    /**
     * Método getter
     *
     * @return fechaCarrera
     */
    public Date getFechaCarrera() {
        return fechaCarrera;
    }

    /**
     * Método setter
     *
     * @param fechaCarrera Fecha de la carrera
     */
    public void setFechaCarrera(Date fechaCarrera) {
        this.fechaCarrera = fechaCarrera;
    }

    /**
     * Método getter
     *
     * @return lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Método setter
     *
     * @param lugar Lugar de la carrera
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Método getter
     *
     * @return numMaxCorredores
     */
    public int getNumMaxCorredores() {
        return numMaxCorredores;
    }

    /**
     * Método setter
     *
     * @param numMaxCorredores Numero max de corredores
     */
    public void setNumMaxCorredores(int numMaxCorredores) {
        this.numMaxCorredores = numMaxCorredores;
    }

    /**
     * Método getter
     *
     * @return listaParticipantes
     */
    public List<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    /**
     * Método setter
     *
     * @param listaParticipantes
     */
    public void setListaParticipantes(List<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    /**
     * Método ToString que muestra todos los datos de la carrera
     *
     * @return datos carrera
     */
    @Override
    public String toString() {
        return nombreCarrera + ", " + fechaCarrera + ", " + lugar + ", " + numMaxCorredores;
    }

}
