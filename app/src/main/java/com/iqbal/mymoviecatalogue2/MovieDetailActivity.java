package com.iqbal.mymoviecatalogue2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        TextView tvTitle, tvScore, tvRuntime, tvBudget, tvGenre, tvOverview;
        ImageView imagePoster;

        tvTitle = findViewById(R.id.tv_item_title);
        tvScore = findViewById(R.id.tv_item_score);
        tvRuntime = findViewById(R.id.tv_item_runtime);
        tvBudget = findViewById(R.id.tv_item_budget);
        tvGenre = findViewById(R.id.tv_item_genre);
        tvOverview = findViewById(R.id.tv_overview);
        imagePoster = findViewById(R.id.img_item_photo);

        Movies movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        tvTitle.setText(movie.getTitle());
        tvScore.setText(movie.getScore());
        tvRuntime.setText(movie.getRuntime());
        tvBudget.setText(movie.getBudget());
        tvGenre.setText(movie.getGenre());
        tvOverview.setText(movie.getOverview());

        Glide.with(this)
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(imagePoster);
    }
}
