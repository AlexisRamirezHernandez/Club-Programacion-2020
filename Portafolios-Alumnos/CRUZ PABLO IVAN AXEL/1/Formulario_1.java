/*
 Ivan_Axel_Cruz_Pablo
Segundo_Semestre
Ing._Sistemas_Computacionales
19161260
 */
package com.mycompany.fomulario_1;
import javax.swing.*;
import java.awt.FlowLayout;
/**
 *
 * @author Ivan Axel Cruz Pablo
 */
public class Formulario_1 extends JFrame{
    private JLabel nombre,apellidoPa,apellidoMa,direccion,estado,sexo;
    private JPanel panel;
    private JTextField tnombre,tapellidoPa,tapellidoMa,tdireccion,testado;
    private JButton aceptar;
    private JRadioButton sMu,sHo;
    private JComboBox combo;
    
    public Formulario_1() {
        init();
    }
    private void init(){
        panel = new JPanel();
        setTitle("Formulario n° 1");
        setSize(600, 200);
        setLayout(new FlowLayout());
        
        nombre = new JLabel("Nombre:                   ");
        tnombre = new JTextField(40);
        apellidoPa = new JLabel("Apellido Paterno:   ");
        tapellidoPa = new JTextField(40);
        apellidoMa = new JLabel("Apellido Materno:  ");
        tapellidoMa = new JTextField(40); 
        direccion = new JLabel("Dirección:               ");
        tdireccion = new JTextField(40);
        estado = new JLabel("Estado");
        combo = new JComboBox();
        combo.addItem("Elige estado");
        combo.addItem("Soltero");
        combo.addItem("Casado");
        sexo = new JLabel("Sexo:");
        ButtonGroup grupoBotones = new ButtonGroup();
        sMu = new JRadioButton("Mujer");
        grupoBotones.add(sMu);
        sHo = new JRadioButton("Hombre");
        grupoBotones.add(sHo);
        aceptar = new JButton("Aceptar");
        
        this.add(nombre);
        this.add(tnombre);
        this.add(apellidoPa);
        this.add(tapellidoPa);
        this.add(apellidoMa);
        this.add(tapellidoMa);
        this.add(direccion);
        this.add(tdireccion);
        this.add(estado);
        this.add(combo);
        this.add(sexo);
        this.add(sMu);
        this.add(sHo);
        this.add(aceptar);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Formulario_1();
    }
}