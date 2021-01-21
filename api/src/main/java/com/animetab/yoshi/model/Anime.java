/*
    anime model
*/

package com.animetab.yoshi.model;

import javax.persistence.Table;

@Table(name = "anime")
public class Anime extends Entry{
    private int seasons;

    public Anime(){}

    public Anime(String title, String authorFirstName, String authorLastName){
        super(title, authorFirstName, authorLastName);
    }

    public int getSeasons(){
        return seasons;
    }
}
