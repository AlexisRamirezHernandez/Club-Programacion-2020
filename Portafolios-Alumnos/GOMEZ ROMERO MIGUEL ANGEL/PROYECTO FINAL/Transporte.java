
package MIGUEL_ANGEL;
/**
 *  NOMBRE: MIGUEL ANGEL GOMEZ ROMERO
 *  NO. CONTROL: 19161282
 *  SEMESTRE: SEGUNDO
 *  ACTIVIDAD: QUE VALE X3
 *  FECHA: 20/05/2020
     */
public class Transporte {
    private String marca,modelo,placas;
    private int capacidad;
    
    public Transporte(String marca, String modelo,String placas,int capacidad){
        this.marca=marca;
        this.modelo=modelo;
        this.placas=placas;
        this.capacidad=capacidad;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public String getPlacas(){
        return placas;
    }
    
    public int getCapacidad(){
        return capacidad;
    }
    
    public String toString(){
        String str;
        str="Marca: "+getMarca();
        str+="\nModelo: "+getModelo();
        str+="\nPlacas: "+getPlacas();
        str+="\nCapacidad: "+getCapacidad();
        return str;
    }
}
