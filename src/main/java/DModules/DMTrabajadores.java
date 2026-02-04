/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DModules;

import DBConexiones.ConexionDB;
import DSources.DSTrabajadores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DMTrabajadores {
    
    private static ConexionDB conexionDB;
    private static Connection con;
   
    
    public List<DSTrabajadores> QryCargaTrabajadores() throws SQLException{
      List<DSTrabajadores> ArrayTrabajadores = new ArrayList<>();
    try {
        conexionDB = new ConexionDB();
        con = conexionDB.conex;
        System.out.println("Conexión a base de datos correcta para Trabajadores");
    } catch (SQLException ex) {
        Logger.getLogger(DMTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
    } 

    // Se añade POBLACION y PVP_HORA a la consulta
    String sql = "SELECT NIF, NOMBRE, NOMBRE || ' ' || substr(NIF,7) AS DESCRIPCION, POBLACION, PVP_HORA, TIPO "
            + "FROM TRABAJADORES ORDER BY NOMBRE ASC";   
    PreparedStatement statement;
    System.out.println("Declaracion statement");    
    statement = con.prepareStatement(sql);
    System.out.println("Preparado el Statement");        
    ResultSet resultSet = statement.executeQuery();
    System.out.println("Ejecutada la Query de TRABAJADORES");

    while (resultSet.next()) {
        String Nombre = resultSet.getString("NOMBRE");
        String Nif = resultSet.getString("NIF");
        String Descripcion = resultSet.getString("DESCRIPCION");
        String Poblacion = resultSet.getString("POBLACION");
        int PvpHora = resultSet.getInt("PVP_HORA");
        int Tipo = resultSet.getInt("TIPO");

        ArrayTrabajadores.add(new DSTrabajadores(Nif, Descripcion, Nombre, Poblacion, PvpHora, Tipo));
        System.out.println("Valores: NIF=" + Nif + " DESCRIPCION=" + Descripcion + 
                           " POBLACION=" + Poblacion + " PVP_HORA=" + PvpHora + " TIPO=" + Tipo);
    }

    con.close();
    System.out.println("CIERRE DE LA CONEXION de Trabajadores realizada con exito");

    return ArrayTrabajadores;
}
    
    public boolean eliminarTrabajador(String nif) {
        boolean eliminado = false;
        Statement stmt = null;

        try {
            conexionDB = new ConexionDB();
            con = conexionDB.conex;
            stmt = con.createStatement();

            String sql = "DELETE FROM TRABAJADORES WHERE NIF = '" + nif + "'";
            System.out.println("Ejecutando SQL: " + sql);

            int filas = stmt.executeUpdate(sql);
            if (filas > 0) {
                eliminado = true;
                System.out.println("Trabajador con NIF " + nif + " eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún trabajador con NIF " + nif);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DMTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DMTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return eliminado;
    }
    
    public boolean insertarTrabajador(String nif, String nombre, String poblacion, int pvpHora, String tipo) {
        boolean insertado = false;
        Statement stmt = null;

        try {
            int t= 0;
            if(tipo.equals("Administrativo")){
                t=1;
            }
            conexionDB = new ConexionDB();
            con = conexionDB.conex;
            stmt = con.createStatement();

            String sql = "INSERT INTO TRABAJADORES (NIF, NOMBRE, POBLACION, PVP_HORA, TIPO) VALUES ("
                    + "'" + nif + "', "
                    + "'" + nombre + "', "
                    + "'" + poblacion + "', "
                    + pvpHora + ", "
                    + t + ")";

            System.out.println("Ejecutando SQL: " + sql);

            int filas = stmt.executeUpdate(sql);
            if (filas > 0) {
                insertado = true;
                System.out.println("Trabajador con NIF " + nif + " insertado correctamente.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DMTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DMTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return insertado;
    }
    
    public boolean modificarTrabajador(String nif, String nombre, String poblacion, int pvpHora, int tipo) {
        boolean actualizado = false;
        Statement stmt = null;
        
        try {
             conexionDB = new ConexionDB();
            con = conexionDB.conex;
            stmt = con.createStatement();
            
            String sql = "UPDATE TRABAJADORES SET "
                    + "NOMBRE = '" + nombre + "', "
                    + "POBLACION = '" + poblacion + "', "
                    + "PVP_HORA = " + pvpHora + ", "
                    + "TIPO = " + tipo + " "
                    + "WHERE NIF = '" + nif + "'";
            
            System.out.println("Ejecutando SQL: " + sql);
            
            int filas = stmt.executeUpdate(sql);
            if (filas > 0) {
                actualizado = true;
                System.out.println("Trabajador con NIF " + nif + " actualizado correctamente.");
            } else {
                System.out.println("No se encontró ningún trabajador con NIF " + nif);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DMTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DMTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return actualizado;
    }
    
    public List<DSTrabajadores> QryCargaTodaInfoTrabajadores() throws SQLException {
        List<DSTrabajadores> todaInfoTrabajadores = new ArrayList<>();

        try {
            conexionDB = new ConexionDB();
            con = conexionDB.conex;
            if (con == null) {
                System.out.println("Error: conexión nula.");
                return todaInfoTrabajadores;
            }
            System.out.println("Conexión correcta a BD.");
        } catch (SQLException ex) {
            Logger.getLogger(DMTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
            return todaInfoTrabajadores;
        }

        String sql = "SELECT NIF, NOMBRE, POBLACION, PVP_HORA, TIPO FROM TRABAJADORES ORDER BY NOMBRE ASC";
        try (PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                String nif = rs.getString("NIF");
                String nombre = rs.getString("NOMBRE");
                String poblacion = rs.getString("POBLACION");
                int pvpHora = rs.getInt("PVP_HORA");
                int tipo = rs.getInt("TIPO");

                todaInfoTrabajadores.add(new DSTrabajadores(nif, "", nombre, poblacion, pvpHora, tipo));
                System.out.println("✔ Cargado trabajador: " + nombre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todaInfoTrabajadores;
    }
    
    public String obtenerNifPorNombre(String nombre) {
        String nif = "";
        String sql = "SELECT NIF FROM TRABAJADORES WHERE NOMBRE = ?";

        try (Connection con = new DBConexiones.ConexionDB().conex;
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nif = rs.getString("NIF");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DMTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nif;
}
    
}
    

