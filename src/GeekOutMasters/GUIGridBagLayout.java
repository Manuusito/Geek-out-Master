package GeekOutMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is used for play Geek out Masters
 * @autor Manuel Cuellar Montenegro -- 2041041 -- manuel.cuellar@correounivalle.edu.co
 * @version v.1.0.0 date:28/01/2022
 */
public class GUIGridBagLayout extends JFrame {

    private static final String MENSAJE_INICIO = "Bienvenido a Geek Out Masters " +
            "\nOprime el botón lanzar para iniciar el juego" +
            "\nEl objetivo de este juego es conseguir la mayor cantidad de puntos juntando dados cuya cara visible es la\n" +
            "cara 42." +
            "\nGeek Out Masters no es solo suerte, también importa la estrategia" +
            "\n Utiliza los botones Realizar para ejecutar la accion de los dos dados" +
            "\n Boton borras para eliminar la seleccion del primer dado"+
            "\n Boton reset para reiniciar el juego"

            ;

    private static final String MENSAJE_DADOS = "Uso de Dados en Geek Out Masters " +
            "\n1. El Meeple permite relanzar otro dado en juego, es decir, de la sección dados activos." +
            "\n2. La Nave Espacial envía un dado no usado (de la sección dados activos) a la sección de dados\n" +
            "inactivos."+
            "\n3. El Superhéroe permite que cualquier dado no usado (sección dados activos) sea volteado y\n" +
            "colocado en su cara opuesta." +
            "\n4. El Corazón permite tomar un dado de la sección de dados inactivos y lanzarlo para que sea un\n" +
            "nuevo dado activo." +
            "\n5. El Dragón es la cara que se quiere evitar, ya que si al final de la ronda es el último dado activo que\n" +
            "queda se habrán perdido todos los puntos ganados y acumulados." +
            "\n6. 42 es cara que permite sumar puntos al final de la ronda.";


    private Header headerProject;
    private JLabel dado1;
    private JLabel dado2;
    private JLabel dado3;
    private JLabel dado4;
    private JLabel dado5;
    private JLabel dado6;
    private JLabel dado7;
    private JLabel dado8;
    private JLabel dado9;
    private JLabel dado10;
    private JLabel marcador;
    private JTextArea puntajeTex;
    private JButton lanzar;
    private JButton ayudax;
    private JButton Reset;
    private JButton Borrar;
    private JButton terminarRonda, prueba;
    private JPanel panelDados, panelInactivos, panelDatos, panelUsados;
    private ImageIcon imageDado, ImageMarcador;
    private Escucha escucha;
    private Click click;
    private ModelGeek modelGeek;
    private int rondas, puntos;

    /**
     * Constructor of GUI class
     */
    public GUIGridBagLayout(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        //this.setSize(1200,700);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        //Set up JComponents
        //headerProject = new Header("Header ...", Color.BLACK);
        //this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        escucha = new Escucha();
        click =new Click();
        modelGeek = new ModelGeek();


        ayudax = new JButton("?");
        ayudax.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        this.add(ayudax,constraints);

        Borrar = new JButton("Borrar");
        Borrar.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(Borrar,constraints);

        terminarRonda = new JButton("Terminar Ronda");
        terminarRonda.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(terminarRonda,constraints);


        Reset = new JButton("Reset");
        Reset.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(Reset,constraints);

        imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
        dado1= new JLabel(imageDado);
        dado1.addMouseListener(click);
        dado1.addMouseMotionListener(click);
        dado1.addKeyListener(click);

        dado2= new JLabel(imageDado);
        dado2.addMouseListener(click);
        dado2.addMouseMotionListener(click);
        dado2.addKeyListener(click);

        dado3= new JLabel(imageDado);
        dado3.addMouseListener(click);
        dado3.addMouseMotionListener(click);
        dado3.addKeyListener(click);

        dado4= new JLabel(imageDado);
        dado4.addMouseListener(click);
        dado4.addMouseMotionListener(click);
        dado4.addKeyListener(click);

        dado5= new JLabel(imageDado);
        dado5.addMouseListener(click);
        dado5.addMouseMotionListener(click);
        dado5.addKeyListener(click);

        dado6= new JLabel(imageDado);
        dado6.addMouseListener(click);
        dado6.addMouseMotionListener(click);
        dado6.addKeyListener(click);

        dado7= new JLabel(imageDado);
        dado7.addMouseListener(click);
        dado7.addMouseMotionListener(click);
        dado7.addKeyListener(click);


        panelDados = new JPanel();
        panelDados.setPreferredSize(new Dimension(400,240));
        panelDados.setBorder(BorderFactory.createTitledBorder("Tus Dados Activos"));
        panelDados.addMouseListener(click);
        panelDados.addMouseMotionListener(click);
        panelDados.addKeyListener(click);
        panelDados.add(dado1);
        panelDados.add(dado2);
        panelDados.add(dado3);
        panelDados.add(dado4);
        panelDados.add(dado5);
        panelDados.add(dado6);
        panelDados.add(dado7);

        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelDados,constraints);


        imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
        dado8= new JLabel(imageDado);
        dado9= new JLabel(imageDado);
        dado10= new JLabel(imageDado);

