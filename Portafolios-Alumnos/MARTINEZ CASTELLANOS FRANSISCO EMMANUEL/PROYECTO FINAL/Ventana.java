package jugador;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class Ventana extends JFrame {


    
    JPanel panelPrincipal;/*panelPrincipal-> objeto de la clase JPanel -> nos permite colocar elementos sobre el.*/

    JPanel panelSuperior,
            panelInferior,
            panelSuperiorP,
            panelSuperiorS;

    JButton boton_agregar,
            boton_borrar,
            boton_Salir;

    JTextField texto_NU,/*cajas de texto */
            texto_Nom,
            texto_MJ,
            texto_GA;
    JLabel label_NU,/*Etiquetas para poder poner texto*/
            label_Nom,
            label_MJ,
            label_GA, label_tipo;
    
    //ACA EMPIEZA LO NUEVO
    Persona personita;
    Artista artist;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane barra_dezlizadora;
    String encabezados[] = {"Nombre", "Apellido", "AKA", "Edad"};
    String tipos_artistas[] = { "Escritor", "Cantante", "Actor","Pintor"};
    JComboBox combo;
    ArrayList<Persona> person = new ArrayList<Persona>();
    static FileWriter fileWriter = null;
    static BufferedWriter buff = null;

    /*este como arreglo por que usaremos muchos jugadores;*/
    //Los declaramos globales para oder usarlos en cualquier momento del programa.
    public Ventana() {/*Constructor de la clase ,
      El utilizar el contructor de una clase nos da la ventaja de ser la primera cosa que se ejecuta cuando un objeto es creado. 
        La herencia nos permite utilizar metodos directamente de la clase extendida.*/
        iniciarComponentes();//Metdo que inicializara los componenetes que construiran nuestra ventana.
    }

    private void iniciarComponentes() {

        panelPrincipal = new JPanel();//Inicalizamos el objeto.
        panelPrincipal.setPreferredSize(new Dimension(700, 500));
        panelPrincipal.setLayout(new GridLayout(2, 1));/*
        setLayout -> Define el comportamiento de la distribucion del contenido en el objeto padre. 
        new GridLayout(filas,columnas) -> crea un Layout de tipo griya (cuadricula). 
         */
        /****
         * ACA EMPIEZA EL PANEL QUE PIDE DATOS
         * USAMOS EL METODO SETPREFEREDSIZE() PARA AJUSTAR UN TAMAÑO POR DEFAULT
         * ESTE NOS PIDE UN OBJETO DE TIPO DIMENSION () EL CUAL PIDE COMO PARAMETROS
         * UN LARGO Y UN ANCHHO
         */
        texto_NU = new JTextField();
        texto_NU.setPreferredSize(new Dimension(200, 30));
        texto_Nom = new JTextField();
        texto_Nom.setPreferredSize(new Dimension(200, 30));
        texto_MJ = new JTextField();
        texto_MJ.setPreferredSize(new Dimension(200, 30));
        texto_GA = new JTextField();
        texto_GA.setPreferredSize(new Dimension(200, 30));

        label_NU = new JLabel("Nombre:");
        label_NU.setPreferredSize(new Dimension(100, 30));
        label_NU.setHorizontalAlignment(SwingConstants.RIGHT);

        label_Nom = new JLabel("Apellido:");
        label_Nom.setPreferredSize(new Dimension(100, 30));
        label_Nom.setHorizontalAlignment(SwingConstants.RIGHT);

        label_MJ = new JLabel("AKA");
        label_MJ.setPreferredSize(new Dimension(100, 30));
        label_MJ.setHorizontalAlignment(SwingConstants.RIGHT);

        label_GA = new JLabel("Edad");
        label_GA.setPreferredSize(new Dimension(100, 30));
        label_GA.setHorizontalAlignment(SwingConstants.RIGHT);

        label_tipo = new JLabel("Tipo de artista");
        label_tipo.setPreferredSize(new Dimension(100, 30));
        label_tipo.setHorizontalAlignment(SwingConstants.RIGHT);

        combo = new JComboBox(tipos_artistas);
        combo.setPreferredSize(new Dimension(200, 30));
        
        //AGREGAMOS LOS COMPONENTES AL PANEL QUE PIDE DATOS
        panelSuperiorP = new JPanel();
        panelSuperiorP.setBorder(BorderFactory.createTitledBorder("Dar de alta artistas."));/*creamos un borde con titulo para poder colocarle el titulo.*/
        panelSuperiorP.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSuperiorP.add(label_NU);
        panelSuperiorP.add(texto_NU);
        panelSuperiorP.add(label_Nom);
        panelSuperiorP.add(texto_Nom);
        panelSuperiorP.add(label_MJ);
        panelSuperiorP.add(texto_MJ);
        panelSuperiorP.add(label_GA);
        panelSuperiorP.add(texto_GA);
        panelSuperiorP.add(label_tipo);
        panelSuperiorP.add(combo);
        
        //EVENTOS
        combo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                radio_PCambio(e);
            }
        });

        boton_agregar = new JButton("Agregar Datos.");//Inicalizamos el objeto. pasandole el texto como parametro.
        boton_agregar.setPreferredSize(new Dimension(((400 - 20) / 2), 50));
        boton_agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                agregar(e);
            }
        });

        boton_borrar = new JButton("Borrar Datos.");
        boton_borrar.setPreferredSize(new Dimension(((400 - 20) / 2), 50));
        boton_borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = tabla.getSelectedRow();
                eliminar(e, fila);
            }
        });

        boton_Salir = new JButton("Salir");
        boton_Salir.setPreferredSize(new Dimension(((400 - 20) / 2), 50));
        boton_Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panelSuperiorS = new JPanel();
        panelSuperiorS.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
        panelSuperiorS.add(boton_agregar);
        panelSuperiorS.add(boton_borrar);
        panelSuperiorS.add(boton_Salir);

        panelSuperior = new JPanel();
        panelPrincipal.add(panelSuperior);/*Añadimos el panel superior al panel principal*/

        panelSuperior.setLayout(new GridLayout(1, 2, 20, 20));
        panelSuperior.add(panelSuperiorP);
        panelSuperior.add(panelSuperiorS);

        /*_____________________________________________________________________________________*/
        //CUANDO NECESITAMOS INDICAR UN MODELO VACIO A UNA TABLA PARA QUE POR LO MENOS TENGA 
        //ALGO USAMOS ESTA SINTAXIS, DESPUES LA MODIFICAREMOS (LINEA 243 A 248)
        barra_dezlizadora = new JScrollPane();
        tabla = new JTable();
        tabla.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null}
                },
                encabezados
        ));

        barra_dezlizadora = new JScrollPane(tabla);     //BARRA DEZLIZADORA

        panelInferior = new JPanel(new FlowLayout());
        barra_dezlizadora.setPreferredSize(new Dimension(680, 200));
        panelInferior.add(barra_dezlizadora);           //AÑADIMOS LA BARRA Y YA NO LA TABLA

        panelPrincipal.add(panelInferior);/*Añadimos el panel superior al panel inferior*/
        panelInferior.setBorder(BorderFactory.createTitledBorder("Datos de personas."));

        setDefaultCloseOperation(EXIT_ON_CLOSE);/*con este metodo le dijremos a la clase que se cierre cuando hayamos pulsado el boton rojo 
        para cerrar la pestaña 'X'*/

        setSize(730, 550);/*Nos permite decirle a la ventana las dimenciones que tendra cuando esta aparesca.*/

        setLocationRelativeTo(null);
        /*Ubicacion relativa de la ventana,al pasarle 'null' como parametro
        le estamos diciendo que se muestre en el centro de la pantalla  */

        setTitle("TELEVISA PRESENTA XD: ");/*Metodo para ponerle ttulo a nuestra ventana.*/

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

    private void radio_PCambio(ItemEvent e) {

        if (combo.getSelectedItem() == "Pintor") {/*comprobamos si el elemento a sido seleccionado */
            texto_MJ.setEnabled(false);/*si ES UN PORTERO desabilitamos la caja de texto para los goles */
        } else {
            texto_MJ.setEnabled(true);
        }
    }

    private void agregar(ActionEvent e) {
        //GETSELECTITEM NOS PERMITE OBTENER LO QUE SELECCIONAMOS DEL COMBO
        //ESTE METODO TENDRAN QUE MOFICAR 
        if (combo.getSelectedItem() == "Pintor") {
            
               //SI LO QUE TIENE EL COMBO ES IGUAL CON EL TEXTO PORTERO DESHABILITA UN CAMPO
             artist= new Artista (texto_Nom.getText(),
                   texto_NU.getText(),
                texto_MJ.getText(),
                    Integer.parseInt(texto_GA.getText()));

            //ACA AGREGAMOS EL PORTERO QUE HAYAMOS CREADO AL ARRAY LIST
            person.add(artist);
            actualizar_tabla();
          
            JOptionPane.showMessageDialog(null, "Agregado perfectamente");
      
        } else if (combo.getSelectedItem() != "Persona") {
            //SI NO PROCEDEMOS A CREAR UN OBJETO DE TIPO JUGADOR
            personita = new Persona(texto_Nom.getText(),
                   texto_NU.getText(),
                texto_MJ.getText(),
                    Integer.parseInt(texto_GA.getText()));
           person.add(personita);
            actualizar_tabla();
      JOptionPane.showMessageDialog(null, "Agregado perfectamente");
        } else {
            JOptionPane.showMessageDialog(null, "No selecionaste algun juagador.");
        }
        
       
    }

    //ESTE METODO RECORRE EL ARRAY LIST HASTA ENCONTRAR EL ELEMENTO Y YA CON ESO. LO QUITA
    public void eliminar(ActionEvent e, int fila) {
        for (int i = 0; i < person.size(); i++) {
            if (i == fila) {
                person.remove(i);
            }
        }
        actualizar_tabla();
    }
    //ESTE METODO ACTUALIZA LA TABLA ANTE CUALQUIER CAMBIO
    private void actualizar_tabla() {
        Object[][] datos = new Object[person.size()][4];//LA MATRIZ DE OBJETOS ES DEL TAMAÑO QUE TENGA LA LISTA POR LAS 4 COLUMNAS
        for (int i = 0; i < person.size(); i++) {  //EN BASE AL TAMAÑO DE LA LISTA DE JUGADORES LOS INDICAMOS EN LA TABLA
            datos[i][0] = person.get(i).getNombre();//ASI ACCEDEMOS A LAS PROPIEDADES DE UN OBJETO. CON EL METODO GET().METODO DE LA CLASE
            datos[i][1] = person.get(i).getApellido();
            datos[i][2] = person.get(i).getAka();
            datos[i][3] = person.get(i).getEdad();
        }
        tabla.setModel(new DefaultTableModel(datos, encabezados)); //INDICAMOS EL MODELO NUEVO QUE HICIMOS
        generar_archivo();  //Y ACA GENERAMOS EL ARCHIVO
    }

    public static void crear_archivo() {
        //Para la creacion del archivo necesitamos hacer uso de
        //una clausula try-catch
        try {
            //para poder usar el buffer necesita de un objeto FileWriter
            //fileWriter necesita como paramtero el nombre de tu archivo
            fileWriter = new FileWriter("Artistas.txt");
            buff = new BufferedWriter(fileWriter);
        } catch (Exception e) {
            System.out.println("Error al crear el archivo !!!");
            e.printStackTrace();
        }
    }
    //CREAMOS EL ARCHIOVO ACA Y LO GENERAMOS EN BASE A LA TABLA
    public void generar_archivo(){
        crear_archivo();
        for (int i = 0; i < person.size(); i++) {
            //PARA OBTENER EL ELEMENTO DE UNA TABLA USAMOS 
            //EL METODO GETVALUE(FILA,COLUMNA).TOSTRING
                try {
                    //aca le damos   
                    buff.write(tabla.getValueAt(i,0).toString()+","+
                               tabla.getValueAt(i,1).toString()+","+
                                tabla.getValueAt(i,2).toString()+","+
                                tabla.getValueAt(i,3).toString());
                    buff.newLine();
                    buff.flush();
                } catch (Exception e) {
                    System.out.println("Error in FileWriter !!!");

                    e.printStackTrace();
                
            }
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /*______________________________________________________________________________________________________________________*/

        new Ventana().setVisible(true);
    }
}
