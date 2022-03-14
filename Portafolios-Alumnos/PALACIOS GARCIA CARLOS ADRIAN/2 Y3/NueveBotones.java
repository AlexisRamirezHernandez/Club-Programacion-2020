/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevebotones;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Carlos Adrian Palacios Garcia
 * No. Control: 19161374
 * Carrera: ing. Sistemas
 * segundo semestre
 */
public class NueveBotones extends JFrame {
    
    private GridLayout grL;
    private JPanel Ppanel;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;

    public NueveBotones(){
    init();}
    
    public void init(){
        grL=new GridLayout(3,3);
    Ppanel=new JPanel();
        setTitle("Botones 1-9");
        setSize(450,300);
        this.setLayout(grL);
        
        
        ButtonGroup GrBoton=new ButtonGroup();
        b1=new JButton("1");
        GrBoton.add(b1);
        b2=new JButton("2");
        GrBoton.add(b2);
        b3=new JButton("3");
        GrBoton.add(b3);
        b4=new JButton("4");
        GrBoton.add(b4);
        b5=new JButton("5");
        GrBoton.add(b5);
        b6=new JButton("6");
        GrBoton.add(b6);
        b7=new JButton("7");
        GrBoton.add(b7);
        b8=new JButton("8");
        GrBoton.add(b8);
        b9=new JButton("9");
        GrBoton.add(b9);
        
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        this.add(b6);
        this.add(b7);
        this.add(b8);
        this.add(b9);
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, b1.getText());}
        });
        
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,b2.getText());}
        });
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,b3.getText());}
        });
        b4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
            JOptionPane.showMessageDialog(null, b4.getText());}
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,b5.getText());}
        });
        b6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
            JOptionPane.showMessageDialog(null, b6.getText());}
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,b5.getText());}
        });
        b8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
            JOptionPane.showMessageDialog(null, b8.getText());}
        });
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,b9.getText());}
        });
        
        b5.setBackground(Color.MAGENTA);
              
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        new NueveBotones();
    }
    
}
