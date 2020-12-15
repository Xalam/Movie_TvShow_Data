package com.xalam.movietvshowrepo.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.xalam.movietvshowrepo.R;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.viewmodel.ViewModelFactory;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_CATEGORY = "extra_category";

    private TextView tvTitle, tvDate, tvGenre, tvDuration, tvUserScore, tvDescription;
    private ImageView imgContent, imgBackground;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tv_title_detail);
        tvDate = findViewById(R.id.tv_date_detail);
        tvGenre = findViewById(R.id.tv_genre_detail);
        tvDuration = findViewById(R.id.tv_duration_detail);
        tvUserScore = findViewById(R.id.tv_score_detail);
        tvDescription = findViewById(R.id.tv_description_detail);
        imgContent = findViewById(R.id.img_detail);
        imgBackground = findViewById(R.id.img_bg_detail);
        progressBar = findViewById(R.id.progress_detail);

        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        DetailViewModel detailViewModel = new ViewModelProvider(this, factory).get(DetailViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String contentId = extras.getString(EXTRA_ID);
            String category = extras.getString(EXTRA_CATEGORY);
            progressBar.setVisibility(View.VISIBLE);

            detailViewModel.setSelectedContent(contentId);

            assert category != null;
            if (category.equals(getString(R.string.cat_movie))) {
                getSupportActionBar().setTitle(R.string.movies);
                detailViewModel.getMovie().observe(this, this::detailMovie);
            } else {
                getSupportActionBar().setTitle(R.string.tv_shows);
                detailViewModel.getTvShow().observe(this, this::detailTvShow);
            }
        }
    }

    private void detailMovie(MoviesEntity moviesEntity) {
        progressBar.setVisibility(View.GONE);
        tvTitle.setText(moviesEntity.getTitle() + " (" + moviesEntity.getYear() + ")");
        tvDate.setText(moviesEntity.getDate());
        tvGenre.setText(moviesEntity.getGenre());
        tvDuration.setText(moviesEntity.getDuration());
        tvUserScore.setText(moviesEntity.getUserScore());
        tvDescription.setText(moviesEntity.getDescription());

        Glide.with(this)
                .load(moviesEntity.getImagePath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                .into(imgContent);

        Glide.with(this)
                .load(moviesEntity.getImagePath())
                .apply(RequestOptions.placeholderOf(R.color.colorTextTertiary).error(R.color.colorTextTertiary))
                .into(imgBackground);
    }

    private void detailTvShow(TVShowsEntity tvShowsEntity) {
        progressBar.setVisibility(View.GONE);
        tvTitle.setText(tvShowsEntity.getTitle() + " (" + tvShowsEntity.getYear() + ")");
        tvDate.setText(tvShowsEntity.getDate());
        tvGenre.setText(tvShowsEntity.getGenre());
        tvDuration.setText(tvShowsEntity.getDuration());
        tvUserScore.setText(tvShowsEntity.getUserScore());
        tvDescription.setText(tvShowsEntity.getDescription());

        Glide.with(this)
                .load(tvShowsEntity.getImagePath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                .into(imgContent);

        Glide.with(this)
                .load(tvShowsEntity.getImagePath())
                .apply(RequestOptions.placeholderOf(R.color.colorTextTertiary).error(R.color.colorTextTertiary))
                .into(imgBackground);
    }
}