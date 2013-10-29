/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mymovies;

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
    ArrayList<String> genre;
    ArrayList<String> country;
    
    // Réalisateur(s)
    ArrayList<String> director;
    
    // Acteur(s)
    ArrayList<String> actors;
    
    // Synopsis
    String synopsis;
    
    // Affiche du film
    Image poster;
    
    //Commentaires & Note
    int grade;
    ArrayList<String> comments;
    
    //Informations du fichier vidéo
    String fileName;
    String filePath;
    
    //Getter & Setter
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
    public ArrayList<String> getGenre()
    {
        return genre;
    }   
    public void setGenre(ArrayList<String> genre1)
    {
        genre = genre1;
    }   
    public ArrayList<String> getCountry()
    {
        return country;
    }    
    public void setCountry(ArrayList<String> country1)
    {
        country = country1;
    }   
    public ArrayList<String> getDirector()
    {
        return director;
    }    
    public void setDirector(ArrayList<String> director1)
    {
        director = director1;
    }
    public ArrayList<String> getActors()
    {
        return actors;
    }  
    public void setActors(ArrayList<String> actors1)
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
    public Image getPoster()
    {
        return poster;
    }
    public void setPoster(Image poster1)
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
    public ArrayList<String> getComments()
    {
        return comments;
    }
    public void setComments(ArrayList<String> comments1)
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
    
    //Constructeur
    public Film()
    {
        title = "";
        originalTitle = "";
        filmID = 0;
        releaseYear = 0;
        duration = 0;
        genre = null;
        country = null;
        director = null;
        actors = null;
        synopsis = "";
        poster = null;
        grade = 0;
        comments = null;
    }
    
}
