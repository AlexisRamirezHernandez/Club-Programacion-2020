/*
 * Proyecto final Club De Programacion 
 * clase PADRE: persona 
 * derivadas: empleado y alumno
 * 
 * @author  uzai velasco hernandez
 *          numero de control 19161433 
 *          semetre: 2
 */
package proyectoFinalClub;

public class Empleado extends Persona{
    private String area, sueldo;
    
    public Empleado(String nombre,String apellido,String curp, int edad, String sueldo, String area){
        
        super(nombre,apellido,curp,edad,-1,"No Disponible","No disponible",sueldo,area);
    }
    
    
    public String mostrarDatos(){
        
        String str="Area: "+
        getArea()+"\nSueldo: "+getSueldo();
        return str; 
    }
}
