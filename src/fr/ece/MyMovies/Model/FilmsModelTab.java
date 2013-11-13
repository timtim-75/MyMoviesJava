/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Model;

import Utilities.SQLite;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;

/**
 *
 * @author timotheegrosjean
 */
public class FilmsModelTab extends AbstractTableModel{
    
    private ArrayList<Film>  films = new ArrayList<Film>();
    private final String[] entetesFilms = {"ID", "Titre"};
    
    public FilmsModelTab(ArrayList<Film> filmsFromDB)
    {
        super();
        
        for(Film film : filmsFromDB)
        {
            films.add(film);  
        }

    }
    
    public ArrayList<Film> getFilms()
    {
        return films;
    }
    
    public void setFilms(ArrayList<Film> films)
    {
        this.films = films;
    }
    
    
    
    public int getRowCount() {
        return films.size();
    }
 
    public int getColumnCount() {
        return entetesFilms.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetesFilms[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0 :
                return films.get(rowIndex).getFilmID();
            case 1 :
                return films.get(rowIndex).getTitle();

            default : 
                return null;
                
        }
       
    }

    
    
    public void remplirTab()
    {
        
    }
}