        panelInactivos = new JPanel();
        panelInactivos.addMouseListener(click);
        panelInactivos.addMouseMotionListener(click);
        panelInactivos.addKeyListener(click);
        panelInactivos.setPreferredSize(new Dimension(400,240));
        panelInactivos.setBorder(BorderFactory.createTitledBorder("Tus Dados Inactivos"));
        panelInactivos.add(dado8);
        panelInactivos.add(dado9);
        panelInactivos.add(dado10);

        constraints.gridx=1;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelInactivos,constraints);

        panelUsados = new JPanel();
        panelUsados.addMouseListener(click);        panelUsados.addMouseMotionListener(click);
        panelUsados.addKeyListener(click);
        panelUsados.setPreferredSize(new Dimension(400,240));
        panelUsados.setBorder(BorderFactory.createTitledBorder("Tus Dados Usados"));

        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelUsados,constraints);


        ImageMarcador = new ImageIcon(getClass().getResource("/resources/descarga.jpeg"));
        marcador = new JLabel(ImageMarcador);

        panelDatos = new JPanel();
        panelDatos.setPreferredSize(new Dimension(400,240));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Tabla de puntaje"));
        panelDatos.add(marcador);

        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelDatos,constraints);

        lanzar= new JButton("Iniciar");
        lanzar.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        add(lanzar,constraints);

        prueba= new JButton("Realizar");
        prueba.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        this.add(prueba,constraints);

        puntajeTex = new JTextArea(1,31);
        puntajeTex.setBorder(BorderFactory.createTitledBorder("Resultados"));
        puntajeTex.setText("Rondas: "+rondas+ " Puntos: "+puntos);
        puntajeTex.setBackground(null);
        puntajeTex.setEditable(false);

        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(puntajeTex,constraints);

        //corazon=0;
        //yaEsta=0;
        //rondas=0;
        //puntos=0;

    }

public void caraToDado1() {
    panelUsados.add(dado1);
    panelDados.remove(dado1);
    }
