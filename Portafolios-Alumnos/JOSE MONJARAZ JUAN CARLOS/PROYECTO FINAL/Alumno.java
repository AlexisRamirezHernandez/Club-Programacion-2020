
public class Alumno extends Persona{
    
    public Alumno(String nombre, String Apellido_P, String Apellido_M, String telefono) {
        super(nombre, Apellido_P, Apellido_M, telefono);
    }
    
    public String toString(){
        return "Nombre:"+getNombre()+".\nApellido Paterno:"+getApellido_P()+".\nApellido Materno:"+getApellido_P()+".\nTeléfono:"+getTelefono(); 
    }
}