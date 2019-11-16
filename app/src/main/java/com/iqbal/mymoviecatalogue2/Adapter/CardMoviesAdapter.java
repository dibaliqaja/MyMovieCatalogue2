package com.iqbal.mymoviecatalogue2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iqbal.mymoviecatalogue2.MovieDetailActivity;
import com.iqbal.mymoviecatalogue2.Movies;
import com.iqbal.mymoviecatalogue2.R;

import java.util.ArrayList;

public class CardMoviesAdapter extends RecyclerView.Adapter<CardMoviesAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Movies> listMovies;

    public ArrayList<Movies> getListMovies() {
        return listMovies;
    }

    public void setListMovies(ArrayList<Movies> listMovies) {
        this.listMovies = listMovies;
    }

    public CardMoviesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardMoviesAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_movies, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardMoviesAdapter.CardViewViewHolder cardViewViewHolder, int i) {
        Movies movie = getListMovies().get(i);
        Glide.with(context)
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(cardViewViewHolder.imgPhoto);

        cardViewViewHolder.tvTitle.setText(movie.getTitle());
        cardViewViewHolder.tvDate.setText(movie.getDate());
        cardViewViewHolder.tvScore.setText(movie.getScore());
        cardViewViewHolder.tvRuntime.setText(movie.getRuntime());
        cardViewViewHolder.tvLanguage.setText(movie.getLanguage());
    }

    @Override
    public int getItemCount() {
        return getListMovies().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgPhoto;
        TextView tvTitle, tvDate, tvScore, tvRuntime, tvLanguage;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDate = itemView.findViewById(R.id.tv_item_released);
            tvScore = itemView.findViewById(R.id.tv_item_score);
            tvRuntime = itemView.findViewById(R.id.tv_item_runtime);
            tvLanguage = itemView.findViewById(R.id.tv_item_lang);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int i = getAdapterPosition();
            Movies movie = getListMovies().get(i);

            movie.setTitle(movie.getTitle());
            movie.setOverview(movie.getOverview());

            Intent moveWithObjectIntent = new Intent(itemView.getContext(), MovieDetailActivity.class);
            moveWithObjectIntent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie);
            context.startActivity(moveWithObjectIntent);
        }
    }
}
