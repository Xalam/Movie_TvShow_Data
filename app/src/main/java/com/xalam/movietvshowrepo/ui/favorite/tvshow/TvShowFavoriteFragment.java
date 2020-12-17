package com.xalam.movietvshowrepo.ui.favorite.tvshow;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xalam.movietvshowrepo.databinding.FragmentTvShowFavoriteBinding;
import com.xalam.movietvshowrepo.viewmodel.ViewModelFactory;

public class TvShowFavoriteFragment extends Fragment {

    private FragmentTvShowFavoriteBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTvShowFavoriteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            TvShowFavoriteViewModel tvShowFavoriteViewModel = new ViewModelProvider(this, factory).get(TvShowFavoriteViewModel.class);

            TvShowFavoriteAdapter adapter = new TvShowFavoriteAdapter();

            binding.progressTvShowFavorite.setVisibility(View.VISIBLE);
            tvShowFavoriteViewModel.getTvShowFavorites().observe(this, tvShows -> {
                binding.progressTvShowFavorite.setVisibility(View.GONE);
                adapter.setListTvShows(tvShows);
                adapter.notifyDataSetChanged();
            });

            binding.rvTvShowFavorite.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.rvTvShowFavorite.setHasFixedSize(true);
            binding.rvTvShowFavorite.setAdapter(adapter);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}