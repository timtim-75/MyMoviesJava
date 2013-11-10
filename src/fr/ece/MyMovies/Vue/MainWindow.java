/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Vue;

import fr.ece.MyMovies.Model.FilmsModelTab;
import fr.ece.MyMovies.Model.SeriesModelTab;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
    private JTable tableauSeries;
    private JTable tableauFilms;
    
    //Boutons
    private JPanel boutons;
    private JButton ajout;
    private JButton suppression;
    private JButton sousTitres;
    private JButton play;
    
    //Zone de recherche
    private JPanel search;
    private JTextField searchZone;
    
    
    
    public MainWindow(SeriesModelTab mySeriesModele, FilmsModelTab myFilmsModele){
	super();
        seriesModele = mySeriesModele;
        filmsModele = myFilmsModele;
        build();
	}

    private void build(){
        
		this.setTitle("MyMovies"); //On donne un titre à l'application
		this.setSize(800,600); //On donne une taille à notre fenêtre
		this.setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		this.setResizable(true) ; //On interdit la redimensionnement de la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer
                
                
                // Onglets & Tableaux
                tabs = new JTabbedPane();
                panelFilms = new JPanel();
                panelSeries = new JPanel();
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

                
                
                // Boutons
                boutons = new JPanel();
                ajout = new JButton("Ajout");
                suppression = new JButton("Supprimer");
                sousTitres = new JButton("Lier des Sous-Titres");
                play = new JButton("Lancer la vidéo");
                
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
                fond.setBackground(Color.black);
                fond.add(tabs, BorderLayout.CENTER);
                fond.add(barreMenu,BorderLayout.NORTH);
                
                this.add(fond);
    }
    
    public void registerAjoutButtonListener(ActionListener l){
        System.out.println("Ca register en masse");
        ajout.addActionListener(l);
    }
    
    public void registerRemoveButtonListener(ActionListener l){
        System.out.println("Ca register toujours tahu");
        suppression.addActionListener(l);
    }
    
    public void registerSousTitresButtonListener(ActionListener l){
        System.out.println("Ca register encore ma gueule");
        sousTitres.addActionListener(l); 
    }
    
    public void registerPlayButtonListener(ActionListener l){
        System.out.println("Ca register encore et toujours");
        play.addActionListener(l);
    }
    
    public int[] getTabFilmsSelectedRows(){
        
        return tableauFilms.getSelectedRows();
    }
    
    public int[] getTabSeriesSelectedRows(){
        
        return tableauSeries.getSelectedRows();
    }
    
    
    
}
