/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Utilidades.Utils;
import java.awt.Component;
import java.io.*;
import java.text.ParseException;
import java.util.*;
import javax.swing.JOptionPane;
import modelo.Carrera;
import modelo.Corredor;
import modelo.Participante;

/**
 * Clase LogicaNegocio donde vamos a desarrollar todos los métodos específicos
 * del corredor y de las carreras.
 *
 * @author Annie
 */
public class LogicaNegocio implements Serializable {

    private List<Corredor> listaCorredores;
    private List<Carrera> listaCarreras;
    private List<Participante> listaParticipantes;
    private List<Carrera> listaCarrerasFinalizadas;
    private long tiempoActualizacionAutomatica = 0;
    private transient Timer time;

    /**
     * Metodo constructor donde ya creamos la lista de corredores, la lista de
     * carreras y la lista de participantes
     *
     */
    public LogicaNegocio() {
        listaCorredores = new ArrayList<>();
        listaCarreras = new ArrayList<>();
        listaCarrerasFinalizadas = new ArrayList<>();
        listaParticipantes = new ArrayList<>();
    }

    public List<Corredor> getListaCorredores() {
        return listaCorredores;
    }

    public void setListaCorredores(List<Corredor> listaCorredores) {
        this.listaCorredores = listaCorredores;
    }

