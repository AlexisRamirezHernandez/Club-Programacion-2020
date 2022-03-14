package aplicacionesmarzo2020;

//Nombre: José Monjaraz Juan Carlos
//No. Control: 18161148
//Semestre:4
//Carrera:Ingenieria en Sistemas


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Carlos Monjaraz
 */
public class FormularioCarlosMonjaraz {
    public JTextField txtNombre, txtApellp, txtApellM, txtDireccion;
    public JComboBox bxEstados;
    public JRadioButton rbHombre, rbMujer;
    public JButton btnAceptar; 
    public String aEstados[] = {"Elige tu estado"};
    public FormularioCarlosMonjaraz(){
        JFrame f = new JFrame();
        f.setTitle("");
        f.setLayout(new BorderLayout());
        f.setVisible(true);
        f.setLocation(300,100);
        f.setSize(500,170);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        txtNombre = new JTextField(30);
        txtApellp = new JTextField(30);
        txtApellM = new JTextField(30);
        txtDireccion = new JTextField(30);
        JLabel lbNombre = new JLabel("Nombre:");
        JLabel lbApellp = new JLabel("Apellido Paterno:");
        JLabel lbApellm = new JLabel("Apellido Materno:");
        JLabel lbDireccion = new JLabel("Dirección");
        
        JLabel estados = new JLabel("Estados:");
        JLabel sexo = new JLabel("Sexo:");
        bxEstados = new JComboBox(aEstados);
        rbMujer = new JRadioButton("Mujer");
        rbHombre =  new JRadioButton("Hombre");
        btnAceptar = new JButton("ACEPTAR");
        
        JPanel pInformacion = new JPanel();
        JPanel pInformacionl = new JPanel();
        JPanel pInformaciont = new JPanel();
        JPanel pCentro = new JPanel();
        pInformacion.setLayout(new FlowLayout());
        pInformacionl.setLayout(new GridLayout(4,0));
        pInformaciont.setLayout(new GridLayout(4,0));
        pCentro.setLayout(new FlowLayout());
        pInformacionl.add(lbNombre);
        pInformacionl.add(lbApellp);
        pInformacionl.add(lbApellm);
        pInformacionl.add(lbDireccion);
        pInformaciont.add(txtNombre);
        pInformaciont.add(txtApellp);
        pInformaciont.add(txtApellM);;
        pInformaciont.add(txtDireccion);
        pInformacion.add(pInformacionl);
        pInformacion.add(pInformaciont);
        pCentro.add(estados);
        pCentro.add(bxEstados);
        pCentro.add(sexo);
        pCentro.add(rbMujer);
        pCentro.add(rbHombre);
        pCentro.add(btnAceptar);
        
        f.add(pInformacion,BorderLayout.NORTH);
        f.add(pCentro,BorderLayout.CENTER);
    }    
    
    public static void main(String[] args) {
        FormularioCarlosMonjaraz obj = new FormularioCarlosMonjaraz();
    }
}