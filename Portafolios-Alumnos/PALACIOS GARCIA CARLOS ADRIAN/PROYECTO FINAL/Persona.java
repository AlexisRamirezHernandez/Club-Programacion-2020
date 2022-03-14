/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendaventana;


public class Persona {

    private int Sueldo,ID;
    private String Nombre,Direccion;
    
    public Persona(int Sueldo, int Id, String Name, String domicilio){
    this.Sueldo=Sueldo;
    ID=Id;
    Nombre=Name;
    Direccion=domicilio;
    }
    
    public int getSueldo(){
    return Sueldo;
    }
    
    public int getId(){
    return ID;
    }
    
    public String getName(){
    return Nombre;
    }
    
    public String getDireccion(){
    return Direccion;}
    
    public String toString(){
    return "Id:"+getId()+".\nNombre:"+getName()+".\nDireccion:"+getDireccion()+".\nSueldo: $"+getSueldo()+".00"; 
    }
}