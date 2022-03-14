/*
 * Matias Velasquez Angel Omar
 * 19161348
 * Ingenieria en Sistemas Computacionales
 * Segundo Semestre
 */
package ClubProgramacion;

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
 * @author angel
 */
public class Tarea3 extends JFrame{
    private JPanel panelA, panelB;
    private JLabel eRojo, eVerde, eAzul, titulo;
    private JTextField dRojo, dVerde, dAzul;
    private JButton calcular;
    
   public Tarea3(){
       init();
   }
   
   private void init(){
   this.setSize(new Dimension(540, 480));
        this.setTitle("Paleta de Colores");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
    
        
        panelA = new JPanel();
        panelA.setLayout(new GridBagLayout());
        eRojo = new JLabel("Rojo");
        gbc.gridx=0;
        gbc.gridy=0;
        panelA.add(eRojo,gbc);
        dRojo=new JTextField(10);
        gbc.gridx=1;
        gbc.gridy=0;
        panelA.add(dRojo,gbc);

        eVerde = new JLabel("Verde");
        gbc.gridx=0;
        gbc.gridy=1;
        panelA.add(eVerde,gbc);
        dVerde=new JTextField(10);
        gbc.gridx=1;
        gbc.gridy=1;
        panelA.add(dVerde,gbc);
        
        eAzul = new JLabel("Azul");
        gbc.gridx=0;
        gbc.gridy=2;
        panelA.add(eAzul,gbc);
        dAzul=new JTextField(10);
        gbc.gridx=1;
        gbc.gridy=2;
        panelA.add(dAzul,gbc);
        
        calcular= new JButton("Mostrar Color");
        calcular.setBackground(Color.LIGHT_GRAY);
        gbc.gridx=2;
        gbc.gridy=1;
        gbc.fill=GridBagConstraints.WEST;
        panelA.add(calcular,gbc);
        
        
        panelB = new JPanel();
        this.add(panelA,BorderLayout.WEST);
        this.add(panelB,BorderLayout.CENTER);
        
        titulo =new JLabel("Paleta de Colores");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
	this.add(titulo,BorderLayout.NORTH);
        
        
         calcular.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e) {
                int r=Integer.parseInt(dRojo.getText().trim());
            int g=Integer.parseInt(dVerde.getText().trim());
            int b=Integer.parseInt(dAzul.getText().trim());
            System.out.println(dRojo+" "+dVerde+" "+dAzul);
         if((r<=255 && g<=255 && b<=255)&& (r>=0&& g>=0 && b>=0)){
                    Color color = new Color(r,g,b);
                    panelB.setBackground(color);
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
    new Tarea3();
   }
}
    