    public List<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    public void setListaCarreras(List<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    public List<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(List<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    /**
     * Metodo para anhadir 1corredor a la lista de corredores
     *
     * @param corredor Corredor
     */
    public void anhadirCorredor(Corredor corredor) {

        listaCorredores.add(corredor);
    }

    public List<Carrera> getListaCarrerasFinalizadas() {
        return listaCarrerasFinalizadas;
    }

    public void setListaCarrerasFinalizadas(List<Carrera> listaCarrerasFinalizadas) {
        this.listaCarrerasFinalizadas = listaCarrerasFinalizadas;
    }

    /**
     * Metodo para anhadir una carrera a la lista de carreras
     *
     * @param carrera
     */
    public void anhadirCarrera(Carrera carrera) {
        listaCarreras.add(carrera);
    }

    /**
     * Añade un participante a la lista de participantes
     *
     * @param participante
     */
    public void anhadirParticipante(Participante participante) {
        listaParticipantes.add(participante);
    }

    /**
     * Añade un participante a una carrera
     *
     * @param participante
     */
    public void anhadirParticipanteACarrera(Participante participante) {
        for (Carrera carrera : listaCarreras) {
            carrera.getListaParticipantes().add(participante);
        }
    }

    /**
     * Añade un corredor a la lista de participantes
     *
     * @param corredor
     */
    public void anhadirCorrerorAlistaParticipantes(Corredor corredor) {
        for (Participante participante : listaParticipantes) {
            participante.setCorredor(corredor);

        }
    }

    /**
     * Método para borrar un participante de la lista de participantes
     *
     * @param participante
     */
    public void borrarParticipante(Participante participante) {
        if (listaParticipantes.contains(participante)) {
            listaParticipantes.remove(participante);
        }
    }

    /**
     * Método para borrar un corredor de la lista de corredores
     *
     * @param corredor
     */
    public void borrarCorredor(Corredor corredor) {
        if (listaCorredores.contains(corredor)) {
            listaCorredores.remove(corredor);
        }
    }

    /**
     * Método borrar carreras de la lista de carreras
     *
     * @param carrera
     */
    public void borrarCarrera(Carrera carrera) {
        if (listaCarreras.contains(carrera)) {
            listaCarreras.remove(carrera);
        }
    }

    /**
     * Añadir el corredor a la carrera
     *
     * @param corredor
     * @param carrera
     * @return
     */
    public boolean anhadirCorredorAcarrera(Corredor corredor, Carrera carrera) {

        int nunDorsal = carrera.getListaParticipantes().size() + 1;
        int tiempo = 0;
        Participante participante = new Participante(nunDorsal, corredor, tiempo);

        carrera.getListaParticipantes().add(participante);

        return true;
    }

    /**
     * Graba un CSV de todos los corredores de la lista. Formateamos la fecha de
     * nacimiento con el SimpleDateFormat (sdf) del paquete "Utils"
     *
     * @throws IOException
     */
    public void grabarCsvCorredores() {

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("CorredoresInterfaz.csv", true);
            pw = new PrintWriter(fw);

            for (Corredor corredor : listaCorredores) {
                pw.write(corredor.getNombre() + "," + corredor.getDni() + "," + corredor.getDireccion()
                        + "," + "," + corredor.getTlfno() + ","
                        + Utils.sdf.format(corredor.getFechaNacimiento()) + "\n");

            }

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

    /**
     * Método que ordena a los corredores por fecha de nacimiento (de más edad a
     * menos edad).
     */
    public void ordenarCorredores() {

        Comparator<Corredor> comparatorCorredores = new Comparator<Corredor>() {
            public int compare(Corredor c, Corredor c1) {
                return c.getFechaNacimiento().compareTo(c1.getFechaNacimiento());
            }

        };
        listaCorredores.sort(comparatorCorredores);
        System.out.println(listaCorredores);

    }

    public void ordenarParticipantes() {

        Comparator<Participante> comparatorParticipantes = new Comparator<Participante>() {
            public int compare(Participante p1, Participante p2) {
                return new Double(p1.getTiempoLlegada()).compareTo(new Double(p2.getTiempoLlegada()));
            }

        };
        listaParticipantes.sort(comparatorParticipantes);
        System.out.println(listaParticipantes);

    }
    //Collections.sort(listaParticipantes, (Participante p1, Participante p2) -> new Double(p1.getTiempoLlegada()).compareTo(new Double(p2.getTiempoLlegada())));

    /**
     * Método que lee el Csv creado de cada corredor de la lista de corredores.
     */
    public void leerCsvCorredores() {
        Corredor c;
        listaCorredores.clear();
        File file = new File("CorredoresInterfaz.csv");

        if (file.exists()) {
            String linea;
            try {
                FileReader fr = new FileReader("CorredoresInterfaz.csv");
                BufferedReader br = new BufferedReader(fr);
                linea = br.readLine();

                while (linea != null) {
                    StringTokenizer tokens = new StringTokenizer(linea, ",");
                    while (tokens.hasMoreTokens()) {
                        String nombre = tokens.nextToken().trim();
                        String dni = tokens.nextToken().trim();
                        String direccion = tokens.nextToken().trim();
                        int telefono = Integer.parseInt(tokens.nextToken().trim());
                        Date fechaNacimiento = Utils.sdf.parse(tokens.nextToken().trim());

                        c = new Corredor(nombre, dni, direccion, telefono, fechaNacimiento);
                        listaCorredores.add(c);
                    }
                    linea = br.readLine();
                }

            } catch (FileNotFoundException ex) {
                System.out.println("fsf");
            } catch (IOException ex) {
                System.out.println("Error en la lectura");
            } catch (ParseException ex) {
                System.out.println("Error al formatear fecha");

            }
        } else {
            Component OpcionesCorredor = null;
            JOptionPane.showMessageDialog(OpcionesCorredor, "El archivo no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Graba un CSV de todas las carreras de la lista con sus lista de
     * participanes dentro.
     *
     * @throws IOException
     */
    public void grabarCsvCarrerasIncripcionSolo() {

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("CarrerasInterfaz.csv", true);
            pw = new PrintWriter(fw);

            for (Carrera carrera : listaCarreras) {
                for (Participante participante : carrera.getListaParticipantes()) {
                    pw.write(carrera.getNombreCarrera() + "," + Utils.sdf.format(carrera.getFechaCarrera()) + ","
                            + carrera.getLugar() + "," + carrera.getNumMaxCorredores() + ","
                            + participante.getDorsal() + "," + participante.getCorredor() + ","
                            + participante.getTiempoLlegada() + "\n");
                }
            }
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

    /**
     * Método que lee el Csv creado de cada carrera de la lista de carreras con
     * su lista de participantes dentro.
     */
    public void leerCsvCarreras() {
        Carrera ca;
        Participante pa;
        listaCarreras.clear();
        File file = new File("CarrerasInterfaz.csv");

        if (file.exists()) {
            String linea;
            try {
                FileReader fr = new FileReader("CarrerasInterfaz.csv");
                BufferedReader br = new BufferedReader(fr);
                linea = br.readLine();

                while (linea != null) {
                    StringTokenizer tokens = new StringTokenizer(linea, ",");
                    while (tokens.hasMoreTokens()) {
                        String nombreCarrera = tokens.nextToken().trim();
                        Date fechaCarrera = Utils.sdf.parse(tokens.nextToken().trim());
                        String lugar = tokens.nextToken().trim();
                        int numMaxCorredores = Integer.parseInt(tokens.nextToken().trim());

                        int dorsal = Integer.parseInt(tokens.nextToken().trim());
                        Corredor corredor = (Corredor) tokens.nextElement();
                        int tiempoLlegada = Integer.parseInt(tokens.nextToken().trim());

                        ca = new Carrera(nombreCarrera, fechaCarrera, lugar, numMaxCorredores);
                        pa = new Participante(dorsal, corredor, tiempoLlegada);

                        listaParticipantes.add(pa);
                        listaCarreras.add(ca);

                    }
                    linea = br.readLine();
                }

            } catch (FileNotFoundException ex) {
                System.out.println("fsf");
            } catch (IOException ex) {
                System.out.println("Error en la lectura");
            } catch (ParseException ex) {
                System.out.println("Error al formatear fecha");

            }
        } else {
            Component OpcionesCarrera = null;
            JOptionPane.showMessageDialog(OpcionesCarrera, "El archivo no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void guardadoAutomatico(int automaticSave) {

        if (automaticSave == 0) {
            tiempoActualizacionAutomatica = 5 * 60 * 1000;
        }
        tiempoActualizacionAutomatica = automaticSave * 60 * 1000;
        if (time == null) {
            time = new Timer();
            time.schedule(new TimerTask() {
                @Override
                public void run() {
                    grabarCsvCarrerasIncripcionSolo();
                }
            }, tiempoActualizacionAutomatica);
        } else if (time != null) {
            time.cancel();
            time = new Timer();
            time.schedule(new TimerTask() {
                @Override
                public void run() {
                    grabarCsvCarrerasIncripcionSolo();
                }
            }, tiempoActualizacionAutomatica);

        }

    }
/**
 * Graba un csv de los resultados de las carreras
 */
    public void grabarResultados() {

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("resultados.csv", true);
            pw = new PrintWriter(fw);

            for (Carrera carrera : listaCarreras) {
                for (Participante participante : carrera.getListaParticipantes()) {
                    pw.write("R E S U L T A D O S  C A R R E R A S\n" + "-->NOMBRE\n" + carrera.getNombreCarrera() + "\n" +"-->FECHA\n" + Utils.sdf.format(carrera.getFechaCarrera()) + "\n"
                            + "-->LUGAR\n"+carrera.getLugar() + "\n" +"-->NUM MAX CORREDORES\n"+ carrera.getNumMaxCorredores() + "\n"
                            + "-->DORSAL\n"+participante.getDorsal() + "\n" +"-->CORREDOR\n"+ participante.getCorredor() + "\n"
                            + "-->TIEMPO LLEGADA\n"+participante.getTiempoLlegada() + "\n");
                }
            }
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

}
