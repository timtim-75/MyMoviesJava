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
public class SeriesModelTab extends AbstractTableModel {
    
    private final ArrayList<Serie> series= new ArrayList<Serie>();
    
    
    
    private final String[] entetesSeries = {"ID", "Titre", "Saison", "Episode"};
 
    public SeriesModelTab() {
        super();
 
        series.add(new Serie(1,"The Walking Dead", 4, 1 )) ;
        series.add(new Serie(2,"The Walking Dead", 4, 2 ));
        series.add(new Serie(3,"The Walking Dead", 4, 3 ));
        series.add(new Serie(4,"The Walking Dead", 4, 4 ));
        series.add(new Serie(5,"The Walking Dead", 4, 5 ));
        series.add(new Serie(6,"Homeland", 3, 1));
        series.add(new Serie(7,"Homeland", 3, 2));
        series.add(new Serie(8,"Homeland", 3, 3));

   }
 
    public int getRowCount() {
        return series.size();
    }
 
    public int getColumnCount() {
        return entetesSeries.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetesSeries[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0 :
                return series.get(rowIndex).getFilmID();
            case 1 :
                return series.get(rowIndex).getName();
            case 2 :
                return series.get(rowIndex).getSeason();
            case 3 :
                return series.get(rowIndex).getEpisode();
            
            default : 
                return null;
                
        }
       
    }

    public void addSerie(Serie serie)
    {
        series.add(serie);
        fireTableRowsInserted(series.size() -1, series.size() -1);
    }
    
    public void removeSerie(int rowIndex) {
        series.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void remplirTab()
    {
        
    }
}
