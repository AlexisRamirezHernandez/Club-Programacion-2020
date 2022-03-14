import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  
  ///Martinez Castellanos Francisco Emmanuel 16161365 8vo semestre
public class MyGridLayout{  
JFrame f;  
MyGridLayout(){  
    f=new JFrame();  
      
    JButton b1=new JButton("1");  
    JButton b2=new JButton("2");  
    JButton b3=new JButton("3");  
    JButton b4=new JButton("4");  
    JButton b5=new JButton("5");  
    JButton b6=new JButton("6");  
    JButton b7=new JButton("7");  
    JButton b8=new JButton("8");  
    JButton b9=new JButton("9");  
          
    f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);  
    f.add(b6);f.add(b7);f.add(b8);f.add(b9);  
  
    f.setLayout(new GridLayout(3,3));  
    //setting grid layout of 3 rows and 3 columns  
  
    f.setSize(300,300);  
    f.setVisible(true);  
    
    
	 b1.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
	
			  JOptionPane.showMessageDialog(null, "El valor es : "+"1");
		 }
		 });
	 
	 
	 b2.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
	
			  JOptionPane.showMessageDialog(null, "El valor es : "+"2");
		 }
		 });
	 
	 b3.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
	
			  JOptionPane.showMessageDialog(null, "El valor es : "+"3");
		 }
		 });
	 
	 b4.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
	
			  JOptionPane.showMessageDialog(null, "El valor es : "+"4");
		 }
		 });
	 b5.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
	
			  JOptionPane.showMessageDialog(null, "El valor es : "+"5");
		 }
		 });
	 
	 b6.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
	
			  JOptionPane.showMessageDialog(null, "El valor es : "+"6");
		 }
		 });
	 
	 b7.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
	
			  JOptionPane.showMessageDialog(null, "El valor es : "+"7");
		 }
		 });
	 
	 b8.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
	
			  JOptionPane.showMessageDialog(null, "El valor es : "+"8");
		 }
		 });
	 b9.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
	
			  JOptionPane.showMessageDialog(null, "El valor es : "+"9");
		 }
		 });
    
}  

public static void main(String[] args) {  
    new MyGridLayout();  
}  
}