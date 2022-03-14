package jugador;

/**
 *
 * @author Adan Sanchez numero de control: 17161238 carrera: ing. sistemas
 */
public class Erencia_17161238 {

    private class Animal {

        private String nombre, tamanio, raza, sexo;
        private int patas, edad;

        public Animal(String nombre, String tamanio, String raza, String sexo, int patas, int edad) {
            this.nombre = nombre;
            this.tamanio = tamanio;
            this.raza = raza;
            this.sexo = sexo;
            this.patas = patas;
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String gettamanio() {
            return tamanio;
        }

        public void settamanio(String tamanio) {
            this.tamanio = tamanio;
        }

        public String getRaza() {
            return raza;
        }

        public void setRaza(String raza) {
            this.raza = raza;
        }

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public int getPatas() {
            return patas;
        }

        public void setPatas(int patas) {
            this.patas = patas;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

    }

    static class Perro extends Animal {

        private String otro;

        public Perro(String nombre, String tamanio, String raza, String sexo, int patas, int edad, String otro) {
            super(nombre, tamanio, raza, sexo, patas, edad);
            this.otro = otro;
        }

        @Override
        public String toString() {
            return "Perro\n  nombre: " + getNombre() + "\n  tamanio: " + gettamanio() + "\n  raza: " + getRaza()
                    + "\n  sexo: " + getSexo() + "\n  patas: " + getPatas() + "\n  edad: " + getEdad() + "\n  otro: " + otro;
        }
    }

    static class Gato extends Animal {

        int numero;
        public Gato(String nombre, String tamanio, String raza, String sexo, int patas, int edad, int numero) {
            super(nombre, tamanio, raza, sexo, patas, edad);
            this.numero=numero;
        }
        
        @Override
        public String toString() {
            return "Gato\n  nombre: " + getNombre() + "\n  tamanio: " + gettamanio() + "\n  raza: " + getRaza()
                    + "\n  sexo: " + getSexo() + "\n  patas: " + getPatas() + "\n  edad: " + getEdad() + "\n  numero: " + numero;
        }
    }
    
    static class Vaca extends Animal{
        
        float leche;
        
        public Vaca(String nombre, String tamanio, String raza, String sexo, int patas, int edad, float leche) {
            super(nombre, tamanio, raza, sexo, patas, edad);
            this.leche=leche;
        }
        
        @Override
        public String toString() {
            return "Vaca\n  nombre: " + getNombre() + "\n  tamanio: " + gettamanio() + "\n  raza: " + getRaza()
                    + "\n  sexo: " + getSexo() + "\n  patas: " + getPatas() + "\n  edad: " + getEdad() + "\n  leche: " + leche;
        }
    }

    public static void main(String[] args) {
        Perro perro=new Perro("Solovino", "Mediano", "desconocida", "machito", 4, 5, "no sabia que poner");
        Gato gato=new Gato("Michi", "Pequeño", "sabra diosito", "hembra", 4, 6, 24);
        Vaca vaca=new Vaca("Juan", "Grande", "ni se existen razas de vacas", "pues hembra", 4, 5, 4.6f);
        System.out.println(perro);
        System.out.println(gato);
        System.out.println(vaca);
    }
}
