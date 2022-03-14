/* Club de Programación
 * Alumno: Javier Manuel Pérez Santos
 * Programa: Ejercicio Paleta de colores
 * Número de control: 19161381
 */
package com.mycompany.cpaleta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.*;
public class cpaleta extends JFrame{
    
    GridBagConstraints gbc;
    private JLabel titulito;
    private JLabel rojo;
    private JLabel verdiuk;
    private JLabel azulillo;
    private JTextField dRojo;
    private JTextField dVerdiuk;
    private JTextField dAzulillo;
    private JButton mostrarColor;
    private JPanel simple;
    private JPanel panelGrid;
            
    public cpaleta(){
        init();
    }
    
    public void init(){
        this.setSize(new Dimension(650, 500));
        this.setLayout(new BorderLayout());
        this.setTitle("C Paleta de C olores");  
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        panelGrid = new JPanel();
        panelGrid.setLayout(new GridBagLayout());
        
        titulito = new JLabel("C Paleta de C olores");
        titulito.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titulito,BorderLayout.NORTH);
        rojo=new JLabel("Rojo");
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        panelGrid.add(rojo,gbc);
        dRojo=new JTextField(10);
        gbc.gridx=1;
        gbc.gridy=0;
        panelGrid.add(dRojo,gbc);
        
        verdiuk = new JLabel("Verdiuk");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        panelGrid.add(verdiuk,gbc);
        dVerdiuk = new JTextField(10);
        gbc.gridx=1;
        gbc.gridy=1;
        panelGrid.add(dVerdiuk,gbc);
        
        azulillo = new JLabel("Azulillo");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        panelGrid.add(azulillo,gbc);
        dAzulillo = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelGrid.add(dAzulillo,gbc);
        
        mostrarColor = new JButton("Mostrar C olor");
        mostrarColor.setBackground(Color.MAGENTA);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.WEST;
        panelGrid.add(mostrarColor, gbc);
        
        simple=new JPanel();     
        this.add(simple,BorderLayout.CENTER); 
        this.add(panelGrid,BorderLayout.WEST);
           
        mostrarColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                   
            int r=Integer.parseInt(dRojo.getText().trim());
            int g=Integer.parseInt(dVerdiuk.getText().trim());
            int b=Integer.parseInt(dAzulillo.getText().trim());
        if((r<=255 && g<=255 && b<=255)&& (r>=0&& g>=0 && b>=0)){
                    Color color = new Color(r,g,b);
                    simple.setBackground(color);
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
    public static void main(String[] args) {
        new cpaleta();
    }
}