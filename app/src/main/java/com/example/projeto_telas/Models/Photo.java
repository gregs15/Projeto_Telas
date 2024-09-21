package com.example.projeto_telas.Models;

import org.json.JSONObject;

public class Photo {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;


    public Photo(int albumId, int id, String title, String url, String thumbnailUrl){
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }


    public void setAlbumId( int albumId ) {
        this.albumId = albumId;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public void setUrl( String url ) {
        this.url = url;
    }

    public void setThumbnailUrl( String thumbnailUrl ) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Photo(JSONObject json) {
        this.title = "";
        this.url = "";
        this.thumbnailUrl = "";
        try {
            this.albumId = json.getInt("albumId");
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
            this.url = json.getString("url");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.thumbnailUrl = json.getString("thumbnailUrl");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
