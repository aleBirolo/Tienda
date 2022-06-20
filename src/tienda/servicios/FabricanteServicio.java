/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

/**
 *
 * @author Alejandro Birolo
 */
public class FabricanteServicio {
    
    private Scanner teclado;
    private FabricanteDAO dao;

    public FabricanteServicio() {
        this.dao = new FabricanteDAO();
    }

    public void crearFabricante(int codigo, String nombre) throws Exception {

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe un nombre de fabricante");
            }
            
            if (codigo == 0 ) {
                throw new Exception("Debe indicar un codigo");
            }
            
            if (buscarFabricantePorCodigo(codigo) != null) {
                throw new Exception("Ya existe un fabricante con el codigo  indicado " + codigo);
            }

            //Creamos el Fabricante
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);
            dao.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void crearFabricante() throws Exception {

        try {
            int codigo;
            String nombre;
            
            teclado = new Scanner(System.in).useDelimiter("\n");
            
            System.out.print("Ingrese codigo de fabricante: ");
            codigo= teclado.nextInt();
            if (codigo == 0 ) {
                throw new Exception("Debe indicar un codigo");
            }
            
            System.out.print("Ingrese nombre de fabricante: ");
            nombre = teclado.next();
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe un nombre de fabricante");
            }
            
            if (buscarFabricantePorCodigo(codigo) != null) {
                throw new Exception("Ya existe un fabricante con el codigo  indicado " + codigo);
            }

            //Creamos el Fabricante
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);
            dao.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarNombreFabricante(int codigo, String nombre, String nuevoNombre) throws Exception {

        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un fabricante");
            }
            
            if (codigo == 0) {
                throw new Exception("Debe indicar el codigo del fabricante");
            }

            if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nuevo nombre del fabricante");
            }

            //Buscamos
            Fabricante fabricante = buscarFabricantePorCodigo(codigo);

            //Validamos
            if (fabricante.getCodigo() != codigo) {
                throw new Exception("El codigo actual no es el codigo en el sistema para ese fabricante");
            }

            //Modificamos
            fabricante.setNombre(nuevoNombre);

            dao.modificarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarFabricante(int codigo) throws Exception {

        try {

            //Validamos 
            if (codigo == 0 ) {
                throw new Exception("Debe indicar el codigo de fabricante a eliminar");
            }

            dao.eliminarFabricante(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {

        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del fabricante");
            }

            Fabricante fabricante = dao.buscarFabricantePorNombre(nombre);

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricantePorCodigo(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo == 0) {
                throw new Exception("Debe el codigo del fabricante");
            }

            Fabricante fabricante = dao.buscarFabricantePorCodigo(codigo);

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Fabricante> listarFabricantes() throws Exception {

        try {

            Collection<Fabricante> fabricantes = dao.listarFabricantes();

            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirFabricantes() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Fabricante> fabricantes = dao.listarFabricantes();

            //Imprimimos los usuarios
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen fabricantes para imprimir");
            } else {
                for (Fabricante f : fabricantes) {
                    System.out.println(f);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
}
