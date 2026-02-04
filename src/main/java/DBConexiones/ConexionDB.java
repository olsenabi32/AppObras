/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConexiones;

import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eromero
 */
public class ConexionDB {
//    private static final ConexionDB conexionDB=null;
    private String strDriver = null;
//    private String strJDBC = null;
    public Connection conex=null;
    public ConexionDB() throws SQLException{
        System.out.println("Entra en el constructor de ConexionDB ");

//        strJDBC ="org.sqlite.JDBC"; //Driver de conexión
        strDriver="jdbc:sqlite:./BDatos/EjercicioClaseSepEvalIni.db";
        System.out.println( "Se han iniciado las varibles del constructor ");
        System.out.println( "Llamo al metodo setconnection "); 
        try {
            conex = getConnection(this.strDriver,"","");
            conex.createStatement().execute("PRAGMA foreign_keys = ON;");
            System.out.println( "Exito al conectar la base de datos con la cadena " + strDriver);
        } catch (SQLException ex) {
          System.out.println( "ERROR CONEXION DB" + strDriver + " " + ex);
          Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
