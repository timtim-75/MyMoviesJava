/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.sql.*;
import fr.ece.MyMovies.Model.Film;
import fr.ece.MyMovies.Model.Serie;
import java.util.ArrayList;
import org.sqlite.JDBC;
/**
 *
 * @author timotheegrosjean
 */
public class SQLite {
    static Connection con;
    static Statement st;
    static ResultSet rs;

    //Constructeur
    public static void CreateTable() {
    
        try{
                Class.forName("org.sqlite.JDBC");
               
                con = DriverManager.getConnection("jdbc:sqlite:"+FonctionsBases.getDBPath());
                con.setAutoCommit(true);
                st = con.createStatement();

                
                int execute = st.executeUpdate("CREATE TABLE IF NOT EXISTS movies (id INTEGER PRIMARY KEY,title TEXT, originalTitle TEXT , releaseYear INTEGER, filePath TEXT, fileName TEXT, duration  INTEGER, genre TEXT,country TEXT,director TEXT, actors TEXT, synopsis TEXT,  poster BLOB, grade INTEGER, comment TEXT );");
                int execute1 = st.executeUpdate("CREATE TABLE IF NOT EXISTS series (id INTEGER PRIMARY KEY,title TEXT, originalTitle TEXT , releaseYear INTEGER, filePath TEXT, fileName TEXT, duration  INTEGER, genre TEXT,country TEXT,director TEXT, actors TEXT, synopsis TEXT,  poster BLOB, grade INTEGER, comment TEXT, season INTEGER, episode INTEGER );");

                System.out.println(execute);
                System.out.println(execute1);

                
                con.close();
        }
        catch(Exception e){
        System.out.println("DB ERROR: "+e);
        }
    }
    
    
    public static void addFilm(Film film) 
    {
        try{
                Class.forName("org.sqlite.JDBC");
                //chargement du driver
                con = DriverManager.getConnection("jdbc:sqlite:"+FonctionsBases.getDBPath());
                con.setAutoCommit(true);
                st = con.createStatement();
                film.setTitle(film.getTitle().replace(' ', '_')); 
                //System.out.println(film.getTitle());
                int execute = st.executeUpdate("INSERT INTO movies(id,title,originalTitle,releaseYear, filePath, fileName, duration, genre, country, director, actors, synopsis, poster, grade, comment ) VALUES (\'"+film.getFilmID()+"\',\'"+film.getTitle()+"\',\'"+film.getOriginalTitle()+"\',\'"+film.getReleaseYear()+"\',\'"+film.getFilePath()+"\',\'"+film.getFileName()+"\',\'"+film.getDuration()+"\',\'"+film.getGenre()+"\',\'"+film.getCountry()+"\',\'"+film.getDirector()+"\',\'"+film.getActors()+"\',\'"+film.getSynopsis()+"\',\'"+film.getPoster()+"\',\'"+film.getGrade()+"\',\'"+film.getComments()+"\')");

        }
        catch(Exception e){
        System.out.println("DB ERROR: "+e);
        }
    }
    
    
    public static void addSerie(Serie serie)
    {
        try{
                Class.forName("org.sqlite.JDBC");
                //chargement du driver
                con = DriverManager.getConnection("jdbc:sqlite:"+FonctionsBases.getDBPath());
                con.setAutoCommit(true);
                st = con.createStatement();
                serie.setTitle(serie.getTitle().replace(' ', '_'));
                //System.out.println(serie.getTitle());
                String query = "INSERT INTO series(id,title,originalTitle,releaseYear, filePath, fileName, duration, genre, country, director, actors, synopsis, poster, grade, comment, season, episode ) VALUES (\'"+serie.getFilmID()+"\',\'"+serie.getTitle()+"\',\'"+serie.getOriginalTitle()+"\',\'"+serie.getReleaseYear()+"\',\'"+serie.getFilePath()+"\',\'"+serie.getFileName()+"\',\'"+serie.getDuration()+"\',\'"+serie.getGenre()+"\',\'"+serie.getCountry()+"\',\'"+serie.getDirector()+"\',\'"+serie.getActors()+"\',\'"+serie.getSynopsis()+"\',\'"+serie.getPoster()+"\',\'"+serie.getGrade()+"\',\'"+serie.getComments()+"\',\'"+serie.getSeason()+"\',\'"+serie.getEpisode()+"\')";
                int execute = st.executeUpdate(query);
                //System.out.println(query);

        }
        catch(Exception e){
        System.out.println("DB ERROR: "+e);
        }
    }
    
    public static void deleteFilmFromDB(int id)
    {
        try{
                Class.forName("org.sqlite.JDBC");
                //chargement du driver
                con = DriverManager.getConnection("jdbc:sqlite:"+FonctionsBases.getDBPath());

                con.setAutoCommit(true);

                st = con.createStatement();
                int execute = st.executeUpdate("DELETE FROM movies WHERE id="+id+"");
        
        }
        catch(Exception e){
        System.out.println("DB ERROR: "+e);
        }
    }
    
