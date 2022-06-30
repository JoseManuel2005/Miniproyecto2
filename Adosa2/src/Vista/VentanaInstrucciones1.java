/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;
/**
 *
 * @author Usuario
 */
public class VentanaInstrucciones1 extends JFrame {
    
    private JTextArea txtInstruccion1;
    private JButton btnSgte;
    private JLabel lblImagen; 
    Container contenedorppal;
    private JButton btnAnterior;
    private Icon icono1, icono2, iconoAnterior, iconoSiguiente,iconoAnteriorPress, iconoSiguientePress, iconoMenu, iconoMenuPress;
    private JButton btnMenu;
    private Font fuente;
    fondoInstrucciones fondo = new fondoInstrucciones();
    
    public VentanaInstrucciones1() {
        this.setContentPane(fondo);
        iniciarComponentes();
        setSize(1000,700);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void iniciarComponentes(){
        fuente = new Font("JHUF",Font.PLAIN, 20);
        icono1 = new ImageIcon("src/Imagenes/ventanaInstrucciones/ilustracion1.png");
        icono2 = new ImageIcon("src/Imagenes/ventanaInstrucciones/ilustracion2.png");
        iconoAnterior = new ImageIcon("src/Imagenes/ventanaInstrucciones/btnAnterior.png");
        iconoAnteriorPress = new ImageIcon("src/Imagenes/ventanaInstrucciones/btnAnteriorpress.png");
        iconoSiguiente = new ImageIcon("src/Imagenes/ventanaInstrucciones/btnSiguiente.png");
        iconoSiguientePress = new ImageIcon("src/Imagenes/ventanaInstrucciones/btnSgtePress.png");
        iconoMenu = new ImageIcon("src/Imagenes/ventanaInstrucciones/menu.png");
        iconoMenuPress = new ImageIcon("src/Imagenes/ventanaInstrucciones/menuPress.png");
  
        txtInstruccion1 = new JTextArea("""
                                        En el transcurso del juego apareceran varias baldosas, cada una con forma 
                                        
                                        diferente, el borde azul te indica que el cuadro acaba de cambiar su forma.
                                        
                                        Cuando veas una pareja identica de cuadros debes pulsar rapidamentes
                                        
                                        espacio o dar clic en el boton""");
        txtInstruccion1.setEditable(false);
        txtInstruccion1.setOpaque(false);
        txtInstruccion1.setForeground(Color.BLACK);
        txtInstruccion1.setFont(fuente);
        txtInstruccion1.setAlignmentX(CENTER_ALIGNMENT);
        txtInstruccion1.setBounds(80, 450, 900, 100);
     
        lblImagen = new JLabel(icono1);
        lblImagen.setBounds(250, 10, 500, 400);
        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 6);
        lblImagen.setBorder(border);
  
        btnSgte = new JButton(iconoSiguiente);
        btnSgte.setRolloverIcon(iconoSiguientePress);
        btnSgte.setBounds(700, 600, 218, 66);
        btnSgte.setFocusPainted(false);
        btnSgte.setBorderPainted(false);
        btnSgte.setContentAreaFilled(false);
        btnSgte.setAutoscrolls(true);
        btnSgte.setBorder(null);
    
        btnAnterior = new JButton(iconoAnterior);
        btnAnterior.setRolloverIcon(iconoAnteriorPress);
        btnAnterior.setBounds(50, 600, 218, 66);
        btnAnterior.setVisible(false);
        btnAnterior.setFocusPainted(false);
        btnAnterior.setBorderPainted(false);
        btnAnterior.setContentAreaFilled(false);
        btnAnterior.setAutoscrolls(true);
        btnAnterior.setBorder(null);
        
        btnMenu = new JButton(iconoMenu);
        btnMenu.setRolloverIcon(iconoMenuPress);
        btnMenu.setBounds(440, 608, 130, 50);
        btnMenu.setFocusPainted(false);
        btnMenu.setBorderPainted(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setAutoscrolls(true);
        btnMenu.setBorder(null);
        
        contenedorppal = getContentPane();
        contenedorppal.setLayout(null);
        contenedorppal.add(txtInstruccion1);
        contenedorppal.add(btnSgte);
        contenedorppal.add(lblImagen);
        contenedorppal.add(btnAnterior);
        contenedorppal.add(btnMenu);
        
        btnSgte.addMouseListener(new manejadoraDeEventos());
        btnAnterior.addMouseListener(new manejadoraDeEventos());
        btnMenu.addMouseListener(new manejadoraDeEventos());
    }
    
    class manejadoraDeEventos extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == btnSgte) {
                btnAnterior.setVisible(true);
                txtInstruccion1.setText("Ten cuidado! Si no presionas el boton a tiempo perderas una vida");
                lblImagen.setIcon(icono2);    
           
            }else{
                txtInstruccion1.setText("""
                                        En el transcurso del juego apareceran varias baldosas, cada una con forma 
                                        
                                        diferente, el borde azul te indica que el cuadro acaba de cambiar su forma.
                                        
                                        Cuando veas una pareja identica de cuadros debes pulsar rapidamente
                                        
                                        espacio o dar clic en el boton""");
                btnAnterior.setVisible(false);
                lblImagen.setIcon(icono1);
            }
                    
            if (e.getSource() == btnMenu) {
                VentanaInicio ventana= new VentanaInicio();
                dispose();
            }
        
    
            }
            
        }
    
    class fondoInstrucciones extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/frames/fondoInstrucciones.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
