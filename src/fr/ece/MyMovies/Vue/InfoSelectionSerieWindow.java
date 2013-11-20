/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Vue;

import fr.ece.MyMovies.Model.InfosSelectionFilmModelTab;
import fr.ece.MyMovies.Model.InfosSelectionSerieModelTab;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author timotheegrosjean
 */
public class InfoSelectionSerieWindow extends JFrame{
    private JPanel fond;
    private JTable tableau;
    private JButton choisir;
    private JPanel buttons;
    private InfosSelectionSerieModelTab infoSelectionModele;
    
    public InfoSelectionSerieWindow(InfosSelectionSerieModelTab infoSelectionModele1)
    {
        infoSelectionModele = infoSelectionModele1;
        
        build();
        
    }
    
    private void build()
    {
        this.setTitle("Choisissez votre Serie"); //On donne un titre à l'application
        this.setSize(800,300); //On donne une taille à notre fenêtre
        this.setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        this.setResizable(true) ; //On autorise la redimensionnement de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer
        
        
        fond = new JPanel();
        buttons = new JPanel();
        tableau = new JTable(infoSelectionModele);
        choisir = new JButton("Choisir");

        buttons.add(choisir);
        fond.setLayout(new BorderLayout());
        
        fond.add(buttons, BorderLayout.SOUTH);
        fond.add(new JScrollPane(tableau),BorderLayout.CENTER);
        
        this.add(fond);

    }
    
    public void registerChoisirButtonListener(ActionListener e)
    {
        choisir.addActionListener(e);
    }

    public int[] getSelectedRows(){
        
        return tableau.getSelectedRows();
    }
}
