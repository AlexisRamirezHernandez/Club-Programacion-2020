/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author Ivan Axel Cruz Pablo
 */
public class Multimedia {

    private String titulo, autor, formato, duracion;

    Multimedia(String titulo, String autor, String formato, String duracion) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.duracion = duracion;
    }

    public String setdameTitulo() {
        return titulo;
    }

    public String setdameAutor() {
        return autor;
    }

    public String setdameFormato() {
        return formato;
    }

    public String setdameDuracion() {
        return duracion;
    }
    
    public String Datos(){
        String man="\nTitulo"+titulo+"\nAutor"+autor+"\nFormato"+formato+"\nDuracion"+duracion;
        return man;
    }
}
