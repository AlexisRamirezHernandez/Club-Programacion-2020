/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanaaspirantes;

/**
 *
 * @author daniel
 */
public class Aspirante extends Persona{
     private int numcontrol;
    private float notaFinal;
    
    public Aspirante(String Nombre,int Edad, String Carrera,int numcontrol, float notaFinal){
        super(Nombre,Edad,Carrera);
        this.numcontrol = numcontrol;
        this.notaFinal = notaFinal;
    }
    public void mostrarDatos(){
        System.out.println("Mostrando los datos del Estudiante");
        System.out.println("Nombre: "+getNombre());
        System.out.println("Edad: "+getEdad());
        System.out.println("Carrera: "+getCarrera());
        System.out.println("numero de control "+numcontrol);
        System.out.println("Nota: "+notaFinal);
    }
}
