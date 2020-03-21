/**
 * Clase ConexionDB
 * 
 * Permite la conexión del sistema con una base de datos MySQL
 * 
 * @author Ángel José Calderón Ortega
 * @version 1.0
 */

package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {
    
    // Atributos
    private String driver;
    private Connection conn;
    private String host;
    private String database;
    private String username;
    private String password;
    private String port;
    private static ConexionDB connect;
    
    /**
    * Cosntructor que recibe el host, el puesto, nombre de la base de datos, el
    * nombre de usuario y la contraseña para poder conectarse a la base de datos.
    *
    * @param host  El host de manejador de base de datos
    * @param port Puerto en el que se conecta la base de datos
    * @param database Nombre de la base de datos a la que se desea conectar
    * @param username Nombre de usuario en el servicio de base de datos
    * @param paswword Contraseña del usuario en el servicio de base de datos
    */
    public ConexionDB(String host, String port, String database, String username, String password) {
        //oracle.jdbc.driver.OracleDriver
        this.driver = "com.mysql.jdbc.Driver";
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
        this.port = port;
        String url = "jdbc:mysql://" + host + ":"+port+"/" + database +"?useTimezone=true&serverTimezone=UTC";
        
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connect = this;
    }
    

    /**
    * Constructor basio por defecto.
    * Ya cuenta con los elementos necesarios para conectarse automaticamente.
    * Para poder establecer la conexión es necesario modificar los atributos de este cosntrutor.
    */
    public ConexionDB() {
        this.driver= "com.mysql.jdbc.Driver";
        this.database = "inventario";
        this.host = "localhost";
        this.port = "3306";
        this.username = "root";
        this.password = "321654987angel";
        String url = "jdbc:mysql://"+host+":"+port+"/"+database+"?useTimezone=true&serverTimezone=UTC";
        try {
            conn = DriverManager.getConnection(url, username, "321654987angel");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connect = this;
    }
    
    /**
    * Regresa la conexion establecida
    *
    *
    */
    public Connection connection() {
        try {
            return getConn();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public Statement query(String sQuery) throws SQLException {
        Statement s = getConn().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        s.executeQuery(sQuery);
        return s;
    }

    public Statement update(String sQuery) throws SQLException {
        Statement s = getConn().createStatement();
        s.executeUpdate(sQuery);
        return s;
    }

    public void close(Statement s) {
        try {
            s.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        }
    }

    public void close() {
        try {
            if(getConn()!=null){
                getConn().close();   
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        }
    }

    public static ConexionDB getConnect() {
        return connect;
    }

    public static void setConnect(ConexionDB connect) {
        ConexionDB.connect = connect;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}