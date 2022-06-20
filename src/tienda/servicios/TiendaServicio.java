/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.Scanner;

/**
 *
 * @author Alejandro Birolo
 */
public class TiendaServicio {
    
    private Scanner teclado;
    private ProductoServicio ps;
    private FabricanteServicio fs;

    public TiendaServicio() {
        this.ps = new ProductoServicio();
        this.fs = new FabricanteServicio();
    }
    
    private void menuOpciones(){
        System.out.println( " Menu: "
                           +"\n a: Lista el nombre de todos los productos que hay en la tabla producto."
                           +"\n b: Lista los nombre y los precios de todos los productos de la tabla producto."
                           +"\n c: Listar aquellos productos que su precio este entre 120 y 202."
                           +"\n d: Buscar y listar todos los Portatiles de la tabla producto."
                           +"\n e: Lista el nombre y el precio del producto mas barato."
                           +"\n f: Ingresar un producto a la base de datos."
                           +"\n g: Ingresar un fabricante a la base de datos."
                           +"\n h: Editar un producto con datos a eleccion."
                           +"\n i: Lista todos los fabricantes"
                           +"\n z: Salir");
    }
    
    public void consultarTienda() throws Exception 
    {
        teclado = new Scanner(System.in).useDelimiter("\n");
        char opc;
        
        menuOpciones();
        System.out.print("\n Ingrese opcion: ");
        opc = teclado.next().charAt(0);
        
        try {
            while (opc != 'z'){
                switch(opc){
                case 'a':
                    ps.imprimirProductos(ps.listarProductosPorNombre());
                    break;
                case 'b':
                    ps.imprimirProductos(ps.listarProductosPorNombreYPrecio());
                    break;
                case 'c':
                    ps.imprimirProductos(ps.listarProductosPorRangoDePrecio(120, 202));
                    break;
                case 'd':
                    ps.imprimirProductos(ps.listarProductosPorComodinNombre("portatil"));
                    break;
                case 'e':
                    ps.imprimirProductos(ps.buscarProductoMasBarato());
                    break;
                case 'f':
                    ps.crearProducto();
                    ps.imprimirProductos();
                    break;
                case 'g':
                    fs.crearFabricante();
                    fs.imprimirFabricantes();
                    break;
                case 'h':
                    int codigo;
                    float precio;
                    System.out.print("Ingrese codigo de producto a modificar: ");
                    codigo = teclado.nextInt();
                    
                    System.out.print("Ingrese el nuevo precio: ");
                    precio = teclado.nextFloat();
                    ps.modificarPrecioProducto(codigo, precio);
                    ps.imprimirProductos(ps.buscarProductoPorCodigo(codigo));
                    break;
                case 'i':
                    fs.imprimirFabricantes();
                    break;
                default:
                    System.out.print("\n Opcion invalida. Vuelva a ingresar opcion.\n Presione una tecla para continuar...");
                    teclado.next();
                }
                
                System.out.println("\n\n");
                menuOpciones();
                System.out.print("\n Ingrese opcion: ");
                opc = teclado.next().charAt(0);
            }
        } catch (Exception e) {
            throw e;
        }
        
        
    }
    
}
