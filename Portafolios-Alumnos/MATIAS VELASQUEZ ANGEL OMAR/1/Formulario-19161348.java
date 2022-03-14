/*
 * Matias Velasquez Angel Omar
 * 19161348
 * Ingenieria en Sistemas Computacionales
 * Segundo Semestre
 */
package ClubProgramacion;
import javax.swing.*;
import java.awt.FlowLayout;
/**
 *
 * @author angel
 */
public class Formulario extends JFrame{
    private JLabel Enombre,EapellidoPa,EapellidoMa,Edireccion,Eestado,Esexo;
    private JPanel panel;
    private JTextField Tnombre,TapellidoPa,TapellidoMa,Tdireccion,Testado;
    private JButton aceptar;
    private JRadioButton sMu,sHo;
    private JComboBox combo;
    
    public Formulario() {
        init();
    }
    private void init(){
        panel = new JPanel();
        setTitle("Formulario");
        setSize(435, 200);
        setLayout(new FlowLayout());
        
        Enombre = new JLabel("Nombre:                ");
        Tnombre = new JTextField(25);
        EapellidoPa = new JLabel("Apellido Paterno:");
        TapellidoPa = new JTextField(25);
        EapellidoMa = new JLabel("Apellido Materno:");
        TapellidoMa = new JTextField(25);
        Edireccion = new JLabel("Dirección:            ");
        Tdireccion = new JTextField(25);
        Eestado = new JLabel("Estado: ");
        combo = new JComboBox();
        combo.addItem("Elige estado");
        combo.addItem("Casado");
        combo.addItem("Soltero");
        combo.addItem("Union libre");
        combo.addItem("Viudo");
        Esexo = new JLabel("Sexo:");
        ButtonGroup grupoBotones = new ButtonGroup();
        sMu = new JRadioButton("Mujer");
        grupoBotones.add(sMu);
        sHo = new JRadioButton("Hombre");
        grupoBotones.add(sHo);
        aceptar = new JButton("Aceptar");
        
        this.add(Enombre);
        this.add(Tnombre);
        
        this.add(EapellidoPa);
        this.add(TapellidoPa);
        
        this.add(EapellidoMa);
        this.add(TapellidoMa);
        
        this.add(Edireccion);
        this.add(Tdireccion);
        
        this.add(Eestado);
        this.add(combo);
        
        this.add(Esexo);
        this.add(sMu);
        this.add(sHo);
        
        this.add(aceptar);
        
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new Formulario();
    }
}