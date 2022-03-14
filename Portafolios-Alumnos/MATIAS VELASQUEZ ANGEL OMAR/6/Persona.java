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
public class Persona {
   private  int edad, salario;
   
        
   private  String nombre, nacionalidad;    
    public Persona(String nombre,String nacionalidad,int edad, int salario){
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
        this.edad=edad;
        this.salario=salario;
    }
      
    public int getEdad() {
        /* alcansedelMetod tipodeRetorno nombreDelMetod {
        return segun_sea_el_tipo;
    }      */
        return edad;
    }

    public int getSalario() {
        return salario;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }
     public String toString(){/*Este metodo nos regresa informacion del objeto, pero al sobre escribirlo 
        nosotros escojemos como queremos esa informacion.*/
        return "Nombre: "+getNombre()+".\nNacionalidad: "+getNacionalidad()+".\nEdad: "+getEdad()+".\nSalario : $"+getSalario()+".00 MXN"; 
    }
}

