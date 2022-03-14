/* Club de Programación
 * Alumno: Javier Manuel Pérez Santos
 * Programa: Butones
 * Número de control: 19161381
 */

package com.mycompany.butones;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JOptionPane;
import static org.omg.CORBA.ORB.init;

public class butones extends JFrame {

    private GridLayout gl;
    private JButton one, two, three, four, five, six, seven, eight, nine, ten;
    
    public butones() {
        init();
    }
 
 private void init() {
        int filas = 3;
        int columnas = 3;
        gl = new GridLayout(filas, columnas);
        this.setLayout(gl);
        
        one = new JButton ("1");
        two = new JButton ("2");
        three = new JButton ("3");
        four = new JButton ("4");
        five = new JButton ("5");
        six = new JButton ("6");
        seven = new JButton ("7");
        eight = new JButton ("8");
        nine = new JButton ("9");
        
        this.add(one);
        this.add(two);
        this.add(three);
        this.add(four);
        this.add(five);
        this.add(six);
        this.add(seven);
        this.add(eight);
        this.add(nine);
        
        one.addActionListener(new ActionListener(){
        @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, one.getText());}
         });
        two.addActionListener(new ActionListener(){
        @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, two.getText());}
        });
        three.addActionListener(new ActionListener(){
        @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, three.getText());}
        });
        four.addActionListener(new ActionListener(){
        @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, four.getText());}
        });
        five.addActionListener(new ActionListener(){
        @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, five.getText());}
        });
        six.addActionListener(new ActionListener(){
        @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, six.getText());}
        });
        seven.addActionListener(new ActionListener(){
        @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, seven.getText());}
        });
        eight.addActionListener(new ActionListener(){
        @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, eight.getText());}
        });
        nine.addActionListener(new ActionListener(){
        @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, nine.getText());}
        });
                
        this.setTitle("GridLayout");
        this.setSize(500, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new butones();
    }
}
