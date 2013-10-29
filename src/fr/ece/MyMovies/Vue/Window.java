/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Vue;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author timotheegrosjean
 */
public class Window extends JFrame{
    
    public Window(){
	super();
        build();
	}

    private void build(){
		this.setTitle("Ma première application"); //On donne un titre à l'application
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
         
                boutons.add(new JButton(new Actions("my First JButton")));
                boutons.add(new JButton("my Second JButton"));
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
                
                panel.add(menuOuest,BorderLayout.WEST);
                panel.add(menuNord,BorderLayout.NORTH);
                this.add(panel);
    }
    
}
