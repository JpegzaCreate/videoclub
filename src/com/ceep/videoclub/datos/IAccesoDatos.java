/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.videoclub.datos;

import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.AccesoDatosExcepcion;
import com.ceep.videoclub.excepciones.EscrituraDatosExcepcion;
import com.ceep.videoclub.excepciones.LecturaDatosExcepcion;
import java.util.List;

/**
 *
 * @author javip
 */
public interface IAccesoDatos {
    
    public boolean existe( String nombreArchivo ) throws AccesoDatosExcepcion;
    
    public List<Pelicula> listar( String nombreArchivo ) throws LecturaDatosExcepcion ; //Lista todas la peliculas el archivo.txt
    
    public void escribir( Pelicula pelicula,String nombreArchivo,boolean anexar)throws EscrituraDatosExcepcion ;
    
    public void buscar(String nombreArchivo,String buscar) throws LecturaDatosExcepcion;
    
    public void crear (String nombreArchivo) throws AccesoDatosExcepcion ;
    
    public void borrar (String nombreArchivo) throws AccesoDatosExcepcion ;
    

    
    
    
}
