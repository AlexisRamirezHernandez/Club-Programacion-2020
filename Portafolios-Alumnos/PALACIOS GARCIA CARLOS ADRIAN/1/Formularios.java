
package formularios;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Carlos adrian Palacios Garcia
 * No. Control: 19161374
 * carrera:ing. Sistemas
 * segundo semestre
 */
public class Formularios extends JFrame{

    private JLabel eName, eApp, eApm,eDireccion,eEstado,eSexo;
    private JPanel panel;
    private JTextField tName, tApp, tApm, tDireccion;
    private JComboBox EligeEstado;
    private JCheckBox cMujer, cHombre;
    private JButton bAceptar;
    
    public Formularios(){
    init();}
    
    private void init(){
    panel=new JPanel();
        setTitle("Formulario");
        setSize(540, 200);
        setLayout(new FlowLayout());
        
        
        eName=new JLabel("Nombre:               ");
        tName=new JTextField(35);
        eApp=new JLabel("Apellido Paterno:");
        tApp=new JTextField(35);
        eApm=new JLabel("Apellido Paterno:");
        tApm=new JTextField(35);
        eDireccion=new JLabel("Direccion:            ");
        tDireccion=new JTextField(35);
        ButtonGroup grBotoon=new ButtonGroup();
        
        eEstado=new JLabel("Estado: ");
        EligeEstado=new JComboBox();
        //grBotoon.add(EligeEstado);
        EligeEstado.addItem("Elige Estado");
        EligeEstado.addItem("Solterosky");
        EligeEstado.addItem("Dejado");
        EligeEstado.addItem("Amarrado");
        eSexo=new JLabel("Sexo:");
        cMujer=new JCheckBox("mujer");
        grBotoon.add(cMujer);
        cHombre=new JCheckBox("Hombre");
        grBotoon.add(cHombre);
        bAceptar=new JButton("Aceptar");
        grBotoon.add(bAceptar);
        
        this.add(eName);
        this.add(tName);
        this.add(eApp);
        this.add(tApp);
        this.add(eApm);
        this.add(tApm);
        this.add(eDireccion);
        this.add(tDireccion);
        this.add(eEstado);
        this.add(EligeEstado);
        this.add(eSexo);
        this.add(cMujer);
        this.add(cHombre);
        this.add(bAceptar);
        
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formularios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Formularios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Formularios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Formularios.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Formularios();
    }
    
}
