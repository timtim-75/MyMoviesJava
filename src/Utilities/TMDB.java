/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author timotheegrosjean
 */
public class TMDB {
    
    //apiKey
    static String tmdb = "http://api.themoviedb.org/3/";
    static String apiKey = "?api_key=194d36d0fbb5e0db1b04fd0ffe4fff1c";
    static String query = "&query=";
    static String language = "&language=fr";
    static String userAgent = "Safari/7.0";
    
    //Image
    static String image = "http://d3gtl9l2a4fn1j.cloudfront.net/t/p/";
    static String width = "w185";
    
    //Film
    static String movie = "movie/";
    static String searchMovie = "search/movie";
    static String cast = "&append_to_response=casts";
    
    //Serie
    static String searchSerie = "search/tv";
    static String serie = "tv/";
    static String season = "/season/";
    static String episode = "/episode/";
    static String credits = "&append_to_response=credits";
    
    
    public static String getAPIKey()
    {
        return apiKey;
    }
    
    public static void setAPIKey(String apiKey1)
    {
        apiKey = apiKey1;
    }
    
    public static String getTMDB()
    {
        return tmdb;
    }
    
    public static void setTMDB(String tmdb1)
    {
        tmdb= tmdb1;
    }
    
    public static String getQuery()
    {
        return query;
    }
    
    public static void setQuery(String query1)
    {
        query = query1;
    }
    
    public static String getLanguage()
    {
        return language;
    }
    
    public static void setLAnguage(String language1)
    {
        language = language1;
    }
    
    public static String makeFilmSearchQuery(String keyWords)
    {
        String completeQuery="";
        keyWords = keyWords.replace(' ', '+');
        //System.out.println(keyWords);
        
        completeQuery = tmdb+ searchMovie + apiKey + query + keyWords + language;
        
        //System.out.println(completeQuery);

        return completeQuery;
        
    }
    
    public static String makeSerieSearchQuery( String keyWords)
    {
        System.out.println(keyWords);
        String completeQuery = "";
        
        keyWords = keyWords.replace(' ','+');
        
        completeQuery = tmdb + searchSerie + apiKey + query + keyWords + language;
        
        System.out.println(completeQuery);
        
        return completeQuery;
        
    }
    
    public static ArrayList<String> makeFilmIDSQuery(ArrayList<String> ids)
    {
        
        ArrayList<String> idsURL = new ArrayList<>();
        
        for(String s:ids)
        {
            idsURL.add(tmdb + movie+ s + apiKey+ cast + language );
        }
        //System.out.println(idsURL);
        return idsURL;
    }
    
    public static ArrayList<String> makeSerieIDSQuery(ArrayList<String> ids)
    {
        ArrayList<String> idsURL = new ArrayList<>();
        
        for(String s:ids)
        {
            idsURL.add(tmdb+ serie+ s + apiKey+ credits + language);
        }
        System.out.println(idsURL);
        return idsURL;
    }
    
    
    public static ArrayList<String> sendIDSQuery(ArrayList<String> idsURL ) throws MalformedURLException, IOException
    {
        ArrayList<String> responses = new ArrayList<>();
        
        for(String s : idsURL)
        {
            System.out.println(s);
            URL obj = new URL(s);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", userAgent);
            
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + s);
            System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
                responses.add( response.toString());
                System.out.println(responses);

                
        }
        return responses;
    }
    
    public static String sendQuery(String url) throws MalformedURLException, IOException
    {
       
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", userAgent);
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
                return response.toString();
 
	}
    
    public static String makePosterQuery(String posterPath)
    {
        String poster="";
        if(!posterPath.matches("(.*)ripplewerkz(.*)"))
        {
            poster = image + width + posterPath;
        }
        else poster = posterPath;
        
        return poster;
    }
}
    
    
    

