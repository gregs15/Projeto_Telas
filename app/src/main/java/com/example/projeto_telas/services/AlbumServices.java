package com.example.projeto_telas.services;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projeto_telas.Models.Album;



import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class AlbumServices {
    private static final String URL = "https://jsonplaceholder.typicode.com/albums";

    private static final String TAG = "AlbumServices";
    private List<Album> albumns;
    private Context context;
    private boolean ready = false;


    //singleton instance
    private static AlbumServices instance;

    //implementação do singleton
    private AlbumServices(Context context){
        this.context = context;
        this.albumns = new ArrayList<>();
        initialLoad();
    }

    //metodo para obter a instancia

    public static AlbumServices getInstance(Context context){
        if(instance == null){
            instance = new AlbumServices(context);
        }
        return instance;
    }

    //segundo método para obter a instancia

    public static AlbumServices getInstance() throws RuntimeException{
        if(instance == null){
            throw new RuntimeException("Não foi possível obter a instância do AlbumServices, É necessário chamar o método getInstance(Context) antes.");
        }
        return instance;
    }

    public boolean isReady(){
        return ready;
    }

    public List<Album> getAlbumn() {
        //To-do implementar lista imutavel ou de cópias
        return albumns;
    }

    public Album getAlbum(int id){
        //utilizando método stream

        return albumns.stream().filter(album -> album.getId() == id).findFirst().orElse(null);
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
                                albumns.add(new Album(jsonArray.getJSONObject(i)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        Log.d("Album", "dentro do initialLoad: " + albumns.size());
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
