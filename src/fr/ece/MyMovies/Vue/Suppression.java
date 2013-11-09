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
import fr.ece.MyMovies.Model.Film;
import fr.ece.MyMovies.Model.Serie;

/**
 *
 * @author timotheegrosjean
 */
public class Suppression extends AbstractAction{
    
    public Suppression(String texte)
    {
        super(texte);
    }
    
    public void actionPerformed (ActionEvent e) 
    {
        Film film = new Film();
        SQLite.deleteFilm(film);
    }
}
