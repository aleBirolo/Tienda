/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.entidades;

/**
 *
 * @author Alejandro Birolo
 */
public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int codigoFabricante;

    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio, int codigoFabricante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.codigoFabricante = codigoFabricante;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCodigoFabricante() {
        return codigoFabricante;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCodigoFabricante(int codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }

    @Override
    public String toString() {
        return "Producto{" 
                            +  (codigo == 0           ? "" : " codigo= "            + codigo + ",")  
                            +  (nombre == null        ? "" : " nombre= "            + nombre + ",")
                            +  (precio == 0           ? "" : " precio= "            + precio + ",")
                            +  (codigoFabricante == 0 ? "" : " codigoFabricante= "  + codigoFabricante )  
                     + '}';
    }
    
}
