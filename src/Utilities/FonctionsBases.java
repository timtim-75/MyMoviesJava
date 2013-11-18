/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;


import fr.ece.MyMovies.Model.TempFilm;
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
    
    
    
    
    
    
    
    public static ArrayList<String> getFilmsID(String response)
    {
        String s;
        s = response.toString();
        
        
        String[] answers;
        String[] infos = null;
        ArrayList<String[]> allInfos = new ArrayList<String[]>();
        
        ArrayList<String> ids = new ArrayList<>();
       
        answers = s.split("[}]+");
        System.out.println("Reponse : "+response);
        for(int i=0; i<answers.length; i++)
        {
            infos = answers[i].split("[,]+");
            //System.out.println("Answers : "+answers[i]);
            allInfos.add(infos);
        }
        for(String [] i : allInfos)
        {
            for(int j=0; j<i.length;j++)
            {
               if(i[j].matches("\"id(.*)"))
                {
                     String[] split= i[j].split("[:]+");
                     split[1] = split[1].replace('\"', ' ');
                     split[1] = split[1].trim();
                     ids.add(split[1]);
                     //System.out.println(ids);
                }
            }
        }
        
        return ids;
    }
    
    public static ArrayList<Film> parseJSON(ArrayList<String> responses, int filmID, String filePath, String fileName )
    {   
        
        ArrayList<Film> tempFilms = new ArrayList<Film>();
        Film tmpFilm;

        
            
        for(String s : responses)
        {
            tmpFilm = new Film();
            
            tmpFilm.setFilePath(filePath);
            tmpFilm.setFileName(fileName);
            tmpFilm.setFilmID(filmID);
            String[] getGenres = s.split("(:\\[)+");
            int count = 0;
            for(int i=0; i<getGenres.length; i++)
            {
                
                System.out.println("TEST : "+getGenres[i]);
                if(getGenres[i].matches("\\{\"id(.*)") && !getGenres[i].matches(("(.*)character(.*)"))&& !getGenres[i].matches("(.*)job(.*)"))
                {
                    //System.out.println(getGenres[i]);
                    String[] cut = getGenres[i].split("\\]");
                    String[] genres =cut[0].split(",");
                    for(int j=0; j<genres.length;j++)
                    {
                        if(genres[j].matches("(.*)name(.*)") )
                        {
                            genres[j]=genres[j].replace("\"name\":","");
                            genres[j]=genres[j].replace("\"","");
                            genres[j]=genres[j].replace("}","");
                            
                            System.out.println(genres[j]);
                        }
                        else genres[j]="";
                    }
                    String genre = genres[1];
                    for(int l=2;l<genres.length;l++)
                    {
                        if(!genres[l].isEmpty())
                        genre = genre+", "+genres[l];
                    }
                    tmpFilm.setGenre(genre);
                    System.out.println("Genre : "+genre);
                }
            }
            
            String[] getCast = s.split("(:\\[)+");
            for(int i=0; i<getCast.length; i++)
            {
                
                System.out.println("TEST : "+getCast[i]);
                if(getCast[i].matches("\\{\"id(.*)") && getCast[i].matches(("(.*)character(.*)"))&& !getCast[i].matches("(.*)job(.*)"))
                {
                    //System.out.println(getGenres[i]);
                    String[] cut = getCast[i].split("\\]");
                    String[] cast =cut[0].split(",");
                    for(int j=0; j<cast.length;j++)
                    {
                        if(cast[j].matches("(.*)name(.*)") )
                        {
                            cast[j]=cast[j].replace("\"name\":","");
                            cast[j]=cast[j].replace("\"","");
                            cast[j]=cast[j].replace("}","");
                            
                            System.out.println(cast[j]);
                        }
                        else cast[j]="";
                    }
                    String casting = cast[1];
                    for(int l=2;l<cast.length;l++)
                    {
                        if(!cast[l].isEmpty())
                        casting = casting+", "+cast[l];
                    }
                    tmpFilm.setActors(casting);
                    System.out.println("Cast : "+casting);
                }
            }
            
            String[] getDirector = s.split("(:\\[)+");
            for(int i=0; i<getDirector.length; i++)
            {
                
                System.out.println("TEST : "+getDirector[i]);
                if(getDirector[i].matches("\\{\"id(.*)") && !getDirector[i].matches(("(.*)character(.*)"))&& getDirector[i].matches("(.*)job(.*)"))
                {
                    //System.out.println(getGenres[i]);
                    String[] cut = getDirector[i].split("\\},\\{");
                    for(int j=0; j<cut.length; j++)
                    {
                        if(cut[j].matches("(.*)\"Director\"(.*)"))
                        {
                            String[] director = cut[j].split(",");
                            for(int k=0;k<director.length; k++)
                            {
                                if(director[k].matches("(.*)name(.*)"))
                                {
                                    director[k] = director[k].replace("\"name\":", "");
                                    director[k] = director[k].replace("\"", "");
                                    tmpFilm.setDirector(director[k]); 
                                }
                                
                            }
                        }    
                                    
                                
                        
                    }
                }
            }
            
            String[] infos = s.split("(,\")+");
            
            for(int i=0; i<infos.length;i++)
            {
                //System.out.println(infos[i]);
                if(infos[i].matches("title(.*)"))
                {
                     String[] split= infos[i].split("[:]+");
                     split[1] = split[1].replace('\"', ' ');
                     split[1] = split[1].trim();
                     tmpFilm.setTitle(split[1]);
                     //System.out.println("Titre : "+tmpFilm.getTitle());  
                }
                
                else if(infos[i].matches("original_title(.*)"))
                {
                     String[] split= infos[i].split("[:]+");
                     split[1] = split[1].replace('\"', ' ');
                     split[1] = split[1].trim();
                     tmpFilm.setOriginalTitle((split[1]));
                     //System.out.println("Titre Original : "+tmpFilm.getOriginalTitle());
                }
                else if(infos[i].matches("release_date(.*)"))
                {
                     String[] split= infos[i].split("[:]+");
                     String[] date = split[1].split("[-]+");
                     date[0] = date[0].replace('\"', ' ');
                     date[0] = date[0].trim();
                     
                     if(!date[0].equalsIgnoreCase(""))
                     {
                        
                        tmpFilm.setReleaseYear(Integer.parseInt(date[0]));
                        //System.out.println("Annee : "+tmpFilm.getReleaseYear());
                     }
                     else tmpFilm.setReleaseYear(-1);
                }
                else if(infos[i].matches("overview(.*)"))
                {
                    
                     String[] split= infos[i].split("[\":\"]+");
                     if(!split[1].equalsIgnoreCase("null"))
                     {
                        split[1] = split[1].replace('\"', ' ');
                        split[1] = split[1].trim();
                     }
                     else split[1] = "Pas de Synopsis disponible pour ce film";
                     
                     tmpFilm.setSynopsis(split[1]);
                     //System.out.println("Synopsis : "+tmpFilm.getSynopsis());
                }
                
                else if(infos[i].matches("poster_path(.*)"))
                {
                     String[] split= infos[i].split("[:]+");
                     split[1] = split[1].replace('\"', ' ');
                     split[1] = split[1].trim();
                     tmpFilm.setPoster((split[1]));
                     //System.out.println("Poster : "+tmpFilm.getPoster());
                }
            }
            tempFilms.add(tmpFilm);
        }
        return tempFilms;
    }
    
    
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
                if(decoupe[j].matches(".*\\d"))
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
        //System.out.println(filmTitle);
        
        
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
    
    public static String replaceSRT(String s)
    {
        System.out.println(s);
        s=s.replace("mp4", "srt");
        s=s.replace("avi", "srt");
        s=s.replace("mov", "srt");
        s=s.replace("mkv", "srt");
        System.out.println(s);
        return s;
        
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
    
    public static Film underscoreAllString(Film film)
    {
        film.setActors(film.getActors().replace(' ', '_'));
        film.setComments(film.getComments().replace(' ', '_'));
        film.setCountry(film.getCountry().replace(' ', '_'));
        film.setDirector(film.getDirector().replace(' ', '_'));
        film.setFileName(film.getFileName().replace(' ', '_'));
        film.setGenre(film.getGenre().replace(' ', '_'));
        film.setOriginalTitle(film.getOriginalTitle().replace(' ', '_'));
        film.setPoster(film.getPoster().replace(' ', '_'));
        film.setSynopsis(film.getSynopsis().replace(' ', '_'));
        film.setTitle(film.getTitle().replace(' ', '_'));
        return film;
    }
    
    public static Film spaceAllString(Film film)
    {
        film.setActors(film.getActors().replace('_', ' '));
        film.setComments(film.getComments().replace('_', ' '));
        film.setCountry(film.getCountry().replace('_', ' '));
        film.setDirector(film.getDirector().replace('_', ' '));
        film.setFileName(film.getFileName().replace('_', ' '));
        film.setGenre(film.getGenre().replace('_', ' '));
        film.setOriginalTitle(film.getOriginalTitle().replace('_', ' '));
        film.setPoster(film.getPoster().replace('_', ' '));
        film.setSynopsis(film.getSynopsis().replace('_', ' '));
        film.setTitle(film.getTitle().replace('_', ' '));
        return film;
    }
    
    
    
    
    
}
