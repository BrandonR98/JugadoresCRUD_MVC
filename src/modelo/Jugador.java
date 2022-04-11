/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Brandon Rogerio Aguirre Mendoza bran1189@gmail.com
 */
public class Jugador {

    private String nombre;
    private String pronostico;
    private String temperatura;
    private String humedad;
    private String viento;
    private String jugar;

    public Jugador(String nombre, String pronostico, String temperatura, String humedad, String viento, String jugar) {
        this.nombre = nombre;
        this.pronostico = pronostico;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.viento = viento;
        this.jugar = jugar;
    }

    public Jugador(String[] datos) {
        this(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
    }

    public Jugador() {
        this("", "", "", "", "", "");
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the pronostico
     */
    public String getPronostico() {
        return pronostico;
    }

    /**
     * @param pronostico the pronostico to set
     */
    public void setPronostico(String pronostico) {
        this.pronostico = pronostico;
    }

    /**
     * @return the temperatura
     */
    public String getTemperatura() {
        return temperatura;
    }

    /**
     * @param temperatura the temperatura to set
     */
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * @return the humedad
     */
    public String getHumedad() {
        return humedad;
    }

    /**
     * @param humedad the humedad to set
     */
    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    /**
     * @return the viento
     */
    public String getViento() {
        return viento;
    }

    /**
     * @param viento the viento to set
     */
    public void setViento(String viento) {
        this.viento = viento;
    }

    /**
     * @return the jugar
     */
    public String getJugar() {
        return jugar;
    }

    /**
     * @param jugar the jugar to set
     */
    public void setJugar(String jugar) {
        this.jugar = jugar;
    }

    @Override
    public String toString() {
        return nombre + ", "
                + pronostico + ", "
                + temperatura + ", "
                + humedad + ", "
                + viento + ", "
                + jugar;
    }
    
    public String[] getJugador(){
        return new String[]  {nombre, pronostico, temperatura, humedad, viento, jugar};
    }

}
