package com.example.projectuts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailFilm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("title") && getIntent().hasExtra("synopsis")){

            String filmTitle = getIntent().getStringExtra("title");
            String filmSynopsis = getIntent().getStringExtra("synopsis");
            String filmReleaseDate = getIntent().getStringExtra("release_date");
            String filmCoverImage = getIntent().getStringExtra("cover_film");
            String filmRate = getIntent().getStringExtra("rate");
            String filmLanguage = getIntent().getStringExtra("lang");

            setFilm(filmTitle, filmSynopsis, filmReleaseDate, filmCoverImage, filmRate, filmLanguage);
        }
    }

    private void setFilm(String filmTitle, String filmSynopsis, String filmReleaseDate, String filmCoverImage, String filmRate, String filmLanguage){
        TextView title = findViewById(R.id.title_film);
        TextView synopsis = findViewById(R.id.synopsis_film);
        TextView release_date = findViewById(R.id.release_date);
        ImageView cover_image = findViewById(R.id.cover_film);
        TextView rate = findViewById(R.id.rate_film);
        TextView lang = findViewById(R.id.language_film);

        title.setText(filmTitle);
        synopsis.setText(filmSynopsis);
        release_date.setText(filmReleaseDate);
        Picasso.get().load(filmCoverImage).into(cover_image);
        rate.setText(filmRate);
        lang.setText(filmLanguage);
    }
}