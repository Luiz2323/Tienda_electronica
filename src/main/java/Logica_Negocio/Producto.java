/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_Negocio;

/**
 *
 * @author AdmonGTI
 */
public class Producto {
    
    public String Nombre;
    public String Marca;
    public String Serial;
    
    
    //Constructor No Parametrizado

    public Producto() {
    }
    
    //Constructor Parametrizado

    public Producto(String Nombre, String Marca, String Serial) {
        this.Nombre = Nombre;
        this.Marca = Marca;
        this.Serial = Serial;
    }

    
    //Getters

    public String getNombre() {
        return Nombre;
    }

    public String getMarca() {
        return Marca;
    }

    public String getSerial() {
        return Serial;
    }
    
    //Setters

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setSerial(String Serial) {
        this.Serial = Serial;
    }
    
    
    
    
    
    
    
}
