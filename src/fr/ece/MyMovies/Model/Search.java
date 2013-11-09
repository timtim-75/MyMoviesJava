/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Model;

/**
 *
 * @author timotheegrosjean
 */
public class Search {
    
    String keywords;
    
    //Getter & Setter
    public String getKeyWords()
    {  
        return keywords;
    }   
    public void setKeyWords(String keywords1)
    {
        keywords = keywords1;
    }  
    
    //Constructeur
    Search()
    {
        keywords = "";
    }
    
}
