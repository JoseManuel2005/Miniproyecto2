/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import java.awt.*;
import javax.swing.*;
import Modelo.Juego;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author Usuario
 */
public class VentanaPerder extends JFrame{
    private Juego juego;
    private JLabel lblFinJuego;
    private JLabel lblAciertos;
    private JLabel lblErrores;
    private JLabel lblPuntuacion;
    private JButton btnReiniciarJuego;
    private JButton btnCerrar;
    private Font fuente;
    private Icon iconoBoton;
    private Icon iconoBoton2;
    private Icon iconoCerrar;
    
    Container contenedorPpal;
    fondoPerder fondo = new fondoPerder();
    

    public VentanaPerder(Juego juego) {
        this.juego = juego;
        this.setContentPane(fondo);
        iniciarComponentes();
        setSize(500,450);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void iniciarComponentes(){
        fuente = new Font("JHUF",Font.PLAIN, 40);
        iconoBoton = new ImageIcon("src/Imagenes/botones/botonReiniciar.png");
        iconoBoton2 = new ImageIcon("src/Imagenes/botones/btnReiniciarPresionado.png");
        iconoCerrar = new ImageIcon("src/Imagenes/botones/close.png");
        
        lblFinJuego = new JLabel("Fin del juego ");
        lblFinJuego.setFont(fuente);
        
        lblAciertos = new JLabel("Aciertos: "  + juego.getAciertos());
        lblAciertos.setFont(fuente);
        lblAciertos.setBounds(130, 150, 400, 40);
        
        lblErrores = new JLabel("Errores: " + juego.getErrores()) ;
        lblErrores.setBounds(140, 200, 400, 40);
        lblErrores.setFont(fuente);
        
        lblPuntuacion =  new JLabel("Puntuacion: " + juego.getPuntuacion());
        lblPuntuacion.setFont(fuente);
        lblPuntuacion.setBounds(115, 250, 400, 40);
              
        btnReiniciarJuego = new JButton(iconoBoton);
        btnReiniciarJuego.setRolloverIcon(iconoBoton2);
        btnReiniciarJuego.setBounds(100, 320, 300, 50);
        btnReiniciarJuego.setFocusPainted(false);
        btnReiniciarJuego.setBorderPainted(false);
        btnReiniciarJuego.setContentAreaFilled(false);
        btnReiniciarJuego.setAutoscrolls(true);
        btnReiniciarJuego.setBorder(null);
        
        btnCerrar = new JButton(iconoCerrar);
        btnCerrar.setBounds(400, 10, 70, 70);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setAutoscrolls(true);
        btnCerrar.setBorder(null);
        
        contenedorPpal = getContentPane();
        contenedorPpal.setLayout(null);
        contenedorPpal.add(lblAciertos);
        contenedorPpal.add(lblErrores);
        contenedorPpal.add(lblPuntuacion);
        contenedorPpal.add(btnReiniciarJuego);
        contenedorPpal.add(btnCerrar);
        
        btnReiniciarJuego.addMouseListener(new manejadoraDeEventos());
        btnCerrar.addMouseListener(new manejadoraDeEventos());
    }
    
    
    class manejadoraDeEventos extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == btnReiniciarJuego) {
                VentanaJuego juego= new VentanaJuego();
                dispose();
            }else if (e.getSource() == btnCerrar)
            {
                VentanaInicio ventana = new VentanaInicio();
                dispose();
            }
        }
        
    }
    
     class fondoPerder extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/frames/fondoPerder.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}

