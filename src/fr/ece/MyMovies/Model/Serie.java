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
    
    public Serie(int id1,String title1, String originalTitle1, int releaseYear1, int duration1, String path1, String fileName1, String genre1,String country1, String director1, String actors1, String synopsis1,String poster1, int grade1, String comments1, int season1, int episode1)
    {
        filmID = id1;
        title = title1;
        originalTitle = originalTitle1;
        filePath = path1;
        fileName = fileName1;
        releaseYear = releaseYear1;
        duration = duration1;
        genre = genre1;
        country = country1;
        director = director1;
        actors = actors1;
        synopsis = synopsis1;
        poster = poster1;
        grade = grade1;
        comments = comments1;
        season = season1;
        episode = episode1;
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
