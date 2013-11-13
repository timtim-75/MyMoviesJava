/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import fr.ece.MyMovies.Model.Film;
import fr.ece.MyMovies.Model.Serie;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author timotheegrosjean
 */
public class FonctionsBases {
    
    static String interdit[] = {"YIFY", "x264", "1080p", "720p", "bluray", "brrip", "dvdrip","r5","srt", "extended", "cut", "director", "gaz", "axxo", "[www","Cpasbien","me]","unrated","limited","xvid-sparks","xvid-fwd", "ac3-314r", "dvdr","r4","dvdscr","TS", "ntsc","french","xvid-qcp", "mp4","avi","mkv","mov","mpg","mpa","wma","vob", }; 
    static String dbPath="/Users/timotheegrosjean/Desktop/films.db";
    static File pathDatas;
    static String defaultPlayer = "/Applications/VLC.app/Contents/MacOS/VLC ";
    static String defaultDirectory = " /Users/timotheegrosjean/Desktop/MyMovies";
    
    
    public static void moveFile(String path, String newName) throws IOException
    {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("mv "+path+defaultDirectory);
    }
    
    public static String getDefaultDirectory()
    {
        return defaultDirectory;
    }
    public static void makeDirectory() throws IOException
    {
        if(!new File (defaultDirectory).exists())
        {
            new File(defaultDirectory).mkdir();
        }
    }
    public static String getDefaultPlayer()
    {
        return defaultPlayer; 
    }
    
    public static void setDefaultPlayer(String defaultPlayer1)
    {
        defaultPlayer = defaultPlayer1;
    }
    public static String getDBPath()
    {
        return dbPath;
    }
    
    public static void setDBPath(String dbPath1)
    {
        dbPath = dbPath1;
    }
    
    public static File getPathDatas()
    {
        return pathDatas;
    }
    
    public static void setPathDatas(File pathDatas1)
    {
        pathDatas= pathDatas1;
    }
    
    public static String reTitleFilm(String fileName)
    {
        String filmTitle = "";
        fileName = fileName.replace(' ','.');
 
        String[] decoupe = fileName.split("[.]+");

        for(int i=0; i <interdit.length; i++)
        {
            for(int j=0; j < decoupe.length; j++)
            {

                if(decoupe[j].equalsIgnoreCase(interdit[i]) == true)
                {
                    decoupe[j]="";
                }   
            }
        }
        String newName = decoupe[0];
        for(int i=1; i<decoupe.length;i++)
        {
            if(decoupe[i].equalsIgnoreCase("") == false)
            newName=newName+"."+decoupe[i];
        }
        
        filmTitle = newName.replace('.',' ');
        filmTitle = filmTitle.trim();
        
        
        return filmTitle;
    }
    
    
    public static ObjectSerie reTitleSerie(String fileName)
    {
        ObjectSerie info= new ObjectSerie();
        
        String[] decoupe = fileName.split(("[.]+"));
        
        for(int i=1;i< decoupe.length;i++)
        {
            if(decoupe[i-1].matches(".*[sS]\\d+[eE]\\d+.*") || decoupe[i-1].matches(".*\\d+[xX]\\d+.*"))
            {
                
                decoupe[i-1]= decoupe[i-1].toLowerCase();
                if(decoupe[i-1].matches(".*[sS]\\d+[eE]\\d+.*"))
                {
                    String[] s_e = decoupe[i-1].split("e");
                    String[] s = s_e[0].split("s");
                    s_e[0]=s[1];
                    info.season = Integer.parseInt(s_e[0]);
                    info.episode = Integer.parseInt(s_e[1]);
                    System.out.println(info.season+" "+info.episode);
                    
                }
                else if(decoupe[i-1].matches(".*\\d+[xX]\\d+.*"))
                {
                    String[] s_e = decoupe[i-1].split("x");
                    info.season = Integer.parseInt(s_e[0]);
                    info.episode = Integer.parseInt(s_e[1]);
                    System.out.println(info.season+" "+info.episode);
                    
                }
                    
                
                for(int j=i-1;j<decoupe.length;j++)
                {
                    decoupe[j] = "";
                }
            }
        }
        
        String newName = decoupe[0];
        for(int i=1; i<decoupe.length;i++)
        {
            if(decoupe[i].equalsIgnoreCase("") == false)
            newName = newName+"."+decoupe[i];
        }
        info.name=newName.replace('.', ' ');
        System.out.println(info.name);
        return info;
    }
    
    public static void removeFilmFromArrayList(ArrayList<Film> list, int id)
    {
        Film filmToDelete = null;
        for(Film f : list){
            if(f.getFilmID() == id) filmToDelete = f;
        }
        if(filmToDelete != null) list.remove(filmToDelete);
    }
    
    public static void removeSerieFromArrayList(ArrayList<Serie> list, int id)
    {
        Serie serieToDelete = null;
        for(Serie s : list){
            if(s.getFilmID() == id) serieToDelete = s;
        }
        if(serieToDelete != null) list.remove(serieToDelete);
    }
    
    
    
    public static boolean isFilm(String fileName)
    {
        boolean answer=true;
        
        if(fileName.matches(".*[sS]\\d+[eE]\\d+.*"))
            answer=false;
        else if(fileName.matches(".*\\d+[xX]\\d+.*"))
            answer=false;

        return answer;
    }
    
    
    
    
    
}
