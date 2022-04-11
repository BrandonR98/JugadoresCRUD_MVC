/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brandon Rogerio Aguirre Mendoza bran1189@gmail.com
 */
public class Archivo {
    
    public ArrayList<String> leerArchivo(String urlArchivo) {
        ArrayList<String> lineas = new ArrayList();
        
        try {
            //Abre el archivo
            FileReader flujoFileReader = new FileReader(urlArchivo);
            BufferedReader bufferReader = new BufferedReader(flujoFileReader);
            
            String linea = bufferReader.readLine();
            while (linea != null) {
                lineas.add(linea);
                linea = bufferReader.readLine();
            }
            
            bufferReader.close();
            flujoFileReader.close();
            
        } catch (IOException ex) {
            System.out.println("Error de la lectura de archivo: " + ex.getMessage());
            System.exit(-1);
        }
        
        return lineas;
    }
    
    public void grabarArchivo(String urlArchivo, ArrayList<String> lineas){
        try {
            FileWriter flujoFileWriter = new FileWriter(urlArchivo);
            BufferedWriter buffer = new BufferedWriter(flujoFileWriter);
            
            for(String linea : lineas){
                buffer.write(linea);
                buffer.newLine();
            }
            
            buffer.close();
            flujoFileWriter.close();
            
        } catch (IOException e) {
            System.out.println("Error al escribir archivo: " + e.getMessage());
            System.exit(-1);
        }
    }
    
}
