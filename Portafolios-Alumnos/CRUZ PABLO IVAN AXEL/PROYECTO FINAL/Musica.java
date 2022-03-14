/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ivan Axel Cruz Pablo
 */
public class Musica extends Multimedia {

    private String artista, genero;
    public Musica (String titulo, String autor, String formato, String duracion) {
        super(titulo, autor, formato, duracion);
    }
    public void setArtista(String artista){
        this.artista=artista;
    }
    public void setGenero(String genero){
        this.genero=genero;
    }
    public String getArtista(){
        return artista;
    }
    public String getGenero(){
        return genero;
    }
    public String datos(){
        String man="Genero "+genero+"\nArtista "+artista;
        return man;
    }
}