package com.xalam.movietvshowrepo.tvshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xalam.movietvshowrepo.R;
import com.xalam.movietvshowrepo.viewmodel.ViewModelFactory;

public class TvShowFragment extends Fragment {

    private RecyclerView rvTvShow;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvTvShow = view.findViewById(R.id.rv_tv_show);
        progressBar = view.findViewById(R.id.progress_tv_show);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {
            progressBar.setVisibility(View.VISIBLE);

            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            TvShowViewModel tvShowViewModel = new ViewModelProvider(this, factory).get(TvShowViewModel.class);

            TvShowAdapter tvShowAdapter = new TvShowAdapter();
            tvShowViewModel.getTvShows().observe(this, tvShows -> {
                progressBar.setVisibility(View.GONE);
                tvShowAdapter.setListTvShows(tvShows);
                tvShowAdapter.notifyDataSetChanged();
            });

            rvTvShow.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvTvShow.setHasFixedSize(true);
            rvTvShow.setAdapter(tvShowAdapter);
        }
    }
}