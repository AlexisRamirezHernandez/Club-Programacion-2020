
package jugador;

public class Artista extends Persona  {
    
    public Artista(String Nombre, String Apellido, String Aka, int Edad) {
        super(Nombre, Apellido, Aka, Edad);
    }
    
    
       public String toString(){
        return "Nombre:"+getNombre()+".\nApellido:"+getApellido()+".\nAka:"+getAka()+".\nEdad"+getEdad(); 
    }
}
