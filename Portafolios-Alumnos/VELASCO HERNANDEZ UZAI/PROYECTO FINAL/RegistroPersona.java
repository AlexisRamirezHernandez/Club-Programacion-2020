/** 
 * Proyecto final Club De Programacion 
 * clase PADRE: persona 
 * derivadas: empleado y alumno
 * 
 * @author  uzai velasco hernandez
 *          numero de control 19161433 
 *          semetre: 2
 */

package proyectoFinalClub;
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

/**
 *
 * @author Admin
 */
public class RegistroPersona extends JFrame{
  JPanel panelPrincipal;

    JPanel panelSuperior,
            panelInferior,
            panelSuperiorP,
            panelSuperiorS;

    JButton boton_agregar,
            boton_borrar,
            boton_Salir;
    
   
    
    JLabel label_Nom,
            label_Ape,
            label_Curp,
            label_Ed,
            label_NC,
            label_Seme,
            label_Carrera,
            label_Sueldo,
            label_Area,
            label_tipo_Persona;
    
    JTextField texto_Nom,
            texto_Ape,
            texto_Curp,
            texto_Ed,
            texto_NC,
            texto_Seme,
            texto_Carrera,
            texto_Sueldo,
            texto_Area;
    
    Estudiante miEstudiante;
    Empleado miEmpleado;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane barra_dezlizadora;
    String encabezados[] = {"Nombre", "Apellidos", "CURP", "Edad","Numero de control","Semestre","Carrera",
        "Sueldo","Area"};
    String tipos_Personas[] = {"Seleccionar","Estudiante", "Empleado"};
    JComboBox combo;
    ArrayList<Persona> persona = new ArrayList<Persona>();
    static FileWriter fileWriter = null;
    static BufferedWriter buff = null;
    
