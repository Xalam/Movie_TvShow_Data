package com.xalam.movietvshowrepo.ui.tvshow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.xalam.movietvshowrepo.R;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.ui.detail.DetailActivity;

public class TvShowAdapter extends PagedListAdapter<TVShowsEntity, TvShowAdapter.TvShowViewHolder> {

    TvShowAdapter() {
        super(DIFF_CALLBACK);
    }

    private static DiffUtil.ItemCallback<TVShowsEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TVShowsEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull TVShowsEntity oldItem, @NonNull TVShowsEntity newItem) {
                    return oldItem.getTvId().equals(newItem.getTvId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull TVShowsEntity oldItem, @NonNull TVShowsEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public TvShowAdapter.TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_tv_show, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowAdapter.TvShowViewHolder holder, int position) {
        TVShowsEntity tvShowsEntity = getItem(position);
        holder.bind(tvShowsEntity);
    }

    public class TvShowViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvScore, tvDate;

        public TvShowViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPoster = itemView.findViewById(R.id.img_tv_show);
            tvTitle = itemView.findViewById(R.id.tv_title_tv_show);
            tvScore = itemView.findViewById(R.id.tv_score_tv_show);
            tvDate = itemView.findViewById(R.id.tv_date_tv_show);
        }

        void bind(final TVShowsEntity tvShowsEntity) {
            tvTitle.setText(tvShowsEntity.getTitle());
            tvScore.setText(tvShowsEntity.getUserScore());
            tvDate.setText(tvShowsEntity.getDate());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString(DetailActivity.EXTRA_ID, tvShowsEntity.getTvId());
                    bundle.putString(DetailActivity.EXTRA_CATEGORY, tvShowsEntity.getCategory());
                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    intent.putExtras(bundle);
                    itemView.getContext().startActivity(intent);
                }
            });
            Glide.with(itemView.getContext())
                    .load(tvShowsEntity.getImagePath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_broken_image_grey).error(R.drawable.ic_broken_image_grey))
                    .into(imgPoster);
        }
    }
}
