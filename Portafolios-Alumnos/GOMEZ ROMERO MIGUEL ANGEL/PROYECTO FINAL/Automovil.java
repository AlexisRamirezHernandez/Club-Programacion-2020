
package MIGUEL_ANGEL;

/**
 *  NOMBRE: MIGUEL ANGEL GOMEZ ROMERO
 *  NO. CONTROL: 19161282
 *  SEMESTRE: SEGUNDO
 *  ACTIVIDAD: QUE VALE X3
 *  FECHA: 20/05/2020
 */
public class Automovil extends Transporte{
    
    public Automovil(String marca,String modelo,String placas,int capacidad){
        super(marca,modelo,placas,capacidad);
    }
    
    public String toString(){
        String str;
        str="Automovil";
        str+="\nMarca: "+getMarca();
        str+="\nModelo: "+getModelo();
        str+="\nPlacas: "+getPlacas();
        str+="\nCapacidad:"+getCapacidad();
        return str;
    }
}
