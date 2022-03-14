/* Instituto Tecnológico de Oaxaca
 * Christian Perez Ruiz 19161379
 * Javier Manuel Pérez Santos 19161381
 * Programa: Proyecto Final Clase
 */
package jugador;

import java.awt.Color;
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
import static jugador.EscuelaVentana.fileWriter;

public class EscuelaVentana extends JFrame {

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
            radio_D,
            radio_M,
            radio_Del;
    ButtonGroup grupo;

    JTextField texto_NU,/*cajas de texto */
            texto_Nom,
            texto_MJ,
            texto_GA;
    JLabel label_NU,/*Etiquetas para poder poner texto*/
            label_Nom,
            label_MJ,
            label_GA;
    Estudiante miEstudiante; //declaramos el objeto  'miPortero ' de la clase Portero.
    Persona1 personas[];//declaramos el arreglo  'jugadorInde ' de la clase Jugador.
    static FileWriter fileWriter = null;
    static BufferedWriter buff = null;

    /*este como arreglo por que usaremos muchos jugadores;*/
    //Los declaramos globales para oder usarlos en cualquier momento del programa.
    public EscuelaVentana() {/*Constructor de la clase ,
      El utilizar el contructor de una clase nos da la ventaja de ser la primera cosa que se ejecuta cuando un objeto es creado. 
        La herencia nos permite utilizar metodos directamente de la clase extendida.*/
        personas = new Persona1[4];  //declaramos el arreglo  'jugadorInde ' de la clase Jugador.
        iniciarComponentes();//Metdo que inicializara los componenetes que construiran nuestra ventana.
    crear_archivo();
    }

    private void iniciarComponentes() {

        panelPrincipal = new JPanel();//Inicalizamos el objeto.
        panelPrincipal.setPreferredSize(new Dimension(500, 500));
        panelPrincipal.setLayout(new GridLayout(2, 1));/*
        setLayout -> Define el comportamiento de la distribucion del contenido en el objeto padre. 
        new GridLayout(filas,columnas) -> crea un Layout de tipo griya (cuadricula). 
         */

        radio_P = new JRadioButton("Estudiante.");//Declaramos los botonoes de radio.
        radio_P.setPreferredSize(new Dimension(200, 45));
        radio_P.addChangeListener(new ChangeListener() {/*Escuchador de eventos de cambio sobre el boton de radio.*/
            @Override
            public void stateChanged(ChangeEvent e) {
                radio_PCambio(e);
            }
        });
        radio_D = new JRadioButton("Director.");
        radio_D.setPreferredSize(new Dimension(200, 45));
        radio_M = new JRadioButton("Maestro.");
        radio_M.setPreferredSize(new Dimension(200, 45));
        radio_Del = new JRadioButton("Conserje.");
        radio_Del.setPreferredSize(new Dimension(200, 45));

        grupo = new ButtonGroup();/*Este grupo de botones nos sirve para que no se pueda seleccionar mas de un boton.*/
        grupo.add(radio_P);
        grupo.add(radio_D);
        grupo.add(radio_M);
        grupo.add(radio_Del);

        panelSuperiorP = new JPanel();
        panelSuperiorP.setBorder(BorderFactory.createTitledBorder("Puesto de la persona."));/*creamos un borde con titulo para poder colocarle el titulo.*/
        panelSuperiorP.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSuperiorP.add(radio_P);
        panelSuperiorP.add(radio_D);
        panelSuperiorP.add(radio_M);
        panelSuperiorP.add(radio_Del);

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
        texto_NU = new JTextField();
        texto_NU.setPreferredSize(new Dimension(300, 45));
        texto_Nom = new JTextField();
        texto_Nom.setPreferredSize(new Dimension(300, 45));
        texto_MJ = new JTextField();
        texto_MJ.setPreferredSize(new Dimension(300, 45));
        texto_GA = new JTextField();
        texto_GA.setPreferredSize(new Dimension(300, 45));

       

        label_Nom = new JLabel("Nombre.");
        label_Nom.setPreferredSize(new Dimension(100, 45));
        label_Nom.setHorizontalAlignment(SwingConstants.RIGHT);

        label_MJ = new JLabel("Nacionalidad.");
        label_MJ.setPreferredSize(new Dimension(100, 45));
        label_MJ.setHorizontalAlignment(SwingConstants.RIGHT);
        
        label_NU = new JLabel("Edad.");
        label_NU.setPreferredSize(new Dimension(100, 45));
        label_NU.setHorizontalAlignment(SwingConstants.RIGHT);

        label_GA = new JLabel("Salario mensual $");
        label_GA.setPreferredSize(new Dimension(100, 45));
        label_GA.setHorizontalAlignment(SwingConstants.RIGHT);

        panelInferior = new JPanel();
        panelPrincipal.add(panelInferior);/*Añadimos el panel superior al panel inferior*/
        panelInferior.setBorder(BorderFactory.createTitledBorder("Datos de la persona."));

        panelInferior.add(label_NU);
        panelInferior.add(texto_NU);
        panelInferior.add(label_Nom);
        panelInferior.add(texto_Nom);
        panelInferior.add(label_MJ);
        panelInferior.add(texto_MJ);
        panelInferior.add(label_GA);
        panelInferior.add(texto_GA);

        setDefaultCloseOperation(EXIT_ON_CLOSE);/*con este metodo le dijremos a la clase que se cierre cuando hayamos pulsado el boton rojo 
        para cerrar la pestaña 'X'*/

        setSize(530, 550);/*Nos permite decirle a la ventana las dimenciones que tendra cuando esta aparesca.*/

        setLocationRelativeTo(null);
        /*Ubicacion relativa de la ventana,al pasarle 'null' como parametro
        le estamos diciendo que se muestre en el centro de la pantalla  */

        setTitle("Escuela Primaria 'Charles Xavier'.");/*Metodo para ponerle ttulo a nuestra ventana.*/

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
        if (radio_P.isSelected()) {/*comprobamos si el elemento a sido seleccionado */
            texto_GA.setEnabled(false);/*si fuel abilitado, desabilitamos la caja de texto para los goles */
        } else {
            texto_GA.setEnabled(true);
        }
    }

