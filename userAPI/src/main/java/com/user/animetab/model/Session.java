package com.user.animetab.model;

public class Session {

    private int response;
    private String message;
    private String token;

    public Session(int response, String message, String token){
        this.response = response;
        this.message = message;
        this.token = token;
    }

    public Session(int response, String message){
        this.response = response;
        this.message = message;
    }

    public int getResponse(){
        return this.response;
    }

    public String getMessage(){
        return this.message;
    }

    public String getToken(){
        return this.token;
    }

}
