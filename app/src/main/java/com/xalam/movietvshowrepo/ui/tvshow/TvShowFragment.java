package com.xalam.movietvshowrepo.ui.tvshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.xalam.movietvshowrepo.databinding.FragmentTvShowBinding;
import com.xalam.movietvshowrepo.viewmodel.ViewModelFactory;

public class TvShowFragment extends Fragment {

    private FragmentTvShowBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTvShowBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {
            binding.progressTvShow.setVisibility(View.VISIBLE);

            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            TvShowViewModel tvShowViewModel = new ViewModelProvider(this, factory).get(TvShowViewModel.class);

            TvShowAdapter tvShowAdapter = new TvShowAdapter();
            tvShowViewModel.getTvShows().observe(this, tvShows -> {
                binding.progressTvShow.setVisibility(View.GONE);
                tvShowAdapter.setListTvShows(tvShows);
                tvShowAdapter.notifyDataSetChanged();
            });

            binding.rvTvShow.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.rvTvShow.setHasFixedSize(true);
            binding.rvTvShow.setAdapter(tvShowAdapter);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}