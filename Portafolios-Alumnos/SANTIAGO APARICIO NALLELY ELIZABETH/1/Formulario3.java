/*
* Santiago Aparicio Nallely Elizabeth
* N. Control 18161245
* Semestre: 4
* Carrera: Ingenieria en Sistemas Computacionales 
 */
package abril_2020;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author nallely santiago
 */
public class Formulario3 {
    private JFrame frame;
    private JPanel pn,ps,pl,pt;
    private JLabel lnom, lap,lam,ld,lestados,lsexo;
    private JTextField tnom,tap,tam,td;
    private JComboBox cestado;
    private ButtonGroup gb = new ButtonGroup();
    private JRadioButton rbmujer,rbhombre;
    private JButton aceptar;
    private String aestados[] = {"Mexico","Puebla","Oaxaca","Jalisco","Chiapas","Veracruz"};
    public Formulario3(){
        frame = new JFrame();
        pn = new JPanel();
        ps = new JPanel();
        pl = new JPanel();
        pt = new JPanel();
        lnom = new JLabel("Nombre:");
        lap = new JLabel("Apellido Paterno:");
        lam = new JLabel("Apellido Materno:");
        ld = new JLabel("Dirección: ");
        lestados = new JLabel("Estados: ");
        lsexo = new JLabel("Sexo:");
        tnom = new JTextField(30);
        tap = new JTextField(30);
        tam = new JTextField(30);
        td = new JTextField(30);
        cestado = new JComboBox(aestados);
        rbmujer = new JRadioButton("Mujer");
        rbhombre = new JRadioButton("Hombre");
        aceptar = new JButton("Aceptar");
        gb.add(rbmujer);
        gb.add(rbhombre);
        frame.add(pn, BorderLayout.NORTH);
        frame.add(ps, BorderLayout.SOUTH);
        pn.setLayout(new FlowLayout());
        pn.add(pl);
        pn.add(pt);
        pl.setLayout(new GridLayout(4,0));
        pl.add(lnom);
        pl.add(lap);
        pl.add(lam);
        pl.add(ld);
        pt.setLayout(new GridLayout(4,0));
        pt.add(tnom);
        pt.add(tap);
        pt.add(tam);
        pt.add(td);
        ps.add(lestados);
        ps.add(cestado);
        ps.add(lsexo);
        ps.add(rbmujer);
        ps.add(rbhombre);
        ps.add(aceptar);
        frame.setVisible(true);
        frame.setLocation(300,100);
        frame.setSize(550, 200);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Formulario3 f3 = new Formulario3();
    }
}