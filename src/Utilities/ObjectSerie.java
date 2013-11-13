/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author timotheegrosjean
 */
public class ObjectSerie {
    
    int id;
    String name;
    int season;
    int episode;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name1)
    {
        name=name1;
    }
    
    public int getSeason()
    {
        return season;
    }
    
    public void setSeason(int season1)
    {
        season=season1;
    }
    
    public int getEpisode()
    {
        return episode;
    }
    
    public void setEpisode(int episode1)
    {
        episode=episode1;
    }
    
    public int getID()
    {
        return id;
    }
    
    public void setID(int id1)
    {
        id=id1;
    }
}
