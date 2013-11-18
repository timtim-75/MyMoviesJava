/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Vue;

import fr.ece.MyMovies.Model.AllFilms;
import fr.ece.MyMovies.Model.Film;
import fr.ece.MyMovies.Model.FilmsModelTab;
import fr.ece.MyMovies.Model.SeriesModelTab;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableColumn;


/**
 *
 * @author timotheegrosjean
 */
public class MainWindow extends JFrame{
    
    
    
    //Organisation fenêtre
    private JPanel fond;
    private JPanel barreMenu;
    
    
    
    //Onglets & Tableaux
    private JTabbedPane tabs;
    private JPanel panelFilms;
    private JPanel panelSeries;
    private SeriesModelTab seriesModele;
    private FilmsModelTab filmsModele;
    private FicheFilmPanel ficheFilmsModele;
    private JTable tableauSeries;
    private JTable tableauFilms;
    
    //Fiche Film
    private JTabbedPane ficheFilmTab;
    private JPanel ficheFilmPanel;
    private JPanel informations;
    private JPanel infos;
    private JPanel noteComment;
    private JLabel synopsis;
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
    
    
    
    //Boutons
    private JPanel boutons;
    private JButton ajout;
    private JButton suppression;
    private JButton sousTitres;
    private JButton play;
    
    //Zone de recherche
    private JPanel search;
    private JTextField searchZone;
    
    
    
    public MainWindow(AllFilms bibliotheque) throws MalformedURLException, IOException{
	super();
        seriesModele = bibliotheque.getSerietheque();
        filmsModele = bibliotheque.getFilmotheque();
        ficheFilmsModele = new FicheFilmPanel();
        
        build();
	}

    private void build() throws MalformedURLException, IOException{
        
		this.setTitle("MyMovies"); //On donne un titre à l'application
		this.setSize(1000,600); //On donne une taille à notre fenêtre
		this.setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		this.setResizable(true) ; //On autorise la redimensionnement de la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer
                
                
                // Onglets & Tableaux
                tabs = new JTabbedPane();
                panelFilms = new JPanel();
                panelSeries = new JPanel();
                panelFilms.setLayout(new BorderLayout());
                panelSeries.setLayout(new BorderLayout());
                tableauSeries = new JTable(seriesModele);
                tableauFilms = new JTable(filmsModele);
                panelFilms.add(new JScrollPane(tableauFilms),BorderLayout.CENTER);
                panelSeries.add(new JScrollPane(tableauSeries), BorderLayout.CENTER);
                
                tabs.addTab("Films", panelFilms);
                tabs.setMnemonicAt(0, KeyEvent.VK_1);
                tabs.addTab("Series", panelSeries);
                tabs.setMnemonicAt(1, KeyEvent.VK_2);
                
                
                //Zone de recherche
                search = new JPanel();
                searchZone = new JTextField(10);
                search.add(searchZone);

                ficheFilmTab = new JTabbedPane();
                
                
                //ficheFilmPanel = new JPanel();
                
                ficheFilmPanel = ficheFilmsModele;
                ficheFilmPanel.revalidate();
                ficheFilmTab.addTab("FicheFilm",ficheFilmPanel);
                ficheFilmTab.repaint();
                
                
                
               /* //Fiche Film
                ficheFilmTab = new JTabbedPane();
                ficheFilmPanel = new JPanel();
                ficheFilmTab.addTab("FicheFilm",ficheFilmPanel );
                informations = new JPanel();
                infos = new JPanel();
                noteComment = new JPanel();
                synopsis = new JLabel("Synopsis :");
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
                URL url = new URL("http://d3gtl9l2a4fn1j.cloudfront.net/t/p/w185//h9nvVfX1r4XUTGS9bbSkVulpqQ0.jpg");
                BufferedImage img = ImageIO.read(url);
			
		poster.setIcon(new ImageIcon(img));
                        
                ficheFilmPanel.setLayout(new BorderLayout());
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
                
                ficheFilmPanel.add(informations, BorderLayout.NORTH);
                
                synopsis.setBackground(Color.blue);
                ficheFilmPanel.add(synopsis, BorderLayout.CENTER);
                
                noteComment.setBackground(Color.yellow);
                ficheFilmPanel.add(noteComment, BorderLayout.SOUTH);*/
                        
                
                // Boutons
                boutons = new JPanel();
                ajout = new JButton("Ajout");
                suppression = new JButton("Supprimer");
                sousTitres = new JButton("Lier des Sous-Titres");
                play = new JButton("Lancer la vidéo");
                
                sousTitres.setEnabled(false);
                play.setEnabled(false);
                suppression.setEnabled(false);
                
                boutons.add(ajout);
                boutons.add(suppression);
                boutons.add(sousTitres);
                boutons.add(play);

                //Organisation fenêtre
                fond = new JPanel();
                barreMenu = new JPanel();
   
                barreMenu.add(boutons);
                barreMenu.add(search);

                
                fond.setLayout(new BorderLayout()); 
                fond.add(barreMenu,BorderLayout.NORTH);
                fond.add(tabs, BorderLayout.WEST);
                fond.add(ficheFilmTab, BorderLayout.EAST);
                
                this.add(fond);
                
                this.setVisible(true);
               
    }
    
    public void registerAjoutButtonListener(ActionListener l){
        //System.out.println("Ca register en masse");
        ajout.addActionListener(l);
    }
    
    public void registerRemoveButtonListener(ActionListener l){
        //System.out.println("Ca register toujours tahu");
        suppression.addActionListener(l);
    }
    
    public void registerSousTitresButtonListener(ActionListener l){
        //System.out.println("Ca register encore ma gueule");
        sousTitres.addActionListener(l); 
    }
    
    public void registerPlayButtonListener(ActionListener l){
        //System.out.println("Ca register encore et toujours");
        play.addActionListener(l);
    }
    
    public void registerSelectionRowFilmActionListener(MouseAdapter l)
    {
        tableauFilms.addMouseListener(l);
    }
    
    public void registerSelectionRowSerieActionListener(MouseAdapter l)
    {
        tableauSeries.addMouseListener(l);
    }
    
    public int[] getTabFilmsSelectedRows(){
        
        return tableauFilms.getSelectedRows();
    }
    
    public int[] getTabSeriesSelectedRows(){
        
        return tableauSeries.getSelectedRows();
    }
    
    public int getSelectedTab(){
        return tabs.getSelectedIndex();
    }
    
    public void refreshInfoFilm() throws MalformedURLException, IOException
    {
        
        ficheFilmsModele.refresh(filmsModele.getFilms().get(tableauFilms.getSelectedRow()));
        ficheFilmsModele.revalidate();
        sousTitres.setEnabled(true);
        sousTitres.revalidate();
        play.setEnabled(true);
        play.revalidate();
        suppression.setEnabled(true);
        suppression.revalidate();
        
    }
   
    public void createInfoFilm() throws MalformedURLException, IOException
    {
        ficheFilmsModele.create(filmsModele.getFilms().get(0));
        ficheFilmsModele.revalidate();
    }
    
}
