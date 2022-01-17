package GeekOutMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUIGridBagLayout extends JFrame {

    private static final String MENSAJE_INICIO = "Bienvenido a Geek Out Masters " +
            "\nOprime el botón lanzar para iniciar el juego" +
            "\nEl objetivo de este juego es conseguir la mayor cantidad de puntos juntando dados cuya cara visible es la\n" +
            "cara 42." +
            "\nGeek Out Masters no es solo suerte, también importa la estrategia ya que una vez que se lanzan\n" +
            "los dados TODAS las caras deberán ejecutarse:" +
            "\nSi sacas cualquier otro valor establecerás el Punto" +
            "\nEstando en punto, podrás seguir lanzando los dados" +
            "\n pero ahora ganarás si sacas nuevamente el valor del Punto" +
            "\nsin que previamente hayas sacado 7";

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
    private JButton usoDados;
    private JPanel panelDados, panelInactivos, panelDatos, panelUsados;
    private ImageIcon imageDado, ImageMarcador;
    private GUIGridBagLayout.Escucha escucha;
    private ModelGeek modelGeek;

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
        modelGeek = new ModelGeek();

        ayudax = new JButton("?");
        ayudax.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        this.add(ayudax,constraints);

        usoDados = new JButton("Dados ¿?");
        usoDados.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(usoDados,constraints);

        imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpeg"));
        dado1= new JLabel(imageDado);
        dado2= new JLabel(imageDado);
        dado3= new JLabel(imageDado);
        dado4= new JLabel(imageDado);
        dado5= new JLabel(imageDado);
        dado6= new JLabel(imageDado);
        dado7= new JLabel(imageDado);

        panelDados = new JPanel();
        panelDados.setPreferredSize(new Dimension(400,240));
        panelDados.setBorder(BorderFactory.createTitledBorder("Tus Dados Activos"));
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



        puntajeTex = new JTextArea(1,31);
        puntajeTex.setBorder(BorderFactory.createTitledBorder("Resultados"));
        puntajeTex.setText("Rondas: "+ "Puntos: ");
        puntajeTex.setBackground(null);
        puntajeTex.setEditable(false);

        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(puntajeTex,constraints);
























    }

    /**
     * Main process of the Java program
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
                //imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[7] + ".jpeg"));
                //dado8.setIcon(imageDado);
                //imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[8] + ".jpeg"));
                //dado9.setIcon(imageDado);
                //imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[9] + ".jpeg"));
                //dado10.setIcon(imageDado);

                revalidate();
                repaint();

            }else if (e.getSource()==ayudax){
                JOptionPane.showMessageDialog(null,MENSAJE_INICIO);
            }else if (e.getSource()==usoDados){
                JOptionPane.showMessageDialog(null,MENSAJE_DADOS);
        }






        }
    }
}
