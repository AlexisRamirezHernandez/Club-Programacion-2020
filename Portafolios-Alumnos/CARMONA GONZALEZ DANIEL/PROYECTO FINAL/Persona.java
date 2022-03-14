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
public class Persona {
    //Atributos
    private String Nombre;
    private int Edad;
    private String Carrera;

    public Persona(String Nombre, int Edad, String Carrera) {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Carrera = Carrera;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public String getCarrera() {
        return Carrera;
    }
}
