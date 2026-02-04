/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DModules;

import DSources.DServicioDetallado;
import DBConexiones.ConexionDB;
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
public class DMServicios {
    
   
    private static ConexionDB conexionDB;
    private static final Logger logger = Logger.getLogger(DMServicios.class.getName());
    
    
    public static boolean insertarServicio(String nifTrab, String codObra, String fecha, String horaEnt, String horaSal) throws SQLException {
        boolean insertado = false;
        Connection con = null;
        Statement stmt = null;

        try {
            conexionDB = new ConexionDB();
            con = conexionDB.conex;
            stmt = con.createStatement();
            
            String sql = "INSERT INTO SERVICIOS (NIF_TRAB, COD_OBRA, FECHA, HORA_ENT, HORA_SAL) VALUES ("
                    + "'" + nifTrab + "', "
                    + "'" + codObra + "', "
                    + "'" + fecha + "', "
                    + "'" + horaEnt + "', "
                    + "'" + horaSal + "')";

            System.out.println("Ejecutando SQL: " + sql);

            int filas = stmt.executeUpdate(sql);
            if (filas > 0) {
                insertado = true;
                System.out.println("Servicio para el NIF " + nifTrab + " insertado correctamente.");
            }

        } finally {
            // Este bloque maneja el cierre de recursos internamente para no interferir con el throw
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "Error al cerrar conexión", ex);
            }
        }

        return insertado;
    }
    
    public static boolean existeSuperposicion(String nifTrab, String fecha, String horaEntNueva, String horaSalNueva) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean solapado = false;
        
        try {
            conexionDB = new ConexionDB();
            con = conexionDB.conex;

            // Lógica de Solapamiento: [A, B] y [C, D] se solapan si A <= D AND C <= B
            String sql = "SELECT 1 FROM SERVICIOS "
                    + "WHERE NIF_TRAB = ? "
                    + "  AND FECHA = ? "
                    + "  AND ? <= HORA_SAL "   // Nueva Entrada <= Hora Salida Existente
                    + "  AND ? >= HORA_ENT";   // Nueva Salida >= Hora Entrada Existente

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nifTrab);
            pstmt.setString(2, fecha);
            pstmt.setString(3, horaEntNueva);
            pstmt.setString(4, horaSalNueva);

            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                solapado = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DMServicios.class.getName()).log(Level.SEVERE, "Error al validar superposición.", ex);
            throw ex; // Relanzar la excepción
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
        
        return solapado;
    }
    
    
    public static List<DServicioDetallado> QryCargaServiciosDetallados() throws SQLException {
    List<DServicioDetallado> lista = new ArrayList<>();
    String sql = "SELECT T.NOMBRE, O.DESCRIPCION, S.FECHA, S.HORA_ENT, S.HORA_SAL " +
                 "FROM SERVICIOS S " +
                 "JOIN TRABAJADORES T ON S.NIF_TRAB = T.NIF " +
                 "JOIN OBRAS O ON S.COD_OBRA = O.COD_OBRA"; 

    try (Connection con = new ConexionDB().conex;
         PreparedStatement st = con.prepareStatement(sql);
         ResultSet rs = st.executeQuery()) {
        while (rs.next()) {
            lista.add(new DServicioDetallado(
                rs.getString("NOMBRE"), 
                rs.getString("DESCRIPCION"),
                rs.getString("FECHA"), 
                rs.getString("HORA_ENT"), 
                rs.getString("HORA_SAL")
            ));
        }
    }
        return lista;
    }
    
    public static boolean eliminarServicio(String nif, String cod, String fecha, String hora) throws SQLException {
        String sql = "DELETE FROM SERVICIOS WHERE NIF_TRAB=? AND COD_OBRA=? AND FECHA=? AND HORA_ENT=?";
        try (Connection con = new DBConexiones.ConexionDB().conex;
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nif);
            ps.setString(2, cod);
            ps.setString(3, fecha);
            ps.setString(4, hora);
            return ps.executeUpdate() > 0;
        }
    }
    
}
