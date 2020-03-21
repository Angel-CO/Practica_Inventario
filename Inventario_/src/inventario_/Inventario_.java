package inventario_;

import controlador.Operaciones;
import java.sql.Connection;
import modelo.ConexionDB;
import modelo.Producto_DAO_Imp;
import modelo.Producto;

public class Inventario_ {

    public static void main(String[] args) {
        //ConexionDB conexion = new ConexionDB();
        //conexion.conectarMySQL();
        
        //Estudiante_DAO_Imp estDAOImp = new Estudiante_DAO_Imp();
        //EstudianteVO est = new EstudianteVO("Juan");
        //estDAOImp.create(est);
        Operaciones operar = new Operaciones();
        operar.ejecutarAplicacion();
    }

}
