
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
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Escuela extends JFrame {
    JPanel panelPrincipal;

    JPanel panelSuperior,
            panelInferior,
            panelSuperiorP,
            panelSuperiorS;

    JButton boton_agregar,
            boton_borrar,
            boton_Salir;

    JTextField texto_Nombre,
            texto_ApeP,
            texto_ApeM,
            texto_Tel;
    JLabel label_N,
            label_AP,
            label_AM,
            label_T, label_tipo;
    
    
    Alumno miAlumno; 
    Persona alumno_interno;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane barra_dezlizadora;
    String encabezados[] = {"Nombre", "Apellido Paterno", "Apellido Materno", "Telefono"};
    ArrayList<Persona> persona = new ArrayList<Persona>();
    static FileWriter fileWriter = null;
    static BufferedWriter buff = null;
    
    public Escuela() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {

        panelPrincipal = new JPanel();//Inicalizamos el objeto.
        panelPrincipal.setPreferredSize(new Dimension(700, 500));
        panelPrincipal.setLayout(new GridLayout(2, 1));
        
        texto_Nombre = new JTextField();
        texto_Nombre.setPreferredSize(new Dimension(200, 30));
        texto_ApeP = new JTextField();
        texto_ApeP.setPreferredSize(new Dimension(200, 30));
        texto_ApeM = new JTextField();
        texto_ApeM.setPreferredSize(new Dimension(200, 30));
        texto_Tel = new JTextField();
        texto_Tel.setPreferredSize(new Dimension(200, 30));

        label_N = new JLabel("Nombre.");
        label_N.setPreferredSize(new Dimension(100, 30));
        label_N.setHorizontalAlignment(SwingConstants.RIGHT);

        label_AP = new JLabel("Appelido Paterno");
        label_AP.setPreferredSize(new Dimension(100, 30));
        label_AP.setHorizontalAlignment(SwingConstants.RIGHT);

        label_AM = new JLabel("Apellido Materno.");
        label_AM.setPreferredSize(new Dimension(100, 30));
        label_AM.setHorizontalAlignment(SwingConstants.RIGHT);

        label_T = new JLabel("Telefono");
        label_T.setPreferredSize(new Dimension(100, 30));
        label_T.setHorizontalAlignment(SwingConstants.RIGHT);
        
        //AGREGAMOS LOS COMPONENTES AL PANEL QUE PIDE DATOS
        panelSuperiorP = new JPanel();
        panelSuperiorP.setBorder(BorderFactory.createTitledBorder("Dar de Alta."));/*creamos un borde con titulo para poder colocarle el titulo.*/
        panelSuperiorP.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSuperiorP.add(label_N);
        panelSuperiorP.add(texto_Nombre);
        panelSuperiorP.add(label_AP);
        panelSuperiorP.add(texto_ApeP);
        panelSuperiorP.add(label_AM);
        panelSuperiorP.add(texto_ApeM);
        panelSuperiorP.add(label_T);
        panelSuperiorP.add(texto_Tel);
        
        boton_agregar = new JButton("Agregar Datos.");
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
        panelInferior.setBorder(BorderFactory.createTitledBorder("Datos de Alumnos."));

        setDefaultCloseOperation(EXIT_ON_CLOSE);/*con este metodo le dijremos a la clase que se cierre cuando hayamos pulsado el boton rojo 
        para cerrar la pestaña 'X'*/

        setSize(730, 550);/*Nos permite decirle a la ventana las dimenciones que tendra cuando esta aparesca.*/

        setLocationRelativeTo(null);
        /*Ubicacion relativa de la ventana,al pasarle 'null' como parametro
        le estamos diciendo que se muestre en el centro de la pantalla  */

        setTitle("Escuela.");/*Metodo para ponerle ttulo a nuestra ventana.*/

        getContentPane().add(panelPrincipal);

        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }

    private void agregar(ActionEvent e) {
        alumno_interno = new Persona(texto_Nombre.getText(),texto_ApeP.getText(),texto_ApeM.getText(),texto_Tel.getText());
        persona.add(alumno_interno);
        actualizar_tabla();      
    }

    //ESTE METODO RECORRE EL ARRAY LIST HASTA ENCONTRAR EL ELEMENTO Y YA CON ESO. LO QUITA
    public void eliminar(ActionEvent e, int fila) {
        for (int i = 0; i < persona.size(); i++) {
            if (i == fila) {
                persona.remove(i);
            }
        }
        actualizar_tabla();
    }
    
    private void actualizar_tabla() {
        Object[][] datos = new Object[persona.size()][4];
        for (int i = 0; i < persona.size(); i++) {   
            datos[i][0] = persona.get(i).getNombre();
            datos[i][1] = persona.get(i).getApellido_P();
            datos[i][2] = persona.get(i).getApellido_M();
            datos[i][3] = persona.get(i).getTelefono();
        }
        tabla.setModel(new DefaultTableModel(datos, encabezados)); 
        generar_archivo(); 
    }

    public static void crear_archivo() {
        try {
            fileWriter = new FileWriter("Jugadores.txt");
            buff = new BufferedWriter(fileWriter);
        } catch (Exception e) {
            System.out.println("Error al crear el archivo !!!");
            e.printStackTrace();
        }
    }
    
    public void generar_archivo(){
        crear_archivo();
        for (int i = 0; i < persona.size(); i++) {
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
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Escuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Escuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Escuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Escuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        new Escuela().setVisible(true);
    }
}