/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paleta_de_colores;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Insets;
/**
 *
 * @author Daniel Carmona Gonzalez
 * Numero de Control: 19161746
 */
public class Paleta_de_Colores extends JFrame{
    private JPanel p1;
    private JPanel p2;
    private JLabel titulo;
    private JLabel jpAzul; 
    private JLabel jpRojo; 
    private JLabel jpAmarillo;
    private JTextField jTAzul;
    private JTextField jTRojo; 
    private JTextField jTAmarillo;
    private JButton Mostrar;
     
    public Paleta_de_Colores(){
        init();
    }
    private void init(){
        this.setSize(new Dimension(400,350));
        this.setTitle("Paleta de Colores");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.insets = new Insets(10, 10, 10, 10);
        p1 = new JPanel();
        p1.setLayout(new GridBagLayout());
        jpAzul = new JLabel("Azul");
        grid.gridx=0;
        grid.gridy=0;
        p1.add(jpAzul,grid);
        jTAzul=new JTextField(10);
        grid.gridx=1;
        grid.gridy=0;
        p1.add(jpAzul,grid);        
        jpRojo = new JLabel("Rojo");
        grid.gridx=0;
        grid.gridy=1;
        p1.add(jpRojo,grid);
        jTRojo=new JTextField(10);
        grid.gridx=1;
        grid.gridy=1;
        p1.add(jTRojo,grid);
        jpAmarillo = new JLabel("Amarillo");
        grid.gridx=0;
        grid.gridy=2;
        p1.add(jpAmarillo,grid);
        jTAmarillo=new JTextField(10);
        grid.gridx=1;
        grid.gridy=2;
        p1.add(jTAmarillo,grid);
        Mostrar = new JButton("Mostrar Color");
        Mostrar.setBackground(Color.LIGHT_GRAY);
        grid.gridx=2;
        grid.gridy=1;
        grid.fill=GridBagConstraints.WEST;
        p1.add(Mostrar,grid);
        p2 = new JPanel();
        this.add(p1,BorderLayout.WEST);
        this.add(p2,BorderLayout.CENTER);
        titulo =new JLabel("Paleta de Colores");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
	this.add(titulo,BorderLayout.NORTH);
        Mostrar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e) {
                int r=Integer.parseInt(jTAzul.getText().trim());
            int g=Integer.parseInt(jTRojo.getText().trim());
            int b=Integer.parseInt(jTAmarillo.getText().trim());
            System.out.println(jTAzul+" "+jTRojo+" "+jTAmarillo);
         if((r<=255 && g<=255 && b<=255)&& (r>=0&& g>=0 && b>=0)){
                    Color color = new Color(r,g,b);
                    p2.setBackground(color);
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
        new Paleta_de_Colores();
    }  
}
