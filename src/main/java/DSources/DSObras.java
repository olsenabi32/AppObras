/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSources;


public class DSObras {
    String Codigo;
    String Descripcion;
    String Fecha_Termina;
    int Descuento;
    
    
     public DSObras(String Codigo, String Descripcion, String Fecha_Termina, int Descuento) {
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
        this.Fecha_Termina= Fecha_Termina;
        this.Descuento= Descuento;
    }

    public String getCodigo() {
        return Codigo;
    }

    public int getDescuento() {
        return Descuento;
    }

    public String getFecha_Termina() {
        return Fecha_Termina;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }

    public void setFecha_Termina(String Fecha_Termina) {
        this.Fecha_Termina = Fecha_Termina;
    }

    

    public String getDescripcion() {
        return Descripcion;
    }
    
   

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
   
    @Override
    public String toString() {
    return "DSObras {" +
           "Codigo='" + Codigo + '\'' +
           ", Descripcion='" + Descripcion + '\'' +
           ", Fecha_Termina=" + Fecha_Termina +
           ", Descuento=" + Descuento +
           '}';
}

        
}
