/* Club de Programación
 * Alumno: Javier Manuel Pérez Santos
 * Programa: Formulario
 * Número de control: 19161381
 */
package com.mycompany.formularius;

import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static org.omg.CORBA.ORB.init;
import javax.swing.JComboBox;

public class formularius extends JFrame{
    
    private JLabel eNombre, eApellido_Paterno, eApellido_Materno, eDireccion, eEstado, eSexo;
    private JPanel panel;
    private JTextField dNombre, dApellido_Paterno, dApellido_Materno, dDireccion;
    private JButton ACEPTAR;
    private JComboBox combo;
    private JRadioButton sMas, sFem;

    public formularius(){
        init();
    }
    
    private void init() {
        panel = new JPanel();
        setTitle("formularius");
        setSize(500, 220);
        setLayout(new FlowLayout());
        
        eNombre = new JLabel ("Nombre:                ");
        dNombre = new JTextField(30);
        eApellido_Paterno = new JLabel("Apellido Paterno: ");
        dApellido_Paterno = new JTextField(30);
        eApellido_Materno = new JLabel("Apellido Materno: ");
        dApellido_Materno = new JTextField(30);
        eDireccion = new JLabel("Direccón:               ");
        dDireccion = new JTextField(30);
        eEstado = new JLabel("Estado:");
        combo = new JComboBox();
        combo.addItem("Elije tu estado");
        combo.addItem("Soltero");
        combo.addItem("Casado");
        combo.addItem("Viudo y Disponible");
        eSexo = new JLabel("Sexo: ");
        ButtonGroup grupoBotones = new ButtonGroup();
        sMas = new JRadioButton("Masculino");
        grupoBotones.add(sMas);
        sFem = new JRadioButton("Femenino");
        grupoBotones.add(sFem);
        ACEPTAR = new JButton("ACEPTAR");
        
        this.add(eNombre);
        this.add(dNombre);
        this.add(eApellido_Paterno);
        this.add(dApellido_Paterno);
        this.add(eApellido_Materno);
        this.add(dApellido_Materno);
        this.add(eDireccion);
        this.add(dDireccion);
        this.add(eEstado);
        this.add(combo);
        this.add(eSexo);
        this.add(sMas);
        this.add(sFem);
        this.add(ACEPTAR);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        
        public static void main(String[] args) {
            try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formularius.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(formularius.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(formularius.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(formularius.class.getName()).log(Level.SEVERE, null, ex);
        }
        new formularius();
        }
        
        
    }


