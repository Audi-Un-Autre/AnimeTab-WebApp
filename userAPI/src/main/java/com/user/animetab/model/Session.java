package com.user.animetab.model;

public class Session {

    private int response;
    private String message;
    private final String jwt;

    public Session(int response, String message, String jwt){
        this.response = response;
        this.message = message;
        this.jwt = jwt;
    }

    public int getResponse(){
        return this.response;
    }

    public String getMessage(){
        return this.message;
    }

    public String getToken(){
        return this.jwt;
    }

}
