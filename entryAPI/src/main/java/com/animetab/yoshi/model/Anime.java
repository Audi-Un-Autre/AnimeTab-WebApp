/*
    anime model


    ????   Future   ????
    -> Preview videos
*/

package com.animetab.yoshi.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "anime")
public class Anime extends Entry{
    
    @Column(name = "seasons")
    private int seasons;

    @Column(name = "episodes")
    private int episodes;

    @Column(name = "ova_count")
    private int ovaCount;

    @Column(name = "ova_exists")
    private boolean ovaExists;

    // Video trailer field

    public Anime(){}

    public Anime(String title, String authorFirstName, String authorLastName){
        super(title, authorFirstName, authorLastName);
    }

    // *******     GET    ********

    public int getSeasons(){
        return seasons;
    }

    public int getEpisodes(){
        return episodes;
    }

    public int getOvaCount(){
        return ovaCount;
    }

    public boolean getOvaExists(){
        return ovaExists;
    }

    // *********   SET   **********

    public void setSeasons(int seasons){
        this.seasons = seasons;
    }

    public void setEpisodes(int episodes){
        this.episodes = episodes;
    }

    public void setOvaCount(int ovaCount){
        this.ovaCount = ovaCount;
    }

    public void setOvaExists(boolean ovaExists){
        this.ovaExists = ovaExists;
    }
}
