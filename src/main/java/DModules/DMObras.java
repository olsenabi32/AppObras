/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DModules;

import DBConexiones.ConexionDB;
import DSources.DSObras;
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
public class DMObras {
    
    private static ConexionDB conexionDB;
    private static Connection con;
    
    public boolean insertarObra(String codigo, String fechaTermina, int descuento, String descripcion) {
        boolean insertado = false;
        Statement stmt = null;

        try {
            conexionDB = new ConexionDB();
            con = conexionDB.conex;
            stmt = con.createStatement();

            String sql = "INSERT INTO OBRAS (COD_OBRA, DESCRIPCION, FEC_TERMINA, DESCUENTO) VALUES ("
                    + "'" + codigo + "', "
                    + "'" + descripcion + "', "
                    + "'" + fechaTermina + "', "
                    + descuento + ")";

            System.out.println("Ejecutando SQL: " + sql);

            int filas = stmt.executeUpdate(sql);
            if (filas > 0) {
                insertado = true;
                System.out.println("Obra con código " + codigo + " insertada correctamente.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DMObras.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DMObras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return insertado;
    }
    
    
    public boolean modificarObra(String codObra, String fechaTermina, int descuento, String descripcion) {
        boolean actualizado = false;
        Statement stmt = null;

        try {
            conexionDB = new ConexionDB();
            con = conexionDB.conex;
            stmt = con.createStatement();

            String sql = "UPDATE OBRAS SET "
                    + "FEC_TERMINA = '" + fechaTermina + "', "
                    + "DESCUENTO = " + descuento + ", "
                    + "DESCRIPCION = '" + descripcion + "' "
                    + "WHERE COD_OBRA = '" + codObra + "'";

            System.out.println("Ejecutando SQL: " + sql);

            int filas = stmt.executeUpdate(sql);
            if (filas > 0) {
                actualizado = true;
                System.out.println("Obra con código " + codObra + " actualizada correctamente.");
            } else {
                System.out.println("No se encontró ninguna obra con código " + codObra);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DMObras.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DMObras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return actualizado;
    }
    
    
    public static List<DSObras> QryCargaTodaInfoObras() throws SQLException {
        List<DSObras> todaInfoObras = new ArrayList<>();

        try {
            conexionDB = new ConexionDB();
            con = conexionDB.conex;
            if (con == null) {
                System.out.println("Error: conexión nula.");
                return todaInfoObras;
            }
            System.out.println("Conexión correcta a BD.");
        } catch (SQLException ex) {
            Logger.getLogger(DMObras.class.getName()).log(Level.SEVERE, null, ex);
            return todaInfoObras;
        }

        String sql = "SELECT COD_OBRA, DESCRIPCION, FEC_TERMINA, DESCUENTO FROM OBRAS ";
        try (PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            
            while (rs.next()) {
                String Codigo = rs.getString("COD_OBRA");
                String Descripcion = rs.getString("DESCRIPCION");
                String Fecha = rs.getString("FEC_TERMINA");
                int Descuento = rs.getInt("DESCUENTO");

                todaInfoObras.add(new DSObras(Codigo, Descripcion, Fecha, Descuento));
                System.out.println("Cargado Obra: " + Codigo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todaInfoObras;
    }

    
     public boolean codigoEnServicio(String codigo){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean asociado = false;
        
        try {
            conexionDB = new ConexionDB();
            con = conexionDB.conex; 

            // Consulta SQL para verificar si existe algún registro en SERVICIOS
            // con el COD_OBRA dado. Usamos LIMIT 1 para optimizar.
            String sql = "SELECT 1 FROM SERVICIOS WHERE COD_OBRA = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, codigo);
            rs = pstmt.executeQuery();
            
            // Si rs.next() es true, significa que se encontró al menos un servicio con ese código.
            if (rs.next()) {
                asociado = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DMServicios.class.getName()).log(Level.SEVERE, "Error al validar si el codigo de obra tiene servicios.", ex);
            asociado = true; 
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DModules.DMObras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return asociado;
    }
    
     
    public boolean eliminarObra(String codObra) {
        boolean eliminado = false;
        Statement stmt = null;

        try {
            conexionDB = new ConexionDB();
            con = conexionDB.conex;
            stmt = con.createStatement();

            String sql = "DELETE FROM OBRAS WHERE COD_OBRA = '" + codObra + "'";
            System.out.println("Ejecutando SQL: " + sql);

            int filas = stmt.executeUpdate(sql);
            if (filas > 0) {
                eliminado = true;
                System.out.println("Obra con código " + codObra + " eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna obra con código " + codObra);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DMObras.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DMObras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return eliminado;
    }
    
    
    public String obtenerCodPorDesc(String descripcion) {
        String cod = "";
        String sql = "SELECT COD_OBRA FROM OBRAS WHERE DESCRIPCION = ?";

        try (Connection con = new DBConexiones.ConexionDB().conex;
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, descripcion);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cod = rs.getString("COD_OBRA");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DMObras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cod;
}
    
}
