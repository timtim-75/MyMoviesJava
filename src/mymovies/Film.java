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
    
}
