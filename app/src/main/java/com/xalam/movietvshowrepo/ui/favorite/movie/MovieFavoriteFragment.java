package com.xalam.movietvshowrepo.ui.favorite.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.xalam.movietvshowrepo.R;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.databinding.FragmentMovieFavoriteBinding;
import com.xalam.movietvshowrepo.viewmodel.ViewModelFactory;

public class MovieFavoriteFragment extends Fragment {

    private FragmentMovieFavoriteBinding binding;
    private MovieFavoriteAdapter adapter;
    private MovieFavoriteViewModel movieFavoriteViewModel;

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

        itemTouchHelper.attachToRecyclerView(binding.rvMovieFavorite);

        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            movieFavoriteViewModel = new ViewModelProvider(this, factory).get(MovieFavoriteViewModel.class);

            adapter = new MovieFavoriteAdapter();

            binding.progressMovieFavorite.setVisibility(View.VISIBLE);
            movieFavorite();
        }
    }

    ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            if (getView() != null) {
                int swipedPosition = viewHolder.getAdapterPosition();
                MoviesEntity moviesEntity = adapter.getSwiped(swipedPosition);
                movieFavoriteViewModel.setMovieFavorite(moviesEntity);
                Snackbar snackbar = Snackbar.make(binding.placeSnackbarMovie, R.string.message_delete, Snackbar.LENGTH_LONG);
                snackbar.getView().setBackground(getContext().getDrawable(R.drawable.bg_snackbar));
                snackbar.getView().setElevation(0f);
                snackbar.setAction(R.string.message_undo, v -> movieFavoriteViewModel.setMovieFavorite(moviesEntity));
                snackbar.show();
            }
        }
    });

    private void movieFavorite() {
        movieFavoriteViewModel.getMovieFavorites().observe(this, movies -> {
            binding.progressMovieFavorite.setVisibility(View.GONE);
            if (movies.size() == 0) {
                adapter.submitList(null);
                binding.linImageMovie.setVisibility(View.VISIBLE);
            } else {
                adapter.submitList(movies);
            }
        });

        binding.rvMovieFavorite.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvMovieFavorite.setHasFixedSize(true);
        binding.rvMovieFavorite.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        movieFavorite();
    }
}