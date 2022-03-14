/** ***************DISTRINUCION NULA, o POSICION ABSOLUTA**************************************
 * Consiste en dejar en null el metodo setLayout de un frame o un panel
 * al hacer esto ningun componenete se podra poner en el contenedor en el cual
 * estemos trabajando, para poner los componentes, requerimos del metodo
 * setBouns(), el cual requiere como parametros, valores enteros y debemos ver
 * a la pantalla como un plano cartesiano con coordenadas x y Y solo que no existen
 * coordenadas negativas, los parametros que pide el metodo setBouns son:
 * posicion en X: viene siendo como en que columna lo pondras, 1 Columna=1 unidad
 * posicion en Y: es la fila donde pondre el componente 1 fila= 1Unidad
 * largo del componente
 * ancho del componente
 * las cooordenadas son en base al frame o panel donde estan estableciendo
 * si tienen una ventana de tamaño 600x600 su limite dentro del area visible sera
 * hasta la coordenada 600,600 y asi sucesivamente.
 * Esta distribucion es algo lenta debido a que hay que calcularle en que parte
 * vamos a poner cada componente, y que no queden encimados,
 * es util para poner cosas que sabemos que no se van a mover, inlcuso para los que
 * no dominan los layouts encuentran facil usar esta ya que donde digamos que va el
 * componente ya no se va a mover, ni haciendo grande la ventana,
 * si quiren que no se haga grande la ventana solo al tamaño deseado usar el metodo
 * setResizable(false);
 *************************************************************************** */
package Ejercicios;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * **************************************************************************
 * Este es el mismo formulario que el del ejemplo de GridBagLayout, solo cambia
 * la imagen de lugar y los botones, las coordenadas 0,0 empiezan en la esquina
 * superior izquierda del frame o panel donde trabajen,para que no se cofundan,
 * esto son bases para entender el comportamiento de los graficos en java ya que
 * bajo este estilo funcionan. Si les causa Curiosidad chequen la clase Graphics
 * y Graphics2D
 * **************************************************************************
 */
public class SetBoundsExample extends JFrame {

    private JLabel eNombre;
    private JLabel eApellidos;
    private JLabel eDireccion;
    private JLabel eImagen;
    private JLabel eEncabezado;
    private JTextField dNombre;
    private JTextField dApellido;
    private JTextField dDireccion;
    private JButton inserta;
    private JButton guardar;
    private JPanel pImagen;
    private Spinner s;
    private FileInputStream fis; //Aca se almacena el flujo del archivo
    int longitud_bytes;//longitud se bytes del archivo leido

    public SetBoundsExample() {
        init();
    }

    private void init() {
        this.setLayout(null);//aca le indicamos que es nula la distribucion
        this.setSize(new Dimension(600, 400));//tamaño de la ventana
        //Instanciamos nuestros Objetos 

        eEncabezado = new JLabel("Formulario para dar de alta una persona");
        eNombre = new JLabel("Nombre");
        dNombre = new JTextField();
        eApellidos = new JLabel("Apellidos");
        dApellido = new JTextField();
        eDireccion = new JLabel("Direccion");
        dDireccion = new JTextField();
        inserta = new JButton("Insertar Imagen");
        guardar = new JButton("Guardar");
        s=new Spinner(1,30, 0,3);
                

        //Aca le indicamos la posicion de donde vamos a poner cada componente
        eEncabezado.setBounds(100, 0, 300, 20);
        s.setBounds(200,300,100,30);
        //La etiqueta encabezado se pondra en la posicion 100,0 y tendra un largo de 300 y un ancho de 20
        eNombre.setBounds(20, 40, 100, 20);
        dNombre.setBounds(120, 40, 200, 25);
        eApellidos.setBounds(20, 70, 100, 20);
        dApellido.setBounds(120, 70, 200, 25);
        eDireccion.setBounds(20, 100, 100, 20);
        dDireccion.setBounds(120, 100, 200, 25);
        inserta.setBounds(170, 150, 150, 30);
        guardar.setBounds(220, 190, 100, 30);
        // una buena practica para no sobrecargar de informacion es hacer el programa modular
        //de acuerdo a los paneles principales que trabajemos, entonces
        //Para trabajar el panel donde ira la foto hice un metodo get que nos regresa 
        //el panel donde ira la foto, el cual tiene a su vez varias instrucciones 
        //a realizar
        //para llamarlo lo igualamos a la variable PImagen ya que son del mismo tipo JPanel
        pImagen = getpanel_foto();
        pImagen.setBounds(350, 40, 200, 200);

        //aca solo agregamos al frame lo que vamos a usar
        //el orden para agregarlos no es muy importante ya que cada uno tiene ya su posicion especificada
        this.add(eEncabezado);
        this.add(pImagen);//aca agregamos el panel
        this.add(eNombre);
        this.add(dNombre);
        this.add(eApellidos);
        this.add(dApellido);
        this.add(eDireccion);
        this.add(dDireccion);
        this.add(inserta);
        this.add(guardar);
        this.add(s);

        //Otra forma de llamar a eventos es mediante el uso de clases internas
        //las cuales las señalamos con el modifcador de aacceso private,
        //es decir solo se puede acceder dentro de la misma clase y ya
        //Cabe señalar que esta clase privada debe implementar la interface ActionListener para 
        //que se reconozca para operar ese evento.
        Eventos_Botones evento = new Eventos_Botones();
        //le asignamos a nuestro metodo que en la clase Eventos_Botones estan los escuchadores para 
        //los evenetos
        inserta.addActionListener(evento);
        guardar.addActionListener(evento);

        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SetBoundsExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SetBoundsExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SetBoundsExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SetBoundsExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        new SetBoundsExample();

    }

