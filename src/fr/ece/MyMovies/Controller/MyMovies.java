/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Controller;


import Utilities.FonctionsBases;
import Utilities.SQLite;
import fr.ece.MyMovies.Model.SeriesModelTab;
import fr.ece.MyMovies.Vue.MainWindow;


/**
 *
 * @author timotheegrosjean
 */
public class MyMovies {

    /**
     * @param args the command line arguments
     */
    private static MainWindowController mwc;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //AllFilms bibliotheque = new AllFilms();
        // Declare Model
        /*ModelTab modele = new ModelTab();
        // declare bibli de films & series
        
        // remplis avec ce que tu recupere de la db
        
        
        SQLite s = new SQLite(FonctionsBases.getDBPath());
        MainWindow test = new MainWindow(modele);
         
        test.setVisible(true);*/
        
        // Virer au dessus
        mwc = new MainWindowController();
        
    }
}
