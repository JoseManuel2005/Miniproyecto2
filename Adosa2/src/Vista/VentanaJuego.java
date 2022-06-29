package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import javax.swing.Timer;
import java.util.List;
import java.util.Set;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.border.Border;

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
    private ImageIcon ImgAdivinarPresionado;
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
    private Timer borderTime;
    private boolean notClicked;
    private boolean notPressed;
    private Cuadrado lastCuadrado;
    private Clip sonido;
    private Font fuentePuntuacion;
    private ImageIcon fondoVidas;
    
    private JLabel lblvida1;
    private JLabel lblvida2;
    private JLabel lblvida3;
   
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
    fondoFinJuego fondoFin = new fondoFinJuego();
    
    Container contenedorppal;
     
    public VentanaJuego()  {
        this.setContentPane(fondo);
        iniciarComponentes();
        setSize(800,700);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes(){
        reproducirSonido("fondo");
        fuentePuntuacion = new Font("JHUF",Font.PLAIN, 20);
        lblPuntuacion = new JLabel("Puntuacion "  + 0 + juego.getPuntuacion()); 
        lblPuntuacion.setBounds(10, 10, 300, 20);
        lblPuntuacion.setForeground(Color.white);
        lblPuntuacion.setFont(fuentePuntuacion);
        
        lblCuadrado1 = new JLabel();       
        lblCuadrado1.setBounds(327, 25, 130, 130);
       
        lblCuadrado2 = new JLabel();
        lblCuadrado2.setBounds(327, 175, 130, 130);
        
        lblCuadrado3 = new JLabel();
        lblCuadrado3.setBounds(327, 355, 130, 130);
        
        lblCuadrado4 = new JLabel();
        lblCuadrado4.setBounds(327, 505, 130, 130);
        lblCuadrado4.setVisible(false);
        
        lblCuadrado5 = new JLabel();
        lblCuadrado5.setBounds(500, 265, 130, 130);
        lblCuadrado5.setVisible(false);
        
        lblCuadrado6 = new JLabel();
        lblCuadrado6.setBounds(640, 265, 130, 130);
        lblCuadrado6.setVisible(false);
        
        lblCuadrado7 = new JLabel();
        lblCuadrado7.setBounds(15, 265, 130, 130);
        lblCuadrado7.setVisible(false);
        
        lblCuadrado8 = new JLabel();
        lblCuadrado8.setBounds(155, 265, 130, 130);
        lblCuadrado8.setVisible(false);
       
        uno.setImagen();
        dos.setImagen();
        tres.setImagen();

        uno.setNumero(1);
        dos.setNumero(2);
        tres.setNumero(3);
        cuatro.setNumero(4);
        cinco.setNumero(5);
        seis.setNumero(6);
        siete.setNumero(7);
        ocho.setNumero(8);
        this.notPressed = true;
        this.notClicked = true;

        int x = uno.getImagen();
        int y = dos.getImagen();
        int z = tres.getImagen();
        boolean repetir = true;
        int auxiliar;
        Random k = new Random();

        // Cambia los 3 cuadros que se muestran al iniciar el juego si estos estan repetidos
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

        // Selecciona un Cuadrado de entre los visibles, aleatoriamente, y llama a una funcion que cambia su imagen
        timer.addActionListener((ActionEvent e) -> {
            SwingUtilities.updateComponentTreeUI(contenedorppal);
            boolean noSend = false;
            if(verificar() == true && notClicked == true && notPressed == true){
                baldosasDistintas();
                noSend = true;
            }
            Random r = new Random();
            int max;
            if(juego.getNivel() < 6){
                max = 2 + juego.getNivel();
            } else {
                max = 8;
            }
            int aux = (int)(r.nextDouble()*(max));
            aux = cuadrosGraficar.get(aux).getNumero() -1;
            switch (aux) {
                case 0 -> {
                    if(noSend == false){
                        cambioDeImagen(uno, icono1, lblCuadrado1);
                    } else {
                        cambioDeNumero(uno);
                    }
                    break;
                }
                case 1 -> {
                    if(noSend == false){
                        cambioDeImagen(dos, icono2, lblCuadrado2);
                    } else {
                        cambioDeNumero(dos);
                    }
                    break;
                }
                case 2 -> {
                    if(noSend == false){
                        cambioDeImagen(tres, icono3, lblCuadrado3);
                    } else {
                        cambioDeNumero(tres);
                    }
                    break;
                }
                case 3 -> {
                    if(noSend == false){
                        cambioDeImagen(cuatro, icono4, lblCuadrado4);
                    } else {
                        cambioDeNumero(cuatro);
                    }
                    break;
                }
                case 4 -> {
                    if(noSend == false){
                        cambioDeImagen(cinco, icono5, lblCuadrado5);
                    } else {
                        cambioDeNumero(cinco);
                    }
                    break;
                }
                case 5 -> {
                    if(noSend == false){
                        cambioDeImagen(seis, icono6, lblCuadrado6);
                    } else {
                        cambioDeNumero(seis);
                    }
                    break;
                }
                case 6 -> {
                    if(noSend == false){
                        cambioDeImagen(siete, icono7, lblCuadrado7);
                    } else {
                        cambioDeNumero(siete);
                    }
                    break;
                }
                case 7 -> {
                    if(noSend == false){
                        cambioDeImagen(ocho, icono8, lblCuadrado8);
                    } else {
                        cambioDeNumero(ocho);
                    }
                    break;
                }
            }
            System.out.println(aux);
        });
        
        timer.start();

        ImgAdivinar = new ImageIcon("src/Imagenes/ventanaJuego/boton.PNG");
        ImgAdivinarPresionado = new ImageIcon("src/Imagenes/ventanaJuego/botonPresionado.PNG");

        
        btnAdivinar = new JButton();
        btnAdivinar.setBounds(600, 450, 130, 130);
        btnAdivinar.setIcon(new ImageIcon(ImgAdivinar.getImage().getScaledInstance(btnAdivinar.getWidth() , btnAdivinar.getHeight(), Image.SCALE_SMOOTH)));
        btnAdivinar.setPressedIcon(new ImageIcon(ImgAdivinarPresionado.getImage().getScaledInstance(btnAdivinar.getWidth() , btnAdivinar.getHeight(), Image.SCALE_SMOOTH)));
        btnAdivinar.setFocusPainted(false);
        btnAdivinar.setBorderPainted(false);
        btnAdivinar.setContentAreaFilled(false);
        btnAdivinar.setAutoscrolls(true);
        btnAdivinar.setBorder(null);
        
        fondoVidas = new ImageIcon("src/Imagenes/ventanaJuego/vida.PNG");
        lblvida1 = new JLabel(fondoVidas);
        lblvida1.setBounds(550, 20, 50, 50);
        
        lblvida2 = new JLabel(fondoVidas);
        lblvida2.setBounds(610, 20, 50, 50);
        
        lblvida3 = new JLabel(fondoVidas);
        lblvida3.setBounds(670, 20, 50, 50);
        
        /*
        fondoVidas = new ImageIcon("src/Imagenes/ventanaJuego/vida.PNG");
        btnVida1 = new JButton();
        btnVida1.setEnabled(false);
        btnVida1.setIcon(fondoVidas);
        btnVida1.setBounds(550, 20, 50, 50);
      
        btnVida2 = new JButton();
        btnVida2.setEnabled(false);
        btnVida2.setIcon(fondoVidas);
        btnVida2.setBounds(610, 20, 50, 50);
        
        btnVida3 = new JButton();
        btnVida3.setEnabled(false);
        btnVida3.setIcon(fondoVidas);
        btnVida3.setBounds(670, 20, 50, 50);*/
        
        contenedorppal = getContentPane();
        contenedorppal.setLayout(null);
        
        contenedorppal.add(lblPuntuacion);
        //contenedorppal.add(btnVida1);
        //contenedorppal.add(btnVida2);
        //contenedorppal.add(btnVida3);
        contenedorppal.add(lblCuadrado1);
        contenedorppal.add(lblCuadrado2);
        contenedorppal.add(lblCuadrado3);
        contenedorppal.add(lblCuadrado4);
        contenedorppal.add(lblCuadrado5);
        contenedorppal.add(lblCuadrado6);
        contenedorppal.add(lblCuadrado7);
        contenedorppal.add(lblCuadrado8);
        contenedorppal.add(btnAdivinar);
        contenedorppal.add(lblvida1);//
        contenedorppal.add(lblvida2);//
        contenedorppal.add(lblvida3);//
               
        btnAdivinar.requestFocus();
        btnAdivinar.addMouseListener(new manejadorEventos());  
        btnAdivinar.addKeyListener(new manejadorEventos());

        cuadrosGraficar.add(uno);
        cuadrosGraficar.add(dos);
        cuadrosGraficar.add(tres);
    }

    // Recibe un cuadrado, cambia su imagen, asi como el icono del Label, evitando a toda costa que esta se repita
    public void cambioDeImagen(Cuadrado x, Icon iconx, JLabel lblx){
        int lastImage = x.getImagen();
        x.setImagen();
        if(x.getImagen() == lastImage){
            x.setImagenF(lastImage+1);
        }
        iconx = new ImageIcon("src/Imagenes/ventanaJuego/" + x.getImagen() + ".PNG");
        lblx.setIcon(iconx);
        reproducirSonido("cambio");
        Border border = BorderFactory.createLineBorder(Color.BLUE, 4);
        lblx.setSize(133, 133);
        lblx.setBorder(border);
        borderTime = new Timer(juego.getTiempo()-200,null);
        borderTime.addActionListener((ActionEvent t) -> {
            lblx.setBorder(null);
            borderTime.stop();
        });
        borderTime.start();
        lastCuadrado = x;
    }

    public void cambioDeNumero(Cuadrado y){
        int lastImage = y.getImagen();
        y.setImagen();
        if(y.getImagen() == lastImage){
            y.setImagenEx(lastImage);
        }
    }

    // Selecciona "aleatoriamente" un Cuadrado entre los no visibles, y lo vuelve visible, lo activa para el juego.
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

    /* Se obtiene una lista con el numero de Imagen de cada Cuadrado, se genera un HashSet de esta lista, 
    y este pasara a ser su valor. Si el tamaño inicial y final de la lista son diferentes, significa que hubo
    un elemento repetido */
    public boolean verificar(){
        imagenesCuadros = juego.getNumeroCuadros(cuadrosGraficar);
        int size0 = imagenesCuadros.size();
        Set<Integer> hashSet = new HashSet<>(imagenesCuadros);
        imagenesCuadros.clear();
        imagenesCuadros.addAll(hashSet);
        int sizef = imagenesCuadros.size();
        return size0 != sizef;
    }

    // Cambia la imagen de cada Cuadrado, evitando que alguna de estas se repita.
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

        btnAdivinar.requestFocus();
        timer.setDelay(juego.getTiempo());
        timer.start();
    }

    public JLabel encontrarLabel(Cuadrado l){
        JLabel labelAux = new JLabel();
        switch(l.getNumero()){
            case 1 -> {
                labelAux = lblCuadrado1;
                break;
            }
            case 2 -> {
                labelAux = lblCuadrado2;
                break;
            }
            case 3 -> {
                labelAux = lblCuadrado3;
                break;
            }
            case 4 -> {
                labelAux = lblCuadrado4;
                break;
            }
            case 5 -> {
                labelAux = lblCuadrado5;
                break;
            }
            case 6 -> {
                labelAux = lblCuadrado6;
                break;
            }
            case 7 -> {
                labelAux = lblCuadrado7;
                break;
            }
            case 8 -> {
                labelAux = lblCuadrado8;
                break;
            }
        }
        return labelAux;
    }
    
    public List<JLabel> iluminarCuadrados(boolean iguales){
        borderTime.stop();
        btnAdivinar.setVisible(false);
        btnAdivinar.setBounds(0, 0, 100, 100);
        int imagenBuscar = lastCuadrado.getImagen();
        int lastIndex = cuadrosGraficar.indexOf(lastCuadrado);
        Cuadrado cuadradoAux = lastCuadrado;
        List<JLabel> listaLabels = new ArrayList<>();

        cuadrosGraficar.remove(lastCuadrado);
        for (Cuadrado cuadrado : cuadrosGraficar) {
            if(imagenBuscar == cuadrado.getImagen()){
                cuadradoAux = cuadrado;
                break;
            }           
        }

        cuadrosGraficar.add(lastIndex, lastCuadrado);

        Border bordeVerde = BorderFactory.createLineBorder(Color.GREEN, 4);
        Border bordeRojo = BorderFactory.createLineBorder(Color.RED, 4);

        if(iguales == true){
            encontrarLabel(lastCuadrado).setBorder(bordeVerde);
            encontrarLabel(cuadradoAux).setBorder(bordeVerde);
        } else {
            encontrarLabel(lastCuadrado).setBorder(bordeRojo);
            encontrarLabel(cuadradoAux).setBorder(bordeRojo);
        }


        listaLabels.add(encontrarLabel(lastCuadrado));
        listaLabels.add(encontrarLabel(cuadradoAux));

        return listaLabels;
    }

    public void apagarCuadros(List<JLabel> lista){
        for(JLabel j : lista){
            j.setBorder(null);
        }
    }

    // Cosas a realizar cuando hay una accion en el juego, y se determina que en este hay baldosas repetidas
    public void baldosasIguales(){
        timer.stop();
        reproducirSonido("acierto");
        final List<JLabel> listaLabels = iluminarCuadrados(true);
        Timer restart = new Timer(2500, null);
        restart.addActionListener((ActionEvent r) -> {
            apagarCuadros(listaLabels);
            btnAdivinar.setVisible(true);
            btnAdivinar.setBounds(600, 450, 130, 130);
            juego.setPuntuacion();
            lblPuntuacion.setText("Puntuacion " + 0 + juego.getPuntuacion() + "");
            juego.setAciertos();
            juego.setNivel(juego.getNivel() + 1);
            activar();
            if(juego.getTiempo() > 700){
                juego.setTiempo(juego.getTiempo() - 75);                
            }

            graficarDiferentes();
            restart.stop();
        });
        restart.start();
    }

    // Cosas a realizar cuando hay una acción en el juego, y no hay baldosas repetidas
    public void baldosasDistintas(){
        timer.stop();
        reproducirSonido("error");
        final List<JLabel> listaLabels = iluminarCuadrados(false);
        Timer restart = new Timer(2500, null);
        restart.addActionListener((ActionEvent r) -> {
            apagarCuadros(listaLabels);
            btnAdivinar.setVisible(true);
            btnAdivinar.setBounds(600, 450, 130, 130);
            juego.disminuirVidas();
            juego.errores();
            juego.setTiempo(1500);
            graficarDiferentes();
            if (juego.isHuboError()== true) {
                switch (juego.getErrores()) {
                    case 1 -> {
                        //btnVida3.setVisible(false);
                        lblvida3.setVisible(false);
                    }
                    case 2 -> {
                        //btnVida2.setVisible(false);
                        lblvida2.setVisible(false);
                    }
                    case 3 -> {
                        //btnVida1.setVisible(false);
                        lblvida1.setVisible(false);
                        timer.stop();
                        sonido.close();
                        reproducirSonido("derrota");
                        contenedorppal.removeAll();
                        SwingUtilities.updateComponentTreeUI(contenedorppal);
                        //this.setContentPane(fondoFin);
                        VentanaPerder estadisiticas = new VentanaPerder(juego);
                        dispose();
                        //this.setContentPane(fondoFin);
                        System.out.println("Fin del juego");
                        
                            
                    }
                }
            }

            restart.stop();
        });
        restart.start();
    }

    public void reproducirSonido(String cualSonido){
        switch(cualSonido){
            case "fondo" -> {
            try {
                sonido = AudioSystem.getClip();
                sonido.open(AudioSystem.getAudioInputStream(new File("src\\Musica\\fondo.wav")));
                sonido.start();
    
                sonido.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                System.out.println("" + e);
            }
            }
            case "cambio" -> play("src\\musica\\cambio.wav", juego.getTiempo()-100);
            case "acierto" -> play("src\\musica\\acierto.wav", 2000);
            case "error" -> play("src\\musica\\error.wav", 2000);
            case "derrota" -> play("src\\musica\\derrota.wav", 2000);
            default -> {
            }
        }
    }

    void play(String filePath, int delay2) {
        try {
            Clip sonido2 = AudioSystem.getClip();
            sonido2.open(AudioSystem.getAudioInputStream(new File(filePath)));
            sonido2.start();
            Timer timer2;
            timer2 = new Timer(delay2, e -> { sonido2.close(); });
            timer2.setRepeats(false);
            timer2.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("" + e);
        }
    }
    
    class manejadorEventos extends MouseAdapter implements KeyListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == btnAdivinar){
                if (verificar() == true) {
                    notClicked = false;
                    Timer click = new Timer(juego.getTiempo(),null);
                    click.addActionListener((ActionEvent cl) -> { apagar(); click.stop(); });
                    click.start();
                    baldosasIguales();    
                }else{
                    baldosasDistintas();
                }
            }
        }

        public void apagar(){
            notClicked = true;
            notPressed = true;
        }

        @Override
        public void keyPressed(KeyEvent f) {
            if(KeyEvent.VK_SPACE == f.getKeyCode()){
                if (f.getSource() == btnAdivinar){
                    if (verificar() == true) {
                        notPressed = false;
                        baldosasIguales();
                        Timer click = new Timer(juego.getTiempo(),null);
                        click.addActionListener((ActionEvent cl) -> { apagar(); click.stop(); });
                        click.start();    
                    }else{
                        baldosasDistintas();
                    }
                }
            } 
        }  
        @Override  
        public void keyReleased(KeyEvent f) {} 
        @Override   
        public void keyTyped(KeyEvent f) {}   
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

class fondoFinJuego extends JPanel{
    private Image imagen;

    
    @Override
    public void paint(Graphics g) {
        
        
        imagen = new ImageIcon(getClass().getResource("/imagenes/frames/fondoFin.png")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}