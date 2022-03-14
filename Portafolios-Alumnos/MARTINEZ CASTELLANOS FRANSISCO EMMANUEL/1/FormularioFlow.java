import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// Martinez Castellanos Francisco Emmanuel 8vo semestre 16161365
public class FormularioFlow extends JFrame{
	
	FormularioFlow(){
		//Creacion del jframe	
		JFrame frame= new JFrame();
		frame.setSize(460,180);
		frame.setResizable(false);
		//frame.setResizable(false);
		frame.setTitle("Formulario");
		frame.setVisible(true);	
		
	//Esto pasa si se agrega al frame directamente.
	//		JButton boton= new JButton();
	//		boton.setSize(10,10);
	//		frame.add(boton);
		
	//Creacion del panel	
	JPanel panel1= new JPanel();
	//panel1.setBackground(Color.YELLOW);


	panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

	//panel1.setLayout(new FlowLayout(0,0,70));
	////////////////////////////////    x,y


	//Se añade al frame el panel
	frame.add(panel1);

	
	JLabel eti1= new JLabel("Nombre:                ");
    eti1.setSize(100,100);
    //eti1.setForeground(Color.RED);
	panel1.add(eti1);
	
	
	JTextField txt1= new JTextField(30);
	txt1.setSize(100,100);
	//txt1.setBounds(0,0,50,60);
	panel1.add(txt1);
	
	JLabel eti2= new JLabel("Apellido Paterno:");
    eti1.setSize(100,100);
	panel1.add(eti2);
	
	JTextField txt2= new JTextField(30);
	txt2.setSize(100,100);
	panel1.add(txt2);
	
	JLabel eti3= new JLabel("Apellido Materno:");
    eti1.setSize(100,100);
	panel1.add(eti3);
	
	JTextField txt3= new JTextField(30);
	txt3.setSize(100,100);
	panel1.add(txt3);

	JLabel eti4= new JLabel("Dirección:              ");
    eti4.setSize(100,100);
	panel1.add(eti4);
	
	JTextField txt4= new JTextField(30);
	txt4.setSize(100,100);
	panel1.add(txt4);

	JLabel eti5= new JLabel("Estado: ");
	eti5.setSize(100,100);
	panel1.add(eti5);

	JComboBox com5= new JComboBox();
	com5.addItem("Elige estado");
	com5.addItem("Soltero");
	com5.addItem("Casado");
	com5.addItem("Viudo");
    com5.setSize(100,100);
	panel1.add(com5);
	
	JLabel eti6= new JLabel("Sexo: ");
    eti6.setSize(100,100);
	panel1.add(eti6);
	
	JLabel m= new JLabel("Mujer");
    m.setSize(100,100);
	panel1.add(m);
	
	JCheckBox txt6= new JCheckBox();
	txt6.setSize(100,100);
	panel1.add(txt6);
	
	JLabel eti7= new JLabel("Hombre");
    eti7.setSize(100,100);
	panel1.add(eti7);
	
	JCheckBox txt7= new JCheckBox();
	txt7.setSize(100,100);
	panel1.add(txt7);
	
	
	
	
//	
//	JLabel sugerencia= new JLabel("Escriba su sugerencia:    ");
//	sugerencia.setSize(100,100);
//	panel1.add(sugerencia);
	
	JTextArea txtare= new JTextArea();
	txtare.setSize(100,100);
	txtare.setVisible(true);
    panel1.add(txtare);
	

	JButton bot= new JButton("ACEPTAR");
    bot.setSize(100,100);
	panel1.add(bot);
	
    
	}
	


	
	public static void main(String[]args){
		
		new FormularioFlow();

	}

}
