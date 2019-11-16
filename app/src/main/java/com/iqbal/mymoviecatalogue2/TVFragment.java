package com.iqbal.mymoviecatalogue2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iqbal.mymoviecatalogue2.Adapter.CardTVAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVFragment extends Fragment {

    private RecyclerView rvTV;
    private ArrayList<TVShow> list = new ArrayList<>();

    public TVFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv, container, false);
        rvTV = view.findViewById(R.id.rv_tv);
        rvTV.setHasFixedSize(true);

        list.addAll(TVShowData.getListData());
        showRecyclerTV();

        return view;
    }

    private void showRecyclerTV() {
        rvTV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        CardTVAdapter cardTVAdapter = new CardTVAdapter(this.getContext());
        cardTVAdapter.setListTVShow(list);
        rvTV.setAdapter(cardTVAdapter);
    }

}
