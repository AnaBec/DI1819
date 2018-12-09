package modelo;

import java.util.Date;
import java.util.Objects;

/**
 * Clase corredor
 *
 * @author Annie
 */
public class Corredor {

    private String nombre;
    private String dni;
    private String direccion;
    private int tlfno;
    private Date fechaNacimiento;

    /**
     * Mátodo constructor
     *
     * @param nombre Nombre
     * @param dni Dni
     * @param direccion Direccion
     * @param tlfno Teléfono
     * @param fechaNacimiento FechaNacimiento
     */
    public Corredor(String nombre, String dni, String direccion, int tlfno, Date fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.tlfno = tlfno;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método getter nombre
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setter nombre
     *
     * @param nombre Nombre
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getter dni
     *
     * @return dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * Método setter dni
     *
     * @param dni Dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * método getter direccion
     *
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método setter direccion
     *
     * @param direccion Dirección
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método getter tlfno
     *
     * @return tlfno
     */
    public int getTlfno() {
        return tlfno;
    }

    /**
     * Método setter tlfno
     *
     * @param tlfno Teléfono
     */
    public void setTlfno(int tlfno) {
        this.tlfno = tlfno;
    }

    /**
     * Método getter fechaNacimiento
     *
     * @return fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Metodo Setter fechaNacimiento
     *
     * @param fechaNacimiento FechaNacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Metodo ToString
     *
     * @return todos los datos del corredor
     */
    @Override
    public String toString() {
        return nombre + ", " + dni + ", " + direccion + ", " + tlfno + ", " + fechaNacimiento;
    }

  @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public boolean equals(Corredor c) {
        

        if (this.dni.equals(c.dni)) {
            return true;
        } else {
            return false;
        }
    }

   

}
