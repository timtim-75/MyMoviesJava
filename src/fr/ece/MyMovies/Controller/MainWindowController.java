/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Controller;

import Utilities.FonctionsBases;
import Utilities.ObjectSerie;
import Utilities.SQLite;
import fr.ece.MyMovies.Model.Film;
import fr.ece.MyMovies.Model.FilmsModelTab;
import fr.ece.MyMovies.Model.SeriesModelTab;
import fr.ece.MyMovies.Model.Serie;
import fr.ece.MyMovies.Vue.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author timotheegrosjean
 */
public class MainWindowController {
    private MainWindow mainWindow;
    private FilmsModelTab filmsModele;
    private SeriesModelTab seriesModele; //Bibliothèque Series
    // Bibliothèque
    private SQLite db;
    // DB Films
    // DB Séries
    // Objet DB
    
    public MainWindowController(){
        
        initFromDB();
        
        mainWindow = new MainWindow(seriesModele);
        
        // Enregistrer les listeners
        mainWindow.registerAjoutButtonListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ca bomberde");
                JFileChooser dialogue = new JFileChooser("/Users/timotheegrosjean/Desktop");
        
                dialogue.setFileFilter(new FileNameExtensionFilter("Fichier Video", "mp4","avi","mkv","mov","mpg","mpa","wma","vob"));
                if (dialogue.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) 
                {

                    Film film = new Film();
                    File fichier = dialogue.getSelectedFile();
                    if(FonctionsBases.isFilm(dialogue.getSelectedFile().getName()))
                    {
                        film.setFileName(dialogue.getSelectedFile().getName());
                        film.setFilePath(dialogue.getSelectedFile().getAbsolutePath());
                        System.out.println(film.getFilePath());
                        film.setTitle(FonctionsBases.reTitleFilm(film.getFileName()));
                        System.out.println(film.getTitle());
                        SQLite.addFilm(FonctionsBases.getDBPath(), film.getTitle());
                    }
                    else 
                    {
                        Serie serie = new Serie();
                        ObjectSerie s = new ObjectSerie();
                        s = FonctionsBases.reTitleSerie(dialogue.getSelectedFile().getName());
                        serie.setEpisode(s.getEpisode());
                        serie.setName(s.getName());
                        serie.setSeason(s.getSeason());
                        SQLite.addSerie(FonctionsBases.getDBPath(), s);

                        System.out.println(serie.getName()+""+serie.getSeason()+" "+serie.getEpisode());
                    }
                }
    
                seriesModele.addSerie(new Serie(340,"The Walking Dead", 4, 12 ));
            }
        
        });
        
        mainWindow.registerRemoveButtonListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ca t'encule");
                int[] selection = mainWindow.getTabSelectedRows();
 
                for(int i = selection.length - 1; i >= 0; i--){
                    seriesModele.removeSerie(selection[i]);
                
            }
            
        }
        });
                
        
        mainWindow.setVisible(true);
        
    }
    
    private void initFromDB(){
        // Ouvrir la db
        // Récupérer les objets films et series dans la db
        // Remplir la les objets avec le contenu de la db
        seriesModele = new SeriesModelTab();
        db = new SQLite(FonctionsBases.getDBPath());
        
        //modele.remplir(db);
    }
    
}
