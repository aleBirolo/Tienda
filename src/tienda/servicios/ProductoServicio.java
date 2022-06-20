/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

/**
 *
 * @author Alejandro Birolo
 */
public class ProductoServicio {
    
    private Scanner teclado;
    private ProductoDAO dao;
    
    public ProductoServicio(){
        this.dao= new ProductoDAO();
    }
    
    public void crearProducto(int codigo, String nombre, float precio, int codigoFabricante) throws Exception{
        try {
              //Validamos
            if (codigo == 0) {
                throw new Exception("Debe un codigo de producto");
            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe un nombre de producto");
            }
            
            if (precio == 0) {
                throw new Exception("Debe un precio de producto");
            }

            if (codigoFabricante == 0) 
                throw new Exception("Debe un codigo de fabricante");
                
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            
            dao.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void crearProducto() throws Exception{
        try {
            int codigo;
            String nombre;
            float precio;
            int codigoFabricante;
            
            teclado = new Scanner(System.in).useDelimiter("\n");
            
            System.out.print("Ingrese Codigo de producto: ");
            codigo = teclado.nextInt();
            
              //Validamos
            if (codigo == 0) {
                throw new Exception("Debe un codigo del producto");
            }
            
            System.out.print("Ingrese nombre de producto: ");
            nombre = teclado.next();
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe un nombre del producto");
            }
            
            System.out.print("Ingrese precio de producto: ");
            precio = teclado.nextFloat();
            if (precio == 0) {
                throw new Exception("Debe un precio del producto");
            }
            
            System.out.print("Ingrese codigo de fabricante del producto: ");
            codigoFabricante = teclado.nextInt();
            if (codigoFabricante == 0) 
                throw new Exception("Debe un codigo de fabricante");
                
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            
            dao.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarPrecioProducto(int codigo, float nuevoPrecio) throws Exception {

        try {

            //Validamos
            if (codigo == 0) {
                throw new Exception("Debe indicar codigo de producto");
            }

            if (nuevoPrecio == 0) {
                throw new Exception("Debe el nuevo precio del producto");
            }

            //Buscamos
            Producto producto = buscarProductoPorCodigo(codigo);
            producto.setPrecio(nuevoPrecio);
            
            dao.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(int codigo) throws Exception {

        try {

            //Validamos 
            if (codigo == 0) {
                throw new Exception("Debe indicar el codigo de producto eliminar");
            }
            dao.eliminarProducto(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo == 0) {
                throw new Exception("Debe indicar el codigo de producto");
            }
            
            Producto producto = dao.buscarProductoPorCodigo(codigo);
            //Verificamos
            if (producto == null) {
                throw new Exception("No se econtró el producto para el codigo de producto indicado");
            }

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> buscarProductoMasBarato() throws Exception {

        try {

            Collection<Producto> productos = dao.buscarProductoMasBarato();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Collection<Producto> listarProductosPorNombre() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductosPorNombre();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Collection<Producto> listarProductosPorComodinNombre(String nombre) throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductosPorComodinNombre(nombre);

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Collection<Producto> listarProductosPorNombreYPrecio() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductosPorNombreYPrecio();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Collection<Producto> listarProductosPorRangoDePrecio(int inf, int sup) throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductosPorRangoPrecio(inf, sup);

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductos() throws Exception {

        try {

            //Listamos los mascotas
            Collection<Producto> productos = dao.listarProductos();

            //Imprimimos los mascotas
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirProductos(Collection<Producto> productos) throws Exception {

        try {

            //Imprimimos los mascotas
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirProductos(Producto producto) throws Exception {

        try {

            //Imprimimos los mascotas
            if (producto == null ) {
                throw new Exception("No existe el producto para imprimir");
            } else {
                
                    System.out.println(producto.toString());
                
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
}
