/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;
import javax.swing.*;
import Java.awt.*;
import Java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Tester {

    public Tester(){

        JComboBox box = new JComboBox();
        box.addItem("One");
        box.addItem("Two");
        box.addItem("Three");
        box.addItem("Four");

        box.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                System.out.println(e.getItem() + " " + e.getStateChange() );
            }
        });

        JFrame frame = new JFrame();
        frame.getContentPane().add(box);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String [] args) {
        Tester tester = new Tester();
    }
}