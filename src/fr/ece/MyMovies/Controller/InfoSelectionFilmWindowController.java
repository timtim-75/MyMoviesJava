/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Controller;

import fr.ece.MyMovies.Model.AllFilms;
import fr.ece.MyMovies.Model.Film;
import fr.ece.MyMovies.Model.InfosSelectionFilmModelTab;
import fr.ece.MyMovies.Model.TempFilm;
import fr.ece.MyMovies.Vue.InfoSelectionFilmWindow;
import fr.ece.MyMovies.Vue.NoResponse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author timotheegrosjean
 */
public class InfoSelectionFilmWindowController {
    
    InfosSelectionFilmModelTab infosFilms;
    AllFilms bibliotheque;
    //ArrayList<Film> returnFilms;
    InfoSelectionFilmWindow filmWindow ;
    NoResponse empty;
    Film film;
    
    public InfoSelectionFilmWindowController(final ArrayList<Film> selectedFilm, AllFilms bibliotheque1,Film film1)
    {
        if(!selectedFilm.isEmpty())
        {
        infosFilms = new InfosSelectionFilmModelTab(selectedFilm);
        filmWindow = new InfoSelectionFilmWindow(infosFilms);
        bibliotheque = bibliotheque1;
        filmWindow.registerChoisirButtonListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                
                int[] tmp = filmWindow.getSelectedRows();
                
                
                bibliotheque.addFilm(selectedFilm.get(tmp[0]));
                filmWindow.dispose();
                
            }
            
        });
        
        filmWindow.setVisible(true);
        }
        else
        {
            film=new Film();
            film = film1;  
            empty = new NoResponse();
            /*System.out.println(film.getTitle());
            System.out.println(film.getFilmID());
            bibliotheque.addFilm(film);*/
        }
    }
    
    public int[] getTabSelectedRows(){
        
        return filmWindow.getSelectedRows();
    }
    
}
