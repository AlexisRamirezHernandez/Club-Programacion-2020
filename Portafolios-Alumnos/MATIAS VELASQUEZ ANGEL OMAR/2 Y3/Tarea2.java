/*
 * Matias Velasquez Angel Omar
 * 19161348
 * Ingenieria en Sistemas Computacionales
 * Segundo Semestre
 */
package ClubProgramacion;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
/**
 *
 * @author angel
 */

public class Tarea2 extends JFrame{
    private GridLayout gl;
    private JButton uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve;
    
    public Tarea2() {
        init();
    }
    
    private void init() {
        int filas = 3;
        int columnas = 3;
        gl = new GridLayout(filas, columnas);
        
        this.setLayout(gl);
        
        uno = new JButton("1");
        dos = new JButton("2");
        tres = new JButton("3");
        cuatro = new JButton("4");
        cinco = new JButton("5");
        seis = new JButton("6");
        siete = new JButton("7");
        ocho = new JButton("8");
        nueve = new JButton("9");
        
        this.add(uno);
        this.add(dos);
        this.add(tres);
        this.add(cuatro);
        this.add(cinco);
        this.add(seis);
        this.add(siete);
        this.add(ocho);
        this.add(nueve);

        uno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, uno.getText());
            }
        });
        
        dos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, dos.getText());
            }
        });
        
        tres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, tres.getText());
            }
        });
        
        cuatro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, cuatro.getText());
            }
        });
        
        cinco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, cinco.getText());
            }
        });
        
        seis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, seis.getText());
            }
        });
        
        siete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, siete.getText());
            }
        });
        
        ocho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, ocho.getText());
            }
        });
        
        nueve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, nueve.getText());
            }
        });
        
      
        uno.setBackground(Color.GRAY);
        dos.setBackground(Color.WHITE);
        tres.setBackground(Color.GRAY);
        cuatro.setBackground(Color.WHITE);
        cinco.setBackground(Color.GRAY);
        seis.setBackground(Color.WHITE);
        siete.setBackground(Color.GRAY);
        ocho.setBackground(Color.WHITE);
        nueve.setBackground(Color.GRAY);

        this.setTitle("GridLayout");
        this.setSize(500, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public static void main(String[] args) {
        new Tarea2();
    }
}