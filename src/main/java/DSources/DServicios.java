/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSources;

public class DServicios {
    String NIF_Trab;
    String Cod_Obras;
    String Fecha;
    String Hora_Inicio;
    String Hora_Fin;

    public DServicios(String NIF_Trab, String Cod_Obras, String Fecha, String Hora_Inicio, String Hora_Fin) {
        this.NIF_Trab = NIF_Trab;
        this.Cod_Obras = Cod_Obras;
        this.Fecha = Fecha;
        this.Hora_Inicio = Hora_Inicio;
        this.Hora_Fin = Hora_Fin;
    }

    public String getNIF_Trab() {
        return NIF_Trab;
    }

    public void setNIF_Trab(String NIF_Trab) {
        this.NIF_Trab = NIF_Trab;
    }

    public String getCod_Obras() {
        return Cod_Obras;
    }

    public void setCod_Obras(String Cod_Obras) {
        this.Cod_Obras = Cod_Obras;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora_Inicio() {
        return Hora_Inicio;
    }

    public void setHora_Inicio(String Hora_Inicio) {
        this.Hora_Inicio = Hora_Inicio;
    }

    public String getHora_Fin() {
        return Hora_Fin;
    }

    public void setHora_Fin(String Hora_Fin) {
        this.Hora_Fin = Hora_Fin;
    }

    @Override
    public String toString() {
        return "DSServicios {" +
               "NIF_Trab='" + NIF_Trab + '\'' +
               ", Cod_Obras='" + Cod_Obras + '\'' +
               ", Fecha='" + Fecha + '\'' +
               ", Hora_Inicio='" + Hora_Inicio + '\'' +
               ", Hora_Fin='" + Hora_Fin + '\'' +
               '}';
    }
}
