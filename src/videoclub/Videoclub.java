/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;

import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.viedoclub.negocio.CatalogoPeliculas;
import com.ceep.viedoclub.negocio.CatalogoPeliculasImp;
import java.util.Scanner;

/**
 *MENU
 * 1.Iniciar catalogo de Peliculas
 * 2. Agregar una Pelicula (Introduce el nombre de la pelicula, Pelicula y agregada con exito)
 * 3. Listar una Pelicula (Pel1, pel2, pel3)
 * 4. Buscar una Pelicula (Introducir nombre: La pelicula se encuentra en la linea X del catalogo o no se encuentra )
 * 5. Salir
 */

public class Videoclub {
    
    
    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        System.out.println("Introduce el nombre del catalogo sobre el que deseas trabajar: ");
       var nombreCatalogo = sn.next();
       CatalogoPeliculas catalogo = new CatalogoPeliculasImp();
//       catalogo.iniciarArchivo(nombreCatalogo);
//       catalogo.agregarPelicula("Matrix", nombreCatalogo);
//       catalogo.agregarPelicula("Spiderman", nombreCatalogo);
//       catalogo.agregarPelicula("Torrente", nombreCatalogo);
//       catalogo.agregarPelicula("Heidi", nombreCatalogo);
//       catalogo.buscarPelicula(nombreCatalogo, "Torrente");
//       catalogo.listarPeliculas(nombreCatalogo);
       
       
        
       boolean salir = false;
       int opcion; //Guardaremos la opcion del usuario
        
       while(!salir){
            
           System.out.println("1.Iniciar catalogo de Peliculas");
           System.out.println("2.Agregar una Pelicula");
           System.out.println("3.Listar Peliculas");
           System.out.println("4.Buscar una Pelicula");
           System.out.println("5. Borrar archivo");    
           System.out.println("6. Salir");           
           System.out.println("Escribe una de las opciones");
           opcion = sn.nextInt();
            
           switch(opcion){
               case 1:
                   System.out.println("");
                   System.out.println("Introduce el nombre del catalogo: ");
                   catalogo.iniciarArchivo(nombreCatalogo);
                   System.out.println("Su nombre es " + nombreCatalogo);
                   System.out.println("");
                   break;
               case 2:
                   System.out.println("");
                   System.out.println("Introcuce el nombre de la pelicula");
                   catalogo.agregarPelicula(sn.next(), nombreCatalogo);
                   System.out.println("");
                   break;
                case 3:
                    System.out.println("");
                    catalogo.listarPeliculas(nombreCatalogo);
                    System.out.println("");
                            
                   break;
                case 4:
                    System.out.println("");
                   System.out.println("Introcuce el nombre de la pelicula que quieres buscar: ");
                   catalogo.buscarPelicula(nombreCatalogo, sn.next());
                   System.out.println("");
                   break;
                case 5 :
                    System.out.println("");
                   catalogo.borrarArchivo(nombreCatalogo);
                    System.out.println("Se ha borrado el archivo correctamente");
                   System.out.println("");
                   break;   
                case 6:
                   salir=true;
                   break;
                default:
                   System.out.println("Solo números entre 1 y 5");
           }
            
       }
        
    }
    
    

        
    }
     

       

