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
    private JLabel note;
    private JLabel comment;
    private JLabel titre;
    private JLabel annee;
    private JLabel realisateur;
    private JLabel genre;
    private JLabel pays;
    private JPanel acteurs;
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
        infos = new JPanel();
        noteComment = new JPanel();
        
        titre = new JLabel(film.getTitle()+" ( "+film.getOriginalTitle()+" )");
        annee = new JLabel(Integer.toString(film.getReleaseYear()));
        realisateur = new JLabel("Realisateur : "+film.getDirector());
        genre = new JLabel("Genre : "+film.getGenre());
        pays = new JLabel("Pays : "+film.getCountry());
        synopsis = new JTextArea("Synopsis : "+film.getSynopsis());
        synopsis.setLineWrap(true);
        synopsis.setWrapStyleWord(true);
        acteurs = new JPanel();
        poster = new JLabel();
        center = new JPanel();
        
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
        infos.add(pays);


        infos.setBackground(Color.white);
        center.setBackground(Color.white);
        
        infos.setPreferredSize(dimension);
        informations.setLayout(new BorderLayout());

        informations.add(center, BorderLayout.CENTER);
        informations.add(infos, BorderLayout.EAST);
        informations.add(poster, BorderLayout.WEST);

        this.add(informations, BorderLayout.NORTH);

        
        this.add(synopsis, BorderLayout.CENTER);

        noteComment.setBackground(Color.yellow);
        this.add(noteComment, BorderLayout.SOUTH); 
    }
    public void refresh(Film film) throws MalformedURLException, IOException
    {
        Dimension dimension = new Dimension();
        dimension.height = 280;
        dimension.width = 300;
        
        informations = new JPanel();
        infos = new JPanel();
        noteComment = new JPanel();
        
        titre = new JLabel(film.getTitle()+" ( "+film.getOriginalTitle()+" )");
        annee = new JLabel(Integer.toString(film.getReleaseYear()));
        realisateur = new JLabel("Realisateur : "+film.getDirector());
        genre = new JLabel("Genre : "+film.getGenre());
        pays = new JLabel("Pays : "+film.getCountry());
        synopsis = new JTextArea("Synopsis : "+film.getSynopsis());
        synopsis.setLineWrap(true);
        synopsis.setWrapStyleWord(true);
        acteurs = new JPanel();
        poster = new JLabel();
        center = new JPanel();
        
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
        infos.add(pays);


        infos.setBackground(Color.white);
        center.setBackground(Color.white);
        
        infos.setPreferredSize(dimension);
        informations.setLayout(new BorderLayout());

        informations.add(center, BorderLayout.CENTER);
        informations.add(infos, BorderLayout.EAST);
        informations.add(poster, BorderLayout.WEST);

        this.add(informations, BorderLayout.NORTH);

       
        this.add(synopsis, BorderLayout.CENTER);

        noteComment.setBackground(Color.yellow);
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
        infos = new JPanel();
        noteComment = new JPanel();
        
        titre = new JLabel(film.getTitle()+" ( "+film.getOriginalTitle()+" )");
        annee = new JLabel(Integer.toString(film.getReleaseYear()));
        realisateur = new JLabel("Realisateur : "+film.getDirector());
        genre = new JLabel("Genre : "+film.getGenre());
        pays = new JLabel("Pays : "+film.getCountry());
        synopsis = new JTextArea("Synopsis : "+film.getSynopsis());
        synopsis.setWrapStyleWord(true);
        acteurs = new JPanel();
        poster = new JLabel();
        center = new JPanel();
        
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
        infos.add(pays);


        infos.setBackground(Color.white);
        center.setBackground(Color.white);
        
        infos.setPreferredSize(dimension);
        informations.setLayout(new BorderLayout());

        informations.add(center, BorderLayout.CENTER);
        informations.add(infos, BorderLayout.EAST);
        informations.add(poster, BorderLayout.WEST);

        this.add(informations, BorderLayout.NORTH);

        
        this.add(synopsis, BorderLayout.CENTER);

        noteComment.setBackground(Color.yellow);
        this.add(noteComment, BorderLayout.SOUTH); 
                
    }
   
    public FicheFilmPanel() throws MalformedURLException, IOException
    {
                
                
                informations = new JPanel();
                infos = new JPanel();
                noteComment = new JPanel();
                synopsis = new JTextArea("Synopsis :");
                note = new JLabel("note : ");
                comment = new JLabel("Comment : ");
                titre = new JLabel("Titre : ");
                annee = new JLabel("Annee : ");
                realisateur = new JLabel("Realisateur : ");
                genre = new JLabel("Genre : ");
                pays = new JLabel("Pays");
                acteurs = new JPanel();
                poster = new JLabel();
                center = new JPanel();
                
                //ficheFilm.setBackground(Color.white);
                URL url = new URL("http://d3gtl9l2a4fn1j.cloudfront.net/t/p/w185/doKQhNr0kQzxsR7Tboem3Jb3Q0X.jpg");
                BufferedImage img = ImageIO.read(url);
			
		poster.setIcon(new ImageIcon(img));
                        
                this.setLayout(new BorderLayout());
                infos.setLayout(new GridLayout(6,1));
                
                infos.add(titre);
                infos.add(annee);
                infos.add(realisateur);
                infos.add(genre);
                infos.add(pays);
                
                
                infos.setBackground(Color.white);
                center.setBackground(Color.white);
                poster.setBackground(Color.yellow);
                Dimension dimension = new Dimension();
                dimension.height = 280;
                dimension.width = 300;
                infos.setPreferredSize(dimension);
                informations.setLayout(new BorderLayout());
                
                informations.add(center, BorderLayout.CENTER);
                informations.add(infos, BorderLayout.EAST);
                informations.add(poster, BorderLayout.WEST);
                
                this.add(informations, BorderLayout.NORTH);
                
                
                this.add(synopsis, BorderLayout.CENTER);
                
                noteComment.setBackground(Color.yellow);
                this.add(noteComment, BorderLayout.SOUTH);
    }

    
    
}
