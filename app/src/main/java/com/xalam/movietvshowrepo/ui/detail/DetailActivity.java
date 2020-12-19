package com.xalam.movietvshowrepo.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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
    DetailViewModel detailViewModel;
    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbarDetail);
        binding.toolbarDetail.setNavigationIcon(R.drawable.ic_chevron_left);
        binding.toolbarDetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        detailViewModel = new ViewModelProvider(this, factory).get(DetailViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String contentId = extras.getString(EXTRA_ID);
            String category = extras.getString(EXTRA_CATEGORY);

            detailViewModel.setSelectedContent(contentId);

            assert category != null;
            if (category.equals(getString(R.string.cat_movie))) {
                binding.tvToolbarDetail.setText(R.string.movies);
                detailViewModel.movie.observe(this, moviesEntityResource -> {
                    if (moviesEntityResource != null) {
                        switch (moviesEntityResource.status) {
                            case LOADING:
                                binding.progressDetail.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                if (moviesEntityResource.data != null) {
                                    binding.progressDetail.setVisibility(View.GONE);
                                    detailMovie(moviesEntityResource.data);
                                    observeFavoriteMovie();
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
                binding.tvToolbarDetail.setText(R.string.tv_shows);
                detailViewModel.tvShow.observe(this, tvShowsEntityResource -> {
                    if (tvShowsEntityResource != null) {
                        switch (tvShowsEntityResource.status) {
                            case LOADING:
                                binding.progressDetail.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                if (tvShowsEntityResource.data != null) {
                                    binding.progressDetail.setVisibility(View.GONE);
                                    detailTvShow(tvShowsEntityResource.data);
                                    observeFavoriteTvShow();
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
            binding.btnFavDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (category.equals(getString(R.string.cat_movie))) {
                        detailViewModel.setMovieFavorite();
                    } else {
                        detailViewModel.setTvShowFavorite();
                    }
                }
            });
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

    private void observeFavoriteMovie() {
        detailViewModel.movie.observe(this, moviesEntityResource -> {
            if (moviesEntityResource != null) {
                switch (moviesEntityResource.status) {
                    case LOADING:
                        binding.progressDetail.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        if (moviesEntityResource.data != null) {
                            binding.progressDetail.setVisibility(View.GONE);
                            boolean state = moviesEntityResource.data.isFavorite();
                            favoriteStatus(state);
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

    private void observeFavoriteTvShow() {
        detailViewModel.tvShow.observe(this, tvShowsEntityResource -> {
            if (tvShowsEntityResource != null) {
                switch (tvShowsEntityResource.status) {
                    case LOADING:
                        binding.progressDetail.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        if (tvShowsEntityResource.data != null) {
                            binding.progressDetail.setVisibility(View.GONE);
                            boolean state = tvShowsEntityResource.data.isFavorite();
                            favoriteStatus(state);
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

    private void favoriteStatus(boolean state) {
        if (state) {
            binding.btnFavDetail.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star));
        } else {
            binding.btnFavDetail.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star_border));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}