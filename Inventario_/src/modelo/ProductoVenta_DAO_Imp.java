package modelo;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoVenta_DAO_Imp implements ProductoVenta_DAO{

    @Override
    public boolean crearProductoVenta(ProductoVenta productoVenta) {
        boolean crear = false;
        Statement stm = null;
        String query = "INSERT INTO producto_venta VALUES "+
                "('"+productoVenta.getClaveVenta()+"','"
                +productoVenta.getClaveProducto()+"', "
                +productoVenta.getCantidad()+");";
        ConexionDB conexion = new ConexionDB();
        try{
            stm = conexion.update(query);
            crear=true;
            stm.close();
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error al agregar al ProductoVenta, método registrar");
            e.printStackTrace();
        }
        return crear;
    }
    
}
