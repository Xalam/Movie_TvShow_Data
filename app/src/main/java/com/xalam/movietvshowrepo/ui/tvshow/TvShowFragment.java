package com.xalam.movietvshowrepo.ui.tvshow;

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

            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            TvShowViewModel tvShowViewModel = new ViewModelProvider(this, factory).get(TvShowViewModel.class);

            TvShowAdapter tvShowAdapter = new TvShowAdapter();
            tvShowViewModel.getTvShows().observe(this, tvShows -> {
                if (tvShows != null) {
                    switch (tvShows.status) {
                        case LOADING:
                            binding.progressTvShow.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            binding.progressTvShow.setVisibility(View.GONE);
                            tvShowAdapter.setListTvShows(tvShows.data);
                            tvShowAdapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            binding.progressTvShow.setVisibility(View.GONE);
                            Toast.makeText(getContext(), R.string.error, Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
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