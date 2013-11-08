/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Vue;

import Utilities.FonctionsBases;
import Utilities.ObjectSerie;
import Utilities.SQLite;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import mymovies.Film;
import mymovies.Serie;

/**
 *
 * @author timotheegrosjean
 */

public class Ajout extends AbstractAction{
    
    
    public Ajout(String texte)
    {
        super(texte);
    }
    
   
    
    public void actionPerformed (ActionEvent e) 
    {
        
        JFileChooser dialogue = new JFileChooser();
        
        dialogue.setFileFilter(new FileNameExtensionFilter("Fichier Video", "mp4","avi","mkv","mov","mpg","mpa","wma","vob"));
	PrintWriter sortie = null;
	
        
        
	
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
    }
}
