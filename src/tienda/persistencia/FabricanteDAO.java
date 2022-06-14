/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;

/**
 *
 * @author Alejandro Birolo
 */
public final class FabricanteDAO extends DAO {
    
    public void guardarFabricante(Fabricante fabricante)throws Exception{

            try {
                if (fabricante == null){
                    throw new Exception("Debe indicar un fabricante");
                }

                String sql = "INSERT INTO fabricante (codigo, nombre)"
                             + "VALUES ('" + fabricante.getCodigo() + "', '" + fabricante.getNombre()+ "' );";

                insertarModificarEliminar(sql);
            } catch (Exception e) {
                throw e;
            }
        }

    public void modificarFabricante(Fabricante fabricante)throws Exception{

        try {
            if (fabricante == null){
                throw new Exception("Debe indicar un fabricante que desea modificar");
            }

            String sql = "UPDATE fabricante SET "
                    + "nombre= '" + fabricante.getNombre() +"' WHERE codigo = '" + fabricante.getCodigo()+ "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarFabricante(int codigo)throws Exception{

        try {

            String sql = "DELETE fabricante WHERE  codigo = '" + codigo + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricantePorCodigo(int codigo) throws Exception{
        try {
            String sql = "SELECT * FROM Fabricante "
                       + " WHERE codigo = '" + codigo + "'" ;
            consultarBase(sql);

            Fabricante fabricante = null;

            while (resultado.next()){
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }

            desconectarBase();
            return fabricante;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception{
        try {
            String sql = "SELECT * FROM Usuario "
                       + " WHERE nombre = '" + nombre + "'" ;

            consultarBase(sql);

            Fabricante fabricante = null;

            while (resultado.next()){
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }

            desconectarBase();
            return fabricante;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Fabricante> listarFabricantes() throws  Exception{
        try {

            String sql = "SELECT * FROM Fabricante ";

            consultarBase(sql);

            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();


            while (resultado.next()){
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricantes.add(fabricante);
            }

            desconectarBase();
            return fabricantes;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception ("Error de sistema");
        }
    }
    
}