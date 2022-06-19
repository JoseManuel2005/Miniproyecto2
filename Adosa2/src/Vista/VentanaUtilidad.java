package Vista;
import java.awt.*;
import javax.swing.*;

/**
 * Laboratorio N.2: segundo miniproyecto. Archivo: VentanaUtilidad.java, Autores (Grupo 01 POE): 
 * Brayan Andrés Sánchez Lozano <brayan.andres.sanchez@correounivalle.edu.co>
 * Jose Manuel Palma Oquendo <jose.palma@correounivalle.edu.co>
 * Fecha creación: 10-06-2022, Fecha última modificación: 18-06-2022 
 * Docente: Luis Romo <luis.romo@correounivalle.edu.co>
 */

public class VentanaUtilidad extends JFrame{
    Container contenedorPpal;
    private JLabel lblTexto1;
    private JLabel lblTexto2;
    private JLabel lblTexto3;
    private JLabel lblTexto4;
    private JLabel lblTexto5;
    private JLabel lblTexto6;
    fondoUtilidad fondo = new fondoUtilidad();
    
    public VentanaUtilidad() {
        this.setContentPane(fondo);
        iniciarComponentes();
        setSize(720, 230);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("¿Para que sirve?");
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    
    private void iniciarComponentes(){
        lblTexto1 = new JLabel((new ImageIcon("src/Imagenes/ventanautilidad/1.png")));
        lblTexto1.setBounds(50, 1, 591, 41);
       
        lblTexto2 = new JLabel((new ImageIcon("src/Imagenes/ventanautilidad/2.png")));
        lblTexto2.setBounds(36, 31, 621, 45);
        
        lblTexto3 = new JLabel((new ImageIcon("src/Imagenes/ventanautilidad/3.png")));
        lblTexto3.setBounds(27, 65, 645, 41);
        
        lblTexto4 = new JLabel((new ImageIcon("src/Imagenes/ventanautilidad/4.png")));
        lblTexto4.setBounds(1, 95, 696, 39);
        
        lblTexto5 = new JLabel((new ImageIcon("src/Imagenes/ventanautilidad/5.png")));
        lblTexto5.setBounds(23, 121, 675, 42);
        
        lblTexto6 = new JLabel((new ImageIcon("src/Imagenes/ventanautilidad/6.png")));
        lblTexto6.setBounds(23, 151, 657, 42);
        
        contenedorPpal = getContentPane();
        contenedorPpal.setLayout(null);
        
        contenedorPpal.add(lblTexto1);
        contenedorPpal.add(lblTexto2);
        contenedorPpal.add(lblTexto3);
        contenedorPpal.add(lblTexto4);
        contenedorPpal.add(lblTexto5);
        contenedorPpal.add(lblTexto6); 
    }
    
    class fondoUtilidad extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/frames/fondoUtilidad.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}