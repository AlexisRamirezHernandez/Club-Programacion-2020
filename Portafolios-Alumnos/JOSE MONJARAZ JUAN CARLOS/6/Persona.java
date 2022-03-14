public class Persona {
    private  String nombre;
    private String Apellido_P;
    private String Apellido_M;
    private String telefono;

    public Persona(String nombre, String Apellido_P, String Apellido_M, String telefono) {
        this.nombre = nombre;
        this.Apellido_P = Apellido_P;
        this.Apellido_M = Apellido_M;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido_P() {
        return Apellido_P;
    }

    public String getApellido_M() {
        return Apellido_M;
    }

    public String getTelefono() {
        return telefono;
    }
     
    public String toString(){/*Este metodo nos regresa informacion del objeto, pero al sobre escribirlo 
        nosotros escojemos como queremos esa informacion.*/
        return "Nombre:"+getNombre()+".\nApellido Paterno:"+getApellido_P()+".\nApellido Materno:"+getApellido_P()+".\nTeléfono:"+getTelefono(); 
    }
}
