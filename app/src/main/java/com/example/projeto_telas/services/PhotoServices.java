package com.example.projeto_telas.services;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projeto_telas.Models.Photo;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class PhotoServices {
    private static final String URL = "https://jsonplaceholder.typicode.com/photos";

    private static final String TAG = "PhotoServices";
    private List<Photo> photos;
    private Context context;
    private boolean ready = false;


    //singleton instance
    private static PhotoServices instance;

    //implementação do singleton
    private PhotoServices(Context context){
        this.context = context;
        this.photos = new ArrayList<>();
        initialLoad();
    }

    //metodo para obter a instancia

    public static PhotoServices getInstance(Context context){
        if(instance == null){
            instance = new PhotoServices(context);
        }
        return instance;
    }

    //segundo método para obter a instancia

    public static PhotoServices getInstance() throws RuntimeException{
        if(instance == null){
            throw new RuntimeException("Não foi possível obter a instância do PhotoServices, É necessário chamar o método getInstance(Context) antes.");
        }
        return instance;
    }

    public boolean isReady(){
        return ready;
    }

    public List<Photo> getPhoto() {
        //To-do implementar lista imutavel ou de cópias
        return photos;
    }

    public Photo getPhoto(int id){
        //utilizando método stream

        return photos.stream().filter(album -> album.getId() == id).findFirst().orElse(null);
    }

    private void initialLoad() {
        // cria a fila de requisições http feitas pelo Volley
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrRequest = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        Log.d("Response", jsonArray.toString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                photos.add(new Photo(jsonArray.getJSONObject(i)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        Log.d("Photo", "dentro do initialLoad: " + photos.size());
                        ready = true;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("Error", volleyError.toString());
            }

        });
        // adiciona a requisição na fila para ser executada
        queue.add(jsonArrRequest);
    }
}