    public RegistroPersona(){  
        iniciarComponentes();      
    }
    private void iniciarComponentes(){
        panelPrincipal = new JPanel();//Inicalizamos el objeto.
        panelPrincipal.setPreferredSize(new Dimension(900, 800));
        panelPrincipal.setLayout(new GridLayout(2, 1));
        texto_Nom = new JTextField();
        texto_Nom.setPreferredSize(new Dimension(200, 30));
        texto_Ape = new JTextField();
        texto_Ape.setPreferredSize(new Dimension(200, 30));
        texto_Curp = new JTextField();
        texto_Curp.setPreferredSize(new Dimension(200, 30));
        texto_Ed = new JTextField();
        texto_Ed.setPreferredSize(new Dimension(200, 30));
        texto_NC = new JTextField();
        texto_NC.setPreferredSize(new Dimension(200, 30));
        texto_Seme = new JTextField();
        texto_Seme.setPreferredSize(new Dimension(200, 30));
        texto_Carrera = new JTextField();
        texto_Carrera.setPreferredSize(new Dimension(200, 30));
        texto_Sueldo = new JTextField();
        texto_Sueldo.setPreferredSize(new Dimension(200, 30));
        texto_Area = new JTextField();
        texto_Area.setPreferredSize(new Dimension(200, 30));
        
        label_Nom = new JLabel("Nombre");
        label_Nom.setPreferredSize(new Dimension(100, 30));
        label_Nom.setHorizontalAlignment(SwingConstants.RIGHT);

        label_Ape = new JLabel("Apellidos");
        label_Ape.setPreferredSize(new Dimension(100, 30));
        label_Ape.setHorizontalAlignment(SwingConstants.RIGHT);

        label_Curp = new JLabel("CURP");
        label_Curp.setPreferredSize(new Dimension(100, 30));
        label_Curp.setHorizontalAlignment(SwingConstants.RIGHT);

        label_Ed = new JLabel("Edad");
        label_Ed.setPreferredSize(new Dimension(100, 30));
        label_Ed.setHorizontalAlignment(SwingConstants.RIGHT);
        
        label_NC = new JLabel("Numero de Control");
        label_NC.setPreferredSize(new Dimension(100, 30));
        label_NC.setHorizontalAlignment(SwingConstants.RIGHT);
        
        label_Seme = new JLabel("Semestre");
        label_Seme.setPreferredSize(new Dimension(100, 30));
        label_Seme.setHorizontalAlignment(SwingConstants.RIGHT);
        
        label_Carrera = new JLabel("Carrera");
        label_Carrera.setPreferredSize(new Dimension(100, 30));
        label_Carrera.setHorizontalAlignment(SwingConstants.RIGHT);
        
        label_Sueldo = new JLabel("Sueldo");
        label_Sueldo.setPreferredSize(new Dimension(100, 30));
        label_Sueldo.setHorizontalAlignment(SwingConstants.RIGHT);
        
        label_Area = new JLabel("Area");
        label_Area.setPreferredSize(new Dimension(100, 30));
        label_Area.setHorizontalAlignment(SwingConstants.RIGHT);

        label_tipo_Persona = new JLabel("Tipo De Persona");
        label_tipo_Persona.setPreferredSize(new Dimension(100, 30));
        label_tipo_Persona.setHorizontalAlignment(SwingConstants.RIGHT);
        combo = new JComboBox(tipos_Personas);
        combo.setPreferredSize(new Dimension(200, 30));
        
        panelSuperiorP = new JPanel();
        panelSuperiorP.setBorder(BorderFactory.createTitledBorder("Dar de Alta Personas"));/*creamos un borde con titulo para poder colocarle el titulo.*/
        panelSuperiorP.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSuperiorP.add(label_Nom);
        panelSuperiorP.add(texto_Nom);
        panelSuperiorP.add(label_Ape);
        panelSuperiorP.add(texto_Ape);
        panelSuperiorP.add(label_Curp);
        panelSuperiorP.add(texto_Curp);
        panelSuperiorP.add(label_Ed);
        panelSuperiorP.add(texto_Ed);
        panelSuperiorP.add(label_NC);
        panelSuperiorP.add(texto_NC);
        panelSuperiorP.add(label_Seme);
        panelSuperiorP.add(texto_Seme);
        panelSuperiorP.add(label_Carrera);
        panelSuperiorP.add(texto_Carrera);
        panelSuperiorP.add(label_Sueldo);
        panelSuperiorP.add(texto_Sueldo);
        panelSuperiorP.add(label_Area);
        panelSuperiorP.add(texto_Area);
        panelSuperiorP.add(label_tipo_Persona);
        panelSuperiorP.add(combo);
    
         combo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                radio_PerCambio(e);
                
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
        panelPrincipal.add(panelSuperior);
        panelSuperior.setLayout(new GridLayout(1, 2, 20, 20));
        panelSuperior.add(panelSuperiorP);
        panelSuperior.add(panelSuperiorS);
    
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
        barra_dezlizadora.setPreferredSize(new Dimension(700, 400));
        panelInferior.add(barra_dezlizadora);           //AÑADIMOS LA BARRA Y YA NO LA TABLA

        panelPrincipal.add(panelInferior);/*Añadimos el panel superior al panel inferior*/
        panelInferior.setBorder(BorderFactory.createTitledBorder("Datos Personas"));

        setDefaultCloseOperation(EXIT_ON_CLOSE);/*con este metodo le dijemos a la clase que se cierre cuando hayamos pulsado el boton rojo 
        para cerrar la pestaña 'X'*/

        setSize(730, 550);

        setLocationRelativeTo(null);
        /*Ubicacion relativa de la ventana,al pasarle 'null' como parametro
        le estamos diciendo que se muestre en el centro de la pantalla  */

        setTitle("Registro de Personas.");/*Metodo para ponerle ttulo a nuestra ventana.*/

        getContentPane().add(panelPrincipal);
       
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }    
    private void radio_PerCambio(ItemEvent e) {

        
        if (combo.getSelectedItem() == "Empleado") {/*comprobamos si el elemento a sido seleccionado */
            texto_NC.setEnabled(false);/*si ES UN Empledo desabilitamos la caja de texto para los numero de control, semestre y carrera */
            texto_Seme.setEnabled(false);
            texto_Carrera.setEnabled(false);
        } else {
            texto_NC.setEnabled(true);
            texto_Seme.setEnabled(true);
            texto_Carrera.setEnabled(true);
        }
        if (combo.getSelectedItem() == "Estudiante") {/*comprobamos si el elemento a sido seleccionado */
            texto_Sueldo.setEnabled(false);/*si ES UN Estudiante desabilitamos la caja de texto para el sueldo y el area */
            texto_Area.setEnabled(false);   
        } else {
            texto_Sueldo.setEnabled(true);
            texto_Area.setEnabled(true);
        } 
        
    }
    
