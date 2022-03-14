/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendaventana;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.ButtonGroup;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 *
 * @author Carli
 */
public class TiendaVentana extends JFrame{
    
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
    Cliente miCliente;
    Persona persona[];
    static FileWriter fileWriter=null;
    static BufferedWriter buff=null;
    
    public TiendaVentana(){
    persona=new Persona[4];
    iniciarComponentes();
    crear_archivo();
    }
    
    private void iniciarComponentes(){
    panelPrincipal=new JPanel();
    panelPrincipal.setPreferredSize(new Dimension(500, 500));
    panelPrincipal.setLayout(new GridLayout(2, 1));
    
    radio_P = new JRadioButton("Cliente.");//Declaramos los botonoes de radio.
        radio_P.setPreferredSize(new Dimension(200, 45));
        radio_P.addChangeListener(new ChangeListener() {/*Escuchador de eventos de cambio sobre el boton de radio.*/
            @Override
            public void stateChanged(ChangeEvent e) {
                radio_PCambio(e);
            }
        });
        radio_D = new JRadioButton("Encargado.");
        radio_D.setPreferredSize(new Dimension(200, 45));
        radio_M = new JRadioButton("Chalan.");
        radio_M.setPreferredSize(new Dimension(200, 45));
        radio_Del = new JRadioButton("Mecanico.");
        radio_Del.setPreferredSize(new Dimension(200, 45));
        
        grupo=new ButtonGroup();
        grupo.add(radio_P);
        grupo.add(radio_D);
        grupo.add(radio_M);
        grupo.add(radio_Del);
        
        panelSuperiorP = new JPanel();
        panelSuperiorP.setBorder(BorderFactory.createTitledBorder("Posicion del Jugador."));/*creamos un borde con titulo para poder colocarle el titulo.*/
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
        
        panelSuperior = new JPanel();
        panelPrincipal.add(panelSuperior);
        
        panelSuperior.setLayout(new GridLayout(1, 2, 10, 10));
        panelSuperior.add(panelSuperiorP);
        panelSuperior.add(panelSuperiorS);
        
        texto_NU = new JTextField();
        texto_NU.setPreferredSize(new Dimension(300, 45));
        texto_Nom = new JTextField();
        texto_Nom.setPreferredSize(new Dimension(300, 45));
        texto_MJ = new JTextField();
        texto_MJ.setPreferredSize(new Dimension(300, 45));
        texto_GA = new JTextField();
        texto_GA.setPreferredSize(new Dimension(300, 45));

        label_NU = new JLabel("Id: ");
        label_NU.setPreferredSize(new Dimension(100, 45));
        label_NU.setHorizontalAlignment(SwingConstants.RIGHT);

        label_Nom = new JLabel("Nombre: ");
        label_Nom.setPreferredSize(new Dimension(100, 45));
        label_Nom.setHorizontalAlignment(SwingConstants.RIGHT);

        label_MJ = new JLabel("Direccion: ");
        label_MJ.setPreferredSize(new Dimension(100, 45));
        label_MJ.setHorizontalAlignment(SwingConstants.RIGHT);

        label_GA = new JLabel("Sueldo: ");
        label_GA.setPreferredSize(new Dimension(100, 45));
        label_GA.setHorizontalAlignment(SwingConstants.RIGHT);

        panelInferior = new JPanel();
        panelPrincipal.add(panelInferior);
        panelInferior.setBorder(BorderFactory.createTitledBorder("Datos de la Persona"));

        panelInferior.add(label_NU);
        panelInferior.add(texto_NU);
        panelInferior.add(label_Nom);
        panelInferior.add(texto_Nom);
        panelInferior.add(label_MJ);
        panelInferior.add(texto_MJ);
        panelInferior.add(label_GA);
        panelInferior.add(texto_GA);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setSize(530, 550);
        
        setLocationRelativeTo(null);
        setTitle("Bicicletas Andrea");
        
        getContentPane().add(panelPrincipal);
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
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
            miCliente = new Cliente(Integer.parseInt(texto_NU.getText()),texto_Nom.getText(), texto_MJ.getText());
            texto_GA.setText("0");
        } else if (radio_D.isSelected()) {
            //El primer objeto del arreglo equibaldra a el defensa del equipo.
            persona[0] = new Persona(Integer.parseInt(texto_GA.getText()),Integer.parseInt(texto_NU.getText()),texto_Nom.getText(),texto_MJ.getText());
        } else if (radio_M.isSelected()) {
            //El segundo objeto del arreglo equibaldra a el Medio campista del equipo.
            persona[1] = new Persona(Integer.parseInt(texto_GA.getText()),Integer.parseInt(texto_NU.getText()),texto_Nom.getText(),texto_MJ.getText());
        } else if (radio_Del.isSelected()) {
            //El tercer objeto del arreglo equibaldra a el Delantero del equipo.
            persona[2] = new Persona(Integer.parseInt(texto_GA.getText()),Integer.parseInt(texto_NU.getText()),texto_Nom.getText(),texto_MJ.getText());
        } else {
            JOptionPane.showMessageDialog(null, "No selecionaste algun juagador.");
        }
        generar_archivo();
    }
    
    public static void crear_archivo() {
        //Para la creacion del archivo necesitamos hacer uso de
        //una clausula try-catch
        try {
            //para poder usar el buffer necesita de un objeto FileWriter
            //fileWriter necesita como paramtero el nombre de tu archivo
            fileWriter = new FileWriter("Jugadores2.txt");
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
            JOptionPane.showMessageDialog(null, miCliente);//Con solo poner el nombre del objeto, este invocara en metodo 'toString'.
        } else if (radio_D.isSelected()) {
            JOptionPane.showMessageDialog(null, persona[0]);
        } else if (radio_M.isSelected()) {
            JOptionPane.showMessageDialog(null, persona[1]);
        } else if (radio_Del.isSelected()) {
            JOptionPane.showMessageDialog(null, persona[2]);
        } else {
            JOptionPane.showMessageDialog(null, "No selecionaste algun juagador.");
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
            java.util.logging.Logger.getLogger(TiendaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TiendaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TiendaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TiendaVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /*______________________________________________________________________________________________________________________*/

        new TiendaVentana().setVisible(true);
    }
    
    
}
