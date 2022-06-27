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
    private JLabel lblImagen, lblPagina; 
    Container contenedorppal;
    private JPanel panelPppal;
    private JButton btnAnterior;
    
    public VentanaInstrucciones1() {
        iniciarComponentes();
        setSize(600,400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void iniciarComponentes(){
        txtInstruccion1 = new JTextArea("En el transcurso del juego apareceran varias baldosas, cada una con un diseño diferente\n" 
                + "el borde azul te indica que el cuadro acaba de cambiar su diseño");
        txtInstruccion1.setEditable(false);
        //txtInstruccion1.setEnabled(false);
        txtInstruccion1.setBounds(50, 200, 500, 500);
        lblImagen = new JLabel("Aqui va la imagen");
        lblImagen.setBounds(150, 60, 100, 100);
        lblPagina = new JLabel("1/4 (borrar)");
        lblPagina.setBounds(3, 1, 70, 30);
        btnSgte = new JButton("Siguiente");
        btnSgte.setBounds(387, 100, 90, 30);
        //panelPppal = new JPanel();
        btnAnterior = new JButton("Anterior");
        btnAnterior.setBounds(10, 100, 90, 30);
        btnAnterior.setVisible(false);
        
        contenedorppal = getContentPane();
        contenedorppal.setLayout(null);
        /*
        panelPppal.add(txtInstruccion1);
        panelPppal.add(btnSgte);
        panelPppal.add(lblImagen);
        panelPppal.add(lblPagina);
        */
        contenedorppal.add(txtInstruccion1);
        contenedorppal.add(btnSgte);
        contenedorppal.add(lblImagen);
        contenedorppal.add(lblPagina);
        contenedorppal.add(btnAnterior);
        //contenedorppal.add(panelPppal);
        btnSgte.addMouseListener(new manejadoraDeEventos());
    }
    
    class manejadoraDeEventos extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == btnSgte) {
                btnAnterior.setVisible(true);
                
            }
        }
        
    }
    
}
