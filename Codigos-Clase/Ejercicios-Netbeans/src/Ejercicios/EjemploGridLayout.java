/********************GRIDLAYOUT***************************************************
 *Gestor de distribución de contenido que organiza los componentes de un
 *contenedor en una cuadrícula rectangular de tamaño nxm. El contenedor se divide en
 *rectángulos de igual tamaño y se coloca un componente en cada rectángulo.
 * puede aplicarse a un JFrame o JPanel en ambos casos el metodo es el mismo
 * setLayout(new GridLayout(filas,columnas));
 ************************************************************************* */

/**************CLASES ANONIMAS***************************************************
 * En pocas palabras, el uso de una clase anónima te permite crear un objeto que 
 * implementa una interfaz en particular y poder usarlo libremente sin la molestia 
 * de tener que definir explícitamente una clase.
 * Esta es una alternativa a la implementacion de la interface ActionListener en 
 * en nuestra clase y lo implementamos con el siguiente codigo
 * el asistente de netBeans te puede generar el codigo
 * compoenente.addActionListener(new ActionListener(){
 *  @Override el override indica que es un metodo sobreescrito
 *  public void actionPerformed(ActionEvent e) {
 *      aca va todo nuestro codigo que deseemos poner todo el codigo que deseemos
 *      una buena practica es poner unicamente el metodo que haga lo que le indiquemos
 *      para no sobrecargar esta parte, por ejemplo el metodo limpiar(); y ya
 *  }
 * });
 ******************************************************************************/
package Ejercicios;

/******************************************************************************
 * Este aplicacion consiste consiste en un Frame con 9 botones y al oprimirlos
 * desplega un JOPtionPane con el valor que tiene como msj
 * Para esta interfaz se usaron solo JButton's entonces para no declarar
 * tantas variables usamos un arreglo de JButton's
 * Y en conjunto con la distribuicion GridLayout los ponemos en esa forma
 * de cuadricula
 *
 ******************************************************************************/
/******************************Actividad********************************
 * En vez de usar un arreglo de JButtone's deben hacer 9 variables de JButton
 * y agregarlos al Jframe ademas usando las clases anonimas para los eventos y con 
 * esto hacer que cuando se presione un button aparezca en un JOptionPane el 
 * numero que se presiona.
 * tendran que hacer 9 veces uso de una clase anonima 
 * bt1.addActionListener(...);
 * todo es dentro del metodo init();
 * y ese se pondra en el constructor de la clase como se ha venido trabajando
 * si tienen una duda pregunten.
 * Pueden Ponerle colores a los botones como quieran o si gustan dejarlo asi
 *****************************************************************************/
import java.awt.Color;//importamos la clase Color
import java.awt.GridLayout;//Importamos la clase GrindLayout
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EjemploGridLayout extends JFrame {//Clase hereda de JFrame

    private GridLayout gl;//Declaramos un objeto de tipo GridLayout

    public EjemploGridLayout() {//constructor
        init();//iniciamos el metodo
    }

    private void init() {
        int filas = 3;
        int columnas = 3;
        //GridLayout nos pide como parametros filas y columnas que tendra
        gl = new GridLayout(filas, columnas);
        
        this.setLayout(gl);//establecemos la distribucion GridLayout al frame
        
        JButton arreglo_botones[] = new JButton[9];//Declaramos un arreglo de botones
        for (int i = 0; i < arreglo_botones.length; i++) {
            //creamos un for para recorrer nuestro arreglo de botones
            arreglo_botones[i] = new JButton(String.format("%2d", i + 1));
            //le decimos que coloque como texto el valor de i+1 para que muestre del 1 al 9
            this.add(arreglo_botones[i]);
            //agregamos el boton al frame
            arreglo_botones[i].setHorizontalAlignment(SwingConstants.CENTER);//pone el texto de los botones en el centro
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
            //hace que el texto se aline al centro, para otros lados vean la API de Java
            //Esto es opcional, para darle un color.
            //Si el modulo de i/2 es 0 pondra los botones Gris Claro si no BLANCOS
            if (i % 2 == 0) {
                arreglo_botones[i].setBackground(Color.LIGHT_GRAY);
                //eL METODO setBackground se usa para establecer color  a un componente
                //Pide como parametros un objeto de la clase Color, con el color que 
                //se desea, La clase color tiene variables estaticas que pone colores por defecto
                //Debemos importarla, import java.awt.Color;

            } else {
                arreglo_botones[i].setBackground(Color.WHITE);//´pone ne blanco los botones
            }
        }
        this.setTitle("GridLayout");
        this.setSize(500, 400);//establece el tamaño del frame
        this.setVisible(true);//lo hace visble
        this.setLocationRelativeTo(null);//memtodo que hace que aparezca centrado en la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cierra el programa

    }

    public static void main(String[] args) {
        new EjemploGridLayout();//prueba
    }

}
