/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Controller;

import Utilities.FonctionsBases;
import Utilities.ObjectSerie;
import Utilities.SQLite;
import Utilities.TMDB;
import fr.ece.MyMovies.Model.AllFilms;
import fr.ece.MyMovies.Vue.FicheFilmPanel;
import fr.ece.MyMovies.Model.Film;
import fr.ece.MyMovies.Model.FilmsModelTab;
import fr.ece.MyMovies.Model.SeriesModelTab;
import fr.ece.MyMovies.Model.Serie;
import fr.ece.MyMovies.Vue.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
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
    InfoSelectionFilmWindowController filmSelection;
    InfoSelectionSerieWindowController serieSelection;
    
    
    
    private AllFilms bibliotheque = new AllFilms();
    
    
    
    public MainWindowController() throws IOException{
        
        bibliotheque.initFromDB();
        
        
        /*Runtime runtime = Runtime.getRuntime();
        runtime.exec("mkdir /Users/$USER/Desktop/MyMovies");*/
        //FonctionsBases.makeDirectory();
        
        
        
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
                    Serie serie = new Serie();
                    ArrayList<String> tmpID = new ArrayList<>();
                    File fichier = choisirVideo.getSelectedFile();
                    if(FonctionsBases.isFilm(choisirVideo.getSelectedFile().getName()))
                    {
                        film.setFileName(choisirVideo.getSelectedFile().getName());
                        film.setFilePath(FonctionsBases.getDefaultDirectory()+"/"+film.getFileName());
                        film.setTitle(FonctionsBases.reTitleFilm(film.getFileName()));
                        film.setFilmID(bibliotheque.getLastFilmID()+1);
                        bibliotheque.setLastFilmID(bibliotheque.getLastFilmID()+1);
                        /*try {
                            FonctionsBases.moveFilmFile(choisirVideo.getSelectedFile().getAbsolutePath(), film.getTitle() );
                        } catch (IOException ex) {
                            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        }*/
                        
                        
                        
                        try {
                           filmSelection = new InfoSelectionFilmWindowController(FonctionsBases.parseFilmJSON(TMDB.sendIDSQuery(TMDB.makeFilmIDSQuery(FonctionsBases.getFilmsID(TMDB.sendQuery(TMDB.makeFilmSearchQuery(film.getTitle()))))), film.getFilmID(), film.getFilePath(), film.getFileName()), bibliotheque, film);
                           
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                    }
                    else 
                    {
                        serie.setFileName(choisirVideo.getSelectedFile().getName());
                        serie.setFilePath(FonctionsBases.getDefaultDirectory()+"/"+serie.getFileName());
                        ObjectSerie s = new ObjectSerie();
                        s = FonctionsBases.reTitleSerie(choisirVideo.getSelectedFile().getName());
                        serie.setEpisode(s.getEpisode());
                        serie.setTitle(s.getName());
                        System.out.println("NUI : "+serie.getTitle());
                        serie.setSeason(s.getSeason());
                        serie.setFilmID(bibliotheque.getLastSerieID()+1);
                        bibliotheque.setLastSerieID(bibliotheque.getLastSerieID()+1);
                        
                        /*try {
                            FonctionsBases.moveSerieFile(choisirVideo.getSelectedFile().getAbsolutePath(), serie.getTitle() );
                        } catch (IOException ex) {
                            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        }*/
                        
                        try {
                            serieSelection = new InfoSelectionSerieWindowController(FonctionsBases.parseSerieJSON(TMDB.sendIDSQuery(TMDB.makeSerieIDSQuery(FonctionsBases.getFilmsID(TMDB.sendQuery(TMDB.makeSerieSearchQuery(serie.getTitle()))))),serie.getFilmID(), serie.getFilePath(), serie.getFileName(), serie.getSeason(), serie.getEpisode() ),bibliotheque, serie);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
        
        mainWindow.registerRemoveButtonListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Ca t'encule");
                switch(mainWindow.getSelectedTab()){
                    case 0:
                        bibliotheque.removeFilm(mainWindow.getTabFilmsSelectedRows());
                        try {
                            mainWindow.createInfoFilm();
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
                
                switch(mainWindow.getSelectedTab()){
                    case 0:
                        
                        choisirSousTitres.setFileFilter(new FileNameExtensionFilter("Fichier Sous-Titres", "ssa","srt","txt","sub"));
                        if (choisirSousTitres.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) 
                        {
                           String path = choisirSousTitres.getSelectedFile().getAbsolutePath();

                            try {
                                bibliotheque.addToFilmsubtitle(mainWindow.getTabFilmsSelectedRows(), path);
                            } 
                            catch (IOException ex) {
                                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    case 1:
                        
                        
                        choisirSousTitres.setFileFilter(new FileNameExtensionFilter("Fichier Sous-Titres", "ssa","srt","txt","sub"));
                        if (choisirSousTitres.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) 
                        {
                           String path = choisirSousTitres.getSelectedFile().getAbsolutePath();

                            try {
                                bibliotheque.addToSeriesubtitle(mainWindow.getTabSeriesSelectedRows(), path);
                            } 
                            catch (IOException ex) {
                                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
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
                
        mainWindow.registerSelectionRowFilmActionListener(new MouseAdapter(){
        
            
            public void mouseClicked(MouseEvent e) {
                try {
                    
                    mainWindow.refreshInfoFilm();
                    
                } catch (MalformedURLException ex) {
                    Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
                
        });
        
        mainWindow.registerSelectionRowSerieActionListener(new MouseAdapter(){
        
            
            public void mouseClicked(MouseEvent e) {
                try {
                    
                    
                    mainWindow.refreshInfoSerie();
                    
                } catch (MalformedURLException ex) {
                    Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
                
        });
        
        mainWindow.setVisible(true);
    }
    
}
