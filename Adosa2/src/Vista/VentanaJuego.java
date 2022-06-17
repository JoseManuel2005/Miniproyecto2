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
import java.util.Timer;
import java.util.TimerTask;
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
    private ImageIcon icono1;
    private ImageIcon icono2;
    private ImageIcon icono3;
    private ImageIcon icono4;
    private ImageIcon icono5;
    private ImageIcon icono6;
    private ImageIcon icono7;
    private ImageIcon icono8;
    //private int array[] = new int[8];
    
    Cuadrado uno = new Cuadrado(true);
    Cuadrado dos = new Cuadrado(true);
    Cuadrado tres = new Cuadrado(true);
    Cuadrado cuatro = new Cuadrado(true);
    Cuadrado cinco = new Cuadrado(true);
    Cuadrado seis = new Cuadrado(true);
    Cuadrado siete = new Cuadrado(true);
    Cuadrado ocho = new Cuadrado(true);
    
    
    
    Juego juego = new Juego(uno,dos,tres,cuatro,cinco,seis,siete,ocho);
    
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
        //icono1 = new ImageIcon("src/Imagenes/ventanaJuego/" + uno.getImagen() + ".PNG");
        
        lblPuntuacion = new JLabel("Puntuacion "  + 0 + juego.getPuntuacion()); //Modificar esto
        lblPuntuacion.setBounds(10, 10, 100, 20);
        lblPuntuacion.setForeground(Color.white);
        
        lblCuadrado1 = new JLabel();       
        lblCuadrado1.setBounds(500, 50, 100, 100);
       
        lblCuadrado2 = new JLabel();
        lblCuadrado2.setBounds(500, 150, 100, 100);
        
        lblCuadrado3 = new JLabel();
        lblCuadrado3.setBounds(500, 280, 100, 100);
        
        lblCuadrado4 = new JLabel();
        lblCuadrado4.setBounds(500, 380, 100, 100);
        lblCuadrado4.setVisible(false);
        
        lblCuadrado5 = new JLabel();
        lblCuadrado5.setBounds(610, 215, 100, 100);
        lblCuadrado5.setVisible(false);
        
        lblCuadrado6 = new JLabel();
        lblCuadrado6.setBounds(710, 215, 100, 100);
        lblCuadrado6.setVisible(false);
        
        lblCuadrado7 = new JLabel();
        lblCuadrado7.setBounds(390, 215, 100, 100);
        lblCuadrado7.setVisible(false);
        
        lblCuadrado8 = new JLabel();
        lblCuadrado8.setBounds(290, 215, 100, 100);
        lblCuadrado8.setVisible(false);
       
        
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                
                uno.setImagen();
                icono1 = new ImageIcon("src/Imagenes/ventanaJuego/" + uno.getImagen() + ".PNG");
                
                dos.setImagen();
                icono2 = new ImageIcon("src/Imagenes/ventanaJuego/" + dos.getImagen() + ".PNG");

                tres.setImagen();
                icono3 = new ImageIcon("src/Imagenes/ventanaJuego/" + tres.getImagen() + ".PNG");
              
                cuatro.setImagen();
                icono4 = new ImageIcon("src/Imagenes/ventanaJuego/" + cuatro.getImagen() + ".PNG");
                
                cinco.setImagen();
                icono5 = new ImageIcon("src/Imagenes/ventanaJuego/" + cinco.getImagen() + ".PNG");
                
                seis.setImagen();
                icono6 = new ImageIcon("src/Imagenes/ventanaJuego/" + seis.getImagen() + ".PNG");
                
                siete.setImagen();
                icono7 = new ImageIcon("src/Imagenes/ventanaJuego/" + siete.getImagen() + ".PNG");
                
                ocho.setImagen();
                icono8 = new ImageIcon("src/Imagenes/ventanaJuego/" + ocho.getImagen() + ".PNG");
                
                

                lblCuadrado1.setIcon(icono1);
                lblCuadrado2.setIcon(icono2);
                lblCuadrado3.setIcon(icono3);
                lblCuadrado4.setIcon(icono4);
                lblCuadrado5.setIcon(icono5);
                lblCuadrado6.setIcon(icono6);
                lblCuadrado7.setIcon(icono7);
                lblCuadrado8.setIcon(icono8);
                /*
                 array[0] = uno.getImagen();
                 array[1] = dos.getImagen();
                 array[2] = tres.getImagen();
                 array[3] = cuatro.getImagen();
                 array[4] = cinco.getImagen();
                 array[5] = seis.getImagen();
                 array[6] = siete.getImagen();
                 array[7] = ocho.getImagen();
                */
               //System.out.println(uno.getImagen() == dos.getImagen());
                
                 
                
                }
                
            
        };
        
        timer.scheduleAtFixedRate(task, 0, 1000);
        
        /*
      
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
        */
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
        contenedorppal.add(lblCuadrado2);
        contenedorppal.add(lblCuadrado3);
        contenedorppal.add(lblCuadrado4);
        contenedorppal.add(lblCuadrado5);
        contenedorppal.add(lblCuadrado6);
        contenedorppal.add(lblCuadrado7);
        contenedorppal.add(lblCuadrado8);
        contenedorppal.add(btnAdivinar);
        
        btnAdivinar.addMouseListener(new manejadorEventos());
        
        
        
        
        
    }
    
    class manejadorEventos extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == btnAdivinar){
                if (uno.getImagen() == dos.getImagen() || uno.getImagen() == tres.getImagen() || dos.getImagen() == tres.getImagen()) {
                    System.out.println("true");
                    juego.setPuntuacion();
                    lblPuntuacion.setText(juego.getPuntuacion() + "");
                    juego.setAciertos();
                    System.out.println(juego.getAciertos());
                }else{
                    juego.disminuirVidas();
                    
                    juego.errores();
                    System.out.println(juego.getErrores());
                    System.out.println(juego.isHuboError());
                    
                    if (juego.isHuboError()== true) {
                        switch (juego.getErrores()) {
                            case 1 -> {
                                btnVida3.setVisible(false);
                            }
                            
                            case 2 -> {
                                btnVida2.setVisible(false);
                            }
                            
                            case 3 -> {
                                btnVida1.setVisible(false);
                            }
                            
                                
                            
                        }
                    }
                }
                }
                
        
            }
        }
        
    }
    
    
    
    
    
    class fondoJuego extends JPanel{
        private Image imagen;
        
        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/frames/fondoJuego.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }

}

