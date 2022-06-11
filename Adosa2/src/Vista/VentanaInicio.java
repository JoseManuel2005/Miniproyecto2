/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Vista.VentanaJuego;
import Vista.VentanaUtilidad;
import Vista.Instrucciones.VentanaInstrucciones1;

/**
 *
 * @author Usuario
 */
public class VentanaInicio extends JFrame{
    private JButton btnComoJugar;
    private JButton btnJugar;
    private JButton btnUtilidad;
    private Container contenedorppal;
    private JPanel panelBotones;
    private JPanel panelPrincipal;


    public VentanaInicio(){
        iniciarComponentes();
        setSize(500,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Adosa2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void iniciarComponentes(){
        btnComoJugar = new JButton("¿Como Jugar?");
        
        //btnComoJugar.setBounds(200, 200, 10, 10);
        btnJugar = new JButton("Jugar");
        btnUtilidad = new JButton("Para que sirve");
        
        contenedorppal = getContentPane();
        contenedorppal.setLayout(null);
        
        /*
        contenedorppal.add(btnComoJugar);
        contenedorppal.add(btnComoJugar);*/
        
        
        
        panelBotones = new JPanel();
        //panelBotones.setLayout(new FlowLayout());
        contenedorppal = getContentPane();
        
        panelPrincipal = new JPanel();
        
        
        panelBotones.add(btnComoJugar);
        panelBotones.add(btnJugar);
        panelBotones.add(btnUtilidad);
        panelPrincipal.add(panelBotones);
       
        contenedorppal.add(panelPrincipal);
        panelPrincipal.setBounds(20, 160, 450, 40);
        btnJugar.addMouseListener(new ManejadorEventos());
        btnComoJugar.addMouseListener(new ManejadorEventos());
        btnUtilidad.addMouseListener(new ManejadorEventos());

        
    }
    
     class ManejadorEventos extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == btnJugar) {
                dispose();
                VentanaJuego ventanaJuego = new VentanaJuego();
                ventanaJuego.setVisible(true);
            }else if (e.getSource() == btnComoJugar) {
                dispose();
                VentanaInstrucciones1 ventanaInstrucciones = new VentanaInstrucciones1();
                ventanaInstrucciones.setVisible(true);
            }else if (e.getSource() == btnUtilidad){
                dispose();
                VentanaUtilidad ventanaUtilidad= new VentanaUtilidad();
                ventanaUtilidad.setVisible(true);
            }
        }
     
     
     }
    
}
