/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Vue;

import Utilities.TMDB;
import fr.ece.MyMovies.Model.Film;
import fr.ece.MyMovies.Model.Serie;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author timotheegrosjean
 */
public class FicheSeriePanel extends JPanel{
    
    
    private JPanel informations;
    private JPanel infos;
    private JPanel noteComment;
    private JTextArea synopsis;
    private JTextArea note;
    private JTextArea comment;
    private JTextArea titre;
    private JTextArea annee;
    private JTextArea createur;
    private JTextArea episodeName;
    private JTextArea genre;
    private JTextArea pays;
    private JTextArea acteurs;
    private JTextArea episode;
    private JLabel poster;
    private JPanel center;
    
    private URL url;
    private BufferedImage img;

    public FicheSeriePanel() throws MalformedURLException, IOException
    {
        Dimension dimension = new Dimension();
        dimension.height = 500;
        dimension.width = 500;
        this.setPreferredSize(dimension);
        
    }
    
    
    
    public void create(Serie serie) throws MalformedURLException, IOException
    {
        
        Dimension dimension = new Dimension();
        dimension.height = 280;
        dimension.width = 300;
        
        informations = new JPanel();
        infos = new JPanel();
        noteComment = new JPanel();
        
        
        
        titre = new JTextArea(serie.getTitle());
        createur = new JTextArea("Createur : "+serie.getDirector());
        genre = new JTextArea("Genre : "+serie.getGenre());
        acteurs = new JTextArea("Acteurs : "+serie.getActors());
        acteurs.setLineWrap(true);
        acteurs.setWrapStyleWord(true);
        episode = new JTextArea("Saison : "+serie.getSeason()+" Episode : "+serie.getEpisode());
        poster = new JLabel();
        center = new JPanel();
        
        url = new URL(TMDB.makePosterQuery(serie.getPoster()));
        System.out.println(url);
        
        img = ImageIO.read(url);
        
        poster.setIcon(new ImageIcon(img));
                        
        this.setLayout(new BorderLayout());
        infos.setLayout(new GridLayout(6,1));

        infos.add(titre);
        infos.add(episode);
        infos.add(createur);
        infos.add(genre);
        infos.add(acteurs);
        
        infos.setBackground(Color.white);
        center.setBackground(Color.white);
        
        infos.setPreferredSize(dimension);
        informations.setLayout(new BorderLayout());

        informations.add(center, BorderLayout.CENTER);
        informations.add(infos, BorderLayout.EAST);
        informations.add(poster, BorderLayout.WEST);

        this.add(informations, BorderLayout.NORTH);

        
        

        noteComment.setBackground(Color.yellow);
        this.add(noteComment, BorderLayout.SOUTH); 
    }
    
    public void refresh(Serie serie) throws MalformedURLException, IOException
    {
        System.out.println(serie.getTitle());
        Dimension dimension = new Dimension();
        dimension.height = 280;
        dimension.width = 300;
        
        informations = new JPanel();
        infos = new JPanel();
        noteComment = new JPanel();
       
        
        titre = new JTextArea(serie.getTitle());
        
        createur = new JTextArea("Createur : "+serie.getDirector());
        genre = new JTextArea("Genre : "+serie.getGenre());
        acteurs = new JTextArea("Acteurs : "+serie.getActors());
        acteurs.setLineWrap(true);
        acteurs.setWrapStyleWord(true);
        episode = new JTextArea("Saison : "+serie.getSeason()+" Episode : "+serie.getEpisode());
        poster = new JLabel();
        center = new JPanel();
        
        url = new URL(TMDB.makePosterQuery(serie.getPoster()));
        System.out.println(url);
        
        img = ImageIO.read(url);
        
        poster.setIcon(new ImageIcon(img));
                        
        this.setLayout(new BorderLayout());
        infos.setLayout(new GridLayout(6,1));

        infos.add(titre);

        infos.add(episode);
        infos.add(createur);
        infos.add(genre);

        infos.add(acteurs);
        
        


        infos.setBackground(Color.white);
        center.setBackground(Color.white);
        
        infos.setPreferredSize(dimension);
        informations.setLayout(new BorderLayout());

        informations.add(center, BorderLayout.CENTER);
        informations.add(infos, BorderLayout.EAST);
        informations.add(poster, BorderLayout.WEST);

        this.add(informations, BorderLayout.NORTH);

       
        

        noteComment.setBackground(Color.yellow);
        this.add(noteComment, BorderLayout.SOUTH); 
                
    }
    //Fiche Film
    public FicheSeriePanel(Serie serie) throws MalformedURLException, IOException
    {
        super();
        
        Dimension dimension = new Dimension();
        dimension.height = 280;
        dimension.width = 300;
        
        informations = new JPanel();
        infos = new JPanel();
        noteComment = new JPanel();
        
        
        titre = new JTextArea(serie.getTitle());
        createur = new JTextArea("Createur : "+serie.getDirector());
        genre = new JTextArea("Genre : "+serie.getGenre());
        acteurs = new JTextArea("Acteurs : "+serie.getActors());
        acteurs.setLineWrap(true);
        acteurs.setWrapStyleWord(true);
        episode = new JTextArea("Saison : "+serie.getSeason()+" Episode : "+serie.getEpisode());
        poster = new JLabel();
        center = new JPanel();
        
        url = new URL(TMDB.makePosterQuery(serie.getPoster()));
        System.out.println(url);
        
        img = ImageIO.read(url);
        
        poster.setIcon(new ImageIcon(img));
                        
        this.setLayout(new BorderLayout());
        infos.setLayout(new GridLayout(6,1));

        infos.add(titre);
        infos.add(episode);
        infos.add(createur);
        infos.add(genre);
        infos.add(acteurs);
        


        infos.setBackground(Color.white);
        center.setBackground(Color.white);
        
        infos.setPreferredSize(dimension);
        informations.setLayout(new BorderLayout());

        informations.add(center, BorderLayout.CENTER);
        informations.add(infos, BorderLayout.EAST);
        informations.add(poster, BorderLayout.WEST);

        this.add(informations, BorderLayout.NORTH);

        
        

        noteComment.setBackground(Color.yellow);
        this.add(noteComment, BorderLayout.SOUTH); 
                
    }
    
}