    public JPanel getpanel_foto() {
        //panel foto
        pImagen = new JPanel();
        pImagen.setLayout(null);//indicamos disteubucion nula
        eImagen = new JLabel("Fotograia");
        eImagen.setHorizontalAlignment(SwingConstants.CENTER);//texto centrado
        eImagen.setBounds(4, 15, 197, 180);//dentro de este oanel empezamos en 0 nuevamente 
        // y todo lo que pase en panel se queda ahi
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Fotografia");///Borde para paneles que permite crear 
        //una linea a un panel para darle mas estetica
        pImagen.setBorder(bordejpanel);//establecemos el borde con los metodos set's
        pImagen.add(eImagen);//al panel agregale la etiqueta
        return pImagen;//regrsa el panel
    }

    //clase privada para el manejo de eventos tiene que implementar la interface ActionListener
    private class Eventos_Botones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //aca hara los ajustes a la imagen que se obtenga
            JButton evento = (JButton) e.getSource();
            if (evento == inserta) {//            JFileChooser jfc = new JFileChooser();//el objeto fileChooser abre una biblioteca de archivos
                JFileChooser jfc = new JFileChooser();//el objeto fileChooser abre una biblioteca de archivos
                jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);//hace que solo se selecione uno
                int estado = jfc.showOpenDialog(null);
                if (estado == JFileChooser.APPROVE_OPTION) {//si seleaccionamos un archivo se hace lo siguiente
                    try {
                        fis = new FileInputStream(jfc.getSelectedFile());//obten la ruta del archivo
                        longitud_bytes = (int) jfc.getSelectedFile().length();//obten el tamaño
                        Image icono = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(eImagen.getWidth(), eImagen.getHeight(), Image.SCALE_DEFAULT);
                        //realiza la escala de acuerdo al tamaño del label
                        eImagen.setIcon(new ImageIcon(icono));//establece al label la imagen con el metodo SetIcon()
                        eImagen.updateUI();//haz una actualizacion
                        longitud_bytes = longitud_bytes;

                    } catch (Exception ee) {
                    }

                }
                //para hacer una validacion que los campos no esten vacios y el programa no truene usamos el metodo isEmpty()
                //este metodo regresa un true si estan vacios o un false si tienen algo, son usados muy frecuentes 
            } else if (evento == guardar) {
                //si el campo del nombre esta vacio o el del apellido esta vacio o el de la direccion esta vacio manda un msj de error
                if (dNombre.getText().isEmpty() || dApellido.getText().isEmpty() || dDireccion.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Un campo esta vacio revise por favor",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                } else { // si no murstra un msj de registro exitoso
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");

                }
            }
        }
    }
}
