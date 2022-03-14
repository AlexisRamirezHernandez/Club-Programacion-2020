package club.de.programacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Adan Sanchez 
 * numero de control: 17161238 
 * carrera: ing. sistemas
 */
public class GridBag_17161238 extends JFrame {

    public GridBag_17161238() {
        super("paleta de colores");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel todo = new JPanel(new BorderLayout());
        JLabel nombre = new JLabel("Paleta de colores");
        nombre.setHorizontalAlignment(JLabel.CENTER);
        todo.add(nombre, BorderLayout.NORTH);

        JPanel datos = new JPanel(new GridBagLayout());
        GridBagConstraints caracteriscticas = new GridBagConstraints();
        JLabel rojo = new JLabel("Rojo");
        caracteriscticas.gridx = 0;
        caracteriscticas.gridy = 0;
        datos.add(rojo, caracteriscticas);

        JLabel verde = new JLabel("Verde");
        caracteriscticas.gridy = 1;
        datos.add(verde, caracteriscticas);

        JLabel azul = new JLabel("Azul");
        caracteriscticas.gridy = 2;
        datos.add(azul, caracteriscticas);

        JTextField rojoTxT = new JTextField(10);
        caracteriscticas.gridx = 1;
        caracteriscticas.gridy = 0;
        datos.add(rojoTxT, caracteriscticas);

        JTextField verdeTxT = new JTextField(10);
        caracteriscticas.gridy = 1;
        datos.add(verdeTxT, caracteriscticas);

        JTextField azulTxT = new JTextField(10);
        caracteriscticas.gridy = 2;
        datos.add(azulTxT, caracteriscticas);

        JButton calcular = new JButton("Calcular");
        caracteriscticas.gridx = 2;
        caracteriscticas.gridy = 1;
        datos.add(calcular, caracteriscticas);

        JPanel Color = new JPanel();
        todo.add(datos, BorderLayout.WEST);
        todo.add(Color, BorderLayout.CENTER);
        add(todo);

        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = Integer.parseInt(rojoTxT.getText().trim());
                int g = Integer.parseInt(verdeTxT.getText().trim());
                int b = Integer.parseInt(azulTxT.getText().trim());
                if ((r <= 255 && g <= 255 && b <= 255) && (r >= 0 && g >= 0 && b >= 0)) {
                    Color color = new Color(r, g, b);
                    Color.setBackground(color);
                } else {
                    JOptionPane.showMessageDialog(null, "Fuera de Rango");
                }
            }
        });

    }

    public static void main(String[] args) {
        new GridBag_17161238();
    }
}
