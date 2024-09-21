package com.example.projeto_telas.services;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projeto_telas.Models.ToDos;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ToDosServices {
    private static final String URL = "https://jsonplaceholder.typicode.com/todos";

    private static final String TAG = "ToDosServices";
    private List<ToDos> toDos;
    private Context context;
    private boolean ready = false;
    //
    // Singleton instance
    private static ToDosServices instance;


    // Implementação do Singleton
    //tornar construtor privado
    private ToDosServices(Context context) {
        this.context = context;
        this.toDos = new ArrayList<>();
        initialLoad();
    }

    //método para obter a instância
    public static ToDosServices getInstance(Context context) {
        if (instance == null) {
            instance = new ToDosServices(context);
        }
        return instance;
    }

    //segundo método para obter a instância
    public static ToDosServices getInstance() throws RuntimeException{
        if (instance == null) {
            throw new RuntimeException("Não foi possível obter a instância de ToDosServices. É necessário chamar o método getInstance(Context) antes.");
        }
        return instance;
    }
    public boolean isReady() {
        return ready;
    }
    public List<ToDos> getToDos() {
        // To-do: implementar lista imutável ou de cópias
        return toDos;
    }
    public ToDos getToDos(int id) {
       return toDos.stream().filter(post -> post.getId() == id).findFirst().orElse(null);

    }
    private void initialLoad() {
        // cria a fila de requisições http feitas pelo Volley
        RequestQueue queue = Volley.newRequestQueue(context);
        // cria a requisição
        // uma requisição precisa de endereço (URL),
        // um listener de sucesso e
        // um listener de erro

        JsonArrayRequest jsonArrRequest = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        Log.d("Response", jsonArray.toString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                toDos.add(new ToDos(jsonArray.getJSONObject(i)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        Log.d("ToDos", "dentro do initialLoad: " + toDos.size());
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
