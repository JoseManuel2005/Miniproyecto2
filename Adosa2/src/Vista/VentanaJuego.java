/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Usuario
 */
public class VentanaJuego extends JFrame{
    private JLabel lblPuntuacion;
    private JButton btnVida1;
    private JButton btnVida2;
    private JButton btnVida3;
   
    
    
    Container contenedorppal;
    
    
    
    public VentanaJuego()  {
        iniciarComponentes();
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void iniciarComponentes(){
        lblPuntuacion = new JLabel("Puntuacion 000"); //Modificar esto
        lblPuntuacion.setBounds(10, 20, 100, 10);
        
        
        btnVida1 = new JButton();
        btnVida1.setEnabled(false);
        btnVida1.setBackground(Color.green);
        btnVida1.setBounds(500, 20, 30, 30);
      
        
        btnVida2 = new JButton();
        btnVida2.setEnabled(false);
        btnVida2.setBackground(Color.green);
        btnVida2.setBounds(550, 20, 30, 30);
        
        btnVida3 = new JButton();
        btnVida3.setEnabled(false);
        btnVida3.setBackground(Color.green);
        btnVida3.setBounds(600, 20, 30, 30);
        
        contenedorppal = getContentPane();
        contenedorppal.setLayout(null);
        
        contenedorppal.add(lblPuntuacion);
        contenedorppal.add(btnVida1);
        contenedorppal.add(btnVida2);
        contenedorppal.add(btnVida3);

        
    }
}
