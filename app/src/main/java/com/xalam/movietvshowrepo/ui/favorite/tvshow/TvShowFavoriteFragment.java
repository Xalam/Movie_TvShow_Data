package com.xalam.movietvshowrepo.ui.favorite.tvshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.xalam.movietvshowrepo.R;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.databinding.FragmentTvShowFavoriteBinding;
import com.xalam.movietvshowrepo.viewmodel.ViewModelFactory;

public class TvShowFavoriteFragment extends Fragment {

    private FragmentTvShowFavoriteBinding binding;
    private TvShowFavoriteAdapter adapter;
    private TvShowFavoriteViewModel tvShowFavoriteViewModel;
    private ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
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
                TVShowsEntity tvShowsEntity = adapter.getSwiped(swipedPosition);
                tvShowFavoriteViewModel.setTvShowFavorite(tvShowsEntity);
                Snackbar snackbar = Snackbar.make(binding.placeSnackbarTvShow, R.string.message_delete, Snackbar.LENGTH_LONG);
                snackbar.getView().setBackground(getContext().getDrawable(R.drawable.bg_snackbar));
                snackbar.getView().setElevation(0f);
                snackbar.setAction(R.string.message_undo, v -> tvShowFavoriteViewModel.setTvShowFavorite(tvShowsEntity));
                snackbar.show();
            }
        }
    });

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

        itemTouchHelper.attachToRecyclerView(binding.rvTvShowFavorite);

        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            tvShowFavoriteViewModel = new ViewModelProvider(this, factory).get(TvShowFavoriteViewModel.class);

            adapter = new TvShowFavoriteAdapter();

            binding.progressTvShowFavorite.setVisibility(View.VISIBLE);
            tvShowFavorite();
        }
    }

    private void tvShowFavorite() {
        tvShowFavoriteViewModel.getTvShowFavorites().observe(this, tvShows -> {
            binding.progressTvShowFavorite.setVisibility(View.GONE);
            if (tvShows.size() == 0) {
                adapter.submitList(null);
                binding.linImageTvShow.setVisibility(View.VISIBLE);
            } else {
                adapter.submitList(tvShows);
            }
        });

        binding.rvTvShowFavorite.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvTvShowFavorite.setHasFixedSize(true);
        binding.rvTvShowFavorite.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        tvShowFavorite();
    }
}