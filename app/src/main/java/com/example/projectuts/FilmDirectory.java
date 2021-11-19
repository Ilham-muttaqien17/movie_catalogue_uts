package com.example.projectuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FilmDirectory extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Film> films;

    private static String API_FILM = "https://api.jsonbin.io/b/618dd6084a56fb3dee0da690";
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_directory);

        recyclerView = findViewById(R.id.recycler_film);
        films = new ArrayList<>();

        getFilm();
    }

    private void getFilm(){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, API_FILM, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("results");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        Film film = new Film();
                        film.setTitle(jsonObject.getString("title").toString());
                        film.setSynopsis(jsonObject.getString("overview").toString());
                        film.setReleaseDate(jsonObject.getString("release_date").toString());
                        film.setCoverImage(jsonObject.getString("poster_path"));
                        film.setRate(jsonObject.getString("vote_average").toString());
                        film.setLanguage(jsonObject.getString("original_language").toString());

                        films.add(film);
                    }
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    adapter = new Adapter(getApplicationContext(), films);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(request);
    }
}