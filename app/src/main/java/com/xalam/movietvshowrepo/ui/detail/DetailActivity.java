package com.xalam.movietvshowrepo.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.xalam.movietvshowrepo.R;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.databinding.ActivityDetailBinding;
import com.xalam.movietvshowrepo.viewmodel.ViewModelFactory;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_CATEGORY = "extra_category";

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbarDetail);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        DetailViewModel detailViewModel = new ViewModelProvider(this, factory).get(DetailViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String contentId = extras.getString(EXTRA_ID);
            String category = extras.getString(EXTRA_CATEGORY);

            detailViewModel.setSelectedContent(contentId);

            assert category != null;
            if (category.equals(getString(R.string.cat_movie))) {
                getSupportActionBar().setTitle(R.string.movies);
                detailViewModel.movie.observe(this, moviesEntityResource -> {
                    if (moviesEntityResource != null) {
                        switch (moviesEntityResource.status) {
                            case LOADING:
                                binding.progressDetail.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                if (moviesEntityResource.data != null) {
                                    detailMovie(moviesEntityResource.data);
                                }
                                break;
                            case ERROR:
                                binding.progressDetail.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), R.string.error, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
            } else {
                getSupportActionBar().setTitle(R.string.tv_shows);
                detailViewModel.tvShow.observe(this, tvShowsEntityResource -> {
                    if (tvShowsEntityResource != null) {
                        switch (tvShowsEntityResource.status) {
                            case LOADING:
                                binding.progressDetail.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                if (tvShowsEntityResource.data != null) {
                                    detailTvShow(tvShowsEntityResource.data);
                                }
                                break;
                            case ERROR:
                                binding.progressDetail.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), R.string.error, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
            }
        }
    }

    private void detailMovie(MoviesEntity moviesEntity) {
        binding.progressDetail.setVisibility(View.GONE);
        binding.tvTitleDetail.setText(moviesEntity.getTitle() + " (" + moviesEntity.getYear() + ")");
        binding.tvDateDetail.setText(moviesEntity.getDate());
        binding.tvGenreDetail.setText(moviesEntity.getGenre());
        binding.tvDurationDetail.setText(moviesEntity.getDuration());
        binding.tvScoreDetail.setText(moviesEntity.getUserScore());
        binding.tvDescriptionDetail.setText(moviesEntity.getDescription());

        Glide.with(this)
                .load(moviesEntity.getImagePath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                .into(binding.imgDetail);

        Glide.with(this)
                .load(moviesEntity.getImagePath())
                .apply(RequestOptions.placeholderOf(R.color.colorTextTertiary).error(R.color.colorTextTertiary))
                .into(binding.imgBgDetail);
    }

    private void detailTvShow(TVShowsEntity tvShowsEntity) {
        binding.progressDetail.setVisibility(View.GONE);
        binding.tvTitleDetail.setText(tvShowsEntity.getTitle() + " (" + tvShowsEntity.getYear() + ")");
        binding.tvDateDetail.setText(tvShowsEntity.getDate());
        binding.tvGenreDetail.setText(tvShowsEntity.getGenre());
        binding.tvDurationDetail.setText(tvShowsEntity.getDuration());
        binding.tvScoreDetail.setText(tvShowsEntity.getUserScore());
        binding.tvDescriptionDetail.setText(tvShowsEntity.getDescription());

        Glide.with(this)
                .load(tvShowsEntity.getImagePath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                .into(binding.imgDetail);

        Glide.with(this)
                .load(tvShowsEntity.getImagePath())
                .apply(RequestOptions.placeholderOf(R.color.colorTextTertiary).error(R.color.colorTextTertiary))
                .into(binding.imgBgDetail);
    }
}