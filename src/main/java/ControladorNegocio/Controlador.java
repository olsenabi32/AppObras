/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorNegocio;

/**
 *
 * @author eromero
 */
public class Controlador {
    public record Usuario(String nif,String Nombre,Integer Tipo){
    
    }
    boolean Usuid = false;
    
    public boolean getUsuid(){
       return Usuid;
    }
    
    public void setUsuid(boolean estado){
        this.Usuid=estado;
    }
    
    
    
}
