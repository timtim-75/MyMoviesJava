/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Model;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author timotheegrosjean
 */
public class Film {
    
    // Titres
    String title;
    String originalTitle;
    
    // Informations
    int filmID;
    int releaseYear;
    int duration;
    String genre;
    String country;
    
    // Réalisateur(s)
    String director;
    
    // Acteur(s)
    String actors;
    
    // Synopsis
    String synopsis;
    
    // Affiche du film
    String poster;
    
    //Commentaires & Note
    int grade;
    String comments;
    
    //Informations du fichier vidéo
    String fileName;
    String filePath;
    String subtitle;
    
    //Getter & Setter
    
    public String getSubtitle()
    {
        return subtitle;
    }
    
    public void setSubtitle(String subtitle1)
    {
        subtitle=subtitle1;
    }
    public String getTitle()
    {  
        return title;
    }   
    public void setTitle(String title1)
    {
        title = title1;
    }  
    public String getOriginalTitle()
    {
        return originalTitle;
    }   
    public void setOriginalTitle(String originalTitle1)
    {
        originalTitle = originalTitle1;
    }   
    public int getReleaseYear()
    {
        return releaseYear;
    }    
    public void setReleaseYear(int releaseYear1)
    {
        releaseYear = releaseYear1;
    }    
    public int getDuration()
    {
        return duration;
    }   
    public void setDuration(int duration1)
    {
        duration = duration1;
    }   
    public String getGenre()
    {
        return genre;
    }   
    public void setGenre(String genre1)
    {
        genre = genre1;
    }   
    public String getCountry()
    {
        return country;
    }    
    public void setCountry(String country1)
    {
        country = country1;
    }   
    public String getDirector()
    {
        return director;
    }    
    public void setDirector(String director1)
    {
        director = director1;
    }
    public String getActors()
    {
        return actors;
    }  
    public void setActors(String actors1)
    {
        actors = actors1;
    }   
    public String getSynopsis()
    {
        return synopsis;
    }
    public void setSynopsis(String synopsis1)
    {
        synopsis = synopsis1;
    }
    public String getPoster()
    {
        return poster;
    }
    public void setPoster(String poster1)
    {
        poster = poster1;
    }
    public int getGrade()
    {
        return grade;
    }
    public void setGrade(int grade1)
    {
        grade = grade1;
    }
    public String getComments()
    {
        return comments;
    }
    public void setComments(String comments1)
    {
        comments = comments1;
    }
    public String getFileName()
    {
        return fileName;
    }
    public void setFileName(String fileName1)
    {
        fileName = fileName1;
    }
    public String getFilePath()
    {
        return filePath;
    }
    public void setFilePath(String filePath1)
    {
        filePath = filePath1;
    }
    public int getFilmID()
    {
        return filmID;
    }
    public void setFilmID(int filmID1)
    {
        filmID = filmID1;
    }
    
    //Constructeurs
    public Film()
    {
        /*title = "";
        originalTitle = "";
        filmID = 0;
        releaseYear = 0;
        duration = 0;
        genre = "";
        country = "";
        director = "";
        actors = "";
        synopsis = "";
        poster = "";
        grade = 0;
        comments = "";*/
    }
    
    public Film(int id1,String title1, String originalTitle1, int releaseYear1, int duration1, String path1, String fileName1, String genre1,String country1, String director1, String actors1, String synopsis1,String poster1, int grade1, String comments1)
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
        
    }
    
    
    
    
    
}
