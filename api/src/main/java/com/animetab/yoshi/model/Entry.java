/*
    abstract model will extend to:
        anime
        manga
        manwha
        comic
        other
*/
package com.animetab.yoshi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entry")
public class Entry {

    @Id
    @Column(name = "entry_id")
    long id;

    @Column(name = "title")
    String title;

    @Column(name = "author_first_name")
    String authorFirstName;

    @Column(name = "author_last_name")
    String authorLastName;

    public Entry(){}
    
    public Entry(String title, String authorFirstName, String authorLastName){
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }

    public long getId(){
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
}