/**     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIGridBagLayout GeekOutMasters = new GUIGridBagLayout();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==lanzar) {

                modelGeek.calcularTiro();
                int[] caras = modelGeek.getCaras();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[0] + ".jpeg"));
                dado1.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[1] + ".jpeg"));
                dado2.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[2] + ".jpeg"));
                dado3.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[3] + ".jpeg"));
                dado4.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[4] + ".jpeg"));
                dado5.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[5] + ".jpeg"));
                dado6.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[6] + ".jpeg"));
                dado7.setIcon(imageDado);

                rondas=rondas+1;
                puntajeTex.setText("Rondas: "+rondas+ " Puntos: "+puntos);

                revalidate();
                repaint();

            }else if (e.getSource()==ayudax){
                JOptionPane.showMessageDialog(null,MENSAJE_INICIO+MENSAJE_DADOS);
            }else if (e.getSource()== Reset) {
                rondas=0;
                puntos=0;


                puntajeTex.setText("Rondas: "+rondas+ " Puntos: "+puntos);

                modelGeek.calcularTiro();
                int[] caras = modelGeek.getCaras();
                imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
                dado1.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
                dado2.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
                dado3.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
                dado4.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
                dado5.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
                dado6.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
                dado7.setIcon(imageDado);

                imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
                dado8.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
                dado9.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
                dado10.setIcon(imageDado);





                modelGeek.BorrarCorazones();
                modelGeek.BorrarUsados();
                JOptionPane.showMessageDialog(null, "Juego Reiniciado.");

                revalidate();
                repaint();

                ;

            }else if (e.getSource()==terminarRonda){

                if (rondas>=5) {
                    if (puntos >= 30) {
                        JOptionPane.showMessageDialog(null, "Has ganado Felicitaciones !!" +
                                "\n Reinicia el juego para jugar otra vez.");

                    } else
                        JOptionPane.showMessageDialog(null, "Has perdido" +
                                "\n Reinicia el juego para jugar otra vez.");

                }
                else {

                    JOptionPane.showMessageDialog(null, "Pasate de Ronda.");
                    modelGeek.terminarRonda();
                    modelGeek.BorrarCorazones();
                    puntos=modelGeek.getPuntaje();

                    rondas=rondas+1;
                    puntajeTex.setText("Rondas: "+rondas+ " Puntos: "+puntos);

                    revalidate();
                    repaint();

                    modelGeek.calcularTiro();
                    int[] caras = modelGeek.getCaras();
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[0] + ".jpeg"));
                    dado1.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[1] + ".jpeg"));
                    dado2.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[2] + ".jpeg"));
                    dado3.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[3] + ".jpeg"));
                    dado4.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[4] + ".jpeg"));
                    dado5.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[5] + ".jpeg"));
                    dado6.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[6] + ".jpeg"));
                    dado7.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
                    dado8.setIcon(imageDado);
                    imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
                    dado9.setIcon(imageDado);

                    imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
                    dado10.setIcon(imageDado);



                    revalidate();
                    repaint();

                }






            }else if (e.getSource()==prueba) {
                int [] Usando = modelGeek.ObtenUsando();
                int [] caras = modelGeek.getCaras();
                modelGeek.getCorazones();

                modelGeek.Realizar();
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[0] + ".jpeg"));
                dado1.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[1] + ".jpeg"));
                dado2.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[2] + ".jpeg"));
                dado3.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[3] + ".jpeg"));
                dado4.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[4] + ".jpeg"));
                dado5.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[5] + ".jpeg"));
                dado6.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[6] + ".jpeg"));
                dado7.setIcon(imageDado);

                if(modelGeek.getCorazones()==1) {
                    imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[7] + ".jpeg"));
                    dado8.setIcon(imageDado);
                }
                else if (modelGeek.getCorazones()==2){
                        imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[8] + ".jpeg"));
                        dado9.setIcon(imageDado);
                }
                else if (modelGeek.getCorazones()==3){
                        imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[9] + ".jpeg"));
                        dado10.setIcon(imageDado);
                }else{

                }







                /*

                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[8] + ".jpeg"));
                dado9.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[9] + ".jpeg"));
                dado10.setIcon(imageDado);

                 */


                //JOptionPane.showMessageDialog(null,""+Usando[0]+Usando[1]+Usando[2]+Usando[3]);


                modelGeek.BorrarUsados();




                revalidate();
                repaint();





            }
            else if (e.getSource()==Borrar){
                modelGeek.BorrarUsados();
            }

        }
    }

    private class Click implements MouseListener, MouseMotionListener, KeyListener {
        @Override

        public void mouseClicked(MouseEvent e) {







            if (e.getSource() == dado1) {
                int [] Usando = modelGeek.ObtenUsando();
                int[] caras = modelGeek.getCaras();




                if (Usando[0] == 0) {
                    Usando[0] = caras[0];
                    Usando[2] = 1;
                }
                else {
                    Usando[1] = caras[0];
                    Usando[3] = 1;
                }

            }

            if (e.getSource() == dado2) {
                int [] Usando = modelGeek.ObtenUsando();
                int[] caras = modelGeek.getCaras();



                if (Usando[0] == 0) {
                    Usando[0] = caras[1];
                    Usando[2] = 2;

                } else {
                    Usando[1] = caras[1];
                    Usando[3] = 2;
                }

            }
            if (e.getSource() == dado3) {
                int [] Usando = modelGeek.ObtenUsando();
                int[] caras = modelGeek.getCaras();


                if (Usando[0] == 0) {
                    Usando[0] = caras[2];
                    Usando[2] = 3;

                } else {
                    Usando[1] = caras[2];
                    Usando[3] = 3;
                }

            }
            if (e.getSource() == dado4) {
                int [] Usando = modelGeek.ObtenUsando();
                int[] caras = modelGeek.getCaras();


                if (Usando[0] == 0) {
                    Usando[0] = caras[3];
                    Usando[2] = 4;

                } else {
                    Usando[1] = caras[3];
                    Usando[3] = 4;
                }


            }
            if (e.getSource() == dado5) {
                int [] Usando = modelGeek.ObtenUsando();
                int[] caras = modelGeek.getCaras();


                if (Usando[0] == 0) {
                    Usando[0] = caras[4];
                    Usando[2] = 5;

                } else {
                    Usando[1] = caras[4];
                    Usando[3] = 5;
                }

            }
            if (e.getSource() == dado6) {
                int [] Usando = modelGeek.ObtenUsando();
                int[] caras = modelGeek.getCaras();


                if (Usando[0] == 0) {
                    Usando[0] = caras[5];
                    Usando[2] = 6;

                } else {
                    Usando[1] = caras[5];
                    Usando[3] = 6;
                }

            }
            if (e.getSource() == dado7) {
                int [] Usando = modelGeek.ObtenUsando();
                int[] caras = modelGeek.getCaras();


                if (Usando[0] == 0) {
                    Usando[0] = caras[6];
                    Usando[2] = 7;

                } else {
                    Usando[1] = caras[6];
                    Usando[3] = 7;
                }


            }
            if (e.getSource() == dado8) {
                int [] Usando = modelGeek.ObtenUsando();
                int[] caras = modelGeek.getCaras();


                if (Usando[0] == 0) {
                    Usando[0] = caras[7];
                    Usando[2] = 8;

                } else {
                    Usando[1] = caras[7];
                    Usando[3] = 8;
                }


            }
            if (e.getSource() == dado9) {
                int [] Usando = modelGeek.ObtenUsando();
                int[] caras = modelGeek.getCaras();


                if (Usando[0] == 0) {
                    Usando[0] = caras[8];
                    Usando[2] = 9;

                } else {
                    Usando[1] = caras[8];
                    Usando[3] = 9;
                }






            }
            if (e.getSource() == dado10) {
                int [] Usando = modelGeek.ObtenUsando();
                int[] caras = modelGeek.getCaras();


                if (Usando[0] == 0) {
                    Usando[0] = caras[9];
                    Usando[2] = 10;

                } else {
                    Usando[1] = caras[9];
                    Usando[3] = 10;
                }







            }


        }



        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }


        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {



        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

    }
}
