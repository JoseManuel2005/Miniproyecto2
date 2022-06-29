/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author Usuario
 */
public class VentanaInstrucciones1 extends JFrame {
    
    private JTextArea txtInstruccion1;
    private JButton btnSgte;
    private JLabel lblImagen; 
    Container contenedorppal;
    private JPanel panelPppal;
    private JButton btnAnterior;
    private Icon icono1, icono2;
    
    
    public VentanaInstrucciones1() {
        iniciarComponentes();
        setSize(600,400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void iniciarComponentes(){
        txtInstruccion1 = new JTextArea("En el transcurso del juego apareceran varias baldosas, cada una con un diseño diferente\n" 
                + "el borde azul te indica que el cuadro acaba de cambiar su diseño \n" 
                + "Una vez veas una pareja identica de cuadros debes pulsar rapidamentes espacio o dar clic en el boton");
        txtInstruccion1.setEditable(false);
        //txtInstruccion1.setEnabled(false);
        txtInstruccion1.setBounds(50, 200, 500, 500);
        
        icono1 = new ImageIcon("src/Imagenes/ventanaInstrucciones/ilustracion1");
        
        lblImagen = new JLabel("Hola");
        lblImagen.setBounds(150, 60, 500, 500);
        lblImagen.setVisible(true);
        
        btnSgte = new JButton("Siguiente");
        btnSgte.setBounds(387, 100, 90, 30);
        //panelPppal = new JPanel();
        btnAnterior = new JButton("Anterior");
        btnAnterior.setBounds(10, 100, 90, 30);
        btnAnterior.setVisible(false);
        
        contenedorppal = getContentPane();
        contenedorppal.setLayout(null);
        
        
        contenedorppal.add(txtInstruccion1);
        contenedorppal.add(btnSgte);
        contenedorppal.add(lblImagen);
        contenedorppal.add(btnAnterior);
        //contenedorppal.add(panelPppal);
        btnSgte.addMouseListener(new manejadoraDeEventos());
        btnAnterior.addMouseListener(new manejadoraDeEventos());
    }
    
    class manejadoraDeEventos extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == btnSgte) {
                btnAnterior.setVisible(true);
                txtInstruccion1.setText("¡Ten cuidado! Si no presionas el boton a tiempo perderas una vida");
           
            }else{
                txtInstruccion1.setText("En el transcurso del juego apareceran varias baldosas, cada una con un diseño diferente\n" 
                + "el borde azul te indica que el cuadro acaba de cambiar su diseño \n" 
                + "Una vez veas una pareja identica de cuadros debes pulsar rapidamentes espacio o dar clic en el boton");
                btnAnterior.setVisible(false);
            }
            
        }
        
    }
    
}
