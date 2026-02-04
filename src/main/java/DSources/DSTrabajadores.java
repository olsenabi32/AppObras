/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSources;

/**
 *
 * @author eromero
 */
public class DSTrabajadores {
    String Nif;
    String Descripcion;
    String Nombre;
    String Poblacion;
    int PVP_Hora;
    int Tipo;
    
    public DSTrabajadores(String Nif, String Descripcion, String Nombre, String Poblacion, int PVP_Hora, int Tipo) {
        this.Nif = Nif;
        this.Descripcion = Descripcion;
        this.Nombre = Nombre;
        this.Poblacion = Poblacion;
        this.PVP_Hora = PVP_Hora;
        this.Tipo= Tipo;
    }
    
    public String getNif() {
        return Nif;
    }

    public String getDescripcion() {
        return Descripcion;
    }
    
    public String getNombre(){
        return Nombre;
    }
    
    public String getPoblacion(){
        return Poblacion;
    }
    
    public int getPVP_Hora(){
        return PVP_Hora;
    }

    public int getTipo(){
        return Tipo;
    }
        
    public void setNif(String Nif) {
        this.Nif = Nif;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    
    public void setPoblacion(String Poblacion){
        this.Poblacion = Poblacion;
    }
    
    public void setPVP_Hora(int PVP_Hora){
        this.PVP_Hora = PVP_Hora;
    }
    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }
    
    @Override
    public String toString() {
        return "CargaComboTrabajadores{" + "Nif=" + Nif + ", Descripcion=" + Descripcion + ", Tipo: " + Tipo + '}';
    }    
}
