package com.example.projeto_telas.Models;
import org.json.JSONObject;

public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;


    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }


    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Post(JSONObject json) {
        this.title = "";
        this.body = "";
        try {
            this.userId = json.getInt("userId");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.id = json.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.title = json.getString("title");
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
