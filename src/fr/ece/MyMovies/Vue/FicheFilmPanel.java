/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Vue;

import Utilities.TMDB;
import fr.ece.MyMovies.Model.Film;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author timotheegrosjean
 */
public class FicheFilmPanel extends JPanel{
    
    
    
    
    private JPanel informations;
    private JPanel infos;
    private JPanel noteComment;
    private JTextArea synopsis;
    private JTextArea note;
    private JTextArea comment;
    private JTextArea titre;
    private JTextArea annee;
    private JTextArea realisateur;
    private JTextArea genre;
   
    private JTextArea acteurs;
    private JLabel poster;
    private JPanel center;
    
    private URL url;
    private BufferedImage img;
    
    
    
    
    public void create(Film film) throws MalformedURLException, IOException
    {
        
        Dimension dimension = new Dimension();
        dimension.height = 280;
        dimension.width = 300;
        
        informations = new JPanel();
        informations.setBackground(Color.white);
        infos = new JPanel();
        infos.setBackground(Color.white);
        noteComment = new JPanel();
        noteComment.setBackground(Color.white);
        
        
        titre = new JTextArea(film.getTitle()+" ( "+film.getOriginalTitle()+" )");
        annee = new JTextArea(Integer.toString(film.getReleaseYear()));
        realisateur = new JTextArea("Realisateur : "+film.getDirector());
        genre = new JTextArea("Genre : "+film.getGenre());
        
        synopsis = new JTextArea("\n\nSynopsis : "+film.getSynopsis());
        synopsis.setLineWrap(true);
        synopsis.setWrapStyleWord(true);
        acteurs = new JTextArea("Acteurs : "+film.getActors());
        acteurs.setLineWrap(true);
        acteurs.setWrapStyleWord(true);
        poster = new JLabel();
        center = new JPanel();
        note = new JTextArea("Note : "+Integer.toString(film.getGrade()));
        comment = new JTextArea("Commentaires : "+film.getComments());
        
        url = new URL(TMDB.makePosterQuery(film.getPoster()));
        System.out.println(url);
        
        img = ImageIO.read(url);
        
        poster.setIcon(new ImageIcon(img));
                        
        this.setLayout(new BorderLayout());
        infos.setLayout(new GridLayout(6,1));

        infos.add(titre);
        infos.add(annee);
        infos.add(realisateur);
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

        
        this.add(synopsis, BorderLayout.CENTER);

        noteComment.setBackground(Color.white);
        noteComment.setLayout(new BorderLayout());
        noteComment.add(note, BorderLayout.WEST);
        noteComment.add(comment, BorderLayout.EAST);
        this.add(noteComment, BorderLayout.SOUTH); 
    }
    
    public void refresh(Film film) throws MalformedURLException, IOException
    {
        Dimension dimension = new Dimension();
        dimension.height = 280;
        dimension.width = 300;
        
        informations = new JPanel();
        informations.setBackground(Color.white);
        infos = new JPanel();
        infos.setBackground(Color.white);
        noteComment = new JPanel();
        noteComment.setBackground(Color.white);
       
        
        titre = new JTextArea(film.getTitle()+" ( "+film.getOriginalTitle()+" )");
        annee = new JTextArea(Integer.toString(film.getReleaseYear()));
        realisateur = new JTextArea("Realisateur : "+film.getDirector());
        genre = new JTextArea("Genre : "+film.getGenre());
        
        synopsis = new JTextArea("\n\nSynopsis : "+film.getSynopsis());
        synopsis.setLineWrap(true);
        synopsis.setWrapStyleWord(true);
        acteurs = new JTextArea("Acteurs : "+film.getActors());
        acteurs.setLineWrap(true);
        acteurs.setWrapStyleWord(true);
        poster = new JLabel();
        center = new JPanel();
        note = new JTextArea("Note : "+Integer.toString(film.getGrade()));
        comment = new JTextArea("Commentaires : "+film.getComments());
        
        url = new URL(TMDB.makePosterQuery(film.getPoster()));
        System.out.println(film.getPoster());
        System.out.println(url);
        
        img = ImageIO.read(url);
        
        poster.setIcon(new ImageIcon(img));
                        
        this.setLayout(new BorderLayout());
        infos.setLayout(new GridLayout(6,1));

        infos.add(titre);
        infos.add(annee);
        infos.add(realisateur);
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

       
        this.add(synopsis, BorderLayout.CENTER);

        noteComment.setBackground(Color.white);
        noteComment.setLayout(new BorderLayout());
        noteComment.add(note, BorderLayout.WEST);
        noteComment.add(comment, BorderLayout.EAST);
        this.add(noteComment, BorderLayout.SOUTH); 
                
    }
    //Fiche Film
    public FicheFilmPanel(Film film) throws MalformedURLException, IOException
    {
        super();
        
        Dimension dimension = new Dimension();
        dimension.height = 280;
        dimension.width = 300;
        
        informations = new JPanel();
        informations.setBackground(Color.white);
        infos = new JPanel();
        infos.setBackground(Color.white);
        noteComment = new JPanel();
        noteComment.setBackground(Color.white);
        
        
        titre = new JTextArea(film.getTitle()+" ( "+film.getOriginalTitle()+" )");
        annee = new JTextArea(Integer.toString(film.getReleaseYear()));
        realisateur = new JTextArea("Realisateur : "+film.getDirector());
        genre = new JTextArea("Genre : "+film.getGenre());
        
        synopsis = new JTextArea("\n\nSynopsis : "+film.getSynopsis());
        synopsis.setWrapStyleWord(true);
        acteurs = new JTextArea("Acteurs : "+film.getActors());
        acteurs.setLineWrap(true);
        acteurs.setWrapStyleWord(true);
        poster = new JLabel();
        center = new JPanel();
        note = new JTextArea("Note : "+Integer.toString(film.getGrade()));
        comment = new JTextArea("Commentaires : "+film.getComments());
        
        url = new URL(TMDB.makePosterQuery(film.getPoster()));
        System.out.println(url);
        
        img = ImageIO.read(url);
        
        poster.setIcon(new ImageIcon(img));
                        
        this.setLayout(new BorderLayout());
        infos.setLayout(new GridLayout(6,1));

        infos.add(titre);
        infos.add(annee);
        infos.add(realisateur);
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

        
        this.add(synopsis, BorderLayout.CENTER);

        noteComment.setBackground(Color.white);
        noteComment.setLayout(new BorderLayout());
        noteComment.add(note, BorderLayout.WEST);
        noteComment.add(comment, BorderLayout.EAST);
        this.add(noteComment, BorderLayout.SOUTH); 
                
    }
   
    public FicheFilmPanel() throws MalformedURLException, IOException
    {
        Dimension dimension = new Dimension();
        dimension.height = 500;
        dimension.width = 500;
        this.setPreferredSize(dimension);
        
    }

    
    
}
