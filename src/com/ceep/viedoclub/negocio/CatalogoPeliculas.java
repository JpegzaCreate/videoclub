/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.viedoclub.negocio;

public interface CatalogoPeliculas {
    
    public void agregarPelicula(String NombrePelicula,String nombreArchivo);
    
    public void listarPeliculas(String nombreArchivo);
    
    public void buscarPelicula(String nombreArchivo, String buscar);
    
    public void iniciarArchivo(String nombreArchivo);
    
    public void borrarArchivo(String nombreArchivo);
}
