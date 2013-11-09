/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.sql.*;
import fr.ece.MyMovies.Model.Film;
import org.sqlite.JDBC;
/**
 *
 * @author timotheegrosjean
 */
public class SQLite {
    static  Connection con;
    static Statement st;
    static ResultSet rs;
    static String dbPath;
 
    
    
    
    /** Creation d'une vouvelle instance SQLite */
    public SQLite(String dbpath) {
    // driver to load
        try{
            
        
        Class.forName("org.sqlite.JDBC");
        //chargement du driver
        con = DriverManager.getConnection("jdbc:sqlite:"+dbpath);
 
        con.setAutoCommit(true);
 
        st = con.createStatement();
 
        //resultat
        int execute = st.executeUpdate("CREATE TABLE IF NOT EXISTS movies (id INTEGER PRIMARY KEY,title TEXT, originalTitle TEXT , releaseYear INTEGER, duration  INTEGER, genre TEXT,country TEXT,director TEXT, actors TEXT, synopsis TEXT,  poster BLOB, grade INTEGER, comment TEXT );");
        int execute1 = st.executeUpdate("CREATE TABLE IF NOT EXISTS series (id INTEGER PRIMARY KEY,title TEXT, originalTitle TEXT , releaseYear INTEGER, duration  INTEGER, genre TEXT,country TEXT,director TEXT, actors TEXT, synopsis TEXT,  poster BLOB, grade INTEGER, comment TEXT, season INTEGER, episode INTEGER );");
        
        System.out.println(execute);
        System.out.println(execute1);
 
        //fermeture de la connection
        con.close();
        }
        catch(Exception e){
        System.out.println("DB ERROR: "+e);
        }
    }
    
    
    public static void addFilm(String dbPath, String name) 
    {
        try{
        Class.forName("org.sqlite.JDBC");
        //chargement du driver
        con = DriverManager.getConnection("jdbc:sqlite:"+dbPath);
 
        con.setAutoCommit(true);
 
        st = con.createStatement();
        name = name.replace(' ', '_');
        
        System.out.println(name);
        
        int execute = st.executeUpdate("INSERT INTO movies(title) VALUES WHERE NOT EXISTS(\'"+name+"\')");
        
        }
        catch(Exception e){
        System.out.println("DB ERROR: "+e);
        }
    }
    
    
    public static void addSerie(String dbPath, ObjectSerie serie)
    {
        try{
        Class.forName("org.sqlite.JDBC");
        //chargement du driver
        con = DriverManager.getConnection("jdbc:sqlite:"+dbPath);
 
        con.setAutoCommit(true);
 
        st = con.createStatement();
        serie.name = serie.name.replace(' ', '_');
        
        System.out.println(serie.name);
        
        
        
        int execute = st.executeUpdate("INSERT INTO series(title, season, episode) VALUES(\'"+serie.name+"\',\'"+serie.season+"\',\'"+serie.episode+"\')");
        
        }
        catch(Exception e){
        System.out.println("DB ERROR: "+e);
        }
    }
    
    public static void deleteFilm(Film currentFilm)
    {
        try{
        Class.forName("org.sqlite.JDBC");
        //chargement du driver
        con = DriverManager.getConnection("jdbc:sqlite:"+dbPath);
 
        con.setAutoCommit(true);
 
        st = con.createStatement();
        int execute = st.executeUpdate("DELETE FROM movies WHERE id="+currentFilm.getFilmID()+"");
        
        }
        catch(Exception e){
        System.out.println("DB ERROR: "+e);
        }
    }
}
