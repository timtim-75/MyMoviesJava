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
public class InfosSelectionSerieModelTab extends AbstractTableModel{
    private ArrayList<Serie>  series = new ArrayList<>();
    private final String[] entetesFilms = { "Titre","Créateurs", "Acteurs"};
    
    public InfosSelectionSerieModelTab(ArrayList<Serie> returnSeries)
    {
        super();
        
        for(Serie serie : returnSeries)
        {
            series.add(serie);  
        }
    }
    
    public ArrayList<Serie> getSeries()
    {
        return series;
    }
    
    public void setFilms(ArrayList<Film> films)
    {
        this.series = series;
    }
    
    public int getRowCount() {
        return series.size();
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
                return series.get(rowIndex).getTitle();
                
            case 1 :
                return series.get(rowIndex).getDirector();
                
            case 2 :
                return series.get(rowIndex).getActors();

            default : 
                return null;
                
        }
       
    }
}
