package Vista;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private JTextArea txtUtilidad;
    private JButton btnAtras;
    private Icon iconoMenu1;
    private Icon iconoMenuPress1;
    private Font fuenteTexto;
    fondoUtilidad fondo = new fondoUtilidad();
    
    public VentanaUtilidad() {
        this.setContentPane(fondo);
        iniciarComponentes();
        setSize(700, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("¿Para que sirve?");
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    
    private void iniciarComponentes(){
        iconoMenu1 = new ImageIcon("src/Imagenes/ventanaUtilidad/menu.png");
        iconoMenuPress1= new ImageIcon("src/Imagenes/ventanaUtilidad/menuPress.png");
        fuenteTexto = new Font("JHUF",Font.PLAIN, 20);
        
        txtUtilidad = new JTextArea("""
                                    Este juego pone en accion la habilidad para 
                                    
                                    comparar patrones visuales, entrenando ademas 
                                    
                                    la atencion a los detalles y la velocidad perceptiva. 
                                    
                                    Estas capacidades son relevantes cuando hay que 
                                    
                                    decidir entre estimulos semejantes y hay que hacerlo 
                                    
                                    de forma rapida, por ejemplo al reconocer  fotografias, 
                                    
                                    caras, objetos cotidianos o palabras escritas
                                    """);
        txtUtilidad.setBounds(50, 100, 600, 200);
        txtUtilidad.setFont(fuenteTexto);
        txtUtilidad.setOpaque(false);
        txtUtilidad.setEditable(false);

        btnAtras = new JButton(iconoMenu1);
        btnAtras.setRolloverIcon(iconoMenuPress1);
        btnAtras.setBounds(290, 300, 130, 50);
        btnAtras.setFocusPainted(false);
        btnAtras.setBorderPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.setAutoscrolls(true);
        btnAtras.setBorder(null);
        
        contenedorPpal = getContentPane();
        contenedorPpal.setLayout(null);  
        contenedorPpal.add(txtUtilidad);
        contenedorPpal.add(btnAtras);
        
        btnAtras.addMouseListener(new manejadoraDeEventos());    
    }
    
    class manejadoraDeEventos extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) { 
            if (e.getSource() == btnAtras) {
                VentanaInicio ventana= new VentanaInicio();
                dispose();
            }
        
    
            }
            
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