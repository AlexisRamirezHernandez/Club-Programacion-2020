
package jugador;
public class Estudiante extends Persona1{

    public Estudiante(String nombre, String nacionalidad, int edad) {
        super(nombre, nacionalidad, edad, -1);/*super-> crea al objeto apartir de la super clase
        en este caos Jugador*/
    }
    public String toString(){/*Este metodo nos regresa informacion del objeto, pero al sobre escribirlo 
        nosotros escojemos como queremos esa informacion.*/
        return "Nombre: "+getNombre()+".\nNacionalidad: "+getNacionalidad()+".\nEdad: "+getEdad();
    }
    
}
