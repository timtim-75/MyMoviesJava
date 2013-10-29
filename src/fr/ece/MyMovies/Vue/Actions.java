/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Vue;

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

/**
 *
 * @author timotheegrosjean
 */

public class Actions extends AbstractAction{
    
    
    public Actions(String texte)
    {
        super(texte);
    }
    
    
    
    public void actionPerformed (ActionEvent e) {
    {
        JFileChooser dialogue = new JFileChooser(new File("."));
        dialogue.setFileFilter(new FileNameExtensionFilter("Fichier Video", "mp4","avi","mkv","mov","mpg","mpa","wma","vob"));
	PrintWriter sortie = null;
	//File fichier = null ;
        Film film = new Film();
	
	if (dialogue.showOpenDialog(null)== 
	    JFileChooser.APPROVE_OPTION) {
                File fichier = dialogue.getSelectedFile();
                film.setFileName(dialogue.getSelectedFile().getName());
                System.out.println(film.getFileName());
            

	}
    }
    }
}
