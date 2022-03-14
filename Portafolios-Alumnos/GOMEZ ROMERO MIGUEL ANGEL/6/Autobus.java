
package MIGUEL_ANGEL;

/**
 *  NOMBRE: MIGUEL ANGEL GOMEZ ROMERO
 *  NO. CONTROL: 19161282
 *  SEMESTRE: SEGUNDO
 *  ACTIVIDAD: QUE VALE X3
 *  FECHA: 20/05/2020
 */
public class Autobus extends Transporte{

    public Autobus(String marca,String modelo,String placas, int capacidad){
        super(marca,modelo,placas,capacidad);
    }
    
    public String toString(){
        String str;
        str="Autobus";
        str+="\nMarca: "+getMarca();
        str+="\nModelo: "+getModelo();
        str+="\nPlacas: "+getPlacas();
        str+="\nCon capacidad para: "+getCapacidad()+" personas";
        return str;    }
}
