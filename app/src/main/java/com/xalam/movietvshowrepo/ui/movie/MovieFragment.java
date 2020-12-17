package com.xalam.movietvshowrepo.ui.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.xalam.movietvshowrepo.R;
import com.xalam.movietvshowrepo.databinding.FragmentMovieBinding;
import com.xalam.movietvshowrepo.viewmodel.ViewModelFactory;

public class MovieFragment extends Fragment {

    private FragmentMovieBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {
            binding.progressMovie.setVisibility(View.VISIBLE);

            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            MovieViewModel movieViewModel = new ViewModelProvider(this, factory).get(MovieViewModel.class);

            MovieAdapter movieAdapter = new MovieAdapter();
            movieViewModel.getMovies().observe(this, movies -> {
                if (movies != null) {
                    switch (movies.status) {
                        case LOADING:
                            binding.progressMovie.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            binding.progressMovie.setVisibility(View.GONE);
                            movieAdapter.setListMovies(movies.data);
                            movieAdapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            binding.progressMovie.setVisibility(View.GONE);
                            Toast.makeText(getContext(), R.string.error, Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

            binding.rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.rvMovie.setHasFixedSize(true);
            binding.rvMovie.setAdapter(movieAdapter);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}