    public static void deleteSerieFromDB (int id)
    {
        try{
                Class.forName("org.sqlite.JDBC");
                //chargement du driver
                con = DriverManager.getConnection("jdbc:sqlite:"+FonctionsBases.getDBPath());

                con.setAutoCommit(true);

                st = con.createStatement();
                int execute = st.executeUpdate("DELETE FROM series WHERE id="+id+"");
        
        }
        catch(Exception e){
        System.out.println("DB ERROR: "+e);
        }
    }
    
    public static ArrayList<Film> getFilmsFromDB()
    {
        ArrayList<Film> filmsFromDB = new ArrayList<>();
        
        Film film = new Film();
        Statement stmt = null;
        
        try{
            
                Class.forName("org.sqlite.JDBC");
                //chargement du driver
                con = DriverManager.getConnection("jdbc:sqlite:"+FonctionsBases.getDBPath());
                con.setAutoCommit(true);
                st = con.createStatement();
                con.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM movies;" );
                while ( rs.next() ) {


                   int id = rs.getInt("id");
                   String title = rs.getString("title");
                   String originalTitle = rs.getString("originalTitle");
                   int releaseYear = rs.getInt("releaseYear");
                   String path = rs.getString("filePath");
                   String fileName = rs.getString("fileName");
                   int duration = rs.getInt("duration");
                   String genre = rs.getString(("genre"));
                   String country = rs.getString("country");
                   String director = rs.getString("director");
                   String actors = rs.getString("actors");
                   String synopsis = rs.getString("synopsis");
                   String poster = rs.getString("poster");
                   int grade = rs.getInt("grade");
                   String comments = rs.getString("comment");
                   
                   title = title.replace('_', ' ');
                   originalTitle = originalTitle.replace('_', ' ');
                   path = path.replace('_', ' ');
                   fileName = fileName.replace('_', ' ');
                   genre = genre.replace('_', ' ');
                   country = country.replace('_', ' ');
                   director = director.replace('_', ' ');
                   actors = actors.replace('_', ' ');
                   synopsis = synopsis.replace('_', ' ');
                   synopsis = synopsis.replace('+', '\'');
                   poster = poster.replace('_', ' ');
                   comments = comments.replace('_', ' ');
                   
                   

                   filmsFromDB.add(new Film(id, title, originalTitle, releaseYear,duration,  path, fileName,  genre, country, director, actors, synopsis, poster, grade, comments));
                }
                rs.close();
                stmt.close();
                con.close();
            }
        catch(Exception e){
        System.out.println("DB ERROR: "+e);
        }
        return filmsFromDB;
        
    }
    
    public static ArrayList<Serie> getSeriesFromDB()
    {
        //System.out.println("Ca bomberde pas");
        ArrayList<Serie> seriesFromDB = new ArrayList<Serie>();
        
        Statement stmt = null;
        
        try{
            
                Class.forName("org.sqlite.JDBC");
                //chargement du driver
                con = DriverManager.getConnection("jdbc:sqlite:"+FonctionsBases.getDBPath());
                con.setAutoCommit(true);
                st = con.createStatement();
                con.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM series;" );
                int i=0;
                while ( rs.next() ) 
                {

                   int id = rs.getInt("id");
                   String title = rs.getString("title");
                   String originalTitle = rs.getString("originalTitle");
                   int releaseYear = rs.getInt("releaseYear");
                   String path = rs.getString("filePath");
                   String fileName = rs.getString("fileName");
                   int duration = rs.getInt("duration");
                   int season = rs.getInt("season");
                   int episode = rs.getInt("episode");
                   String genre = rs.getString("genre");
                   String country = rs.getString("country");
                   String synopsis = rs.getString("synopsis");
                   String director = rs.getString("director");
                   String actors = rs.getString("actors");
                   String poster = rs.getString("poster");
                   int grade = rs.getInt("grade");
                   String comments = rs.getString("comment");
                   
                   title = title.replace('_', ' ');
                   originalTitle = originalTitle.replace('_', ' ');
                   path = path.replace('_', ' ');
                   fileName = fileName.replace('_', ' ');
                   genre = genre.replace('_', ' ');
                   country = country.replace('_', ' ');
                   director = director.replace('_', ' ');
                   actors = actors.replace('_', ' ');
                   synopsis = synopsis.replace('_', ' ');
                   synopsis = synopsis.replace('+', '\'');
                   poster = poster.replace('_', ' ');
                   comments = comments.replace('_', ' ');
                   
                   seriesFromDB.add(new Serie(id, title, originalTitle, releaseYear,duration,  path, fileName,  genre, country, director, actors, synopsis, poster, grade, comments, season, episode));


                }
                rs.close();
                stmt.close();
                con.close();



            }
        catch(Exception e){
        System.out.println("DB ERROR: "+e);
        }
        return seriesFromDB;
    }
    
    SQLite(){
        
    }
}
