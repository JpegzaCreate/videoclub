/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.viedoclub.negocio;

import com.ceep.videoclub.datos.AccesoDatosImp;
import com.ceep.videoclub.datos.IAccesoDatos;
import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.AccesoDatosExcepcion;
import com.ceep.videoclub.excepciones.EscrituraDatosExcepcion;
import com.ceep.videoclub.excepciones.LecturaDatosExcepcion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javip
 */
public class CatalogoPeliculasImp implements CatalogoPeliculas {
    
    private final IAccesoDatos datos;

    public CatalogoPeliculasImp() {
        this.datos = new AccesoDatosImp(); // creo el objeto de la clase de acceso a datos para trabajar con la lista
    }
    
    

    @Override
    public void agregarPelicula(String NombrePelicula, String nombreArchivo) {
        
        Pelicula pelicula = new Pelicula(NombrePelicula);        
        try {
            datos.escribir(pelicula, nombreArchivo, true);
        } catch (EscrituraDatosExcepcion e) {
            e.printStackTrace(System.out);
            System.out.println("Ha habido un error al agregar la pelicula");

        }
        
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        List<Pelicula> peliculas = new ArrayList<>();
        try{
           
            peliculas = datos.listar(nombreArchivo);
            peliculas.forEach(pelicula -> {
                System.out.println("Pelicula --> " + pelicula.getNombre());
            });
        }catch(LecturaDatosExcepcion e){
            System.out.println("Error leyendo el catálogo");
            e.printStackTrace(System.out);
            
        }
        
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        
        try { 
            
            datos.buscar(nombreArchivo, buscar);
        
        } catch (LecturaDatosExcepcion e) {
          // System.out.println("Ha habido un error al buscar");
            e.printStackTrace(System.out);
            //throw new LecturaDatosExcepcion("Hay un error al buscar pelicula");
        }
    }

    
    
    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            //Declaramos un objeto tipo archivo
            if (datos.existe(nombreArchivo)) {
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            }else{
                datos.crear(nombreArchivo);
            }
            
        } catch (AccesoDatosExcepcion e) {
            System.out.println("Error al iniciar el archivo");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void borrarArchivo(String nombreArchivo) {
        try {
            datos.borrar(nombreArchivo);
        } catch (AccesoDatosExcepcion ex) {
            System.out.println("Error al borrar el archivo");
            ex.printStackTrace(System.out);
        }
    }
    
    
    
}
