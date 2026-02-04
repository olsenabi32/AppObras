package DModules; // Asegúrate de que el paquete sea correcto

import DBConexiones.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Clase que genera informes de JasperReports, manejando la conexión
 * a través de ConexionDB.
 */
public class ReportGenerator {
    
    // Logger para registrar errores
    private static final Logger logger = Logger.getLogger(ReportGenerator.class.getName());

    /**
     * Establece la conexión a la base de datos usando la clase ConexionDB.
     * @return Objeto Connection si la conexión es exitosa, null en caso contrario.
     */
    private static Connection getConnection() {
        Connection con = null;
        try {
            // Instanciar la clase de conexión y usar la propiedad 'conex'
            ConexionDB conexionDB = new ConexionDB();
            con = conexionDB.conex;
            
            // Si la conexión es null, mostramos un mensaje
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Error: La conexión a la base de datos es nula.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            }
            return con;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al establecer la conexión: " + e.getMessage(), "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Error al obtener la conexión desde ConexionDB", e);
            return null;
        }
    }

  
    public static void generarReporte(String nombreReporte, String fechaInicio, String fechaFin) {
        Connection con = null;

        try {
            // 1. Obtener Conexión
            con = getConnection();
            if (con == null) return; // Salir si la conexión falló
            
            // 2. Definir el Mapa de Parámetros
            Map<String, Object> parametros = new HashMap<>();
            // Las claves deben coincidir EXACTAMENTE con los nombres definidos en JasperReports Studio
            parametros.put("FechaInicio", fechaInicio);
            parametros.put("FechaFin", fechaFin);

            // 3. Ruta al Reporte Compilado (.jasper)
            // IMPORTANTE: AJUSTA LA RUTA donde se encuentran tus archivos .jasper
            String reportePath = "./Informes/" + nombreReporte + ".jasper";
            
            logger.log(Level.INFO, "Generando reporte: {0} con Fechas: {1} a {2}", new Object[]{nombreReporte, fechaInicio, fechaFin});

            // 4. Llenar el Reporte (Ejecuta la Query SQL)
            JasperPrint reporteLleno = JasperFillManager.fillReport(
                reportePath,
                parametros, 
                con // Usamos la conexión obtenida
            );

            // 5. Mostrar el Reporte
            JasperViewer viewer = new JasperViewer(reporteLleno, false);
            viewer.setTitle("Informe - " + nombreReporte);
            viewer.setVisible(true);

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Error al llenar el informe. Verifique la ruta del .jasper y los parámetros.", "Error de JasperReports", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Error de JasperReports: JRException", e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado al generar el informe: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Error inesperado al generar el reporte", e);
        } finally {
            // 6. Cerrar la Conexión
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    logger.log(Level.SEVERE, "Error al cerrar la conexión en ReportGenerator", e);
                }
            }
        }
    }
}