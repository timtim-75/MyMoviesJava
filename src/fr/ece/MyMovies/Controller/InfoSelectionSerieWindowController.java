/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Controller;

import fr.ece.MyMovies.Model.AllFilms;
import fr.ece.MyMovies.Model.Film;
import fr.ece.MyMovies.Model.InfosSelectionFilmModelTab;
import fr.ece.MyMovies.Model.InfosSelectionSerieModelTab;
import fr.ece.MyMovies.Model.Serie;
import fr.ece.MyMovies.Vue.InfoSelectionFilmWindow;
import fr.ece.MyMovies.Vue.InfoSelectionSerieWindow;
import fr.ece.MyMovies.Vue.NoResponse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author timotheegrosjean
 */
public class InfoSelectionSerieWindowController {
    
    InfosSelectionSerieModelTab infosSeries;
    AllFilms bibliotheque;
    //ArrayList<Film> returnFilms;
    InfoSelectionSerieWindow serieWindow ;
    NoResponse empty;
    Serie serie;
    
    public InfoSelectionSerieWindowController(final ArrayList<Serie> selectedSerie, AllFilms bibliotheque1,Serie serie1)
    {
        if(!selectedSerie.isEmpty())
        {
        infosSeries = new InfosSelectionSerieModelTab(selectedSerie);
        serieWindow = new InfoSelectionSerieWindow(infosSeries);
        bibliotheque = bibliotheque1;
        serieWindow.registerChoisirButtonListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                
                int[] tmp = serieWindow.getSelectedRows();
                
                
                bibliotheque.addSerie(selectedSerie.get(tmp[0]));
                serieWindow.dispose();
                
            }
            
        });
        
        serieWindow.setVisible(true);
        }
        else
        {
            serie =new Serie();
            serie = serie1;  
            empty = new NoResponse();
            /*System.out.println(film.getTitle());
            System.out.println(film.getFilmID());
            bibliotheque.addFilm(film);*/
        }
    }
    
    public int[] getTabSelectedRows(){
        
        return serieWindow.getSelectedRows();
    }
    
}