    private void botonAP(ActionEvent e) {

        //isSelected() -> nos regresa el estado (booleano true-false) del boton si esta o no activo.
        if (radio_P.isSelected()) {
            /*texto_Nom.getText()-> Nos regresa le texto que escribimos sobre  la caja */
 /*Al pasarle los parametros estamos rellenanado los atributos del objeto 'miPortero'  */
            miEstudiante = new Estudiante(texto_Nom.getText(), texto_MJ.getText(), Integer.parseInt(texto_NU.getText()));
            texto_GA.setText("0");
        } else if (radio_D.isSelected()) {
            //El primer objeto del arreglo equibaldra a el defensa del equipo.
            personas[0] = new Persona1(texto_Nom.getText(), texto_MJ.getText(), Integer.parseInt(texto_NU.getText()), Integer.parseInt(texto_GA.getText()));
        } else if (radio_M.isSelected()) {
            //El segundo objeto del arreglo equibaldra a el Medio campista del equipo.
            personas[1] = new Persona1(texto_Nom.getText(), texto_MJ.getText(), Integer.parseInt(texto_NU.getText()), Integer.parseInt(texto_GA.getText()));
        } else if (radio_Del.isSelected()) {
            //El tercer objeto del arreglo equibaldra a el Delantero del equipo.
            personas[2] = new Persona1(texto_Nom.getText(), texto_MJ.getText(), Integer.parseInt(texto_NU.getText()), Integer.parseInt(texto_GA.getText()));
        } else {
            JOptionPane.showMessageDialog(null, "No selecionaste a nadie.");
        }
        generar_archivo();
    }
    public static void crear_archivo() {
        //Para la creacion del archivo necesitamos hacer uso de
        //una clausula try-catch
        try {
            //para poder usar el buffer necesita de un objeto FileWriter
            //fileWriter necesita como paramtero el nombre de tu archivo
            fileWriter = new FileWriter("PersonalEscolar.txt");
            buff = new BufferedWriter(fileWriter);
        } catch (Exception e) {
            System.out.println("Error al crear el archivo !!!");
            e.printStackTrace();
        }
    }

    public void generar_archivo(){
        

        
                try {
                    //aca le damos   
                    buff.write(texto_Nom.getText()+","+
                                texto_NU.getText()+","+
                                texto_MJ.getText()+","+ 
                                texto_GA.getText());
                    buff.newLine();
                    buff.flush();
                } catch (Exception e) {
                    System.out.println("Error in CsvFileWriter !!!");

                    e.printStackTrace();
                
            
        }
    }

    private void botonMDAP(ActionEvent e) {
        if (radio_P.isSelected()) {
            JOptionPane.showMessageDialog(null, miEstudiante);//Con solo poner el nombre del objeto, este invocara en metodo 'toString'.
        } else if (radio_D.isSelected()) {
            JOptionPane.showMessageDialog(null, personas[0]);
        } else if (radio_M.isSelected()) {
            JOptionPane.showMessageDialog(null, personas[1]);
        } else if (radio_Del.isSelected()) {
            JOptionPane.showMessageDialog(null, personas[2]);
        } else {
            JOptionPane.showMessageDialog(null, "No selecionaste a nadie.");
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
            java.util.logging.Logger.getLogger(EscuelaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EscuelaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EscuelaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EscuelaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /*______________________________________________________________________________________________________________________*/

        new EscuelaVentana().setVisible(true);
    }
}
