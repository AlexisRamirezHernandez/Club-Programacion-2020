/*
 * Uzai Velasco Hernandez
 * 19161433 Ingeniería en Sistemas computacionales
 * segundo semestre.
 */
package com.mycompany.formulario;
                                                            //JComboBox
                                                            //JCheckBox

import java.awt.Checkbox;
import javax.swing.*;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author uzai velasco hernandez
 */
public class Formulario extends JFrame{
    private JLabel nombre, apellidoPaterno, apellidoMaterno, direccion, estado, sexo;
    private JPanel panel;
    private JTextField Jnombre, JapellidoPaterno, JapellidoMaterno, Jdireccion, Jestado, Jsexo;
    private JButton aceptar;
    private JCheckBox sMas, sFem;
    private JComboBox componente; 
    
    public Formulario(){
        init();
    
    }
    public void init(){
        panel = new JPanel();
        setTitle("Formulario");
        setSize(520, 250); //ajusta el tamaño de la pantalla//
        setLayout(new FlowLayout());
        nombre = new JLabel("nombre: ");
        Jnombre = new JTextField(30);
        apellidoPaterno = new JLabel("primer apellido apellido: ");
        JapellidoPaterno = new JTextField(30);
        apellidoMaterno = new JLabel("segundo apellido apellido: ");
        JapellidoMaterno = new JTextField(30);
        direccion = new JLabel("correo electronico: ");
        Jdireccion = new JTextField(30);
        estado = new JLabel("Estado: ");
        componente= new JComboBox();
        componente.addItem("Elige estado");
        componente.addItem("Casado");
        componente.addItem("Soltero");
        componente.addItem("viudo");
        componente.addItem("otro");
        sexo = new JLabel("Sexo:");
        ButtonGroup grupoBotones = new ButtonGroup();
        
        sMas = new JCheckBox("Hombre");
        grupoBotones.add(sMas);
        sFem = new JCheckBox("Mujer");
        grupoBotones.add(sFem);
        aceptar = new JButton("aceptar");
        
        this.add(nombre);
        this.add(Jnombre);
        
        this.add(apellidoPaterno);
        this.add(JapellidoPaterno);
        
        this.add(apellidoMaterno);
        this.add(JapellidoMaterno);

        this.add(direccion);
        this.add(Jdireccion);                     
        
        this.add(estado);
        this.add(componente);

        this.add(sexo);
        this.add(sMas);
        this.add(sFem);
        
        this.add(aceptar);
        
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Formulario();
    }
    
}
