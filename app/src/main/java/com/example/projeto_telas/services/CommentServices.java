package com.example.projeto_telas.services;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.example.projeto_telas.Models.Comment;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class CommentServices {
    private static final String URL = "https://jsonplaceholder.typicode.com/comments";

    private static final String TAG = "CommentServices";
    private List<Comment> comments;
    private Context context;
    private boolean ready = false;


    //singleton instance
    private static CommentServices instance;

    //implementação do singleton
    private CommentServices(Context context){
        this.context = context;
        this.comments = new ArrayList<>();
        initialLoad();
    }

    //metodo para obter a instancia

    public static CommentServices getInstance(Context context){
        if(instance == null){
            instance = new CommentServices(context);
        }
        return instance;
    }

    //segundo método para obter a instancia

    public static CommentServices getInstance() throws RuntimeException{
        if(instance == null){
            throw new RuntimeException("Não foi possível obter a instância do CommentServices, É necessário chamar o método getInstance(Context) antes.");
        }
        return instance;
    }

    public boolean isReady(){
        return ready;
    }

    public List<Comment> getComments() {
        //To-do implementar lista imutavel ou de cópias
        return comments;
    }

    public Comment getComments(int id){
        //utilizando método stream

        return comments.stream().filter(album -> album.getId() == id).findFirst().orElse(null);
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
                                comments.add(new Comment(jsonArray.getJSONObject(i)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        Log.d("Comment", "dentro do initialLoad: " + comments.size());
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
