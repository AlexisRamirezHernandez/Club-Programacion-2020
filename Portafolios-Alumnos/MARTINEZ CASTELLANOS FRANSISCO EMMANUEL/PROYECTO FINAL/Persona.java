
package jugador;

public class Persona {
    private String Nombre;
    private String Apellido;
    private String Aka;
    private int Edad;
    
    public Persona (String Nombre,String Apellido, String Aka,int Edad){
    this.Nombre= Nombre;
    this.Apellido=Apellido;
    this.Aka=Aka;
    this.Edad=Edad;
    }
    
    public String getNombre(){
    return Nombre;
    }
    
    public String getApellido(){
    return Apellido;
    }
    
    public String getAka(){
    return Aka;
    }
    
    public int getEdad(){
    return Edad;
    }
    
    public String toString(){
        return "Nombre:"+getNombre()+".\nApellido:"+getApellido()+".\nAka:"+getAka()+".\nEdad"+getEdad(); 
    }
}
