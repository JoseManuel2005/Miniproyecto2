package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Modelo.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;
import java.util.Set;

/**
 * Laboratorio N.2: segundo miniproyecto. Archivo: VentanaJuego.java, Autores (Grupo 01 POE): 
 * Brayan Andrés Sánchez Lozano <brayan.andres.sanchez@correounivalle.edu.co>
 * Jose Manuel Palma Oquendo <jose.palma@correounivalle.edu.co>
 * Fecha creación: 10-06-2022, Fecha última modificación: 18-06-2022 
 * Docente: Luis Romo <luis.romo@correounivalle.edu.co>
 */

public class VentanaJuego extends JFrame{
    private JLabel lblPuntuacion;
    private JButton btnVida1;
    private JButton btnVida2;
    private JButton btnVida3;
    private JLabel lblCuadrado1;
    private JLabel lblCuadrado2;
    private JLabel lblCuadrado3;
    private JLabel lblCuadrado4;
    private JLabel lblCuadrado5;
    private JLabel lblCuadrado6;
    private JLabel lblCuadrado7;
    private JLabel lblCuadrado8;
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
    private int nivel = 1;
    private int temp = 1500;
    private List<Integer> restantes = new ArrayList<Integer>();
    private List<Integer> imagenes = new ArrayList<Integer>();
    private List<Integer> indexD = new ArrayList<Integer>();
    private List<Cuadrado> cuadros = new ArrayList<Cuadrado>();
    private List<Cuadrado> aGraficar = new ArrayList<Cuadrado>();
    private Timer timer = new Timer();
    private TimerTask task;
    private JButton btnPrueba;
    private Font fuentePuntuacion;
    
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
        setSize(800,680);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes(){
        fuentePuntuacion = new Font("JHUF",Font.PLAIN, 20);
        
        lblPuntuacion = new JLabel("Puntuacion "  + 0 + juego.getPuntuacion()); //Modificar esto
        lblPuntuacion.setFont(fuentePuntuacion);
        lblPuntuacion.setBounds(10, 10, 500, 20);
        lblPuntuacion.setForeground(Color.white);
        
        lblCuadrado1 = new JLabel();       
        lblCuadrado1.setBounds(325, 50, 130, 130);
       
        lblCuadrado2 = new JLabel();
        lblCuadrado2.setBounds(325, 182, 130, 130);
        
        lblCuadrado3 = new JLabel();
        lblCuadrado3.setBounds(325, 330, 130, 130);
        
        lblCuadrado4 = new JLabel();
        lblCuadrado4.setBounds(325, 462, 130, 130);
        lblCuadrado4.setVisible(false);
        
        lblCuadrado5 = new JLabel();
        lblCuadrado5.setBounds(465, 256, 130, 130);
        lblCuadrado5.setVisible(false);
        
        lblCuadrado6 = new JLabel();
        lblCuadrado6.setBounds(597, 256, 130, 130);
        lblCuadrado6.setVisible(false);
        
        lblCuadrado7 = new JLabel();
        lblCuadrado7.setBounds(50, 256, 130, 130);
        lblCuadrado7.setVisible(false);
        
        lblCuadrado8 = new JLabel();
        lblCuadrado8.setBounds(182, 256, 130, 130);
        lblCuadrado8.setVisible(false);
       
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

        restantes.add(4);
        restantes.add(5);
        restantes.add(6);
        restantes.add(7);
        restantes.add(8);
        
        task = new TimerTask() {
            @Override
            
            public void run() {
                Random r = new Random();
                int aux = (int)(r.nextDouble()*(nivel+2));
                switch (aux) {
                    case 0 -> {
                        cambioDeImagen(uno, icono1, lblCuadrado1);
                        break;
                    }
                    case 1 -> {
                        cambioDeImagen(dos, icono2, lblCuadrado2);
                        break;
                    }
                    case 2 -> {
                        cambioDeImagen(tres, icono3, lblCuadrado3);
                        break;
                    }
                    case 3 -> {
                        cambioDeImagen(cuatro, icono4, lblCuadrado4);
                        break;
                    }
                    case 4 -> {
                        cambioDeImagen(cinco, icono5, lblCuadrado5);
                        break;
                    }
                    case 5 -> {
                        cambioDeImagen(seis, icono6, lblCuadrado6);
                        break;
                    }
                    case 6 -> {
                        cambioDeImagen(siete, icono7, lblCuadrado7);
                        break;
                    }
                    case 7 -> {
                        cambioDeImagen(ocho, icono8, lblCuadrado8);
                        break;
                    }
                }
            }            
        };
        
        timer.scheduleAtFixedRate(task, 0, temp);

        ImgAdivinar = new ImageIcon("src/Imagenes/ventanaJuego/boton.PNG");
        
        btnAdivinar = new JButton();
        btnAdivinar.setBounds(600, 450, 130, 130);
        btnAdivinar.setIcon(new ImageIcon(ImgAdivinar.getImage().getScaledInstance(btnAdivinar.getWidth() , btnAdivinar.getHeight(), Image.SCALE_SMOOTH)));
        btnAdivinar.setFocusPainted(false);
        btnAdivinar.setBorderPainted(false);
        btnAdivinar.setContentAreaFilled(false);

        btnVida1 = new JButton();
        btnVida1.setEnabled(false);
        btnVida1.setBackground(Color.green);
        btnVida1.setBounds(550, 20, 50, 50);
      
        btnVida2 = new JButton();
        btnVida2.setEnabled(false);
        btnVida2.setBackground(Color.green);
        btnVida2.setBounds(610, 20, 50, 50);
        
        btnVida3 = new JButton();
        btnVida3.setEnabled(false);
        btnVida3.setBackground(Color.green);
        btnVida3.setBounds(670, 20, 50, 50);
        
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

    public void cambioDeImagen(Cuadrado x, Icon iconx, JLabel lblx){
        int lastImage = x.getImagen();
        x.setImagen();
        if(x.getImagen() == lastImage){
            x.setImagenEx(lastImage);
        }
        iconx = new ImageIcon("src/Imagenes/ventanaJuego/" + x.getImagen() + ".PNG");
        lblx.setIcon(iconx);
    }

    public void activar(){
        int listLength = restantes.size();
        if(listLength != 0){
            Random r = new Random();
            int index = (int)(r.nextDouble()*(listLength-1));
            int aux = restantes.get(index);
            switch(aux){
                case 4 -> {
                    lblCuadrado4.setVisible(true);
                    break;
                }
                case 5 -> {
                    lblCuadrado5.setVisible(true);
                    break;
                }
                case 6 -> {
                    lblCuadrado6.setVisible(true);
                    break;
                }
                case 7 -> {
                    lblCuadrado7.setVisible(true);
                    break;
                }
                case 8 -> {
                    lblCuadrado8.setVisible(true);
                    break;
                }
            }
        restantes.remove(index);
        }
    }

    public boolean verificar(){
        cuadros.removeAll(cuadros);
        cuadros.add(uno);
        cuadros.add(dos);
        cuadros.add(tres);
        cuadros.add(cuatro);
        cuadros.add(cinco);
        cuadros.add(seis);
        cuadros.add(siete);
        cuadros.add(ocho);
        imagenes = juego.getNumeroCuadros(cuadros);
        if(nivel < 6){
            while(nivel + 2 != imagenes.size()){
                int length = imagenes.size();
                imagenes.remove(length-1);
            }
        } else {
            while(8 != imagenes.size()){
                int length = imagenes.size();
                imagenes.remove(length-1);
            }
        }
        System.out.println(imagenes);
        int size0 = imagenes.size();
        Set<Integer> hashSet = new HashSet<>(imagenes);
        imagenes.clear();
        imagenes.addAll(hashSet);
        int sizef = imagenes.size();
        return size0 != sizef;
    }

    public void graficarDiferentes(){
        indexD.removeAll(indexD);
        indexD.add(0); indexD.add(1); indexD.add(2); indexD.add(3); indexD.add(4); indexD.add(5); indexD.add(6); indexD.add(7);
        if(nivel < 5){
            while(nivel + 3 != cuadros.size()){
                int length = cuadros.size();
                cuadros.remove(length-1);
            }
        }
        for(Cuadrado x : cuadros){
            Random r = new Random();
            int index = (int)(r.nextDouble()*indexD.size()-1);
            int aux = indexD.get(index);
            x.setImagenF(aux);
            indexD.remove(index);
        }

        icono1 = new ImageIcon("src/Imagenes/ventanaJuego/" + uno.getImagen() + ".PNG");
        icono2 = new ImageIcon("src/Imagenes/ventanaJuego/" + dos.getImagen() + ".PNG");
        icono3 = new ImageIcon("src/Imagenes/ventanaJuego/" + tres.getImagen() + ".PNG");
        icono4 = new ImageIcon("src/Imagenes/ventanaJuego/" + cuatro.getImagen() + ".PNG");
        icono5 = new ImageIcon("src/Imagenes/ventanaJuego/" + cinco.getImagen() + ".PNG");
        icono6 = new ImageIcon("src/Imagenes/ventanaJuego/" + seis.getImagen() + ".PNG");
        icono7 = new ImageIcon("src/Imagenes/ventanaJuego/" + siete.getImagen() + ".PNG");
        icono8 = new ImageIcon("src/Imagenes/ventanaJuego/" + ocho.getImagen() + ".PNG");

        lblCuadrado1.setIcon(icono1);
        lblCuadrado2.setIcon(icono2);
        lblCuadrado3.setIcon(icono3);
        lblCuadrado4.setIcon(icono4);
        lblCuadrado5.setIcon(icono5);
        lblCuadrado6.setIcon(icono6);
        lblCuadrado7.setIcon(icono7);
        lblCuadrado8.setIcon(icono8);

        timer = new Timer();
        TimerTask task2 = task;
        timer.scheduleAtFixedRate(task2, 0, temp);
    }
    
    class manejadorEventos extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == btnAdivinar){
                if (verificar() == true) {
                    juego.setPuntuacion();
                    lblPuntuacion.setText(juego.getPuntuacion() + "");
                    juego.setAciertos();
                    nivel += 1;
                    activar();
                    timer.cancel();
                    timer.purge();
                    graficarDiferentes();
                    if(temp > 800){
                        temp -= 100;                
                    }
                }else{
                    graficarDiferentes();
                    juego.disminuirVidas();
                    juego.errores();
                    
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

