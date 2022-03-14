/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ivan Axel Cruz Pablo
 */
public class Pelicula extends Multimedia {

    private String actorPrincipal, director;
    public Pelicula (String titulo, String autor, String formato, String duracion) {
        super(titulo, autor, formato, duracion);
    }
    public void setActorPrincipal(String actorPrincipal){
        this.actorPrincipal=actorPrincipal;
    }
    public void setDirector(String director){
        this.director=director;
    }
    public String getActorPrincipal(){
        return actorPrincipal;
    }
    public String getDirector(){
        return director;
    }
    public String datos(){
        String man="Actor Principal "+actorPrincipal+"\ndirector "+director;
        return man;
    }
}
