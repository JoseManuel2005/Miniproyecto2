package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Laboratorio N.2: segundo miniproyecto. Archivo: VentanaInicio.java, Autores (Grupo 01 POE): 
 * Brayan Andrés Sánchez Lozano <brayan.andres.sanchez@correounivalle.edu.co>
 * Jose Manuel Palma Oquendo <jose.palma@correounivalle.edu.co>
 * Fecha creación: 10-06-2022, Fecha última modificación: 18-06-2022 
 * Docente: Luis Romo <luis.romo@correounivalle.edu.co>
 */

public class VentanaInicio extends JFrame{
    private JButton btnComoJugar;
    private JButton btnJugar;
    private JButton btnUtilidad;
    private Container contenedorppal;
    private JPanel panelBotones;
    private JPanel panelPrincipal;
    imagenFondo imagenFondo = new imagenFondo();
    private ImageIcon fondoJugar;
    private ImageIcon fondoComoJugar; 
    private ImageIcon fondoUtilidad; 

    public VentanaInicio(){
        this.setContentPane(imagenFondo);
        iniciarComponentes();
        setSize(1100,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Adosa2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
    }
    
    private void iniciarComponentes(){      
        
        fondoJugar = new ImageIcon("src/Imagenes/botones/jugar.png");
        fondoComoJugar = new ImageIcon("src/Imagenes/botones/comoJugar.png");
        fondoUtilidad = new ImageIcon("src/Imagenes/botones/paraQueSirve.png");
        
        btnComoJugar = new JButton("¿Como Jugar?");
        btnComoJugar.setBounds(50, 350, 280, 148);
        btnComoJugar.setIcon(new ImageIcon(fondoComoJugar.getImage().getScaledInstance(btnComoJugar.getWidth() , btnComoJugar.getHeight(), Image.SCALE_SMOOTH)));
        btnComoJugar.setFocusPainted(false);
        btnComoJugar.setBorderPainted(false);
        btnComoJugar.setContentAreaFilled(false);
        btnComoJugar.setAutoscrolls(true);
        btnComoJugar.setBorder(null);
        //btnComoJugar.setPressedIcon(new ImageIcon(getClass().getResource("C:\\Miniproyecto2\\Adosa2\\src\\Imagenes\\botones\\jugarp.png")));
        //btnComoJugar.setRolloverIcon(new ImageIcon(getClass().getResource("C:\\Miniproyecto2\\Adosa2\\src\\Imagenes\\botones\\jugarr.png")));
         
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(380, 380, 238, 77);
        btnJugar.setIcon(new ImageIcon(fondoJugar.getImage().getScaledInstance(btnJugar.getWidth() , btnJugar.getHeight(), Image.SCALE_SMOOTH)));
        btnJugar.setFocusPainted(false);
        btnJugar.setBorderPainted(false);
        btnJugar.setContentAreaFilled(false);
        
        btnUtilidad = new JButton("Para que sirve");
        btnUtilidad.setBounds(668, 350, 378, 148);
        btnUtilidad.setIcon(new ImageIcon(fondoUtilidad.getImage().getScaledInstance(btnUtilidad.getWidth() , btnUtilidad.getHeight(), Image.SCALE_SMOOTH)));
        btnUtilidad.setFocusPainted(false);
        btnUtilidad.setBorderPainted(false);
        btnUtilidad.setContentAreaFilled(false);

        contenedorppal = getContentPane();
        contenedorppal.setLayout(null);
        
        /*
        contenedorppal.add(btnComoJugar);
        contenedorppal.add(btnComoJugar);
        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        */

        contenedorppal = getContentPane();
        
        /*
        panelPrincipal = new JPanel();
        panelBotones.add(btnComoJugar);
        panelBotones.add(btnJugar);
        panelBotones.add(btnUtilidad);
        panelPrincipal.add(panelBotones);
        */

        contenedorppal.add(btnComoJugar);
        contenedorppal.add(btnJugar);
        contenedorppal.add(btnUtilidad);
        //panelPrincipal.setBounds(20, 160, 450, 40);
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
     
    class imagenFondo extends JPanel{
        private Image fondo;
        @Override
        public void paint(Graphics g) {
            fondo = new ImageIcon(getClass().getResource("/imagenes/frames/fondoPrincipal.png")).getImage();
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
