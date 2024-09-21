package com.example.projeto_telas.Models;

import org.json.JSONObject;

public class Album {
    private int userId;
    private int id;
    private String title;


    public Album(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public Album(JSONObject json) {
        this.title = "";
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
    }
}
