package jugador;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import jugador.Erencia_17161238.*;
import static jugador.Ventana.fileWriter;

public class AnimalVentana extends JFrame {

    /*La palabara 'extends' nos hace referencia a que extenderemos una clase (Herencia),
    para poder utilizar la Herencia en la programacion se escribe  ->  public class NombreClase   extends NombreClaseAHeredar{
            //Bloque de codigo.
    }*/
    JPanel panelPrincipal;/*panelPrincipal-> objeto de la clase JPanel -> nos permite colocar elementos sobre el.*/

    JPanel panelSuperior,
            panelInferior,
            panelSuperiorP,
            panelSuperiorS;

    JButton boton_CD,
            boton_MD,
            boton_Salir;

    JRadioButton radio_P,
            radio_G,
            radio_V;
    ButtonGroup grupo;

    JTextField texto_Nom,/*cajas de texto */
            texto_Tam,
            texto_Raza,
            texto_Sexo,
            texto_Pat,
            texto_Edad,
            texto_Ext;
    JLabel label_Nom,/*Etiquetas para poder poner texto*/
            label_Tam,
            label_Raza,
            label_Sexo,
            label_Pat,
            label_Edad,
            label_Ext;

    Perro miPerro;// Declaracion del objeto miPerro
    Gato miGato;// Declaracion del objeto miGato
    Vaca miVaca;// Declaracion del objeto miVaca

    static FileWriter fileWriter = null;
    static BufferedWriter buff = null;

    /*este como arreglo por que usaremos muchos jugadores;*/
    //Los declaramos globales para oder usarlos en cualquier momento del programa.
    public AnimalVentana() {/*Constructor de la clase ,
      El utilizar el contructor de una clase nos da la ventaja de ser la primera cosa que se ejecuta cuando un objeto es creado. 
        La herencia nos permite utilizar metodos directamente de la clase extendida.*/
        iniciarComponentes();//Metdo que inicializara los componenetes que construiran nuestra ventana.
        crear_archivo();
    }

    private void iniciarComponentes() {

        panelPrincipal = new JPanel();//Inicalizamos el objeto.
        panelPrincipal.setPreferredSize(new Dimension(500, 800));
        panelPrincipal.setLayout(new GridLayout(2, 1));/*
        setLayout -> Define el comportamiento de la distribucion del contenido en el objeto padre. 
        new GridLayout(filas,columnas) -> crea un Layout de tipo griya (cuadricula). 
         */

        radio_P = new JRadioButton("Perro.");//Declaramos los botonoes de radio.
        radio_P.setPreferredSize(new Dimension(200, 45));
        radio_P.addChangeListener(new ChangeListener() {/*Escuchador de eventos de cambio sobre el boton de radio.*/
            @Override
            public void stateChanged(ChangeEvent e) {
                radio_PCambio(e);
            }
        });
        radio_G = new JRadioButton("Gato.");
        radio_G.setPreferredSize(new Dimension(200, 45));
        radio_G.addChangeListener(new ChangeListener() {/*Escuchador de eventos de cambio sobre el boton de radio.*/
            @Override
            public void stateChanged(ChangeEvent e) {
                radio_PCambio(e);
            }
        });
        radio_V = new JRadioButton("Vaca.");
        radio_V.setPreferredSize(new Dimension(200, 45));
        radio_V.addChangeListener(new ChangeListener() {/*Escuchador de eventos de cambio sobre el boton de radio.*/
            @Override
            public void stateChanged(ChangeEvent e) {
                radio_PCambio(e);
            }
        });

        grupo = new ButtonGroup();/*Este grupo de botones nos sirve para que no se pueda seleccionar mas de un boton.*/
        grupo.add(radio_P);
        grupo.add(radio_G);
        grupo.add(radio_V);

        panelSuperiorP = new JPanel();
        panelSuperiorP.setBorder(BorderFactory.createTitledBorder("Tipo de animal."));/*creamos un borde con titulo para poder colocarle el titulo.*/
        panelSuperiorP.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSuperiorP.add(radio_P);
        panelSuperiorP.add(radio_G);
        panelSuperiorP.add(radio_V);

        boton_CD = new JButton("Capturar Datos.");//Inicalizamos el objeto. pasandole el texto como parametro.
        boton_CD.setPreferredSize(new Dimension(((500 - 20) / 2), 50));
        boton_CD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonAP(e);
            }
        });

        boton_MD = new JButton("Mostrar Datos.");
        boton_MD.setPreferredSize(new Dimension(((500 - 20) / 2), 50));
        boton_MD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonMDAP(e);
            }
        });

        boton_Salir = new JButton("Salir.");
        boton_Salir.setPreferredSize(new Dimension(((500 - 20) / 2), 50));
        boton_Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);/*Nos sirve para poder terminar todo las instrucciones que el prorama este haciendo y se cierre*/
            }
        });

        panelSuperiorS = new JPanel();
        panelSuperiorS.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
        panelSuperiorS.add(boton_CD);
        panelSuperiorS.add(boton_MD);
        panelSuperiorS.add(boton_Salir);
