package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Venta_DAO_Imp implements Venta_DAO {
    @Override
    public boolean crearVenta(Venta venta){
        boolean crear = false;
        Statement stm = null;
        String query = "INSERT INTO venta VALUES ('"+venta.getClave()+"' , '"+venta.getFecha()+"');";
        ConexionDB conexion = new ConexionDB();
        try{
            stm = conexion.update(query);
            crear=true;
            stm.close();
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error al agregar la venta, método registrar");
            e.printStackTrace();
        }
        return crear;
    }
    public List<Venta> readAll(){
        Statement stm = null;
        ResultSet rs =null;
        String query="SELECT * FROM venta;";
        
        List<Venta> listaVentas = new ArrayList<Venta>();
        ConexionDB conexion = new ConexionDB();
        try{
            stm = conexion.query(query);
            rs = stm.executeQuery(query);
            while (rs.next()){
                Venta venta= new Venta(rs.getString(1),rs.getString(2));
                listaVentas.add(venta);
            }
            stm.close();
            rs.close();
            conexion.close();
        }catch (SQLException e){
            System.out.println("Error: Clase venta_DAO_imp, método readAll();");
            e.printStackTrace();
        }
        return listaVentas;
    }
}