    private void agregar(ActionEvent e) {
        if (combo.getSelectedItem() == "Empleado") {
            //SI LO QUE TIENE EL COMBO ES IGUAL CON EL TEXTO EMPLEADO DESHABILITA UN CAMPO
            miEmpleado = new Empleado(texto_Nom.getText(),
                    texto_Ape.getText(),texto_Curp.getText(),
                    Integer.parseInt(texto_Ed.getText()),
                    texto_Sueldo.getText(),texto_Area.getText());
            //ACA AGREGAMOS EL EMPLEADO QUE HAYAMOS CREADO AL ARRAY LIST
            persona.add(miEmpleado);
            actualizar_tabla();
        } else if (combo.getSelectedItem() == "Estudiante") {
            
            miEstudiante = new Estudiante(texto_Nom.getText(),texto_Ape.getText(),
                    texto_Curp.getText(),Integer.parseInt(texto_Ed.getText()),
                    Integer.parseInt(texto_NC.getText()),texto_Seme.getText(),
                    texto_Carrera.getText());
            System.out.println(miEstudiante.MostrarDatos());
            persona.add(miEstudiante);
            actualizar_tabla();

        } else {
            JOptionPane.showMessageDialog(null, "No selecionaste alguna persona.");
        }
        
       
    }
    public void eliminar(ActionEvent e, int fila) {
        for (int i = 0; i < persona.size(); i++) {
            if (i == fila) {
                persona.remove(i);
            }
        }
        actualizar_tabla();
    }
    private void actualizar_tabla() {
        Object[][] datos = new Object[persona.size()][9];//LA MATRIZ DE OBJETOS ES DEL TAMAÑO QUE TENGA LA LISTA POR LAS 4 COLUMNAS
        for (int i = 0; i < persona.size(); i++) {  //EN BASE AL TAMAÑO DE LA LISTA DE JUGADORES LOS INDICAMOS EN LA TABLA
            datos[i][0] = persona.get(i).nombre();//ASI ACCEDEMOS A LAS PROPIEDADES DE UN OBJETO. CON EL METODO GET().METODO DE LA CLASE
            datos[i][1] = persona.get(i).apellido();
            datos[i][2] = persona.get(i).curp();
            datos[i][3] = persona.get(i).edad();
            datos[i][4] = persona.get(i).getNumeroControl();
            datos[i][5] = persona.get(i).getSemestre();
            datos[i][6] = persona.get(i).getCarrera();
            datos[i][7] = persona.get(i).getSueldo();
            datos[i][8] = persona.get(i).getArea();
        }
        tabla.setModel(new DefaultTableModel(datos, encabezados)); //INDICAMOS EL MODELO NUEVO QUE HICIMOS
        generar_archivo();  //Y ACA GENERAMOS EL ARCHIVO
    }
    public static void crear_archivo() {
        try {
            //para poder usar el buffer necesita de un objeto FileWriter
            //fileWriter necesita como paramtero el nombre de tu archivo
            fileWriter = new FileWriter("Personas.txt");
            buff = new BufferedWriter(fileWriter);
        } catch (Exception e) {
            System.out.println("Error al crear el archivo !!!");
            e.printStackTrace();
        }
    }
    public void generar_archivo(){
        crear_archivo();
        for (int i = 0; i < persona.size(); i++) {
            //PARA OBTENER EL ELEMENTO DE UNA TABLA USAMOS 
            //EL METODO GETVALUE(FILA,COLUMNA).TOSTRING
                try {
                    //aca le damos   
                    buff.write(tabla.getValueAt(i,0).toString()+","+
                               tabla.getValueAt(i,1).toString()+","+
                               tabla.getValueAt(i,2).toString()+","+
                               tabla.getValueAt(i,3).toString()+","+
                               tabla.getValueAt(i,4).toString()+","+
                               tabla.getValueAt(i,5).toString()+","+
                               tabla.getValueAt(i,6).toString()+","+
                               tabla.getValueAt(i,7).toString()+","+
                               tabla.getValueAt(i,8).toString());
                    buff.newLine();
                    buff.flush();
                } catch (Exception e) {
                    System.out.println("Error in FileWriter !!!");

                    e.printStackTrace();
                
            }
        }
    }
     public static void main(String[] args) {
 /*_________________________________________________________________________________________________________*/
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /*______________________________________________________________________________________________________________________*/

        new RegistroPersona().setVisible(true);
    }
}


