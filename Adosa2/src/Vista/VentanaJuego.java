package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import javax.swing.Timer;
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
    private final List<Integer> cuadrosRestantes = new ArrayList<>();
    private final List<Integer> indexGraficables = new ArrayList<>();
    private final List<Cuadrado> cuadrosGraficar = new ArrayList<>();
    private List<Integer> imagenesCuadros = new ArrayList<>();
    private Timer timer;
    
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
       
        uno.setImagen();
        dos.setImagen();
        tres.setImagen();

        int x = uno.getImagen();
        int y = dos.getImagen();
        int z = tres.getImagen();
        boolean repetir = true;
        int auxiliar;
        Random k = new Random();
        while(repetir == true){
            if(x == y || x == z || y == z){
                auxiliar = 0 + k.nextInt((2 - 0) + 1);
                uno.setImagenF(auxiliar);
                auxiliar = 4 + k.nextInt((7 - 4) + 1);
                dos.setImagenF(auxiliar);
                auxiliar = 9 + k.nextInt((10 - 9) + 1);
                tres.setImagenF(auxiliar);
            } else {
                repetir = false;
            }
        }

        icono1 = new ImageIcon("src/Imagenes/ventanaJuego/" + uno.getImagen() + ".PNG");
        icono2 = new ImageIcon("src/Imagenes/ventanaJuego/" + dos.getImagen() + ".PNG");
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

        cuadrosRestantes.add(4);
        cuadrosRestantes.add(5);
        cuadrosRestantes.add(6);
        cuadrosRestantes.add(7);
        cuadrosRestantes.add(8);

        timer = new Timer(juego.getTiempo(), null);
        timer.setInitialDelay(juego.getTiempo());

        timer.addActionListener((ActionEvent e) -> {
                Random r = new Random();
                int aux = (int)(r.nextDouble()*(2+juego.getNivel()));
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
        });
        
        timer.start();

        ImgAdivinar = new ImageIcon("src/Imagenes/ventanaJuego/boton.PNG");
        
        btnAdivinar = new JButton();
        btnAdivinar.setBounds(900, 350, 100, 100);
        btnAdivinar.setIcon(new ImageIcon(ImgAdivinar.getImage().getScaledInstance(btnAdivinar.getWidth() , btnAdivinar.getHeight(), Image.SCALE_SMOOTH)));

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

        cuadrosGraficar.add(uno);
        cuadrosGraficar.add(dos);
        cuadrosGraficar.add(tres);
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
        int listLength = cuadrosRestantes.size();
        if(listLength != 0){
            Random r = new Random();
            int index = (int)(r.nextDouble()*(listLength-1));
            int aux = cuadrosRestantes.get(index);
            switch(aux){
                case 4 -> {
                    lblCuadrado4.setVisible(true);
                    cuadrosGraficar.add(cuatro);
                    break;
                }
                case 5 -> {
                    lblCuadrado5.setVisible(true);
                    cuadrosGraficar.add(cinco);
                    break;
                }
                case 6 -> {
                    lblCuadrado6.setVisible(true);
                    cuadrosGraficar.add(seis);
                    break;
                }
                case 7 -> {
                    lblCuadrado7.setVisible(true);
                    cuadrosGraficar.add(siete);
                    break;
                }
                case 8 -> {
                    lblCuadrado8.setVisible(true);
                    cuadrosGraficar.add(ocho);
                    break;
                }
            }
        cuadrosRestantes.remove(index);
        }
    }

    public boolean verificar(){
        imagenesCuadros = juego.getNumeroCuadros(cuadrosGraficar);
        int size0 = imagenesCuadros.size();
        Set<Integer> hashSet = new HashSet<>(imagenesCuadros);
        imagenesCuadros.clear();
        imagenesCuadros.addAll(hashSet);
        int sizef = imagenesCuadros.size();
        return size0 != sizef;
    }

    public void graficarDiferentes(){
        indexGraficables.removeAll(indexGraficables);
        for (int i = 0; i < 16; i++) {
            indexGraficables.add(i);
        }

        for(Cuadrado x : cuadrosGraficar){
            Random r = new Random();
            int index = (int)(r.nextDouble()*indexGraficables.size()-1);
            int aux = indexGraficables.get(index);
            x.setImagenF(aux);
            indexGraficables.remove(index);
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

        timer.setDelay(juego.getTiempo());
        timer.start();
    }

    public void baldosasIguales(){
        juego.setPuntuacion();
        lblPuntuacion.setText(juego.getPuntuacion() + "");
        juego.setAciertos();
        juego.setNivel(juego.getNivel() + 1);
        activar();
        timer.stop();
        graficarDiferentes();
        if(juego.getTiempo() > 500){
            juego.setTiempo(juego.getTiempo() - 100);                
        }
    }

    public void baldosasDistintas(){
        graficarDiferentes();
        juego.disminuirVidas();
        juego.errores();
        juego.setTiempo(1500);

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
                    timer.stop();
                    System.out.println("Fin del juego");
                }
            }
        }
    }
    
    class manejadorEventos extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == btnAdivinar){
                if (verificar() == true) {
                    baldosasIguales();    
                }else{
                    baldosasDistintas();
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