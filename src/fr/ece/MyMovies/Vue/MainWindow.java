/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Vue;

import fr.ece.MyMovies.Model.AllFilms;
import fr.ece.MyMovies.Model.Film;
import fr.ece.MyMovies.Model.FilmsModelTab;
import fr.ece.MyMovies.Model.Serie;
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
import java.util.ArrayList;
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
    private FicheSeriePanel ficheSeriesModele;
    private JTable tableauSeries;
    private JTable tableauFilms;
    
    //Fiche Film
    private JTabbedPane ficheFilmTab;
    private JTabbedPane ficheSerieTab;
    private JPanel ficheVide;
    private JPanel ficheFilmPanel;
    private JPanel ficheSeriePanel;
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
        ficheSeriesModele = new FicheSeriePanel();
        
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
                /*tableauSeries.setAutoCreateRowSorter(true);
                tableauFilms.setAutoCreateRowSorter(true);*/
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

                
                //Fiches
                ficheFilmTab = new JTabbedPane();
                ficheSerieTab = new JTabbedPane();
                ficheFilmPanel = ficheFilmsModele;
                ficheSeriePanel = ficheSeriesModele;
                ficheFilmTab.addTab("Fiche",ficheFilmPanel);
                ficheSerieTab.addTab("Fiche", ficheSeriePanel);
                ficheFilmTab.setVisible(false);
                ficheSerieTab.setVisible(false);
                
                
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
        
                
        //ficheFilmTab.addTab("Fiche",ficheFilmPanel);
        ficheFilmsModele.refresh(filmsModele.getFilms().get(tableauFilms.getSelectedRow()));
        ficheFilmsModele.revalidate();
        ficheSerieTab.setVisible(false);
        ficheFilmTab.setVisible(true);
        fond.add(ficheFilmTab, BorderLayout.EAST);
        sousTitres.setEnabled(true);
        sousTitres.revalidate();
        play.setEnabled(true);
        play.revalidate();
        suppression.setEnabled(true);
        suppression.revalidate();
        
        
    }
    
    public void refreshInfoSerie() throws MalformedURLException, IOException
    {
       System.out.println(seriesModele.getSeries().get(tableauSeries.getSelectedRow()));
       int[] rows = tableauSeries.getSelectedRows();
       ArrayList<Serie> s = seriesModele.getSeries();
       Serie ser = s.get(rows[0]);
       
       System.out.println(ser.getTitle());
       ficheSeriesModele.refresh(ser);
       
       ficheSerieTab.setVisible(true);
       ficheFilmTab.setVisible(false);
       fond.add(ficheSerieTab,BorderLayout.EAST);
       ficheSeriesModele.revalidate();
       sousTitres.setEnabled(true);
       sousTitres.revalidate();
       play.setEnabled(true);
       play.revalidate();
       suppression.setEnabled(true);
       suppression.revalidate();
       
       //ficheSerieTab.addTab("Fiche", ficheSeriePanel);
    }
    
    public void createInfoSerie() throws MalformedURLException, IOException
    {
        //ficheSeriePanel = ficheSeriesModele;
        
        ficheSeriesModele.create(seriesModele.getSeries().get(seriesModele.getSeries().size()-1));
        ficheSeriesModele.revalidate();
        
    }
   
    public void createInfoFilm() throws MalformedURLException, IOException
    {
        
        ficheFilmTab.setVisible(true);
        ficheSerieTab.setVisible(false);
        ficheFilmsModele.create(filmsModele.getFilms().get(filmsModele.getFilms().size()-1));
        ficheFilmsModele.revalidate();
        
    }
    
    public void start() throws MalformedURLException, IOException
    {
        ficheFilmsModele = new FicheFilmPanel();
    }
    
    
    
}
