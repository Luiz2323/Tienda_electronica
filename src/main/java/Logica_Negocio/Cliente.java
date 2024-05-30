/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica_Negocio;

/**
 *
 * @author AdmonGTI
 */
public class Cliente extends Usuario {

    public Cliente() {
    }

    public Cliente(String Usu, String Contraseña) {
        super(Usu, Contraseña);
    }

    @Override
    public boolean LogOn(String usuario, String contraseña) {
       
        boolean res = true; 
        
        String comprobarusuario = Helpers.HelperCifrado.CifrarSHA256(getUsu());
        String comprobarcontra = Helpers.HelperCifrado.CifrarSHA256(getContra());
        System.out.println("usu ci abs " + "\t" + comprobarusuario);
        System.out.println("usu con abs" + "\t" + comprobarcontra);
        
        if (comprobarusuario.compareTo(usuario) == 0 && comprobarcontra.compareTo(contraseña) == 0){ 
        return res; 
        
    }else {
    
    return !res;
        }
    }
}

