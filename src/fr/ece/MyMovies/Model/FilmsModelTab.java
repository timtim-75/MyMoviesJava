/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Model;

import javax.swing.table.*;
import java.awt.*;
import java.util.*;

/**
 *
 * @author timotheegrosjean
 */
public class FilmsModelTab extends AbstractTableModel{
    
    private final ArrayList<Film>  films = new ArrayList<Film>();
    private final String[] entetesFilms = {"ID", "Titre", "Genre"};
    
    
    
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
            case 2 :
                return films.get(rowIndex).getGenre();
            
            
            default : 
                return null;
                
        }
       
    }

    public void addSerie(Serie serie)
    {
        films.add(serie);
        fireTableRowsInserted(films.size() -1, films.size() -1);
    }
    
    public void removeSerie(int rowIndex) {
        films.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void remplirTab()
    {
        
    }
}
