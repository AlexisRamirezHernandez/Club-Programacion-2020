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

/**
 *
 * @author Admin
 */
public class Estudiante extends Persona{
    private String numeroControl, carrera, semestre;
    
    public Estudiante(String nombre,String apellido, String curp,int edad,int numeroControl,
            String semestre,String carrera){
        super(nombre,apellido,curp,edad,numeroControl,semestre,carrera,"No disponible","No disponible");
    }
    
    public String mostrarDatos(){
        String str="Numero de control: "+
        numeroControl+"\nDe la carrera: "+carrera+"\nSemestre: "+semestre;
        return str;
    }
}
