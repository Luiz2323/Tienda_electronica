/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import Logica_Conexion.PersonaProvider;
import Logica_Negocio.Persona;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AdmonGTI
 */
public class HelperRegistro implements IHelperRegistro{
    
   @Override
    public void RegistrarPersonaNube(Persona objPer, int id, String producto) {
        
        boolean res = PersonaProvider.RetornarUid(objPer.getUid());
       if (!res) {
            try {
                Map<String, Object> datos = new HashMap<>();
                datos.put("uid", objPer.getUid());
                datos.put("Nombre", objPer.getNombre());
                datos.put("Apellido", objPer.getApellido());
                datos.put("Direccion", objPer.getDireccion());
                datos.put("Cedula", objPer.getCedula());
                datos.put("Productos", objPer.getProducto());
                datos.put("Nom_img", objPer.getNom_img());
                
                long inicio = System.currentTimeMillis();
                PersonaProvider.GuardarPersona("Persona", String.valueOf(id), datos);
                long fin = System.currentTimeMillis();
                HelperTiempo.RetornarTiempo(fin, inicio);
                System.out.println("Persona guardada con exito con id" + "\t" + id);
            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }
            
        }else{
            System.out.println("El uid ya existe ");
        }
    
}
    
    public static void RegistrarPersonaNubeI(Persona objper, int id, String producto)
    {
        HelperRegistro objHelperRegistro= new HelperRegistro();
        objHelperRegistro.RegistrarPersonaNube(objper, id, producto);
    }

  
}