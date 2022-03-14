
package Ejercicios;
/*******************JLIST******************************************************
 * Este componente nos permite presentar una lista de selección donde podemos 
 * escoger uno o varios elementos.
 * Agregar Elementos...
 * Se puede a agregar elementos a un JList, la primera mediante un arreglo y 
 * la segunda usando la clase DefaultListModel...
 * Forma 1.
 * Para agregar elementos usando un arreglo es muy simple, tan solo tenemos que 
 * declarar nuestro arreglo y agregarselo al constructor del objeto JList con el 
 * que estemos trabajando..... esta forma es muy usada cuando traemos datos 
 * directamente de una BD y tenemos que mostrarla en pantalla....
 * JList listaNombres;
 * String nombres[] = { "Cristian", "Julian", "Milena"};
 * listaNombres = new JList( nombres );
 * Forma 2.
 * La segunda forma también es muy simple, tenemos que declarar un objeto de tipo 
 * DefaultListModel y por medio del método addElement(elemento), 
 * vamos agregando elementos a nuestro modelo, posteriormente dicho modelo 
 * se agrega al JList con el que trabajemos...... esta forma es muy usada cuando 
 * tenemos que agregar y mostrar directamente los datos ingresados en pantalla.
 * JList listaNombres=new JList();
 * DefaultListModel modelo = new DefaultListModel();
 * modelo.addElement("Elemento1"); 
 * modelo.addElement("Elemento2");
 * modelo.addElement("Elemento3");
 * listaNombres.setModel(modelo);
 ********************************************************************************/
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
public class JList_Example extends JFrame implements ActionListener {

    private JButton agregar, eliminar, borrar;/*declaramos el objeto Boton*/
    private JLabel labelTitulo, mensaje;/*declaramos el objeto Label*/
    private JTextField campo;
    private JList listaNombres;/*declaramos La Lista*/
    private DefaultListModel modelo;/*declaramos el Modelo*/
    private JScrollPane scrollLista;//permite que se dezplace de arriba a abajo como un navegador

    public JList_Example() {
        /*permite iniciar las propiedades de los componentes*/
        iniciarComponentes();
        /*Asigna un titulo a la barra de titulo*/
 /*tamaño de la ventana*/
        this.setVisible(true);
        setSize(280, 330);
        /*pone la ventana en el Centro de la pantalla*/
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        /*con esto definmos nosotros mismos los tamaños y posicion
		 * de los componentes*/
        
        setLayout(null);

        campo = new JTextField();
        campo.setBounds(20, 80, 135, 23);
        /*Propiedades del boton, lo instanciamos, posicionamos* activamos los eventos*/
        agregar = new JButton();
        agregar.setText("Agregar");
        agregar.setBounds(160, 80, 80, 23);
        agregar.addActionListener(this);

        eliminar = new JButton();
        eliminar.setText("Eliminar");
        eliminar.setBounds(20, 210, 80, 23);
        eliminar.addActionListener(this);

        borrar = new JButton();
        borrar.setText("Borrar Lista");
        borrar.setBounds(120, 210, 120, 23);
        borrar.addActionListener(this);

        /*Propiedades del Label, lo instanciamos, posicionamos y
		 * activamos los eventos*/
        labelTitulo = new JLabel();
        labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 28));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("JList");
        //Pone el borde  a una etiqueta
        labelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        labelTitulo.setBounds(40, 20, 180, 43);

        mensaje = new JLabel();
        mensaje.setBounds(20, 250, 280, 23);

        //instanciamos la lista
        listaNombres = new JList();
        listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //instanciamos el modelo
        modelo = new DefaultListModel();

        //instanciamos el Scroll que tendra la lista
        scrollLista = new JScrollPane();
        scrollLista.setBounds(20, 120, 220, 80);
        scrollLista.setViewportView(listaNombres);

        /*Agregamos los componentes al Contenedor*/
        this.add(labelTitulo);
        this.add(campo);
        this.add(agregar);
        this.add(eliminar);
        this.add(borrar);
        this.add(mensaje);
        this.add(scrollLista);
        //this.add(botonCam);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == agregar) {
            agregarNombre();
            mensaje.setText("Se agregó un nuevo elemento");
        }
        if (evento.getSource() == eliminar) {
            eliminarNombre(listaNombres.getSelectedIndex());
        }
        if (evento.getSource() == borrar) {
            borrarLista();
            mensaje.setText("Se borró toda la lista");
        }
    }

    private void agregarNombre() {
        String nombre = campo.getText();
        modelo.addElement(nombre);
        listaNombres.setModel(modelo);
        campo.setText("");
    }

    private void eliminarNombre(int indice) {
        if (indice >= 0) {
            modelo.removeElementAt(indice);
            mensaje.setText("Se eliminó un elemento en la posición " + indice);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un indice",
                    "Error", JOptionPane.ERROR_MESSAGE);

            mensaje.setText("NO se seleccionó ningún elemento");
        }

    }

    private void borrarLista() {
        modelo.clear();// borra todo lo que tiene la lista
    }

    public static void main(String[] args) {
        new JList_Example();

    }
}
