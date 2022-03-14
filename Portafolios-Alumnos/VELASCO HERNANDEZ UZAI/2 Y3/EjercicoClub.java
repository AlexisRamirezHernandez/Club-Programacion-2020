package com.ejerciciosClub.pruebaClubgridlayout;

/*
 * UZAI VELASCO HERNANDEZ
 * 19161433
 * Ingenieria en Sistemas Computacionales
 * Segundo Semestre
 * Ejercicio Del Club: GRIDLAYOUT 
 */
package com.mycompany.prueba2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
/**
 *
 * @author Uzai
 */

public class EjercicioDelClub extends JFrame{
    private GridLayout gl;
    private JButton uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve;
    
    public EjercicioDelClub() {
        init();
    }
    
    private void init() {
        int filas = 3;
        int columnas = 3;
        gl = new GridLayout(filas, columnas);
        
        this.setLayout(gl);
        
        Uno = new JButton("1");
        Dos = new JButton("2");
        Tres = new JButton("3");
        Cuatro = new JButton("4");
        Cinco = new JButton("5");
        Seis = new JButton("6");
        Siete = new JButton("7");
        Ocho = new JButton("8");
        Nueve = new JButton("9");
        
        this.add(Uno);
        this.add(Dos);
        this.add(Tres);
        this.add(Cuatro);
        this.add(Cinco);
        this.add(Seis);
        this.add(Siete);
        this.add(Ocho);
        this.add(Nueve);

        uno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, Uno.getText());
            }
        });
        
        dos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, Dos.getText());
            }
        });
        
        tres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, Tres.getText());
            }
        });
        
        cuatro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, Cuatro.getText());
            }
        });
        
        cinco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, Cinco.getText());
            }
        });
        
        seis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, Seis.getText());
            }
        });
        
        siete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, Siete.getText());
            }
        });
        
        ocho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, Ocho.getText());
            }
        });
        
        nueve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, Nueve.getText());
            }
        });
        
        //Colores para los botonnes LOL
        Uno.setBackground(Color.BLACK);
        Dos.setBackground(Color.CYAN);
        Tres.setBackground(Color.GREEN);
        Cuatro.setBackground(Color.MAGENTA);
        Cinco.setBackground(Color.ORANGE);
        Seis.setBackground(Color.PINK);
        Siete.setBackground(Color.RED);
        Ocho.setBackground(Color.YELLOW);
        Nueve.setBackground(Color.BLUE);

        this.setTitle("GridLayout");
        this.setSize(500, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public static void main(String[] args) {
        new EjercicioDelClub();
    }
}