/*
 * Alumno: uzai velasco hernandez
 * 19161433
 * Ingenieria en Sistemas Computacionales
 * Segundo Semestre
 */

package com.mycompany.clubprogramacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.TextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Insets;
/**
 *
 * @author uzai
 */
public class PaletaDeColoresUzai extends JFrame{
   
    private JPanel panel1;
    private JPanel panel2;
    private JLabel titulo;
    private JLabel jLRojo; 
    private JLabel jLVerde; 
    private JLabel jLAzul;
    private JTextField jTRojo;
    private JTextField jTVerde; 
    private JTextField jTAzul;
    private JButton calcular;
    
   public PaletaDeColoresUzai(){
       init();
   }
   
   private void init(){
   this.setSize(new Dimension(540, 480));
        this.setTitle("Paleta de Colores");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        jLRojo = new JLabel("Rojo");
        gbc.gridx=0;
        gbc.gridy=0;
        panel1.add(jLRojo,gbc);
        jTRojo=new JTextField(10);
        gbc.gridx=1;
        gbc.gridy=0;
        panel1.add(jTRojo,gbc);

        jLVerde = new JLabel("Verde");
        gbc.gridx=0;
        gbc.gridy=1;
        panel1.add(jLVerde,gbc);
        jTVerde=new JTextField(10);
        gbc.gridx=1;
        gbc.gridy=1;
        panel1.add(jTVerde,gbc);
        
        jLAzul = new JLabel("Azul");
        gbc.gridx=0;
        gbc.gridy=2;
        panel1.add(jLAzul,gbc);
        jTAzul=new JTextField(10);
        gbc.gridx=1;
        gbc.gridy=2;
        panel1.add(jTAzul,gbc);
        
        calcular= new JButton("Mostrar Color");
        calcular.setBackground(Color.LIGHT_GRAY);
        gbc.gridx=2;
        gbc.gridy=1;
        gbc.fill=GridBagConstraints.WEST;
        panel1.add(calcular,gbc);
        
        
        panel2 = new JPanel();
        this.add(panel1,BorderLayout.WEST);
        this.add(panel2,BorderLayout.CENTER);
        
        titulo =new JLabel("Paleta de Colores");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
	this.add(titulo,BorderLayout.NORTH); 
        
        
         calcular.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e) {
                int r=Integer.parseInt(jTRojo.getText().trim());
            int g=Integer.parseInt(jTVerde.getText().trim());
            int b=Integer.parseInt(jTAzul.getText().trim());
            System.out.println(jTRojo+" "+jTVerde+" "+jTAzul);
         if((r<=255 && g<=255 && b<=255)&& (r>=0&& g>=0 && b>=0)){
                    Color color = new Color(r,g,b);
                    panel2.setBackground(color);
                    }else{
               JOptionPane.showMessageDialog(null,"Fuera de Rango");

       
               } 
          }
         });
         this.setVisible(true);
        this.setLocationRelativeTo(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
               
    }
   public static void main(String[]args) {
    new PaletaDeColoresUzai();
   }
}
    