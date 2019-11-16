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
import com.iqbal.mymoviecatalogue2.R;
import com.iqbal.mymoviecatalogue2.TVDetailActivity;
import com.iqbal.mymoviecatalogue2.TVShow;

import java.util.ArrayList;

public class CardTVAdapter extends RecyclerView.Adapter<CardTVAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<TVShow> listTVShow;

    public CardTVAdapter(Context context) {
        this.context = context;
    }

    public void setListTVShow(ArrayList<TVShow> listTVShow) {
        this.listTVShow = listTVShow;
    }

    public ArrayList<TVShow> getListTVShow() {
        return listTVShow;
    }

    @NonNull
    @Override
    public CardTVAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_tv, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTVAdapter.CardViewViewHolder cardViewViewHolder, int i) {
        TVShow tvShow = getListTVShow().get(i);
        Glide.with(context)
                .load(tvShow.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);

        cardViewViewHolder.tvTitle.setText(tvShow.getTitle());
        cardViewViewHolder.tvDate.setText(tvShow.getDate());
        cardViewViewHolder.tvScore.setText(tvShow.getScore());
        cardViewViewHolder.tvRuntime.setText(tvShow.getRuntime());
        cardViewViewHolder.tvLanguage.setText(tvShow.getLanguage());

    }

    @Override
    public int getItemCount() {
        return getListTVShow().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imgPhoto;
        TextView tvTitle, tvDate, tvRuntime, tvScore, tvLanguage;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDate = itemView.findViewById(R.id.tv_item_date);
            tvScore = itemView.findViewById(R.id.tv_item_score);
            tvRuntime = itemView.findViewById(R.id.tv_item_runtime);
            tvLanguage = itemView.findViewById(R.id.tv_item_lang);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int i = getAdapterPosition();
            TVShow tvShow = getListTVShow().get(i);

            tvShow.setTitle(tvShow.getTitle());
            tvShow.setOverview(tvShow.getOverview());

            Intent moveWithObjectIntent = new Intent(itemView.getContext(), TVDetailActivity.class);
            moveWithObjectIntent.putExtra(TVDetailActivity.EXTRA_TV_SHOW, tvShow);
            context.startActivity(moveWithObjectIntent);
        }
    }
}
