/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_Negocio;

import java.util.ArrayList;

/**
 *
 * @author AdmonGTI
 */
public class Persona {
    
     public String Uid;
    public String Nombre;
    public String Apellido;
    public String Direccion;
    public String Cedula;
    public String Producto;
    public String Nom_img;
    
    ArrayList <Producto> ListaProducto;
    //Constructor Parametrizado

    public Persona() {
    }
    
    
    //Constructor No Parametrizado

    public Persona(String Uid, String Nombre, String Apellido, String Direccion, String Cedula, String Producto, String Nom_img) {
        this.Uid = Uid;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Cedula = Cedula;
        this.Producto = Producto;
        this.Nom_img = Nom_img;
    }

  
    
    //Getters

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getCedula() {
        return Cedula;
    }

    public String getProducto() {
        return Producto;
    }

    public String getUid() {
        return Uid;
    }

    public ArrayList<Producto> getListaProducto() {
        return ListaProducto;
    }

    
    //Setters

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public void setUid(String Uid) {
        this.Uid = Uid;
    }

    public void setListaProducto(ArrayList<Producto> ListaProducto) {
        this.ListaProducto = ListaProducto;
    }

    public String getNom_img() {
        return Nom_img;
    }

    public void setNom_img(String Nom_img) {
        this.Nom_img = Nom_img;
    }
    
    
    
    
    
}
