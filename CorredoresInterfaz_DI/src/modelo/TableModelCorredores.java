/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Modelo Tabla Corredores: Crea una tabla con X columnas y sus campos
 * rellenados (nombre, dni, direccion, etc)
 *
 * @author Annie
 */
public class TableModelCorredores extends AbstractTableModel { //por extenderla,hay q sobreescribir unos metodos (2 y 3)

    private final List<Corredor> listaCorredores;
    private final String[] columnas = {"NOMBRE", "DNI", "DIRECCIÓN", "TELÉFONO", "FECHA NACIMIENTO"};//defino las columnas(final xq no cambian)

    /**
     * Constructor
     *
     * @param listaCorredores
     */
    public TableModelCorredores(List<Corredor> listaCorredores) { //1. recibe una lista de corredores

        this.listaCorredores = listaCorredores;

        /*
         Vale para otras tablas, si keremos en vez  d alumnos, coches, cambiamos 4 cosas.
        Extendemos desde abstracttablemodel.
        Recibe una lista de lo q sea (1)
         */
    }

    /**
     * Devuelve el número de filas que tendrá nuestra tabla. Depende del tamaño
     * de la lista.
     *
     * @return listaCorredores.size
     */
    @Override
    public int getRowCount() { //2. devuelve cuantas filas tiene la tabla (tantas como corredores haya)
        return listaCorredores.size();
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
     * ({"Nombre","Dni", etc}). El núm de llamadas a este método depende de lo
     * que haya devuelto en "getRowCount" y "getColumnCount".
     *
     * @param rowIndex
     * @param columnIndex
     * @return listaCorredores.get(rowIndex) (nombre, dni, direccion, etc).
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//dame el valor en la columna tal, en la fila cual

        switch (columnIndex) {
            case 0:
                return listaCorredores.get(rowIndex).getNombre();
            case 1:
                return listaCorredores.get(rowIndex).getDni();
            case 2:
                return listaCorredores.get(rowIndex).getDireccion();
            case 3:
                return listaCorredores.get(rowIndex).getTlfno();
            case 4:
                return listaCorredores.get(rowIndex).getFechaNacimiento();
        }
        return null;
    }
}
