/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Model;

import Utilities.ObjectSerie;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;

/**
 *
 * @author timotheegrosjean
 */
public class SeriesModelTab extends AbstractTableModel {
    
    private ArrayList<Serie> series= new ArrayList<Serie>();
    
    
    
    private final String[] entetesSeries = {"ID", "Titre", "Saison", "Episode"};
 
    public SeriesModelTab(ArrayList<Serie> seriesFromDB) {
        super();
        
        for(Serie serie : seriesFromDB)
        {
            series.add(serie);
        }

   }
 
    
    public ArrayList<Serie> getSeries()
    {
        return series;
    }
    
    public void setSeries(ArrayList<Serie> series)
    {
        this.series = series;
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
                return series.get(rowIndex).getTitle();
            case 2 :
                return series.get(rowIndex).getSeason();
            case 3 :
                return series.get(rowIndex).getEpisode();
            
            default : 
                return null;
                
        }
       
    }

}
