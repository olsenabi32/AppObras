package DSources;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class DServicioDetallado {
    
    //usare esta clase para poder crear un array de estos objetos para cargar la tabla
    
    public String nombreTrabajador, descripObra, fecha, horaInicio, horaFin;

    public DServicioDetallado(String nombreTrabajador, String descripObra, String fecha, String horaInicio, String horaFin) {
        this.nombreTrabajador = nombreTrabajador;
        this.descripObra = descripObra;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public String getDescripObra() {
        return descripObra;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public void setDescripObra(String descripObra) {
        this.descripObra = descripObra;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
    
    
    
}
