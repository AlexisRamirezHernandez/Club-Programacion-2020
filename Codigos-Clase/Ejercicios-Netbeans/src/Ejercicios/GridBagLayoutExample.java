/** *******************************************************************************
 *GridBagLayout coloca los componentes en una cuadrícula de filas y columnas,
 *lo que permite que los componentes especificados abarquen varias filas o columnas.
 *No todas las filas necesariamente tienen la misma altura. Del mismo modo, no todas
 *las columnas tienen necesariamente el mismo ancho. Esencialmente, GridBagLayoutcoloca
 *los componentes en rectángulos (celdas) en una cuadrícula y luego usa los tamaños
 *preferidos de los componentes para determinar qué tan grandes deberían ser las celdas.
 *El detalle para esta distribucion es necesario que se declare un o9bjeto de
 *GridBagConstraints el cual tiene la funcion de que este hara posible que coloquemos
 *los componentes en la cuadricula. En esta distribucion no es necesaria declarar el tamañp
 *de la cuadricula como en gridlayout, aca conforme necesitemos vamos metiendo
 *la numeracion empieza en la coordenada (0,0), lo basico que tenemos que declarar
 *al momento de colocar nuestro componente es la siguiente
 * gbc.gridx=coordenada x
 * gbc.gridy=coordenada y
 * panel o frame.add(componente(boton,etiqueta,etc),gbc);
 * esao es lo basico que necesitamos para colocar nuestros componentes
 * conforme necesitemos algo en espefico necesitamos los metodos
 * para mas informacion consultar
 *
 * @http://dar10comyr.blogspot.com/2014/11/gestores-de-diseno-gridlayout.html
 * aca vienen los metodos basicos que se ocupan para dar formato 
 ********************************************************************************
 */
package Ejercicios;

/******************************************************************************
 * Algunos metodos
 *gbc.fill=Este campo se usa cuando el área de visualización del componente es mayor que el tamaño requerido del componente.
 *  gbc.fill=necesita una variable entera, GridBagConstraints ofrece variables estaticas como
 *  GridBagConstraints.WEAST,EAST,NORTH,SOUTH,CENTER,HORIZONTAL,VERTICAL
 *  GridBagContraints.BOTH Hacer que el componente llene su área de visualización por completo.
 * gbc.weightx=Especifica cómo distribuir el espacio horizontal extra. reciben doubles como parametros
 * gbc.weigthy=Especifica cómo distribuir el espacio Vertical extra.
 * gbc.gridwidth=sirve para indicar cuantas celdas ocupare si mi componente ocupa mas celdas hacia lo ancho
 * gbc.gridheight= indica cuantas celdas ocupo si exitiendo mi componente hacia a lo alto
 * estos dos ultimos metoddos tienen el valor por default de 1
 * si llamamos estos metodos si ya no necesitamos mas sus datos tenemos que volverlos a dejar 
 * en su valor original, ya que puede que los otros componentes no se ajusten como se desea
 ******************************************************************************************/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**En esta aplicacion lo importante es como se acomodan los compoentes, adicionalmente 
 * viene como ingresar una imagen y ponerla en un label la cual hace una escala para que 
 * se ajuste al tamaño del label, eso no se va a evaluar por ahora.
 */

public class GridBagLayoutExample extends JFrame implements ActionListener {

    GridBagConstraints gbc;
    GridBagLayout gbl;
    private JLabel eTitulo;
    private JLabel eNombre;
    private JLabel eApellidos;
    private JLabel eDireccion;
    private JPanel imagen;
    private JButton guardar;
    private JTextField dNombre;
    private JTextField dApellido;
    private JTextField dDireccion;
    private JLabel eImagen;
    private JButton abrir;
    private FileInputStream fis; //Aca se almacena el flujo del archivo
    int longitud_bytes;//longitud se bytes del archivo leido

    public GridBagLayoutExample() {
        init();

    }

    private void init() {
        gbl = new GridBagLayout();//instanciamos el objeto para asignar la distribucion
        gbc = new GridBagConstraints();//instanciamos para poder poner nuestros componentes
        this.setLayout(gbl);//establecemos la distribucion
        this.setSize(new Dimension(500, 400));//establecemos el tamaño del frame
        this.setLocationRelativeTo(null);//que se ponga a media pantalla
        gbc.insets = new Insets(10, 10, 10, 10);//esto hace que los componentes no esten tan pegadas
        //sirve para especificar cuantos pixeles arriba abajo izquierda y derecha va a estar

        eTitulo = new JLabel("FORMULARIO PARA DAR DE ALTA A PERSONAS");
        gbc.gridx = 0;//se pone en la fila 0
        gbc.gridy = 0;//columna 0
        gbc.gridwidth = 4;//que abarque 4 celdas
        gbc.weightx = 1.0;//
        gbc.fill = GridBagConstraints.CENTER;//y que el label se ponga al centro
        this.add(eTitulo, gbc);

        eNombre = new JLabel("Nombre");
        gbc.gridx = 0;//fila 0
        gbc.gridy = 1;//columna 1
        gbc.gridwidth = 1;//ajustamos la etiqueta a su valor orginal para que no se descuadre
        gbc.weightx = 0.0;
        this.add(eNombre, gbc);

        dNombre = new JTextField(5);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;//hace que la cajita de texto se alargue 
          gbc.gridwidth=1;//que ocupe una celda mas a lo ancho
        this.add(dNombre, gbc);

        eApellidos = new JLabel("Apellidos");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        this.add(eApellidos, gbc);

        ///esto es lo basico que se hace para posicionar el componente 
        //y hasta aca se les va a pedir
        dApellido = new JTextField(5);
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(dApellido, gbc);

        eDireccion = new JLabel("Direccion");
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(eDireccion, gbc);

        dDireccion = new JTextField(5);
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(dDireccion, gbc);

        guardar = new JButton("Guardar");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.WEST;
        this.add(guardar, gbc);

        abrir = new JButton("Inserta Imagen");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.CENTER;
        this.add(abrir, gbc);
        
        //esto es opcional para la imagen, para ponerla se necesita un label o un button 
        eImagen = new JLabel();
        gbc.gridx = 1;//4
        gbc.gridy = 4;//2
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridwidth = 1;//va a abarcar una celda mas a lancho
        gbc.gridheight = 1;//una celda mas a lo alto
        gbc.fill = GridBagConstraints.BOTH;//hazlo proporicional
        this.add(eImagen, gbc);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        abrir.addActionListener(this);
    }

    public static void main(String[] args) {
        //esto hace que al abrir el JFileChooser nos aparezca con la apariencia de windows
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GridBagLayoutExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GridBagLayoutExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GridBagLayoutExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GridBagLayoutExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        new GridBagLayoutExample();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //aca hara los ajustes a la imagen que se obtenga
        JButton evento = (JButton) e.getSource();
        if (evento == abrir) {
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
        }
    }

}
