package MIGUEL_ANGEL;

/**
 *  NOMBRE: MIGUEL ANGEL GOMEZ ROMERO
 *  NO. CONTROL: 19161282
 *  SEMESTRE: SEGUNDO
 *  ACTIVIDAD: QUE VALE X3
 *  FECHA: 20/05/2020
 */
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

public class VentanaTransporte extends JFrame {

    JPanel panelPrincipal;

    JPanel panelSuperior,
            panelInferior,
            panelSuperiorP,
            panelSuperiorS;

    JButton boton_agregar,
            boton_borrar,
            boton_Salir;

    JTextField texto_MARCA,
            texto_MODELO,
            texto_PLACAS,
            texto_CAPACIDAD;
    JLabel label_MARCA,
            label_MODELO,
            label_PLACAS,
            label_CAPACIDAD, label_tipo;
    
    //CREO NUEVOS OBJETOS TANTO DE AUTOMOVIL, AUTOBUS COMO TRANSPORTE
    
    Automovil miAuto;
    Autobus miAutobus;
    Transporte transporte_inicial;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane barra_dezlizadora;
    String encabezados[] = {"Marca", "Modelo", "Placas", "Capacidad"};
    String tipos_transportes[] = {"Automovil", "Autobus", "Camioneta", "Motocicleta"};
    JComboBox combo;
    ArrayList<Transporte> transporte = new ArrayList<Transporte>();
    static FileWriter fileWriter = null;
    static BufferedWriter buff = null;

   
    public VentanaTransporte() {

        iniciarComponentes();
    }

    private void iniciarComponentes() {

        panelPrincipal = new JPanel();
        panelPrincipal.setPreferredSize(new Dimension(700, 500));
        panelPrincipal.setLayout(new GridLayout(2, 1));
        
        texto_MARCA = new JTextField();
        texto_MARCA.setPreferredSize(new Dimension(200, 30));
        texto_MODELO = new JTextField();
        texto_MODELO.setPreferredSize(new Dimension(200, 30));
        texto_PLACAS = new JTextField();
        texto_PLACAS.setPreferredSize(new Dimension(200, 30));
        texto_CAPACIDAD = new JTextField();
        texto_CAPACIDAD.setPreferredSize(new Dimension(200, 30));

        label_MARCA = new JLabel("Marca: ");
        label_MARCA.setPreferredSize(new Dimension(100, 30));
        label_MARCA.setHorizontalAlignment(SwingConstants.RIGHT);

        label_MODELO= new JLabel("Modelo");
        label_MODELO.setPreferredSize(new Dimension(100, 30));
        label_MODELO.setHorizontalAlignment(SwingConstants.RIGHT);

        label_PLACAS = new JLabel("Placas");
        label_PLACAS.setPreferredSize(new Dimension(100, 30));
        label_PLACAS.setHorizontalAlignment(SwingConstants.RIGHT);

        label_CAPACIDAD = new JLabel("Capacidad: ");
        label_CAPACIDAD.setPreferredSize(new Dimension(100, 30));
        label_CAPACIDAD.setHorizontalAlignment(SwingConstants.RIGHT);

        label_tipo = new JLabel("Tipo de Transporte: ");
        label_tipo.setPreferredSize(new Dimension(100, 30));
        label_tipo.setHorizontalAlignment(SwingConstants.RIGHT);

        combo = new JComboBox(tipos_transportes);
        combo.setPreferredSize(new Dimension(200, 30));
        
        //AGREGO LOS COMPONENTES 
        panelSuperiorP = new JPanel();
        panelSuperiorP.setBorder(BorderFactory.createTitledBorder("Agregar nuevo transporte"));//UN TITULO
        panelSuperiorP.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSuperiorP.add(label_MARCA);
        panelSuperiorP.add(texto_MARCA);
        panelSuperiorP.add(label_MODELO);
        panelSuperiorP.add(texto_MODELO);
        panelSuperiorP.add(label_PLACAS);
        panelSuperiorP.add(texto_PLACAS);
        panelSuperiorP.add(label_CAPACIDAD);
        panelSuperiorP.add(texto_CAPACIDAD);
        panelSuperiorP.add(label_tipo);
        panelSuperiorP.add(combo);


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

        barra_dezlizadora = new JScrollPane(tabla);     

        panelInferior = new JPanel(new FlowLayout());
        barra_dezlizadora.setPreferredSize(new Dimension(680, 200));
        panelInferior.add(barra_dezlizadora);          

        panelPrincipal.add(panelInferior);
        panelInferior.setBorder(BorderFactory.createTitledBorder("Datos de cada transporte."));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(730, 550);
        setLocationRelativeTo(null);
        

        setTitle("Estacionamiento");
        getContentPane().add(panelPrincipal);
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));


    }

    

    private void agregar(ActionEvent e) {
        
        if (combo.getSelectedItem() == "Automovil") {
            
            miAuto = new Automovil(texto_MODELO.getText(),
                    texto_MARCA.getText(),
                    texto_PLACAS.getText(),Integer.parseInt(texto_CAPACIDAD.getText()));
            
            transporte.add(miAuto);
            actualizar_tabla();
        } else if (combo.getSelectedItem() == "Autobus") {
            
            miAutobus = new Autobus(texto_MODELO.getText(),
                    texto_MARCA.getText(),
                    texto_PLACAS.getText(),
                    Integer.parseInt(texto_CAPACIDAD.getText()));
            transporte.add(miAutobus);
            actualizar_tabla();

        } else if(combo.getSelectedItem()!= "Automovil" || combo.getSelectedItem()!= "Autobus"){
            transporte_inicial = new Transporte(texto_MODELO.getText(),
                    texto_MARCA.getText(),
                    texto_PLACAS.getText(),
                    Integer.parseInt(texto_CAPACIDAD.getText()));
            transporte.add(transporte_inicial);
            actualizar_tabla();
        }
        else {
            JOptionPane.showMessageDialog(null, "No selecionaste algun juagador.");
        }
        
       
    }

    
    public void eliminar(ActionEvent e, int fila) {
        for (int i = 0; i < transporte.size(); i++) {
            if (i == fila) {
                transporte.remove(i);
            }
        }
        actualizar_tabla();
    }
    
    private void actualizar_tabla() {
        Object[][] datos = new Object[transporte.size()][4];
        for (int i = 0; i < transporte.size(); i++) {  
            datos[i][0] = transporte.get(i).getModelo();
            datos[i][1] = transporte.get(i).getMarca();
            datos[i][2] = transporte.get(i).getPlacas();
            datos[i][3] = transporte.get(i).getCapacidad();
        }
        tabla.setModel(new DefaultTableModel(datos, encabezados)); 
        generar_archivo();  
    }

    public static void crear_archivo() {
        
        try {
            fileWriter = new FileWriter("Transporte.txt");
            buff = new BufferedWriter(fileWriter);
        } catch (Exception e) {
            System.out.println("Error al crear el archivo !!!");
            e.printStackTrace();
        }
    }
    
    public void generar_archivo(){
        crear_archivo();
        for (int i = 0; i < transporte.size(); i++) {
                try {
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
            java.util.logging.Logger.getLogger(VentanaTransporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaTransporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaTransporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaTransporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        new VentanaTransporte().setVisible(true);
    }
}
