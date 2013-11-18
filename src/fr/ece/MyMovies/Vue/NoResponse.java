/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ece.MyMovies.Vue;

import fr.ece.MyMovies.Model.InfosSelectionModelTab;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author timotheegrosjean
 */
public class NoResponse extends JFrame{
    
    private JFrame frame;
   
    public NoResponse()
    {
    
    JFrame frame = new JFrame();
    JOptionPane.showMessageDialog(frame,
    "\t\tAucune informations sur ce film. \n\n\nVous pourrez ajouter les informations manuellement.",
    "",
    JOptionPane.WARNING_MESSAGE);
    }
    
}
