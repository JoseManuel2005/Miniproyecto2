/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Modelo.*;
/**
 *
 * @author Usuario
 */
public class VentanaJuego extends JFrame{
    private JLabel lblPuntuacion;
    private JButton btnVida1;
    private JButton btnVida2;
    private JButton btnVida3;
    private JLabel  lblCuadrado1;
    private JLabel  lblCuadrado2;
    private JLabel  lblCuadrado3;
    private JLabel  lblCuadrado4;
    private JLabel  lblCuadrado5;
    private JLabel  lblCuadrado6;
    private JLabel  lblCuadrado7;
    private JLabel  lblCuadrado8;
    private JButton btnAdivinar;
    private ImageIcon ImgAdivinar;
    
    Cuadrado uno = new Cuadrado(true);
    Cuadrado dos = new Cuadrado(true);
    
    
    fondoJuego fondo = new fondoJuego();
    
    
    Container contenedorppal;
    
    
    
    public VentanaJuego()  {
        this.setContentPane(fondo);
        iniciarComponentes();
        setSize(1100,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void iniciarComponentes(){
        
        lblPuntuacion = new JLabel("Puntuacion 000"); //Modificar esto
        lblPuntuacion.setBounds(10, 10, 100, 20);
        
      
        lblCuadrado1 = new JLabel(new ImageIcon("src/Imagenes/ventanaJuego/" + uno.getImagen() + ".PNG"));
        lblCuadrado1.setBounds(500, 50, 100, 100);
        
        System.out.println(uno.getImagen());
        lblCuadrado2 = new JLabel(new ImageIcon("src/Imagenes/ventanaJuego/" + dos.getImagen() + ".PNG"));
        lblCuadrado2.setBounds(500, 150, 100, 100);
        
        lblCuadrado3 = new JLabel(new ImageIcon("src/Imagenes/ventanaJuego/3.PNG"));
        lblCuadrado3.setBounds(500, 280, 100, 100);
        
        lblCuadrado4 = new JLabel(new ImageIcon("src/Imagenes/ventanaJuego/"));
        lblCuadrado4.setBounds(500, 380, 100, 100);
        
        lblCuadrado5 = new JLabel(new ImageIcon("src/Imagenes/ventanaJuego/Tierra.PNG"));
        lblCuadrado5.setBounds(610, 215, 100, 100);
        
        lblCuadrado6 = new JLabel(new ImageIcon("src/Imagenes/ventanaJuego/Abano.PNG"));
        lblCuadrado6.setBounds(710, 215, 100, 100);
        
        
        lblCuadrado7 = new JLabel(new ImageIcon("src/Imagenes/ventanaJuego/Rojo.PNG"));
        lblCuadrado7.setBounds(390, 215, 100, 100);
        
        lblCuadrado8 = new JLabel(new ImageIcon("src/Imagenes/ventanaJuego/Madera.PNG"));
        lblCuadrado8.setBounds(290, 215, 100, 100);
        
        ImgAdivinar = new ImageIcon("src/Imagenes/ventanaJuego/boton.PNG");
        
        
        btnAdivinar = new JButton();
        btnAdivinar.setBounds(900, 350, 100, 100);
        btnAdivinar.setIcon(new ImageIcon(ImgAdivinar.getImage().getScaledInstance(btnAdivinar.getWidth() , btnAdivinar.getHeight(), Image.SCALE_SMOOTH)));
        
        
        //btnPrueba = new JButton("Prueba");
        //btnPrueba.setBounds(550, 100, 100, 100);
        
        
        btnVida1 = new JButton();
        btnVida1.setEnabled(false);
        btnVida1.setBackground(Color.green);
        btnVida1.setBounds(900, 20, 30, 30);
      
        
        btnVida2 = new JButton();
        btnVida2.setEnabled(false);
        btnVida2.setBackground(Color.green);
        btnVida2.setBounds(950, 20, 30, 30);
        
        btnVida3 = new JButton();
        btnVida3.setEnabled(false);
        btnVida3.setBackground(Color.green);
        btnVida3.setBounds(1000, 20, 30, 30);
        
        contenedorppal = getContentPane();
        contenedorppal.setLayout(null);
        
        contenedorppal.add(lblPuntuacion);
        contenedorppal.add(btnVida1);
        contenedorppal.add(btnVida2);
        contenedorppal.add(btnVida3);
        contenedorppal.add(lblCuadrado1);
        //contenedorppal.add(lblCuadrado2);
        contenedorppal.add(lblCuadrado3);
        //contenedorppal.add(lblCuadrado4);
        contenedorppal.add(lblCuadrado5);
        //contenedorppal.add(lblCuadrado6);
        contenedorppal.add(lblCuadrado7);
        //contenedorppal.add(lblCuadrado8);
        contenedorppal.add(btnAdivinar);
        
        btnAdivinar.addMouseListener(new manejadorEventos());
        
    }
    
    class manejadorEventos extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == btnAdivinar){
                System.out.println("Boton presionado");
            }
        }
        
    }
    
    
    
    
    
    class fondoJuego extends JPanel{
        private Image imagen;
        
        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }

}
}
