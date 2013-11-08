/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mymovies;


import Utilities.FonctionsBases;
import Utilities.SQLite;
import fr.ece.MyMovies.Vue.Window;


/**
 *
 * @author timotheegrosjean
 */
public class MyMovies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //AllFilms bibliotheque = new AllFilms();
        
        SQLite s = new SQLite(FonctionsBases.getDBPath());
        Window test = new Window();
         
        test.setVisible(true);
        
    }
}
