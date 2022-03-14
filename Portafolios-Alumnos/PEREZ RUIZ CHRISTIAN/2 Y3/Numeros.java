/*
 * Christian Perez Ruiz
 * Segundo semestre Ing. Sistemas computacionales
 * No Control :19161379
*/
package trabajosclub;
        
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Numeros extends JFrame {

    private GridLayout gl;

    public Numeros() {
        init();
    }

    private void init() {
        int filas = 3;
        int columnas = 3;
        
        gl = new GridLayout(filas, columnas);
        
        this.setLayout(gl);
        
        JButton arreglo_botones[] = new JButton[9];
        for (int i = 0; i < arreglo_botones.length; i++) {
            
            arreglo_botones[i] = new JButton(String.format("%2d", i + 1));
            
            this.add(arreglo_botones[i]);
            
            arreglo_botones[i].setHorizontalAlignment(SwingConstants.CENTER);
            arreglo_botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton boton = (JButton) e.getSource();
                    if (boton == arreglo_botones[0]) {
                        JOptionPane.showMessageDialog(null, arreglo_botones[0].getText());
                    }if (boton == arreglo_botones[1]) {
                        JOptionPane.showMessageDialog(null, arreglo_botones[1].getText());
                    }if (boton == arreglo_botones[2]) {
                        JOptionPane.showMessageDialog(null, arreglo_botones[2].getText());
                    }if (boton == arreglo_botones[3]) {
                        JOptionPane.showMessageDialog(null, arreglo_botones[3].getText());
                    }if (boton == arreglo_botones[4]) {
                        JOptionPane.showMessageDialog(null, arreglo_botones[4].getText());
                    }if (boton == arreglo_botones[5]) {
                        JOptionPane.showMessageDialog(null, arreglo_botones[5].getText());
                    }if (boton == arreglo_botones[6]) {
                        JOptionPane.showMessageDialog(null, arreglo_botones[6].getText());
                    }if (boton == arreglo_botones[7]) {
                        JOptionPane.showMessageDialog(null, arreglo_botones[7].getText());
                    }if (boton == arreglo_botones[8]) {
                        JOptionPane.showMessageDialog(null, arreglo_botones[8].getText());
                    }
                    

                }
            });
            
            
                arreglo_botones[i].setBackground(Color.CYAN);
                

            
        }
        this.setTitle("Numeros");
        this.setSize(500, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Numeros();
    }

}
