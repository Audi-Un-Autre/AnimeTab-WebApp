/*
    abstract model will extend to:
        anime
        manga
        manwha
        comic
        other


    !!!!    Needed Updates   !!!!
    -> IMAGE serviced via Glacier
*/
package com.animetab.yoshi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entry")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id")
    int id;

    @Column(name = "title")
    String title;

    @Column(name = "author_first_name")
    String authorFirstName;

    @Column(name = "author_last_name")
    String authorLastName;

    @Column(name = "year")
    int year;

    @Column(name = "medium")
    String medium;

    public Entry(){}
    
    public Entry(String title, String authorFirstName, String authorLastName){
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }

    // *******     GET    ********

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthorFirstName(){
        return authorFirstName;
    }

    public String getAuthorLastName(){
        return authorLastName;
    }

    public int getYear(){
        return year;
    }

    public String getMedium(){
        return medium;
    }

    // *********   SET   **********

    public void setId(int id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthorFirstName(String authorFirstName){
        this.authorFirstName = authorFirstName;
    }

    public void setAuthorLastName(String authorLastName){
        this.authorLastName = authorLastName;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setMedium(String medium){
        this.medium = medium;
    }
}
