/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

/**
 *
 * @author lito_
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Spinner extends Panel implements ActionListener {

    private Button sube;
    private Button baja;
    private TextField dato;
    private Panel contenedor;
    private Panel contenedor2;

    private int value;
    private int maximo;
    private int minimo;
    private int aumento;

    public Spinner(int value, int maximo, int minimo, int aumento) {
        this.setLayout(new BorderLayout());
        contenedor = new Panel();
        contenedor.setLayout(new BorderLayout());
        contenedor.setSize(30, 20);
        dato = new TextField(5);
        contenedor.add(dato, BorderLayout.CENTER);
        contenedor.setVisible(true);
       
       
        contenedor2 = new Panel();
        sube = new Button("^");
        baja = new Button("v");
        
        contenedor2.setLayout(new GridLayout(2, 0));
        contenedor2.setSize(30, 20);
        contenedor2.add(sube);
        contenedor2.add(baja);
        contenedor2.setVisible(true);

        sube.addActionListener(this);
        baja.addActionListener(this);
        this.add(contenedor, BorderLayout.CENTER);
        this.add(contenedor2, BorderLayout.EAST);
        this.setVisible(true);
        this.setSize(200, 100);
//        this.setLocationRelativeTo(null);
//        this.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent windowsEvent) {
//                System.exit(0);
//            }
//        });
        this.value = value;
        this.maximo = maximo;
        this.minimo = minimo;
        this.aumento = aumento;
        dato.setText(value + "");

    }

    public void setValue(int value) {
        this.value = value;
        dato.setText(value+"");
    }
    public int getValue(){
        return value;
    }

    public static void main(String[] args) {
       Spinner spiner= new Spinner(0, 20, 0, 2);
        spiner.setValue(8);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sube) {
            value = value + aumento;
            if (!(value > maximo || value < minimo)) {
                dato.setText(value + "");
            }
        } else if (e.getSource() == baja) {
            value=value-aumento;
            if (!(value > maximo || value < minimo)) {
                dato.setText(value + "");
            }
        }
    }
}
