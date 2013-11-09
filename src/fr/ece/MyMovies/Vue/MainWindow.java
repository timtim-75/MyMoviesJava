/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Vue;

import fr.ece.MyMovies.Model.SeriesModelTab;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.TableColumn;


/**
 *
 * @author timotheegrosjean
 */
public class MainWindow extends JFrame{
    
    private SeriesModelTab modele;
    
    private JButton ajout;
    private JButton suppression;
    
    private JTable tableau;
    
    public MainWindow(SeriesModelTab myModel){
	super();
        modele = myModel;
        build();
	}

    private void build(){
		this.setTitle("MyMovies"); //On donne un titre à l'application
		this.setSize(800,600); //On donne une taille à notre fenêtre
		this.setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		this.setResizable(true) ; //On interdit la redimensionnement de la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer
                
                JPanel panel = new JPanel();
                JPanel panel1 = new JPanel();
                panel.setLayout(new BorderLayout());
                panel1.setLayout(new GridLayout(3,1));
                JTextField searchZone = new JTextField(15);
                
                
                JPanel menuNord = new JPanel();
                JPanel boutons = new JPanel();
                JPanel search = new JPanel();
                menuNord.setLayout(new GridLayout(1,2));
         
                ajout = new JButton("Ajout");
                boutons.add(ajout);
                suppression = new JButton("Supprimer");
                boutons.add(suppression);
                boutons.add(new JButton("my Third JButton"));
                search.add(searchZone); 
                menuNord.add(boutons);
                menuNord.add(search);
                
                
                JPanel menuOuest = new JPanel();
                
                panel1.add(new JButton("Zblerf"));
                panel1.add(new JButton("Zdebler"));
                panel1.add(new JButton("mui"));
                menuOuest.add(panel1);
                
                menuOuest.setBackground(Color.red);
                menuNord.setBackground(Color.blue);
                panel.setBackground(Color.black);
 
                tableau = new JTable(modele);
                
                panel.add(new JScrollPane(tableau),BorderLayout.CENTER);
                
                panel.add(menuOuest,BorderLayout.WEST);
                panel.add(menuNord,BorderLayout.NORTH);
                
                this.add(panel);
    }
    
    public void registerAjoutButtonListener(ActionListener l){
        System.out.println("Ca register en masse");
        ajout.addActionListener(l);
    }
    
    
    public void registerRemoveButtonListener(ActionListener l){
        System.out.println("Ca register toujours tahu");
        suppression.addActionListener(l);
    }
    public int[] getTabSelectedRows(){
        
        return tableau.getSelectedRows();
    }
    
}