//        panelSuperiorS.setBackground(Color.red);

        panelSuperior = new JPanel();
        panelPrincipal.add(panelSuperior);/*Añadimos el panel superior al panel principal*/

        panelSuperior.setLayout(new GridLayout(1, 2, 10, 10));
        panelSuperior.add(panelSuperiorP);
        panelSuperior.add(panelSuperiorS);

        /*_____________________________________________________________________________________*/
        texto_Nom = new JTextField();
        texto_Nom.setPreferredSize(new Dimension(300, 45));
        texto_Tam = new JTextField();
        texto_Tam.setPreferredSize(new Dimension(300, 45));
        texto_Raza = new JTextField();
        texto_Raza.setPreferredSize(new Dimension(300, 45));
        texto_Sexo = new JTextField();
        texto_Sexo.setPreferredSize(new Dimension(300, 45));
        texto_Pat = new JTextField();
        texto_Pat.setPreferredSize(new Dimension(300, 45));
        texto_Edad = new JTextField();
        texto_Edad.setPreferredSize(new Dimension(300, 45));
        texto_Ext = new JTextField();
        texto_Ext.setPreferredSize(new Dimension(300, 45));

        label_Nom = new JLabel("Nombre.");
        label_Nom.setPreferredSize(new Dimension(100, 45));
        label_Nom.setHorizontalAlignment(SwingConstants.RIGHT);

        label_Tam = new JLabel("tamanio.");
        label_Tam.setPreferredSize(new Dimension(100, 45));
        label_Tam.setHorizontalAlignment(SwingConstants.RIGHT);

        label_Raza = new JLabel("Raza.");
        label_Raza.setPreferredSize(new Dimension(100, 45));
        label_Raza.setHorizontalAlignment(SwingConstants.RIGHT);

        label_Sexo = new JLabel("Sexo.");
        label_Sexo.setPreferredSize(new Dimension(100, 45));
        label_Sexo.setHorizontalAlignment(SwingConstants.RIGHT);

        label_Pat = new JLabel("Patas.");
        label_Pat.setPreferredSize(new Dimension(100, 45));
        label_Pat.setHorizontalAlignment(SwingConstants.RIGHT);

        label_Edad = new JLabel("Edad.");
        label_Edad.setPreferredSize(new Dimension(100, 45));
        label_Edad.setHorizontalAlignment(SwingConstants.RIGHT);

        label_Ext = new JLabel("Extra.");
        label_Ext.setPreferredSize(new Dimension(100, 45));
        label_Ext.setHorizontalAlignment(SwingConstants.RIGHT);

        panelInferior = new JPanel();
        panelPrincipal.add(panelInferior);/*Añadimos el panel superior al panel inferior*/
        panelInferior.setBorder(BorderFactory.createTitledBorder("Datos del animal."));

        panelInferior.add(label_Nom);
        panelInferior.add(texto_Nom);
        panelInferior.add(label_Tam);
        panelInferior.add(texto_Tam);
        panelInferior.add(label_Raza);
        panelInferior.add(texto_Raza);
        panelInferior.add(label_Sexo);
        panelInferior.add(texto_Sexo);
        panelInferior.add(label_Pat);
        panelInferior.add(texto_Pat);
        panelInferior.add(label_Edad);
        panelInferior.add(texto_Edad);
        panelInferior.add(label_Ext);
        panelInferior.add(texto_Ext);

        setDefaultCloseOperation(EXIT_ON_CLOSE);/*con este metodo le dijremos a la clase que se cierre cuando hayamos pulsado el boton rojo 
        para cerrar la pestaña 'X'*/

        setSize(530, 850);/*Nos permite decirle a la ventana las dimenciones que tendra cuando esta aparesca.*/

        setLocationRelativeTo(null);
        /*Ubicacion relativa de la ventana,al pasarle 'null' como parametro
        le estamos diciendo que se muestre en el centro de la pantalla  */

        setTitle("Animalitos.");/*Metodo para ponerle ttulo a nuestra ventana.*/

        getContentPane().add(panelPrincipal);
        /*Establecemos el contenido del panel principal.
         getContentPane-> Pane principal 
        panelPrincipal-> contenido.
         */

        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));/*
        getContentPane()-> obtenemos el Pane principal 
         setLayout -> Define el comportamiento de la distribucion de contenido en el objeto padre. 
        new FlowLayout() -> crea un Layout de tipo flujo.
        FlowLayout.CENTER -> Nos dice en donde se ubicara el flujo del contenido.
         */

    }

    private void radio_PCambio(ChangeEvent e) {
        if (radio_G.isSelected()) {/*comprobamos si el elemento a sido seleccionado */
            label_Ext.setText("Numero.");
        } else if (radio_V.isSelected()) {
            label_Ext.setText("Leche.");
        } else {
            label_Ext.setText("Extra.");
        }
    }

    private void botonAP(ActionEvent e) {

        //isSelected() -> nos regresa el estado (booleano true-false) del boton si esta o no activo.
        if (radio_P.isSelected()) {
            /*texto_Nom.getText()-> Nos regresa le texto que escribimos sobre  la caja */
 /*Al pasarle los parametros estamos rellenanado los atributos del objeto 'miPortero'  */
            miPerro = new Perro(texto_Nom.getText(), texto_Tam.getText(), texto_Raza.getText(), texto_Sexo.getText(),
                    Integer.parseInt(texto_Pat.getText()), Integer.parseInt(texto_Edad.getText()), texto_Ext.getText());
        } else if (radio_G.isSelected()) {
            //El primer objeto del arreglo equibaldra a el defensa del equipo.
            miGato = new Gato(texto_Nom.getText(), texto_Tam.getText(), texto_Raza.getText(), texto_Sexo.getText(),
                    Integer.parseInt(texto_Pat.getText()), Integer.parseInt(texto_Edad.getText()), Integer.parseInt(texto_Ext.getText()));
        } else if (radio_V.isSelected()) {
            //El segundo objeto del arreglo equibaldra a el Medio campista del equipo.
            miVaca = new Vaca(texto_Nom.getText(), texto_Tam.getText(), texto_Raza.getText(), texto_Sexo.getText(),
                    Integer.parseInt(texto_Pat.getText()), Integer.parseInt(texto_Edad.getText()), Float.parseFloat(texto_Ext.getText()));
        } else {
            JOptionPane.showMessageDialog(null, "No selecionaste algun animal.");
        }
        generar_archivo();
    }

    public static void crear_archivo() {
        //Para la creacion del archivo necesitamos hacer uso de
        //una clausula try-catch
        try {
            //para poder usar el buffer necesita de un objeto FileWriter
            //fileWriter necesita como paramtero el nombre de tu archivo
            fileWriter = new FileWriter("Animales.txt");
            buff = new BufferedWriter(fileWriter);
        } catch (Exception e) {
            System.out.println("Error al crear el archivo !!!");
            e.printStackTrace();
        }
    }

    public void generar_archivo() {
        try {
            //aca le damos   
            buff.write(texto_Nom.getText() + ","
                    + texto_Tam.getText() + ","
                    + texto_Raza.getText() + ","
                    + texto_Sexo.getText() + ","
                    + texto_Pat.getText() + ","
                    + texto_Edad.getText() + ","
                    + texto_Ext.getText());
            buff.newLine();
            buff.flush();
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");

            e.printStackTrace();

        }
    }

    private void botonMDAP(ActionEvent e) {
        if (radio_P.isSelected()) {
            JOptionPane.showMessageDialog(null, miPerro);//Con solo poner el nombre del objeto, este invocara en metodo 'toString'.
        } else if (radio_G.isSelected()) {
            JOptionPane.showMessageDialog(null, miGato);
        } else if (radio_V.isSelected()) {
            JOptionPane.showMessageDialog(null, miVaca);
        } else {
            JOptionPane.showMessageDialog(null, "No selecionaste algun animal.");
        }

    }

    public static void main(String[] args) {/*Hilo principal de ejecucion del programa.*/
 /*_____________________________________Para que no se va tna  feo :v______________________________________________________________________*/
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnimalVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnimalVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnimalVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnimalVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /*______________________________________________________________________________________________________________________*/

        new AnimalVentana().setVisible(true);
    }
}
