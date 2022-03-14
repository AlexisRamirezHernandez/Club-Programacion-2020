/**
 * Proyecto final Club De Programacion 
 * clase PADRE: persona 
 * derivadas: empleado y alumno
 * 
 * @author  uzai velasco hernandez
 *          numero de control 19161433 
 *          semetre: 2
 */
package proyectoFinalClub;
import javax.swing.JOptionPane;

public class Persona 
{
    private String nombre,apellido,curp,semestre,carrera,sueldo,area;
    private int edad,numeroControl; 
    
  

    public Persona(String nombre, String apellido, String curp, 
            int edad,int numeroControl, String semestre, String carrera, String sueldo, String area) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curp = curp;
        this.semestre = semestre;
        this.numeroControl = numeroControl;
        this.carrera = carrera;
        this.sueldo = sueldo;
        this.area = area;
        this.edad = edad;
    }
    
    public String nombre(){
        return nombre;
    }
    public String apellido(){
        return apellido;
    }
    public String curp(){
        return curp;
    }
    public int edad(){
        return edad;
    }
    public void setNumeroControl(int numeroControl){
        this.numeroControl=numeroControl;
    }
    public void setCarrera(String carrera){
        this.carrera=carrera;
    }
    public void setSemestre(String semestre){
        this.semestre=semestre;
    }
    public int getNumeroControl(){
        return numeroControl;
    }
    public String getSemestre(){
        return semestre;
    }
    public String getCarrera(){
        return carrera;
    }
    public void setArea(String area){
        this.area=area;
    }
    public void setSueldo(String sueldo){
        this.sueldo=sueldo;
    }
    public String getArea(){
        return area;
    }
    public String getSueldo(){
        return sueldo;
    }
    
    public String MostrarDatos(){
        String str="Sus datos son: \nnombre: "+nombre+
        "\napellido: "+apellido+"\ncurp: "+curp+"\nEdad: "+
        edad;
        return str;
    }
}



