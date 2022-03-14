package club.de.programacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Adan Sanchez
 * numero de control: 17161238
 * carrera: ing. sistemas
 */
public class Grid_17161238 extends JFrame {

    public Grid_17161238() {
        super("Prueba grid");
        setSize(400, 400);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(3, 3));
        JButton[] botones = new JButton[9];
        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton(String.valueOf(i + 1));
            panel.add(botones[i]);
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    JOptionPane.showMessageDialog(null, ae.getActionCommand());
                }
            });
        }
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Grid_17161238();
    }
}
