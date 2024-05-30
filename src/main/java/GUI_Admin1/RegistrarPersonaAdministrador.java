/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_Admin1;

import GUI_Admin1.MenuAdministrador;
import Helpers.HelperRegistro;
import Helpers.HelperValidacion;
import Logica_Conexion.Conexion;
import Logica_Negocio.Persona;
import Logica_Negocio.Producto;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author Santiago Lopez
 */
public class RegistrarPersonaAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarPersona
     */
    public ArrayList<Producto> lsproductos = new ArrayList<>();
    public ArrayList<Persona> lspersona = new ArrayList<>();

    Persona objper;
    String producto = "";
    int numglobal = 0;
    int band = 0;
    public String pathc;
    public String pathc2;
    public String s;

    public RegistrarPersonaAdministrador() {
        initComponents();
        this.setSize(500, 500);
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton4.setOpaque(false);
        jButton4.setContentAreaFilled(false);
        jTextField5.setVisible(false);
        jTextField6.setVisible(false);
        jTextField7.setVisible(false);
        jTextField8.setVisible(false);
        jTextField9.setVisible(false);
        jButton4.setVisible(false);
        jLabel12.setVisible(false);

        Path currentRelativePath = Paths.get("");
        s = currentRelativePath.toAbsolutePath().toString();
        pathc = s + "\\Images\\" + "Registro_Persona" + ".jpg";
        pathc2 = s + "\\Images\\" + "Registro_Producto" + ".jpg";
        establecerImagen();

    }

    public int RegistrarNumeroProductos() {
        String num_pro = jTextField4.getText();
        int res1 = HelperValidacion.ValidarVacio(num_pro);
        int numero = 0;
        int band = 0;

        if (res1 == 0) {
            try {
                numero = Integer.parseInt(num_pro.trim());
            } catch (NumberFormatException e) {
                jTextField4.setBorder(new LineBorder(Color.RED, 2));
                System.out.println("Digite un numero valido" + e.getMessage());
                band = 1;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo Vacio!");
            jTextField4.setBorder(new LineBorder(Color.RED, 2));
            band = 1;
        }

        if (band == 0) {
            int res = HelperValidacion.ValidarCantidadRango(numero);

            if (res == 1 && band == 0) {
                numglobal = numero;
                numero = 0;
                jTextField4.setBorder(new LineBorder(Color.BLACK, 1));
                return 1;
            } else {
                jTextField4.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "El numero no se encuentra en el rango");
                return 0;
            }
        }
        return 0;
    }

    public void RegistarProducto() {

        String nombre = jTextField1.getText();
        String marca = jTextField2.getText();
        String serial = jTextField3.getText();

        int res, res1, res2;

        res = Helpers.HelperValidacion.ValidarTodo(nombre);
        res1 = Helpers.HelperValidacion.ValidarTodo(marca);
        res2 = Helpers.HelperValidacion.ValidarTodoSerial(serial);

        if (res == 0 && res1 == 0 && res2 == 0) {

            jTextField1.setBorder(new LineBorder(Color.BLACK, 1));
            jTextField2.setBorder(new LineBorder(Color.BLACK, 1));
            jTextField3.setBorder(new LineBorder(Color.BLACK, 1));

            Producto objproducto = new Producto(nombre, marca, serial);
            lsproductos.add(objproducto);
            band++;

            JOptionPane.showMessageDialog(null, "Registrando producto" + "\t" + band + "de" + numglobal);

            if (band == numglobal) {

                System.out.println("Alcanzo el Limite de registro");

                jTextField5.setVisible(true);
                jTextField6.setVisible(true);
                jTextField7.setVisible(true);
                jTextField8.setVisible(true);
                jTextField9.setVisible(true);
                jTextField1.setVisible(false);
                jTextField2.setVisible(false);
                jTextField3.setVisible(false);
                jButton2.setVisible(false);

            }
        } else {
            if (res >= 1) {
                jTextField1.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo nombre");
            }
            if (res1 >= 1) {
                jTextField2.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo marca ");
            }
            if (res2 >= 1) {
                jTextField3.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campos serial");
            }
        }

    }

    public void RegistrarPersona() {

        String nombre = jTextField5.getText();
        String apellido = jTextField6.getText();
        String cedula = jTextField7.getText();
        String direccion = jTextField8.getText();
        String nom_img = jTextField9.getText();

        int res, res1, res2, res3, res4;

        res = Helpers.HelperValidacion.ValidarTodo(nombre);
        res1 = Helpers.HelperValidacion.ValidarTodo(apellido);
        res2 = Helpers.HelperValidacion.ValidarTodoLetra(cedula);
        res3 = Helpers.HelperValidacion.ValidarTodoDireccion(direccion);
        res4 = Helpers.HelperValidacion.ValidarTodoSerial(nom_img);

        if (res == 0 && res1 == 0 && res2 == 0 && res3 == 0 && res4 == 0) {

            for (int i = 0; i < lsproductos.size(); i++) {
                producto += lsproductos.get(i).getNombre() + "," + lsproductos.get(i).getMarca() + "," + lsproductos.get(i).getSerial() + ";";

            }

            int id = (int) (Math.random() * 100000);

            objper = new Persona(String.valueOf(id), nombre, apellido, direccion, cedula, producto, nom_img);
            lspersona.add(objper);
            objper.setListaProducto(lsproductos);
            HelperRegistro.RegistrarPersonaNubeI(objper, id, producto);
            producto = "";

            jTextField5.setVisible(false);
            jTextField6.setVisible(false);
            jTextField7.setVisible(false);
            jTextField8.setVisible(false);
            jTextField9.setVisible(false);
            jButton1.setVisible(false);
            jButton4.setVisible(true);
            jLabel12.setVisible(true);

            jLabel12.setText("Registro exitoso, El id del cliente es:" + "\t" + id);
        } else {
            if (res >= 1) {
                jTextField5.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo nombre");
            }
            if (res1 >= 1) {
                jTextField6.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campo apellido ");
            }
            if (res2 >= 1) {
                jTextField7.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campos cedula");
            }
            if (res3 >= 1) {
                jTextField8.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campos direccion");
            }
            if (res4 >= 1) {
                jTextField9.setBorder(new LineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Revise el campos nombre imagen");
            }
        }

    }

    public void establecerImagen() {

        Image img = null;
        try {
            File file = new File(pathc);
            img = ImageIO.read(new File(pathc));
            //5. Setear la imagen al JLabel
            jLabel13.setIcon(new ImageIcon(img));
        } catch (IOException ioexception) {
            System.err.println(ioexception);
        }
        Image img2 = null;
        try {
            File file2 = new File(pathc2);
            img2 = ImageIO.read(new File(pathc2));
            //5. Setear la imagen al JLabel
            jLabel14.setIcon(new ImageIcon(img2));
        } catch (IOException ioexception) {
            System.err.println(ioexception);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Persona Administrador");
        getContentPane().setLayout(null);

        jButton4.setToolTipText("");
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(80, 440, 80, 20);

        jTextField1.setBackground(new java.awt.Color(16, 54, 147));
        jTextField1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(250, 127, 150, 20);

        jTextField2.setBackground(new java.awt.Color(16, 54, 147));
        jTextField2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(245, 160, 155, 20);

        jTextField3.setBackground(new java.awt.Color(16, 54, 147));
        jTextField3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(null);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(245, 193, 155, 20);

        jSeparator1.setBackground(new java.awt.Color(0, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(0, 204, 204));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 270, 490, 13);

        jTextField4.setBackground(new java.awt.Color(16, 54, 147));
        jTextField4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setText(" ");
        jTextField4.setBorder(null);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(247, 95, 43, 18);

        jTextField5.setBackground(new java.awt.Color(16, 54, 147));
        jTextField5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setBorder(null);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5);
        jTextField5.setBounds(207, 320, 154, 20);

        jTextField6.setBackground(new java.awt.Color(16, 54, 147));
        jTextField6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setBorder(null);
        getContentPane().add(jTextField6);
        jTextField6.setBounds(207, 343, 154, 20);

        jTextField7.setBackground(new java.awt.Color(16, 54, 147));
        jTextField7.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setBorder(null);
        getContentPane().add(jTextField7);
        jTextField7.setBounds(207, 368, 154, 20);

        jTextField8.setBackground(new java.awt.Color(16, 54, 147));
        jTextField8.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setBorder(null);
        getContentPane().add(jTextField8);
        jTextField8.setBounds(207, 390, 154, 20);

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 204));
        jButton1.setActionCommand("Registrar");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 433, 80, 30);

        jButton2.setBackground(new java.awt.Color(0, 0, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 204, 204));
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(305, 227, 90, 30);

        jButton3.setBackground(new java.awt.Color(0, 0, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 204, 204));
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(297, 92, 80, 28);

        jTextField9.setBackground(new java.awt.Color(16, 54, 147));
        jTextField9.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setBorder(null);
        getContentPane().add(jTextField9);
        jTextField9.setBounds(207, 415, 154, 20);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 204, 204));
        jLabel12.setText("jLabel12");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(60, 550, 380, 16);
        getContentPane().add(jLabel14);
        jLabel14.setBounds(0, 0, 490, 260);

        jLabel13.setBackground(new java.awt.Color(16, 54, 147));
        jLabel13.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel13);
        jLabel13.setBounds(0, 0, 490, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        RegistarProducto();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RegistrarPersona();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int retorno = RegistrarNumeroProductos();
        if (retorno == 1) {
            jTextField4.setVisible(false);
            jButton3.setVisible(false);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        MenuAdministrador menu = new MenuAdministrador();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarPersonaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarPersonaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarPersonaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarPersonaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarPersonaAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
