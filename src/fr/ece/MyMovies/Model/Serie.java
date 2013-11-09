/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Model;

/**
 *
 * @author timotheegrosjean
 */
public class Serie extends Film{
    
    //Informations sur l'episode
    int season;
    int episode;
    String name;
    
    public Serie(int filmID1,String name1, int season1, int episode1)
    {
        this.filmID = filmID1;
        this.name = name1;
        this.season = season1;
        this.episode = episode1;
    }
    
    //Getters & Setter
    public int getSeason()
    {
        return season;
    }    
    public void setSeason(int season1)
    {
        season = season1;
    }    
    public int getEpisode()
    {
        return episode;
    }    
    public void setEpisode(int episode1)
    {
        episode = episode1;
    }
    public String getName()
    {
        return name;
    }   
    public void setName(String name1)
    {
        name = name1;
    }  
    
    //Constructeur
    public Serie()
    {
        season = 0;
        episode = 0;
        name = "";
    }
    
}
