package com.xalam.movietvshowrepo.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.xalam.movietvshowrepo.R;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<MoviesEntity> listMovies = new ArrayList<>();

    void setListMovies(List<MoviesEntity> listMovies) {
        if (listMovies == null) return;
        this.listMovies.clear();
        this.listMovies.addAll(listMovies);
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        MoviesEntity moviesEntity = listMovies.get(position);
        holder.bind(moviesEntity);
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvScore, tvDate;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPoster = itemView.findViewById(R.id.img_movie);
            tvTitle = itemView.findViewById(R.id.tv_title_movie);
            tvScore = itemView.findViewById(R.id.tv_score_movie);
            tvDate = itemView.findViewById(R.id.tv_date_movie);
        }

        void bind(final MoviesEntity movie) {
            tvTitle.setText(movie.getTitle());
            tvScore.setText(movie.getUserScore());
            tvDate.setText(movie.getDate());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString(DetailActivity.EXTRA_ID, movie.getMovieId());
                    bundle.putString(DetailActivity.EXTRA_CATEGORY, movie.getCategory());
                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    intent.putExtras(bundle);
                    itemView.getContext().startActivity(intent);
                }
            });
            Glide.with(itemView.getContext())
                    .load(movie.getImagePath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_broken_image_grey).error(R.drawable.ic_broken_image_grey))
                    .into(imgPoster);
        }
    }
}
