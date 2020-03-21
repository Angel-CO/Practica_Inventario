package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Producto_DAO_Imp implements Producto_DAO{
    
    @Override
    public boolean crearProducto(Producto producto) {
        boolean crear = false;
        Statement stm = null;
        String query = "INSERT INTO producto VALUES "+
                "('"+producto.getClave()+"','"+producto.getNombre()+"','"+producto.getDescripcion()+
                "','"+producto.getUnidad()+"',"+producto.getCantidad()+","+producto.getPrecio()+");";
        ConexionDB conexion = new ConexionDB();
        try{
            stm = conexion.update(query);
            crear=true;
            stm.close();
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error al agregar al estudiante, método registrar");
            e.printStackTrace();
        }
        return crear;
    }

    @Override
    public List<Producto> readAll() {
        Statement stm = null;
        ResultSet rs =null;
        String query="SELECT * FROM producto;";
        
        List<Producto> listaProductos = new ArrayList<Producto>();
        ConexionDB conexion = new ConexionDB();
        try{
            stm = conexion.query(query);
            rs = stm.executeQuery(query);
            while (rs.next()){
                Producto producto = new Producto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getFloat(6));
                listaProductos.add(producto);
            }
            stm.close();
            rs.close();
            conexion.close();
        }catch (SQLException e){
            System.out.println("Error: Clase producto_DAO_imp, método readAll();");
            e.printStackTrace();
        }
        return listaProductos;
    }
    
    public List<Producto> readAll(String clave) {
        Statement stm = null;
        ResultSet rs =null;
        String query=
        "SELECT producto.clave, producto.nombre, producto.descripcion, producto.unidad, producto_venta.cantidad, producto.precio"
        +"    FROM venta"
        +"    JOIN producto_venta ON venta.clave = producto_venta.claveVenta"
        +"    JOIN producto ON producto_venta.claveProducto = producto.clave"
        +"    WHERE venta.clave = '"+clave+"';";
        //+"    WHERE venta.clave = '"+clave+"';";
        
        List<Producto> listaProductos = new ArrayList<Producto>();
        ConexionDB conexion = new ConexionDB();
        try{
            stm = conexion.query(query);
            rs = stm.executeQuery(query);
            while (rs.next()){
                Producto producto = new Producto
                    (rs.getString(1),rs.getString(2),rs.getString(3)
                    ,rs.getString(4),rs.getInt(5),rs.getFloat(6));
                listaProductos.add(producto);
            }
            stm.close();
            rs.close();
            conexion.close();
        }catch (SQLException e){
            System.out.println("Error: Clase producto_DAO_imp, método readAll();");
            e.printStackTrace();
        }
        return listaProductos;
    }
    
    @Override
    public boolean modificarAtributoCadena(String clave, String atributo, String valor) {
        boolean modificar = false;
        //Statement stm = null;
        String query = "UPDATE producto SET "+atributo+" = '"+valor+"' WHERE clave = '"+clave+"';";

        ConexionDB conexion = new ConexionDB();
        try{
            conexion.update(query);
            modificar=true;
            //stm.close();
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error al modificar el producto, método modificar cadena");
            e.printStackTrace();
        }
        return modificar;
    }

    @Override
    public boolean modificarAtributoNumero(String clave, String atributo, float valor) {
        boolean modificar = false;
        Statement stm = null;
        String query = "UPDATE producto SET "+atributo+" = "+valor+" WHERE clave = '"+clave+"';";
        ConexionDB conexion = new ConexionDB();
        try{
            stm = conexion.update(query);
            modificar=true;
            stm.close();
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error al modificar el producto, método modificar numero");
            e.printStackTrace();
        }
        return modificar;
    }

    @Override
    public boolean eliminarProducto(String clave) {
        boolean delete = false;
        Statement stm = null;
        String query = "DELETE FROM producto WHERE clave = '"+clave+"';";
        ConexionDB conexion = new ConexionDB();
        try{
            stm = conexion.update(query);
            delete=true;
            stm.close();
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error al eliminar el producto, método eliminar");
            e.printStackTrace();
        }
        return delete;
    }

    @Override
    public Producto obtenerProducto(String clave) {
        Statement stm = null;
        ResultSet rs =null;
        String query="SELECT * FROM producto WHERE clave = '"+clave+"';";
        Producto producto = null;
        
        ConexionDB conexion = new ConexionDB();
        try{
            stm = conexion.query(query);
            rs = stm.executeQuery(query);
            rs.next();
            producto = new Producto
            (rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getFloat(6));
            stm.close();
            rs.close();
            conexion.close();
        }catch (SQLException e){
            System.out.println("Error: Clase producto_DAO_imp, método obtenerProducto();");
            e.printStackTrace();
        }
        return producto;
    }
    
}
