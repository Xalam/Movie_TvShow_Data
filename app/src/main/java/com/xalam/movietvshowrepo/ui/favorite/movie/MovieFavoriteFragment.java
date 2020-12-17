package com.xalam.movietvshowrepo.ui.favorite.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.xalam.movietvshowrepo.databinding.FragmentMovieFavoriteBinding;
import com.xalam.movietvshowrepo.viewmodel.ViewModelFactory;

public class MovieFavoriteFragment extends Fragment {

    private FragmentMovieFavoriteBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMovieFavoriteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            MovieFavoriteViewModel movieFavoriteViewModel = new ViewModelProvider(this, factory).get(MovieFavoriteViewModel.class);

            MovieFavoriteAdapter adapter = new MovieFavoriteAdapter();

            binding.progressMovieFavorite.setVisibility(View.VISIBLE);
            movieFavoriteViewModel.getMovieFavorites().observe(this, movies -> {
                binding.progressMovieFavorite.setVisibility(View.GONE);
                adapter.setMoviesEntityList(movies);
                adapter.notifyDataSetChanged();
            });

            binding.rvMovieFavorite.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.rvMovieFavorite.setHasFixedSize(true);
            binding.rvMovieFavorite.setAdapter(adapter);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}