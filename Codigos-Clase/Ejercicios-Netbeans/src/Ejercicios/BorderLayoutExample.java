/***********************BORDERLAYOUT*******************************************
*Distribucion BorderLayout: 
*Organiza los componentes en uno de los 5 paneles que corresponde a una de las 
*coordenadas(Norte, Sur, Este, Oeste) y el centro.
*Básicamente luego de crear el objeto del gestor borde y configurarlo para un contenedor,
*Como un JPanel a la hora de agregar componentes, el método 
*add necesitará 2 parámetros:
*   add(Componente, Coordenada)
    -estas coordenadas tienen que ser Strings de clase de BorderLayout:
    NORTH, para el panel superior (Norte)
    WEST, para el panel izquierdo
    CENTER, para el panel central
    EAST, para el panel derecho
    SOUTH, para el panel inferior (Sur)
*Por ejemplo: miPanel.add(boton, BorderLayout.NORTH); 
*de esta manera agregamos el componente al contenedor 
*y en el lugar que el gestor lo dividio.
* Dentro de estas 5 secciones podemos meter cuando componente necesitemos
* obviamente dentro de un panel, es decir puedo meter en la posicion central
* un panel con alguna otra distribucion, por ejemplo la GridLayout
* La FlowLayout, etc, solo es cuestion de tener orden 
* una buena practica es crear metodos que devuelvan JPaneles 
* public JPanel panel(){
*   panel=new JPanel();
*   return panel;
* } 
 *****************************************************************************/
package Ejercicios;

/*****************************************************************************
* Esta clase tiene dos contructores para inicializar
* Constructor vacio BorderLayout():
*   Construye un gestor BorderLayout y sin espacios entre los componentes.
* Constructor BorderLayout(int hgap, int vgap)
*       Construye un diseño BorderLayout con los espacios entre los componentes 
*       especificados. 
*       La distancia horizontal se especifica mediante hgap y 
*       la distancia vertical se especifica por vgap.
******************************************************************************/
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class BorderLayoutExample extends JFrame {

    private JButton boton_NORTE;
    private JButton boton_SUR;
    private JButton boton_ESTE;
    private JButton boton_OESTE;
    private JLabel etiqueta_Central;

    public BorderLayoutExample(){
        init();
    }
    private void init() {
        this.setSize(new Dimension(540, 480));//tamaño de la ventana
        this.setTitle("BorderLayout");//Titulo de la ventana
        this.setLocationRelativeTo(null);//para que se ponga al centro de la pantalla
        this.setLayout(new BorderLayout(5, 5));//separacion de componentes
        //Inicializamos nuestros componentes
        boton_NORTE = new JButton("Boton Norte");
        boton_SUR = new JButton("Boton Sur");
        boton_ESTE = new JButton("Boton Este");
        boton_OESTE = new JButton("Boton Oeste");
        etiqueta_Central=new JLabel("Etiqueta Central");
        etiqueta_Central.setHorizontalAlignment(SwingConstants.CENTER);
        //ponmos el texto de la etiqueta en el centro
        //Los añadimos al frame con la posicion de donde los queremos
        this.add(boton_NORTE, BorderLayout.NORTH);
        this.add(boton_SUR, BorderLayout.SOUTH);
        this.add(boton_ESTE, BorderLayout.EAST);
        this.add(boton_OESTE, BorderLayout.WEST);
        this.add(etiqueta_Central,BorderLayout.CENTER);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        //Este Tramo de codigo ocupa un tema que se ve en POO que son las 
        //Excpeciones, la cual consiste en realizar una determinada actividad pero si
        //no se cumple todo ese proceso se disparan las excepciones por medio del catch
        //por ejemplo se ocupan en division sobre 0 o cuando manejamos archivos
        // o manejando Hilos (Thread's), entonces el catch atrapa ese error 
        //y y hace algo 
        //este codigo permite que tenga la apariencia que tiene con botones mas
        //redondos etc... se puede quitar solo instancien su clase XD 
           try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BorderLayoutExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BorderLayoutExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BorderLayoutExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(BorderLayoutExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        new BorderLayoutExample();
    }
}
