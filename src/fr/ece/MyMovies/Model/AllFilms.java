/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Model;
import Utilities.FonctionsBases;
import Utilities.SQLite;
import java.util.*;

/**
 *
 * @author timotheegrosjean
 */
public class AllFilms {
    
    private FilmsModelTab filmsModele;
    private SeriesModelTab seriesModele;
    private int lastFilmID;
    private int lastSerieID;
    
    public FilmsModelTab getFilmotheque()
    {  
        return filmsModele;
    }   
    public void setFilmotheque(FilmsModelTab filmotheque1)
    {
        filmsModele = filmotheque1;
    }
    public SeriesModelTab getSerietheque()
    {  
        return seriesModele;
    }   
    public void setSerietheque(SeriesModelTab seriesModele)
    {
        this.seriesModele = seriesModele;
    }
    
    public void addSerie(Serie serie){
        seriesModele.getSeries().add(serie);
        seriesModele.fireTableRowsInserted(seriesModele.getSeries().size() -1, seriesModele.getSeries().size() -1);
    }
    
    public void addFilm(Film film){
        
        filmsModele.getFilms().add(film);
        filmsModele.fireTableRowsInserted(filmsModele.getFilms().size()-1, filmsModele.getFilms().size()-1);
        
    }
    
    public void removeFilm(int[] indexes)
    {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        
        for(int i : indexes){
             ids.add(filmsModele.getFilms().get(i).getFilmID());
             filmsModele.fireTableRowsDeleted(i, i);
        }
        
        for(int i : ids){
            FonctionsBases.removeFilmFromArrayList(filmsModele.getFilms(), i);
            SQLite.deleteFilmFromDB(i);
        }
    }
    
    public void removeSerie(int[] indexes){
        ArrayList<Integer> ids = new ArrayList<Integer>();
        
        for(int i : indexes){
             ids.add(seriesModele.getSeries().get(i).getFilmID());
             seriesModele.fireTableRowsDeleted(i, i);
        }
        
        for(int i : ids){
            FonctionsBases.removeSerieFromArrayList(seriesModele.getSeries(), i);
            SQLite.deleteSerieFromDB(i);
        }
        
    }
    public void initFromDB()
    {
        SQLite.CreateTable();
        seriesModele = new SeriesModelTab(SQLite.getSeriesFromDB());
        filmsModele = new FilmsModelTab(SQLite.getFilmsFromDB());
        if(filmsModele.getFilms().size() == 0)
        {
            lastFilmID=0;
        }
        else lastFilmID = filmsModele.getFilms().get(filmsModele.getFilms().size()-1).getFilmID();
        
        if(seriesModele.getSeries().size() == 0)
        {
            lastSerieID = 0;
        }
        
        else lastSerieID = seriesModele.getSeries().get(seriesModele.getSeries().size()-1).getFilmID();
                
    }
    
    public int getLastFilmID()
    {
        return lastFilmID;
    }
    
    public void setLastFilmID(int lastFilmID1)
    {
        lastFilmID = lastFilmID1;
    }
    
    public int getLastSerieID()
    {
        return lastSerieID;
    }
    
    public void setLastSerieID(int lastSerieID1)
    {
        lastSerieID = lastSerieID1;
    }
    //Constructeur
    public AllFilms()
    {
       
    }
}
