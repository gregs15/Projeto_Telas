package com.example.projeto_telas.Models;
import org.json.JSONObject;

public class ToDos {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public ToDos(int userId, int id, String title, boolean completed){
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;

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

    public boolean getCompleted() {
        return completed;
    }

    public void setUserId( int userId ) {
        this.userId = userId;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public void setCompleted( boolean completed ) {
        this.completed = completed;
    }

    public ToDos(JSONObject json) {
        this.title = "";
        this.completed = false;
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
            this.completed = json.getBoolean("completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
