/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ivan Axel Cruz Pablo
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

public class VentanaMultimedia extends JFrame {

    JPanel panelPrincipal;

    JPanel panelSuperior,
            panelInferior,
            panelSuperiorP,
            panelSuperiorS;

    JButton boton_agregar,
            boton_borrar,
            boton_Salir;

    JTextField texto_TITULO,
            texto_AUTOR,
            texto_FORMATO,
            texto_DURACION;
    JLabel label_TITULO,
            label_AUTOR,
            label_FORMATO,
            label_DURACION, label_tipo;

    //Creamos los objetos que utilicsaremos, los de pelicula y musica
    Pelicula cinta1;
    Musica cancion1;
    Multimedia archivo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane barra_dezlizadora;
    String encabezados[] = {"Titulo", "Autor", "Formato", "Duracion"};
    String tipos_archivo[] = {"Musica", "Pelicula"};
    JComboBox combo;
    ArrayList<Multimedia> multimedia = new ArrayList<Multimedia>();
    static FileWriter fileWriter = null;
    static BufferedWriter buff = null;

    public VentanaMultimedia() {

        iniciarComponentes();
    }

    private void iniciarComponentes() {

        panelPrincipal = new JPanel();
        panelPrincipal.setPreferredSize(new Dimension(700, 500));
        panelPrincipal.setLayout(new GridLayout(2, 1));

        texto_TITULO = new JTextField();
        texto_TITULO.setPreferredSize(new Dimension(200, 30));
        texto_AUTOR = new JTextField();
        texto_AUTOR.setPreferredSize(new Dimension(200, 30));
        texto_FORMATO = new JTextField();
        texto_FORMATO.setPreferredSize(new Dimension(200, 30));
        texto_DURACION = new JTextField();
        texto_DURACION.setPreferredSize(new Dimension(200, 30));

        label_TITULO = new JLabel("Titulo: ");
        label_TITULO.setPreferredSize(new Dimension(100, 30));
        label_TITULO.setHorizontalAlignment(SwingConstants.RIGHT);

        label_AUTOR = new JLabel("Autor");
        label_AUTOR.setPreferredSize(new Dimension(100, 30));
        label_AUTOR.setHorizontalAlignment(SwingConstants.RIGHT);

        label_FORMATO = new JLabel("Formato");
        label_FORMATO.setPreferredSize(new Dimension(100, 30));
        label_FORMATO.setHorizontalAlignment(SwingConstants.RIGHT);

        label_DURACION = new JLabel("Duracion: ");
        label_DURACION.setPreferredSize(new Dimension(100, 30));
        label_DURACION.setHorizontalAlignment(SwingConstants.RIGHT);

        label_tipo = new JLabel("Tipo de archivo: ");
        label_tipo.setPreferredSize(new Dimension(100, 30));
        label_tipo.setHorizontalAlignment(SwingConstants.RIGHT);

        combo = new JComboBox(tipos_archivo);
        combo.setPreferredSize(new Dimension(200, 30));

        //se agrgan componenetes
        panelSuperiorP = new JPanel();
        panelSuperiorP.setBorder(BorderFactory.createTitledBorder("Agregar nuevo archivo multimedia"));//UN TITULO
        panelSuperiorP.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSuperiorP.add(label_TITULO);
        panelSuperiorP.add(texto_TITULO);
        panelSuperiorP.add(label_AUTOR);
        panelSuperiorP.add(texto_AUTOR);
        panelSuperiorP.add(label_FORMATO);
        panelSuperiorP.add(texto_FORMATO);
        panelSuperiorP.add(label_DURACION);
        panelSuperiorP.add(texto_DURACION);
        panelSuperiorP.add(label_tipo);
        panelSuperiorP.add(combo);

        boton_agregar = new JButton("Agregar Archivo");
        boton_agregar.setPreferredSize(new Dimension(((400 - 20) / 2), 50));
        boton_agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                agregar(e);
            }
        });

        boton_borrar = new JButton("Borrar Archivo");
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
        panelInferior.setBorder(BorderFactory.createTitledBorder("Datos del archivo"));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(730, 550);
        setLocationRelativeTo(null);

        setTitle("carpeta");
        getContentPane().add(panelPrincipal);
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

    }

    private void agregar(ActionEvent e) {

        if (combo.getSelectedItem() == "Pelicula") {

            cinta1 = new Pelicula(texto_TITULO.getText(),
                    texto_AUTOR.getText(),
                    texto_FORMATO.getText(), 
                    texto_DURACION.getText());

            multimedia.add(cinta1);
            actualizar_tabla();
        } else if (combo.getSelectedItem() == "Musica") {

            cancion1 = new Musica(texto_TITULO.getText(),
                    texto_AUTOR.getText(),
                    texto_FORMATO.getText(), 
                    texto_DURACION.getText());
            multimedia.add(cancion1);
            actualizar_tabla();

        } else if (combo.getSelectedItem() != "Pelicula" || combo.getSelectedItem() != "Musica") {
            archivo = new Multimedia(texto_TITULO.getText(),
                    texto_AUTOR.getText(),
                    texto_FORMATO.getText(), 
                    texto_DURACION.getText());
            multimedia.add(archivo);
            actualizar_tabla();
        } else {
            JOptionPane.showMessageDialog(null, "No selecionaste algun juagador.");
        }

    }

    public void eliminar(ActionEvent e, int fila) {
        for (int i = 0; i < multimedia.size(); i++) {
            if (i == fila) {
                multimedia.remove(i);
            }
        }
        actualizar_tabla();
    }

    private void actualizar_tabla() {
        Object[][] datos = new Object[multimedia.size()][4];
        for (int i = 0; i < multimedia.size(); i++) {
            datos[i][0] = multimedia.get(i).setdameTitulo();
            datos[i][1] = multimedia.get(i).setdameAutor();
            datos[i][2] = multimedia.get(i).setdameFormato();
            datos[i][3] = multimedia.get(i).setdameDuracion();
        }
        tabla.setModel(new DefaultTableModel(datos, encabezados));
        generar_archivo();
    }

    public static void crear_archivo() {

        try {
            fileWriter = new FileWriter("Archivo.txt");
            buff = new BufferedWriter(fileWriter);
        } catch (Exception e) {
            System.out.println("Error al crear el archivo !!!");
            e.printStackTrace();
        }
    }

    public void generar_archivo() {
        crear_archivo();
        for (int i = 0; i < multimedia.size(); i++) {
            try {
                buff.write(tabla.getValueAt(i, 0).toString() + ","
                        + tabla.getValueAt(i, 1).toString() + ","
                        + tabla.getValueAt(i, 2).toString() + ","
                        + tabla.getValueAt(i, 3).toString());
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
            java.util.logging.Logger.getLogger(VentanaMultimedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMultimedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMultimedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMultimedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        new VentanaMultimedia().setVisible(true);
    }
}
