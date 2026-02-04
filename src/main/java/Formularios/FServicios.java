/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import DModules.DMObras;
import DModules.DMServicios;
import DSources.DSObras;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FServicios extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FServicios.class.getName());
    List<DSObras> ALDSObras;
    
    public FServicios() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NifTrabajador = new javax.swing.JTextField();
        ComboxDescripObra = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Dia = new javax.swing.JTextField();
        Mes = new javax.swing.JTextField();
        Año = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Hora_Entrada = new javax.swing.JTextField();
        Hora_Salida = new javax.swing.JTextField();
        BotonInsertar = new javax.swing.JButton();
        BotonAtras = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menu Insertar Servicios");

        jLabel2.setText("NIF Trabajador:");

        jLabel3.setText("Descripcion de Obra:");

        NifTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NifTrabajadorActionPerformed(evt);
            }
        });

        ComboxDescripObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboxDescripObraActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Fecha:");

        jLabel5.setText("Dia:");

        jLabel6.setText("Mes:");

        jLabel7.setText("Año:");

        jLabel8.setText("Hora Entrada: ");

        jLabel9.setText("Hora Salida:");

        BotonInsertar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonInsertar.setText("Insertar");
        BotonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInsertarActionPerformed(evt);
            }
        });

        BotonAtras.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonAtras.setText("Atrás");
        BotonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAtrasActionPerformed(evt);
            }
        });

        jLabel10.setText("Ejemplo: 01 03 2025");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyyMd"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(BotonAtras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BotonInsertar)
                .addGap(154, 154, 154))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(20, 20, 20)
                                .addComponent(Hora_Salida, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Hora_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(239, 239, 239)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NifTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ComboxDescripObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)))
                                .addComponent(Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Año, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NifTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboxDescripObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(Dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Hora_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Hora_Salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(BotonInsertar)
                .addGap(7, 7, 7)
                .addComponent(BotonAtras)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // --- MÉTODOS DE UTILIDAD ---
    
    private void limpiarCampos() {
        this.NifTrabajador.setText("");
        this.Año.setText("");
        this.Mes.setText("");
        this.Dia.setText("");
        this.Hora_Entrada.setText("");
        this.Hora_Salida.setText("");
        
        // Selecciona el primer elemento del ComboBox (si existe)
        if (this.ComboxDescripObra.getItemCount() > 0) {
            this.ComboxDescripObra.setSelectedIndex(0); 
        }
    }
    
    private boolean validarCamposServicio(String nifTrab, String codObra, String año, String mes, String dia, String horaEnt, String horaSal) {
        
        // --- 1. VALIDACIÓN DE CAMPOS VACÍOS Y LONGITUDES ---
        if (nifTrab.isEmpty() || codObra.isEmpty() || año.isEmpty() || mes.isEmpty() || dia.isEmpty() || horaEnt.isEmpty() || horaSal.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos (NIF, Obra, Fecha, Horas) deben estar llenos.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (año.length() != 4 || mes.length() != 2 || dia.length() != 2 || horaEnt.length() != 4 || horaSal.length() != 4) {
            JOptionPane.showMessageDialog(this, "Las longitudes deben ser: Año (4), Mes (2), Día (2), Horas (4).", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        int iAño, iMes, iDia, iHoraEnt, iHoraSal;

        // --- 2. CONVERSIÓN Y VALIDACIÓN DE RANGOS BÁSICOS ---
        try {
            iAño = Integer.parseInt(año);
            iMes = Integer.parseInt(mes);
            iDia = Integer.parseInt(dia);
            iHoraEnt = Integer.parseInt(horaEnt);
            iHoraSal = Integer.parseInt(horaSal);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Las fechas y horas deben contener solo números.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validación Año (Máximo 2025)
        if (iAño < 1900 || iAño > 2025) { 
            JOptionPane.showMessageDialog(this, "El año debe ser un valor válido y no puede ser posterior a 2025.", "Error de Año", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validación Mes
        if (iMes < 1 || iMes > 12) {
            JOptionPane.showMessageDialog(this, "El mes debe estar entre 01 y 12.", "Error de Mes", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // --- 3. VALIDACIÓN DE DÍAS DEL MES ---
        
        if (iMes == 4 || iMes == 6 || iMes == 9 || iMes == 11) { // 30 días
            if (iDia < 1 || iDia > 30) {
                JOptionPane.showMessageDialog(this, "El mes " + iMes + " solo tiene 30 días.", "Error de Día", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else if (iMes == 2) { // Febrero
            boolean bisiesto = (iAño % 4 == 0 && iAño % 100 != 0) || (iAño % 400 == 0);
            int maxDias = bisiesto ? 29 : 28;
            if (iDia < 1 || iDia > maxDias) {
                JOptionPane.showMessageDialog(this, "Febrero de " + iAño + " solo tiene hasta " + maxDias + " días.", "Error de Día", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else { // 31 días
            if (iDia < 1 || iDia > 31) {
                JOptionPane.showMessageDialog(this, "El mes " + iMes + " solo tiene 31 días.", "Error de Día", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        // --- 4. VALIDACIÓN DE HORAS (Formato HHMM y Lógica HORA_ENT < HORA_SAL) ---
        
        int hEnt = iHoraEnt / 100; 
        int mEnt = iHoraEnt % 100; 
        int hSal = iHoraSal / 100; 
        int mSal = iHoraSal % 100; 

        // Validación de formato HH:MM
        if (hEnt < 0 || hEnt > 23 || mEnt < 0 || mEnt > 59 || hSal < 0 || hSal > 23 || mSal < 0 || mSal > 59) {
            JOptionPane.showMessageDialog(this, "El formato de la hora debe ser HHMM y los valores válidos (0000 a 2359).", "Error de Hora", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validación Lógica: Hora de Entrada < Hora de Salida
        if (iHoraEnt >= iHoraSal) {
            JOptionPane.showMessageDialog(this, "La Hora de Entrada debe ser estrictamente menor que la Hora de Salida.", "Error de Lógica", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    
    private void BotonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAtrasActionPerformed
        // TODO add your handling code here:
        dispose();
        FMenPrincipal fm = new FMenPrincipal();
        fm.setVisible(true);
        
    }//GEN-LAST:event_BotonAtrasActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    
    
    // Inicializar el ArrayList de Obras (asumiendo que está declarado globalmente)
    ALDSObras = new ArrayList<>(); 
    
    // 2. Ejecutar la Query
    try {
        // Obtener la lista de objetos DSObras completos
        ALDSObras = DMObras.QryCargaTodaInfoObras();
    } catch (SQLException ex) {
        // Usa el logger de tu clase actual (reemplaza 'TuClaseDeFormulario' si es necesario)
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error al cargar información de Obras", ex);
    }
    
    System.out.println("Se ha cargado el Array List de Obras");
    
    // 3. Limpiar el ComboBox (opcional, pero recomendable al cargar)
    this.ComboxDescripObra.removeAllItems();
    
    // 4. Recorrer la lista y añadir cada objeto DSObras al ComboBox
    for (DSObras cursor : ALDSObras)
       {
           String descripcion= cursor.getDescripcion();
           this.ComboxDescripObra.addItem(descripcion); 
       }
    }//GEN-LAST:event_formWindowActivated

    private void BotonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInsertarActionPerformed
        // TODO add your handling code here:
        // 1. OBTENER LOS VALORES DEL FORMULARIO
        String nifTrab = this.NifTrabajador.getText().trim();
        String horaEnt = this.Hora_Entrada.getText().trim();
        String horaSal = this.Hora_Salida.getText().trim();

        String año = this.Año.getText().trim();
        String mes = this.Mes.getText().trim();
        String dia = this.Dia.getText().trim();
        String fecha = año + mes + dia; 

        // Obtener el COD_OBRA mediante la búsqueda en la lista ALDSObras
        String codObra = "";
        
        if (ALDSObras != null && !ALDSObras.isEmpty() && this.ComboxDescripObra.getSelectedIndex() != -1) {
            String descSeleccionada = (String) this.ComboxDescripObra.getSelectedItem();
            
            for (DSObras obra : ALDSObras) {
                if (obra.getDescripcion().equals(descSeleccionada)) {
                    codObra = obra.getCodigo();
                    break;
                }
            }
        }

        // 2. LLAMAR AL MÉTODO DE VALIDACIÓN DE FORMATO/RANGO
        if (!validarCamposServicio(nifTrab, codObra, año, mes, dia, horaEnt, horaSal)) {
            return; 
        }


        try {
            if (DMServicios.existeSuperposicion(nifTrab, fecha, horaEnt, horaSal)) {
                JOptionPane.showMessageDialog(this, 
                    "El trabajador ya está realizando un servicio que se solapa con este horario. No se puede insertar.", 
                    "Error de Horario", JOptionPane.ERROR_MESSAGE);
                return; 
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error de BD al validar superposición.", ex);
            JOptionPane.showMessageDialog(this, "Error de BD al verificar horarios: " + ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            return;
        }

      
        
        try {
            boolean exito = DMServicios.insertarServicio(nifTrab, codObra, fecha, horaEnt, horaSal);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Servicio insertado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos(); // Limpiar campos tras el éxito
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo insertar el servicio (clave duplicada o referencia inválida).", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex){
            logger.log(Level.SEVERE, "Error al intentar insertar el servicio en la BD.", ex);
            JOptionPane.showMessageDialog(this, "Error de base de datos: " + ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_BotonInsertarActionPerformed

    private void NifTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NifTrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NifTrabajadorActionPerformed

    private void ComboxDescripObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboxDescripObraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboxDescripObraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FServicios().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Año;
    private javax.swing.JButton BotonAtras;
    private javax.swing.JButton BotonInsertar;
    private javax.swing.JComboBox<String> ComboxDescripObra;
    private javax.swing.JTextField Dia;
    private javax.swing.JTextField Hora_Entrada;
    private javax.swing.JTextField Hora_Salida;
    private javax.swing.JTextField Mes;
    private javax.swing.JTextField NifTrabajador;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
