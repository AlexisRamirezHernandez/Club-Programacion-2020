/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanaaspirantes;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniel
 */
public class VentanaAspirantes extends JFrame{
    
    JPanel panelPrincipal;
    
     JPanel panelSuperior,
            panelInferior,
            panelSuperiorP,
            panelSuperiorS;
     JButton boton_agregar,
            boton_borrar,
            boton_Salir;
     JTextField texto_Nom,
            texto_Edad,
            texto_Carrera,
            texto_NumControl,
            texto_notafinal;
     JLabel label_Nom,
            label_Edad,
            label_Carrera,
            label_NumControl, label_notafinal;
     Persona laPersona;
     Aspirante miAspirante;
     
     JTable tabla;
    DefaultTableModel modelo;
    JScrollPane barra_dezlizadora;
    String encabezados[] = {"Nombre", "Edad", "Carrera", "Numero de Control", "Nota Final"};
    String Semestre[] = {"1°", "2°", "3°", "4°","5°","6°","7°","8°","9°","10°","11°","12°","13°"};
    JComboBox combo;
    ArrayList<Aspirante> Aspirante = new ArrayList<Aspirante>();
     static FileWriter fileWriter = null;
     static BufferedWriter buff = null;
     public VentanaAspirantes(){
         iniciarComponentes();
     }
     private void iniciarComponentes(){
        panelPrincipal = new JPanel();
        panelPrincipal.setPreferredSize(new Dimension(700, 500));
        panelPrincipal.setLayout(new GridLayout(2, 1));
        
        texto_Nom = new JTextField();
        texto_Nom.setPreferredSize(new Dimension(200, 30));
        texto_Edad = new JTextField();
        texto_Edad.setPreferredSize(new Dimension(200, 30));
        texto_Carrera = new JTextField();
        texto_Carrera.setPreferredSize(new Dimension(200, 30));
        texto_NumControl = new JTextField();
        texto_NumControl.setPreferredSize(new Dimension(200, 30));
        texto_notafinal.setPreferredSize(new Dimension(200, 30));
        texto_notafinal = new JTextField();
        
        label_Nom = new JLabel("Nombre Completo.");
        label_Nom.setPreferredSize(new Dimension(100, 80));
        label_Nom.setHorizontalAlignment(SwingConstants.RIGHT);
        label_Edad = new JLabel("Edad.");
        label_Edad.setPreferredSize(new Dimension(100, 30));
        label_Edad.setHorizontalAlignment(SwingConstants.RIGHT);
        label_Carrera = new JLabel("Carrera.");
        label_Carrera.setPreferredSize(new Dimension(100, 40));
        label_Carrera.setHorizontalAlignment(SwingConstants.RIGHT);
        label_NumControl = new JLabel("Numero de Control.");
        label_NumControl.setPreferredSize(new Dimension(100, 30));
        label_NumControl.setHorizontalAlignment(SwingConstants.RIGHT);
        label_notafinal = new JLabel("Nota Final.");
        label_notafinal.setPreferredSize(new Dimension(100, 30));
        label_notafinal.setHorizontalAlignment(SwingConstants.RIGHT);
        combo = new JComboBox(Semestre);
        combo.setPreferredSize(new Dimension(200, 30));
        panelSuperiorP = new JPanel();
        panelSuperiorP.setBorder(BorderFactory.createTitledBorder("Dar de Alta Aspirante."));
        panelSuperiorP.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSuperiorP.add(label_Nom);
        panelSuperiorP.add(texto_Nom);
        panelSuperiorP.add(label_Edad);
        panelSuperiorP.add(texto_Edad);
        panelSuperiorP.add(label_Carrera);
        panelSuperiorP.add(texto_Carrera);
        panelSuperiorP.add(label_NumControl);
        panelSuperiorP.add(texto_NumControl);
        panelSuperiorP.add(label_notafinal);
        panelSuperiorP.add(texto_notafinal);
        
        
        boton_agregar = new JButton("Agregar Datos.");
        boton_agregar.setPreferredSize(new Dimension(((400 - 20) / 2), 50));
        boton_agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
            }
        });
         boton_borrar = new JButton("Borrar Datos.");
        boton_borrar.setPreferredSize(new Dimension(((400 - 20) / 2), 50));
        boton_borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = tabla.getSelectedRow();
                
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
         panelInferior.setBorder(BorderFactory.createTitledBorder("Datos de Aspirante."));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Registro de Aspirantes.");
        getContentPane().add(panelPrincipal);
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
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
        for (int i = 0; i < Aspirante.size(); i++) {
            
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
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
}
