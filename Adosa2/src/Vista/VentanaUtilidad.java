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
    private JLabel lblTexto7;
    
    private JTextArea texto;
    private Font fuenteTexto;
    fondoUtilidad fondo = new fondoUtilidad();
    
    public VentanaUtilidad() {
        this.setContentPane(fondo);
        iniciarComponentes();
        setSize(690, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("¿Para que sirve?");
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    
    private void iniciarComponentes(){
        fuenteTexto = new Font("JHUF",Font.PLAIN, 20);
        
        lblTexto1 = new JLabel("Este juego pone en accion la habilidad para comparar");
        lblTexto1.setBounds(50, 30, 700, 30);
        lblTexto1.setFont(fuenteTexto);

        lblTexto2 = new JLabel("patrones visuales, entrenando ademas la atencion");
        lblTexto2.setBounds(65, 60, 700, 30);
        lblTexto2.setFont(fuenteTexto);
        
        lblTexto3 = new JLabel("a los detalles y la velocidad perceptiva.");
        lblTexto3.setBounds(95, 90, 700, 30);
        lblTexto3.setFont(fuenteTexto);
        
        lblTexto4 = new JLabel("Estas capacidades son relevantes cuando hay que decidir entre");
        lblTexto4.setBounds(1, 120, 700, 30);
        lblTexto4.setFont(fuenteTexto);
        
        lblTexto5 = new JLabel ("estimulos semejantes y hay que hacerlo de forma rapida,");
        lblTexto5.setBounds(23, 150, 700, 30);
        lblTexto5.setFont(fuenteTexto);
        
        lblTexto6 = new JLabel("por ejemplo al reconocer fotografias, caras,");
        lblTexto6.setBounds(95, 180, 657, 30);
        lblTexto6.setFont(fuenteTexto);
       
        lblTexto7 = new JLabel("objetos cotidianos o palabras escritas.");
        lblTexto7.setBounds(100, 210, 657, 30);
        lblTexto7.setFont(fuenteTexto);
        
        contenedorPpal = getContentPane();
        contenedorPpal.setLayout(null);
        //contenedorPpal.add(texto);
        contenedorPpal.add(lblTexto1);
      
        contenedorPpal.add(lblTexto1);
        contenedorPpal.add(lblTexto2);
        contenedorPpal.add(lblTexto3);
        contenedorPpal.add(lblTexto4);
        contenedorPpal.add(lblTexto5);
        contenedorPpal.add(lblTexto6); 
        contenedorPpal.add(lblTexto7); 
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