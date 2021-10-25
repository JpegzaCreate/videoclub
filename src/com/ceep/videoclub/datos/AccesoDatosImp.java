/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.videoclub.datos;

import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.viedoclub.negocio.CatalogoPeliculas;
import com.ceep.videoclub.excepciones.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javip
 */
public class AccesoDatosImp  implements IAccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) {
        var archivo = new File (nombreArchivo);
        return  archivo.exists();
       
            
    }
        
    

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosExcepcion { 
        var archivo = new File (nombreArchivo);
        Pelicula pelicula = null;
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            //entrada es el descriptor de lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();//nos decuelve la primera linea del archivo
            var i = 0;
            while(lectura!= null){//hasta que no haya nada y sale
                pelicula= new Pelicula (lectura); //Creamos un objeto de pelicula con cada linea del archivo
               
                peliculas.add(pelicula);//lo añadimos al list
                
                lectura = entrada.readLine();//pasamos a la siguiente linea
            }
            entrada.close();
            System.out.println("Se ha leido y listado el archivo entero");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosExcepcion ("Error de lectura listando peliculas");
        } catch(IOException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosExcepcion ("Error de lectura listando peliculas");
        }
        return peliculas ;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosExcepcion {
       var archivo = new File (nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(nombreArchivo, anexar));
            salida.println(pelicula.getNombre());//agrega contenido
            salida.close();
            System.out.println("Se ha añadido nueva información");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new EscrituraDatosExcepcion("Ha habido un erros al escribir una pelicula");
        } catch(IOException e){
            e.printStackTrace(System.out);
            throw new EscrituraDatosExcepcion("Ha habido un erros al escribir una pelicula");
        }
    }

    @Override
    public void buscar(String nombreArchivo, String buscar) throws LecturaDatosExcepcion {
        var archivo = new File (nombreArchivo);
        try {
            
            //entrada es el descriptor de lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();//nos decuelve la primera linea del archivo
            var cont = 0;
            while(!lectura.equalsIgnoreCase(buscar)){//hasta que no haya nada y sale
                
                lectura = entrada.readLine();
                cont++;
            }
            System.out.println("La pelicula que buscabas es: " + lectura + " y se encuentra en la linea: " + (cont+1));
            entrada.close();
            System.out.println("Se ha leido el archivo entero");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosExcepcion ("Hay un error al buscar la pelicula");
        } catch(IOException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosExcepcion ("Hay un error al buscar la pelicula");
        } catch(NullPointerException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosExcepcion ("Hay un error al buscar la pelicula");
        }
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosExcepcion {
        //Declaramos un objeto tipo archivo
        var archivo = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            //Aqui ya esta creado el archivo
            salida.close(); //cierra el archivo
            System.out.println("Se ha creado el catálogo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new AccesoDatosExcepcion("Hay un erro al crear el catalogo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new  AccesoDatosExcepcion("Hay un erro al crear el catalogo");
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
         var archivo = new File(nombreArchivo);
         if(archivo.exists()){
             archivo.delete();
         }else{
             System.out.println("No se ha encontrado el archivo");
         }
    }

 
    
}
