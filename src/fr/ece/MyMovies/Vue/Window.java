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
                panel.setLayout(new BorderLayout());
                
                JPanel menuNord = new JPanel();
                menuNord.add(new JButton("my First JButton"));
                menuNord.add(new JButton("my Second JButton"));
                menuNord.add(new JButton("my Third JButton"));
                this.add(panel);
                panel.add(menuNord,BorderLayout.NORTH);
       
    }
    
}
