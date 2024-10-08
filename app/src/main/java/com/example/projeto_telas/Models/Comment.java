package com.example.projeto_telas.Models;

import org.json.JSONObject;

public class Comment {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;


    public Comment(int postId, int id, String name, String email, String body){
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }



    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }



    public void setPostId( int postId ) {
        this.postId = postId;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public void setBody( String body ) {
        this.body = body;
    }

    public Comment(JSONObject json) {
        this.name = "";
        this.email = "";
        this.body = "";
        try {
            this.postId = json.getInt("postId");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.id = json.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.name = json.getString("name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.email = json.getString("email");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.body = json.getString("body");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
