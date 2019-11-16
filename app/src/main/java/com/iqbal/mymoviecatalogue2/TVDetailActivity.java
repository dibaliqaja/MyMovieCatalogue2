package com.iqbal.mymoviecatalogue2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class TVDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TV_SHOW = "extra_tv_show";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvdetail);

        TextView tvTitle, tvScore, tvRuntime, tvCrew, tvGenre, tvOverview;
        ImageView imagePoster;

        tvTitle = findViewById(R.id.tv_item_title);
        tvScore = findViewById(R.id.tv_item_score);
        tvRuntime = findViewById(R.id.tv_item_runtime);
        tvCrew = findViewById(R.id.tv_item_crew);
        tvGenre = findViewById(R.id.tv_item_genre);
        tvOverview = findViewById(R.id.tv_overview);
        imagePoster = findViewById(R.id.img_item_photo);

        TVShow tvShow = getIntent().getParcelableExtra(EXTRA_TV_SHOW);

        tvTitle.setText(tvShow.getTitle());
        tvScore.setText(tvShow.getScore());
        tvRuntime.setText(tvShow.getRuntime());
        tvCrew.setText(tvShow.getCrew());
        tvGenre.setText(tvShow.getGenre());
        tvOverview.setText(tvShow.getOverview());
        Glide.with(this)
                .load(tvShow.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(imagePoster);

    }
}
