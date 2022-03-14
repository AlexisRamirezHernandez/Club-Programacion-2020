/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendaventana;

public class Cliente extends Persona{
    
    public Cliente(int id, String Name, String Domic){
    super(-1, id,Name,Domic);
    }
    
    public String toString(){
    return "Id:"+getId()+".\nNombre:"+getName()+".\nDireccion:"+getDireccion();}
}
