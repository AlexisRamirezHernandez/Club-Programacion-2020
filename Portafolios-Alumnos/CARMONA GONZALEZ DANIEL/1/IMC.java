/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;
import java.awt.Checkbox;
import javax.swing.*;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Daniel Carmona Gonzalez
 * Num de Control: 19161746
 */
public class IMC extends JFrame{
  private JLabel nombre,apaterno,amaterno,direccion,estado,sexo;  
  private JPanel panel;
  private JTextField Jnombre,Japaterno,Jamaterno,Jdireccion,Jestado,Jsexo;
  private JCheckBox sexMas,sexFem;
  private JButton Aceptar;
  private JComboBox lista;
 
  
  private void init(){
      panel=new JPanel();
      setTitle("Formulario del Club");
      setSize(580, 300);
      setLayout(new FlowLayout());
      nombre = new JLabel ("Nombre: ");
      Jnombre= new JTextField(40);
      apaterno = new JLabel ("Apellido Paterno: ");
      Japaterno = new JTextField(40);
      amaterno = new JLabel ("Apellido Materno: ");
      Jamaterno = new JTextField(40);
      direccion = new JLabel ("Direccion: ");
      Jdireccion = new JTextField(80);
      estado = new JLabel ("Estado: ");
      lista = new JComboBox();
      lista.addItem("Selecciona tu Estado");
      lista.addItem("Soltero");
      lista.addItem("Casado");
      lista.addItem("Viudo");
      lista.addItem("Divorsiado");
      lista.addItem("Otro");
      sexo = new JLabel ("Sexo: ");
      sexMas = new JCheckBox("Hombre");
      ButtonGroup Boton = new ButtonGroup();
      Boton.add(sexMas);
      sexFem = new JCheckBox("Mujer");
      Boton.add(sexFem);
      Aceptar = new JButton("aceptar");
      this.add(nombre);
      this.add(Jnombre);        
      this.add(apaterno);
      this.add(Japaterno);        
      this.add(amaterno);
      this.add(Jamaterno);
      this.add(direccion);
      this.add(Jdireccion);                     
      this.add(estado);
      this.add(lista);
      this.add(sexo);
      this.add(sexMas);
      this.add(sexFem);  
      this.add(Aceptar);
      setVisible(true);
      setResizable(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String[] args) {
        // IMC M = new IMC();
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IMC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(IMC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(IMC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(IMC.class.getName()).log(Level.SEVERE, null, ex);
        }
        new IMC();
    }
}

