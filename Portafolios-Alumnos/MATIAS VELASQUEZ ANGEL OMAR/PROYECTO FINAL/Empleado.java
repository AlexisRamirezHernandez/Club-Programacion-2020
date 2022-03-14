/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClubProgramacion;

/**
 *
 * @author angel
 */
public class Empleado  extends Persona{

    public Empleado(String nombre, String nacionalidad, int edad, int salario) {
        super(nombre, nacionalidad, edad, salario);/*super-> crea al objeto apartir de la super clase
        en este caos Jugador*/
    }
    public String toString(){/*Este metodo nos regresa informacion del objeto, pero al sobre escribirlo 
        nosotros escojemos como queremos esa informacion.*/
        return "Nombre: "+getNombre()+".\nNacionalidad: "+getNacionalidad()+".\nEdad: "+getEdad()+".\nSalario: "+getSalario()+".00 MXN";
    }
    
}


