/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Modelo Tabla Carreras: Crea una tabla con X columnas y sus campos rellenados
 * (nombre, carrera, fecha, lugar, max corredors)
 *
 * @author Annie
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelCarreras extends AbstractTableModel { //por extenderla,hay q sobreescribir unos metodos (2 y 3)

    private final List<Carrera> listaCarreras;

    private final String[] columnas = {"NOMBRE CARRERA", "FECHA", "LUGAR", "MAX CORREDORES"};//defino las columnas(final xq no cambian)

    /**
     * Constructor
     *
     * @param listaCarreras
     */
    public TableModelCarreras(List<Carrera> listaCarreras) { //1. recibe una lista de carreras

        this.listaCarreras = listaCarreras;

    }

    /**
     * Devuelve el número de filas que tendrá nuestra tabla. Depende del tamaño
     * de la lista.
     *
     * @return listaCarreras.size
     */
    @Override
    public int getRowCount() { //2. devuelve cuantas filas tiene la tabla (tantas como carreras haya)
        return listaCarreras.size();
    }

    /**
     * Método que devuelve el número de columnas
     *
     * @return columnas.lengh
     */
    @Override
    public int getColumnCount() { //3. cuantas columnas tengo? estan definidas arriba 
        return columnas.length;//entonces con el .lenght nos devuelve las q hay
    }

    /**
     * Devuelve la columna correspondiente al índice
     *
     * @param column
     * @return columnas[column]
     */
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    /**
     * Método que se llama 1 vez por cada una de las celdas que tenga la tabla
     * ({"Nombre","Lugar", etc}). El núm de llamadas a este método depende de lo
     * que haya devuelto en "getRowCount" y "getColumnCount". Sacamos los datos
     * de la lista de carreras
     *
     * @param rowIndex
     * @param columnIndex
     * @return listaCarreras.get(rowIndex) (nombre, lugar, fecha, etc) y
     * listaCorredores.get(rowIndex) (dorsal, corredor, tiempo).
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//dame el valor en la columna tal, en la fila cual

        switch (columnIndex) {
            case 0:
                return listaCarreras.get(rowIndex).getNombreCarrera();
            case 1:
                return listaCarreras.get(rowIndex).getFechaCarrera();
            case 2:
                return listaCarreras.get(rowIndex).getLugar();
            case 3:
                return listaCarreras.get(rowIndex).getNumMaxCorredores();

        }
        return null;
    }
}
