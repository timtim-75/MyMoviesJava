/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Model;
import java.util.*;

/**
 *
 * @author timotheegrosjean
 */
public class AllFilms {
    
    TreeSet filmotheque = new TreeSet();
    TreeSet serietheque = new TreeSet();
    
    public TreeSet getFilmotheque()
    {  
        return filmotheque;
    }   
    public void setFilmotheque(TreeSet filmotheque1)
    {
        filmotheque = filmotheque1;
    }
    public TreeSet getSerietheque()
    {  
        return serietheque;
    }   
    public void setSerietheque(TreeSet serietheque1)
    {
        serietheque = serietheque1;
    }
    
    //Constructeur
    AllFilms()
    {
        filmotheque = null;
        serietheque = null;
    }
}
