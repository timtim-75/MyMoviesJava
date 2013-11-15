/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author timotheegrosjean
 */
public class InfosSelectionModelTab extends AbstractTableModel{
    
    private ArrayList<Film>  films = new ArrayList<Film>();
    private final String[] entetesFilms = {"ID", "Titre", "Annee de Sortie", "Synopsis"};
    
    public InfosSelectionModelTab(ArrayList<Film> returnFilms)
    {
        super();
        
        for(Film film : returnFilms)
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
                
            case 2 :
                return films.get(rowIndex).getReleaseYear();
                
            case 3 :
                return films.get(rowIndex).getSynopsis();

            default : 
                return null;
                
        }
       
    }
    
}
