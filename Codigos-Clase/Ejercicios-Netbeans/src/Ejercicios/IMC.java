/*
 * La clase IMC (Indice de Masa Corporal)
 * consiste en una pequeña aplicacion que usa 
 * distribucion FlowLayout para acomodar los componentes
 * que estan dentro de ella.
 * Clases que se usaron:
 *      JFrame
 *      JLabel
 *      JButton 
 *      JSpinner
 *
 */
/** *COSAS NUEVAS
 * Hacemos uso de un tema que se ve en POO que son interfaces:
 * Una interfaz es una clase
 */
// package Ejercicios;

import java.awt.FlowLayout;//Importamos la libreria de java para usar la distribucion
import java.awt.event.ActionEvent;//Nueva libreria para manejo de eventos de Accion
import java.awt.event.ActionListener; //Nueva libreria a usar, para escuchador de eventos
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;//importamos todos los componentes de javax.swing

public class IMC extends JFrame implements ActionListener //activamos la interfaz con implements actionListener y tenemos que reescribir los metodos
//que vamos a usar de esa interface, los metodos se sobreescriben con @Override 
{
    //creamos la clase y le indicamos que hereda de la clase JFrame

    //Declaramos las variables a usar, las variables de tipo JLabel(etiqueta)
    //inician con una e minuscula, pero pueden ponerle 
    private JLabel encabezado;
    private JLabel eEdad;
    private JLabel eCalculo;
    private JLabel eEstatura;
    private JLabel ePeso;
    private JLabel eMensaje;
    private JLabel eMensaje2;
    private JLabel eCinCad;
    private JLabel eCintura;
    private JLabel eCadera;
    private JLabel eSexo;
    private JLabel foto;
    /**
     * @CajasdeTexto
     */
    private JTextField imagen;
    private JTextField dEdad;
    private JTextField dPeso;
    private JTextField dCadera;
    private JTextField dCintura;
    /**
     * @RadioButton
     */
    private JRadioButton sMas, sFem;
    /**
     * @Botones
     *
     */
    private JButton calcularIMC;
    private JButton calcularICC;
    private JButton borrar;

    //Spinner para la edad
    private JSpinner dEstatura;

    //Administrador del grupo de botones
    private ButtonGroup grupoBotones;

    public IMC() {//Constructor
        init();///iniciamos el metodo init en el constructor
    }

    private void init() {

        /**
         * Como heredamos de la clase JFrame, podemos usar sus metodos en esta
         * clase entonces lo indicamos con tl this, si no lo ponemos no hay
         * mucho problema
         */
        this.setTitle("IMC-ICC");//establecer el titulo de la ventana
        this.setSize(330, 500);//establece sus dimensiones
        this.setLayout(new FlowLayout());//establecemos un una distribucion FlowLayout
        this.setLayout(new FlowLayout());//vamos a guardar los elementos en un this
        this.setSize(330, 500);
        //y ese this tendra tambien distribucion FlowLayout
        // Inicializamos los componentes 

        encabezado = new JLabel("INDICADORES BASICOS DE RIESGOS A LA SALUD ");
        foto = new JLabel();//inicializamos una etiqueta vacia, aca ira la imagen
        foto.setIcon(new ImageIcon("bascula.png"));//establecemos la imagen, meidante su nombre y la extension
        eEdad = new JLabel("Proporciona tu Edad (>=19)");
        dEdad = new JTextField(3);//inicializamos la caja de texto que pide la  tamaño de 3
        eCalculo = new JLabel("CALCULO DEL INDICE DE MASA CORPORAL IMC");
        eEstatura = new JLabel("Estatura (cm)");
        //Instanciamos el JSpinner para la edad: 
        //JSpinner maneja varios formatos para la presentacion de datos, uno de ellos es el numerico
        //entonces como parametro del constructor de JSPinner instanciamos un objeto de 
        //SpinnerNumerModel, el cual pide como parametros:
        //Valor donde inicia cuando se inicie la interfaz
        //Valor minimo, valor maximo, y de cuanto en cuanto va a ir incrementando
        dEstatura = new JSpinner(new SpinnerNumberModel(40, 40, 200, 1));
        ePeso = new JLabel("Peso (Kg)");
        dPeso = new JTextField(3);//caja de texto para el peso
        calcularIMC = new JButton("Calcular IMC");
        eMensaje = new JLabel();//esta etiqueta la vamos a usar la siguiente clase, con un evento
        eCinCad = new JLabel("CALCULO DEL INDICE DE CINTURA DE CADERA (ICC)");
        eCintura = new JLabel("Cintura(Cm)");
        dCintura = new JTextField(3);//dato de la cintura
        eCadera = new JLabel("Cadera (cms)");
        dCadera = new JTextField(3);//dato de la cadera
        eSexo = new JLabel("Sexo");

        grupoBotones = new ButtonGroup();
        /**
         * Crea un grupo de botones
         */
        sMas = new JRadioButton("Hombre");//iniciamos los botones para el sexo
        grupoBotones.add(sMas);//agregamos al admin de botones los radiobutton 
        sFem = new JRadioButton("Mujer");//radiobutton para el sexo femenino
        grupoBotones.add(sFem);//añadimos al admin de botones el radiobutton
        calcularICC = new JButton("Calcular ICC");
        eMensaje2 = new JLabel();//etiqueta que se usara con eventos despues
        borrar = new JButton("Borrar Datos");//iniciamos el boton

        //Como estamos usando distribucion flowlayout ingresamos todo  en el orden
        //de como queremos que se vaya viendo, siendo:
        //el encabezado principal
        //la imagen 
        //etiqueta que pide la edad
        //caja de texto para capturar la edad etc.. 
        //La clase JPanel al igual que JFrame hace uso del metodo add
        //entonces la idea es agregar los componentes primero al this 
        //despues el this al frame
        this.add(encabezado);
        this.add(foto);
        this.add(eEdad);
        this.add(dEdad);

        this.add(eCalculo);
        this.add(eEstatura);
        this.add(dEstatura);
        this.add(ePeso);
        this.add(dPeso);
        this.add(calcularIMC);
        this.add(eMensaje);
        this.add(eCinCad);

        this.add(eSexo);
        this.add(sMas);
        this.add(sFem);
        this.add(eCintura);
        this.add(dCintura);
        this.add(eCadera);
        this.add(dCadera);

        this.add(calcularICC);
        this.add(eMensaje2);
        this.add(borrar);
        //Aca agregamos el this al frame
        this.setVisible(true);// hacer visible al frame 
        //setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//hace que se cierre completamente el programa

        ///Aca indicaremos que aplicaremos eventos a los componentes con el metodo
        //AddActionListener
        calcularIMC.addActionListener(this);//el this hace referencia a que en esta clase estan los metodos de la interface
        calcularICC.addActionListener(this);
        borrar.addActionListener(this);
        this.setLocationRelativeTo(null);// esto hace que la ventana se centre en nuestra pantalla 
    }

    public static void main(String[] args) {
        //Prueba de la clase
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IMC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(IMC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(IMC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(IMC.class.getName()).log(Level.SEVERE, null, ex);
        }
        new IMC();
    }

    //Meotodo que tiene Sobreescriito la interface, para eventos
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton productor = (JButton) e.getSource();//como vamos a tener dos botones, este boton auxiliar va a permitir que se sepa cual se va a presionar

        if (calcularIMC == productor) {//Si el boton que guarda el evento es igual al boton de calcularIMC realiza lo siguiente

            /**
             * *para obtener lo que contiene una caja de texto, una etiqueta o
             * algun componente que tenga texto ocupamos el metodo
             *
             * @getText() esto metodo obtiene lo que tiene la caja de texto o el
             * componente en ese momento
             *
             */
            int edad = Integer.parseInt(dEdad.getText());//Convierte a numero entero lo que tiene la caja de texto, es necesario eso ya que lo que devuelve es un String y 
            //vamos a necesitar que el valor sea numerico para operarlo
            if (edad > 19) {//si la edad es mayor a 19 entonces
                double estaturamts = Double.parseDouble(dEstatura.getValue().toString()) / 100;//obtiene el dato del peso y lo convierte a double y lo divide entre 100, 
                /*NOTA: JSPINNER PARA OBTNER UN DATO ES CON EL METODO GETVALUE() PERO ESTE REGRESA UN OBJETO DE TIPO OBJECT, ENTONCES SE LE APLICA EL METODO @TOSTRING
                Y YA SE HACE LA CONVERSION DE CADENA A NUMERO DOUBLE 
                */
                //interpreta la edad como 1.66 o asi
                double peso = Double.parseDouble(dPeso.getText());//Lo mismo para el peso
                double imc = peso / (estaturamts * estaturamts); //la formula para el IMC es (peso)/(estaturaen metrosal cuadrado.

                //NOTA: PARA IMPRIMIR UN VALOR EN UNA ETIQUETA, CAJA DE TEXTO, O ALGUN OTRO COMPONENTE QUE LO PERMITA USAMOS EL METODO 
                /**
                 * @setText(ponemos un String ), solo acepta valores se String,
                 * aqui hay unas formas de como poderlo hacer
                 */
                if (imc < 18.5) {// si el resultado de esa operacion es menor a 18.5 imprime
                    //el mas practico es el String.format ya que los otros metodos en algun momento pueden mostrar numeros muy grande en decimales y con el format puedes delimitar el numero que aparezcan
                    eMensaje.setText(String.format("%5.2f ", imc) + " Peso bajo");//Con el String.format el resultado solo tendra 2 decimales por eso .2
                } else if (imc >= 18.5 && imc < 25.0) {
                    eMensaje.setText(String.valueOf(imc) + " Peso Correcto");//Con el metodo estatico de la clase String ValueOf() transforma lo que le metas a un String
                } else if (imc >= 25.0 && imc < 30.0) {
                    eMensaje.setText(String.format("%5.2f ", imc) + " SobrePeso");
                } else if (imc >= 30) {
                    eMensaje.setText(String.format("%5.2f ", imc) + " Obesidad grado 1");
                }

            } else {
                JOptionPane.showMessageDialog(null, "DEBES TENER MAS DE 19 AÑOS");//Ventana que se activa si tiene menos de 19 años  
            }
        } else if (calcularICC == productor) { //Si se presiona el boton calcular ICC 

            double cadera = Double.parseDouble(dCadera.getText());// obten el valor de la cadera
            double cintura = Double.parseDouble(dCintura.getText());// obten el valor de la cintura
            double icc = cintura / cadera;//realiza la formula

            /**
             * Aca vamos a saber que radio button esta seleccionado, con el
             * metodo
             *
             * @isSelected(), esto nos devolvera @True o @false dependiendo
             *
             */
            if (sMas.isSelected() == true) {//si el boton del sexo masculino es seleccionado entonces
                //se implemento asi ya que para los varones sus valores que obtengan son algo diferentes al de las mujeres
                //Aca hacemos uso de las etiquetas que teniamos pendientes de darles un valor, con el metodo 
                /**
                 * @setText()* y hacmos uso nuevamente del String.format()
                 */
                if (icc >= 0.95 && icc < 1) {
                    eMensaje2.setText(String.format("%5.2f ", icc) + "Riesgo Cardiovascular MEDIO");
                } else if (icc < 0.95) {
                    eMensaje2.setText(String.format("%5.2f ", icc) + " Riesgo CardioVascular BAJO");
                } else if (icc >= 1) {
                    eMensaje2.setText(String.format("%5.2f ", icc) + "Riesgo ALTO! CardioVascular");
                }

            } else if (sFem.isSelected() == true) {// si el boton esta seleccionado en modo mujeres
                //realiza lo mismo de arriba excepto con los datos
                if (icc < 0.80) {
                    eMensaje2.setText(String.format("%5.2f ", icc) + "Bajo Riesgo CardioVascular");
                } else if (icc >= 0.80 && icc < 0.85) {
                    eMensaje2.setText(String.format("%5.2f ", icc) + " Riesgo CardioVascular MEDIO");
                } else if (icc >= 0.85) {
                    eMensaje2.setText(String.format("%5.2f ", icc) + "Riesgo ALTO! CardioVascular");
                }

            }

        } else if (productor == borrar) {// si el boton pulsado es igual a borrar
            //pondra los componentes en blanco, esto se hace con el metodo setText() pero poniendole
            //como cadena un String vacio 
            dCadera.setText("");
            dCintura.setText("");
            eMensaje.setText("");
            dEdad.setText("");
            dEstatura.setValue(40);// aca como el componente es un JSpinner para valores numericos establecemos un valor entero que es el valor minimo usado anteriormente 
            dPeso.setText("");
            eMensaje2.setText("");
            sFem.setSelected(false);// desactivamos los botones para dejarlos birn
            sMas.setSelected(false);//
        }
    } //else JOptionPane.showM
}
