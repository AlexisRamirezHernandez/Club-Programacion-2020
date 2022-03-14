/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botones;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JOptionPane;
import static org.omg.CORBA.ORB.init;
/**
 *
 * @author Daniel Carmona Gonzalez
 * Numero de Control: 19161746
 */
public class Botoness extends JFrame {
    
   private GridLayout But;
    private JButton n1,n2,n3,n4,n5,n6,n7,n8,n9;
    public Botoness() {
    init();
}
    private void init(){
        int filas = 3;
        int columnas = 3;
        But = new GridLayout(filas, columnas);
        this.setLayout(But);
        n1 = new JButton ("1");
        n2 = new JButton ("2");
        n3 = new JButton ("3");
        n4 = new JButton ("4");
        n5 = new JButton ("5");
        n6 = new JButton ("6");
        n7 = new JButton ("7");
        n8 = new JButton ("8");
        n9 = new JButton ("9");
        
        this.add(n1);
        this.add(n2);
        this.add(n3);
        this.add(n4);
        this.add(n5);
        this.add(n6);
        this.add(n7);
        this.add(n8);
        this.add(n9);
        n1.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, n1.getText());}
         });   
        n2.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, n2.getText());}
         }); 
        n3.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, n3.getText());}
         }); 
        n4.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, n4.getText());}
         }); 
        n5.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, n5.getText());}
         }); 
        n6.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, n6.getText());}
         }); 
        n7.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, n7.getText());}
         }); 
        n8.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, n8.getText());}
         }); 
        n9.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, n9.getText());}
         }); 
        this.setTitle("GridLayout");
        this.setSize(600, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Clase Principal
      public static void main(String[] args) {
        new butones();
      }
}
