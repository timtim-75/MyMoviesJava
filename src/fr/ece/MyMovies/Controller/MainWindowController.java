/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Controller;

import Utilities.FonctionsBases;
import Utilities.ObjectSerie;
import Utilities.SQLite;
import fr.ece.MyMovies.Model.AllFilms;
import fr.ece.MyMovies.Model.Film;
import fr.ece.MyMovies.Model.FilmsModelTab;
import fr.ece.MyMovies.Model.SeriesModelTab;
import fr.ece.MyMovies.Model.Serie;
import fr.ece.MyMovies.Vue.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author timotheegrosjean
 */
public class MainWindowController {
    private MainWindow mainWindow;
    
    
    
    private AllFilms bibliotheque = new AllFilms();
    
    
    public MainWindowController() throws IOException{
        
        bibliotheque.initFromDB();
        FonctionsBases.makeDirectory();
        
        
        mainWindow = new MainWindow(bibliotheque);
        
        // Enregistrer les listeners
        mainWindow.registerAjoutButtonListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Ca bomberde");
                JFileChooser choisirVideo = new JFileChooser("/Users/timotheegrosjean/Desktop");
        
                choisirVideo.setFileFilter(new FileNameExtensionFilter("Fichier Video", "mp4","avi","mkv","mov","mpg","mpa","wma","vob"));
                if (choisirVideo.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) 
                {

                    Film film = new Film();
                    File fichier = choisirVideo.getSelectedFile();
                    if(FonctionsBases.isFilm(choisirVideo.getSelectedFile().getName()))
                    {
                        film.setFileName(choisirVideo.getSelectedFile().getName());
                        film.setFileName(choisirVideo.getSelectedFile().getName());
                        
                        film.setFilePath(FonctionsBases.getDefaultDirectory()+"/"+film.getFileName());
                        System.out.println(film.getFilePath());
                        film.setTitle(FonctionsBases.reTitleFilm(film.getFileName()));
                        film.setFilmID(bibliotheque.getLastFilmID()+1);
                        bibliotheque.setLastFilmID(bibliotheque.getLastFilmID()+1);
                        try {
                            FonctionsBases.moveFile(choisirVideo.getSelectedFile().getAbsolutePath(), film.getTitle() );
                        } catch (IOException ex) {
                            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println(film.getTitle());
                        SQLite.addFilm(film);
                        bibliotheque.addFilm(film);
                    }
                    else 
                    {
                        Serie serie = new Serie();
                        ObjectSerie s = new ObjectSerie();
                        s = FonctionsBases.reTitleSerie(choisirVideo.getSelectedFile().getName());
                        serie.setEpisode(s.getEpisode());
                        serie.setTitle(s.getName());
                        serie.setSeason(s.getSeason());
                        serie.setFilmID(bibliotheque.getLastSerieID()+1);
                        bibliotheque.setLastSerieID(bibliotheque.getLastSerieID()+1);
                        SQLite.addSerie(serie);
                        bibliotheque.addSerie(serie);

                        System.out.println(serie.getName()+""+serie.getSeason()+" "+serie.getEpisode());
                    }
                }
    
                //seriesModele.addSerie(new Serie(340,"The Walking Dead", 4, 12 ));
            }
        
        });
        
        mainWindow.registerRemoveButtonListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Ca t'encule");
                switch(mainWindow.getSelectedTab()){
                    case 0:
                        bibliotheque.removeFilm(mainWindow.getTabFilmsSelectedRows());
                        break;
                    case 1:
                        bibliotheque.removeSerie(mainWindow.getTabSeriesSelectedRows());
                        break;
                    default:
                        break;
                }
            
            }
        });
        
        mainWindow.registerSousTitresButtonListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                JFileChooser choisirSousTitres = new JFileChooser("/Users/timotheegrosjean/Desktop");
                choisirSousTitres.setFileFilter(new FileNameExtensionFilter("Fichier Sous-Titres", "ssa","srt","txt","sub"));
                if (choisirSousTitres.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) 
                {
                       
                }
            }
            
        });
        
        mainWindow.registerPlayButtonListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                
                String path ="";
                
                
            switch(mainWindow.getSelectedTab()){
                    case 0:
                try {
                    
                    bibliotheque.playFilm(mainWindow.getTabFilmsSelectedRows());
                } catch (IOException ex) {
                    Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                }
                        break;
                    case 1:
                try {
                    bibliotheque.playSerie(mainWindow.getTabSeriesSelectedRows());
                } catch (IOException ex) {
                    Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                }
                        break;
                    default:
                        break;
                }
            }
            
        });
                
        
        mainWindow.setVisible(true);
        
    }
    
}
