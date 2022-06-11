/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Usuario
 */
public class VentanaUtilidad extends JFrame{
    Container contenedorPpal;
    private JTextArea lblTexto;

    public VentanaUtilidad() {
        iniciarComponentes();
        setSize(400, 150);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("¿Para que sirve?");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    private void iniciarComponentes(){
        lblTexto = new JTextArea("Este juego pone en accion la habilidad para comparar" + "\n" + "patrones visuales, entrenando ademas la aatencion" + "\n" + "a los detalles y la velocidad perceptiva. Estas capacidades son" + "\n"   + "relevantes cuand hay que decidir entre estimulos" + "\n" + "semejantes y hay que hacerlo de forma rapida, por ejemplo" + "\n" + "al reconocer fotografias, caras, objetos cotidianos o palabras escritas.");
        lblTexto.setBounds(1, 1, 390, 150);
        lblTexto.setEditable(false);
       
        contenedorPpal = getContentPane();
        contenedorPpal.setLayout(null);
        contenedorPpal.add(lblTexto);
        
    }
    
}
