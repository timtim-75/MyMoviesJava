/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Model;

import Utilities.TMDB;
import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author timotheegrosjean
 */
public class ImageModeleCell extends DefaultTableCellRenderer{
    
    public ImageModeleCell()
    {
        super();
        setHorizontalAlignment(JLabel.CENTER);
    }
    
    public Component getImageModeleCellComponent(String posterPath) throws MalformedURLException
    {
        URL image = new URL(TMDB.makePosterQuery(posterPath));
        setIcon(new ImageIcon(image));
        
        return this;
    }
}
