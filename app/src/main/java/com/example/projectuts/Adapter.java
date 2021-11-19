package com.example.projectuts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Film> film;
    Context context;

    public Adapter(Context context, List<Film> film) {
        this.context = context;
        this.film = film;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(film.get(position).getTitle());
        holder.synopsis.setText(film.get(position).getSynopsis());
        holder.release_date.setText(film.get(position).getReleaseDate());
        Picasso.get().load(film.get(position).getCoverImage()).into(holder.coverImage);

        //
        holder.film_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailFilm.class);
                intent.putExtra("title", film.get(position).getTitle());
                intent.putExtra("synopsis", film.get(position).getSynopsis());
                intent.putExtra("release_date", film.get(position).getReleaseDate());
                intent.putExtra("cover_film", film.get(position).getCoverImage());
                intent.putExtra("rate", film.get(position).getRate());
                intent.putExtra("lang", film.get(position).getLanguage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return film.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView synopsis;
        TextView release_date;
        ImageView coverImage;
        LinearLayout film_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            synopsis = itemView.findViewById(R.id.txtSynopsis);
            release_date = itemView.findViewById(R.id.txtReleaseDate);
            coverImage = itemView.findViewById(R.id.coverImg);
            film_layout = itemView.findViewById(R.id.layout_film);
        }
    }
}
