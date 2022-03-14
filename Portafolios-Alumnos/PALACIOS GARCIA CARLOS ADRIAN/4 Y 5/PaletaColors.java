/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paletacolors;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
public class PaletaColors extends JFrame{
    
    private JPanel pPanel,pPanel1;
    private JLabel eTitle,eRed, eBlue, eGreen;
    private JTextField tRed,tBlue,tGreen;
    private JButton bCalcular;
    
    public PaletaColors(){
    init();}
    
    private void init(){
        this.setTitle("Paleta de colores");
        this.setSize(500,400);
        this.setLayout(new BorderLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(10, 10, 10, 10);
        
        eTitle=new JLabel("Paleta de Colores");
        eTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(eTitle,BorderLayout.NORTH);
        
        pPanel=new JPanel();
        pPanel.setLayout(new GridBagLayout());
        eRed=new JLabel("Rojo");
        gbc.gridx=0;
        gbc.gridy=0;
         pPanel.add(eRed,gbc);
         
         tRed=new JTextField(15);
         gbc.gridx=0;
         gbc.gridy=1;
         pPanel.add(tRed,gbc);
         
         eGreen=new JLabel("Verde");
         gbc.gridx=0;
         gbc.gridy=2;
         pPanel.add(eGreen,gbc);
         
         tGreen=new JTextField(15);
         gbc.gridx=0;
         gbc.gridy=3;
         pPanel.add(tGreen,gbc);
         
         eBlue=new JLabel("Azul");
         gbc.gridx=0;
         gbc.gridy=4;
         pPanel.add(eBlue,gbc);
         
         tBlue=new JTextField(15);
         gbc.gridx=0;
         gbc.gridy=5;
         pPanel.add(tBlue,gbc);
         
         bCalcular=new JButton("Mostrar Color");
         gbc.gridx=1;
         gbc.gridy=3;
         gbc.fill=GridBagConstraints.WEST;
         pPanel.add(bCalcular,gbc);
         
         pPanel1=new JPanel();
         this.add(pPanel,BorderLayout.WEST);
         this.add(pPanel1, BorderLayout.CENTER);
         
         bCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    
            int r=Integer.parseInt(tRed.getText().trim());
            int g=Integer.parseInt(tGreen.getText().trim());
            int b=Integer.parseInt(tBlue.getText().trim());
            System.out.println(tRed+" "+tGreen+" "+tBlue);
        if((r<=255 && g<=255 && b<=255)&& (r>=0&& g>=0 && b>=0)){
                    Color color = new Color(r,g,b);
                    pPanel1.setBackground(color);
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
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new PaletaColors();
    }
    
}
