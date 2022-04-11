/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import utilidad.Archivo;

/**
 *
 * @author Brandon Rogerio Aguirre Mendoza bran1189@gmail.com
 */
public class Jugadores extends HashMap<String, Jugador> {

    private String nombreArchivo;
    private int totalJugadores;
    private int totalJugando;

    /**
     * @return the nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param nombreArchivo the nombreArchivo to set
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * @return the totalJugadores
     */
    public int getTotalJugadores() {
        return totalJugadores;
    }

    /**
     * @param totalJugadores the totalJugadores to set
     */
    public void setTotalJugadores(int totalJugadores) {
        this.totalJugadores = totalJugadores;
    }

    /**
     * @return the totalJugando
     */
    public int getTotalJugando() {
        return totalJugando;
    }

    /**
     * @param totalJugando the totalJugando to set
     */
    public void setTotalJugando(int totalJugando) {
        this.totalJugando = totalJugando;
    }

    public void adicionarJugador(Jugador jugador) {
        this.put(jugador.getNombre(), jugador);
        totalJugadores++;
        totalJugando += jugador.getJugar().equals("si") ? 1 : 0;
    }

    public Jugador buscarJugador(String nombre) {
        return get(nombre);
    }

    public Jugador modificarJugador(Jugador jugador) {
        String nombre = jugador.getNombre();

        String valorActual = this.get(nombre).getJugar();
        String valorNuevo = jugador.getJugar();
        if (!valorActual.equals(valorNuevo)) {
            totalJugando += jugador.getJugar().equals("si") ? -1 : 1;
        }

        return replace(nombre, jugador);
    }

    public Jugador eliminarJugador(Jugador jugador) {
        String nombre = jugador.getNombre();
        Jugador jugadorEliminado = this.remove(nombre);
        if (jugadorEliminado != null) {
            totalJugadores--;
            totalJugando -= jugador.getJugar().equals("si") ? 1 : 0;
        }
        return jugadorEliminado;
    }

    public void inicializarJugadores() {
        this.clear();
        totalJugadores = 0;
        totalJugando = 0;
    }

    public void leerJugadores(File archivo) {
        this.inicializarJugadores();
        this.nombreArchivo = archivo.getAbsolutePath();

        Archivo archivoLocal = new Archivo();

        ArrayList<String> registros = archivoLocal.leerArchivo(archivo.getPath());

        for (String registro : registros) {
            Jugador jugador = new Jugador(registro.split(", "));
            adicionarJugador(jugador);
        }

    }

    public void grabarJugadores(File archivo) {

        ArrayList<String> lista = new ArrayList<>();

        Iterator<Jugador> iterador = this.values().iterator();

        while (iterador.hasNext()) {
            Jugador jugador = iterador.next();
            lista.add(jugador.toString());
        }

        Archivo archivoLocal = new Archivo();
        archivoLocal.grabarArchivo(archivo.getPath(), lista);
        nombreArchivo = archivo.getName();

    }

}
