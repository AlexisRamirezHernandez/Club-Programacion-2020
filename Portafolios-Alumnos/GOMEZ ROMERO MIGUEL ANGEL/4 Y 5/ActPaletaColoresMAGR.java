/*
 * Gomez Romero Miguel Angel
 * 19161282
 * Ingenieria en Sistemas Computacionales
 * Segundo Semestre
 * ACTIVIDAD DEL CLUB: BorderLayout & GridBagLayout
 */
package com.unidad5.paletacolores;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.*;
public class ActPaletaColoresMAGR extends JFrame{
    
    GridBagConstraints gbc;
    private JLabel titulo;
    private JLabel rojo;
    private JLabel verde;
    private JLabel azul;
    private JLabel xd;
    private JTextField dRojo;
    private JTextField dVerde;
    private JTextField  dAzul;
    private JButton mostrar;
    private JPanel simple;
    private JPanel panelGrid;
            
    public ActPaletaColoresMAGR(){
        init();
    }
    
    public void init(){
        this.setSize(new Dimension(850, 700));
        this.setLayout(new BorderLayout());
        this.setTitle("Paleta de Colores");  
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        panelGrid = new JPanel();
        panelGrid.setLayout(new GridBagLayout());
        
        titulo = new JLabel("Paleta de Colores");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titulo,BorderLayout.NORTH);
        
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
        
        verde= new JLabel("Verde");
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        panelGrid.add(verde,gbc);
        
        dVerde=new JTextField(10);
        gbc.gridx=1;
        gbc.gridy=1;
        panelGrid.add(dVerde,gbc);
        
        azul=new JLabel("Azul");
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        panelGrid.add(azul,gbc);

        dAzul=new JTextField(10);
        gbc.gridx=1;
        gbc.gridy=2;
        panelGrid.add(dAzul,gbc);
        
        mostrar = new JButton("Mostrar Color");
        mostrar.setBackground(Color.PINK);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.WEST;
        panelGrid.add(mostrar, gbc);
        
        /* Esto es para ver si se podia poner un GIF y posicionarlo como los Label y TextField
        xd = new JLabel();
        xd.setIcon(new ImageIcon("XD.gif")); SI FUNCIONA :)
        gbc.gridx = 1;
        gbc.gridy = 4; PREGUNTA: ¿Se puede cambiar el tamaño de un gif o una imagen?
        panelGrid.add(xd,gbc);
        */ 
        
        simple=new JPanel();
        
        this.add(simple,BorderLayout.CENTER); 
        this.add(panelGrid,BorderLayout.WEST);
        
              
        mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    
            int r=Integer.parseInt(dRojo.getText().trim());
            int g=Integer.parseInt(dVerde.getText().trim());
            int b=Integer.parseInt(dAzul.getText().trim());
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
        new ActPaletaColoresMAGR();
    }
    
}
