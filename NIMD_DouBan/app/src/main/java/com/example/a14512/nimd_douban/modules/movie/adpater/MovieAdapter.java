package com.example.a14512.nimd_douban.modules.movie.adpater;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by HP on 2017/5/11.
 */

public class MovieAdapter extends RecyclerView.Adapter{
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
   /* private ArrayList<Movie> mMovies;
    private ArrayList<USMovie> mUsBoxes;
    private int flag = 1;
    private Context mContext;

    public void setMovies(ArrayList<Movie> movies) {
        mMovies = movies;
        flag = 1;
    }

    public void setUsBox(ArrayList<USMovie> usBoxes) {
            mUsBoxes = usBoxes;
            flag = 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }

        if (flag == 1) {
            final View view = LayoutInflater.from(parent
                    .getContext()).inflate(R.layout.item_movie, null);
            final MovieHolder holder = new MovieHolder(view);
            holder.movieView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActionStart(mMovies.get(holder.getAdapterPosition()).id, v);
                }
            });
            return holder;
        }else {
            View view = LayoutInflater.from(parent
                    .getContext()).inflate(R.layout.item_us_movie, null);
            final UsMovieHolder holder = new UsMovieHolder(view);
            holder.usMovieView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActionStart(mUsBoxes.get(holder.getAdapterPosition()).subject.id, v);
                }
            });
            return holder;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (flag == 1) {
            MovieHolder movieHolder = (MovieHolder) holder;
            Movie movie = mMovies.get(position);

        }
        else {
            UsMovieHolder usMovieHolder = (UsMovieHolder) holder;
            USMovieSubject.UsBox usBox = mUsBoxes.get(position);
            usMovieHolder.usTitle.setText(usBox.subject.title);
            Glide.with(mContext).load(usBox.subject.images.small).into(usMovieHolder.usImageView);
            usMovieHolder.rank.setText("排名："+usBox.rank);
            usMovieHolder.box.setText("票房："+usBox.box);
        }
    }

    @Override
    public int getItemCount() {
        if (flag == 1) {
            return mMovies == null ? 0 : mMovies.size();
        }
        else {
            return mUsBoxes == null ? 0 : mUsBoxes.size();
        }
    }

    private class MovieHolder extends RecyclerView.ViewHolder {
        View movieView;
        public ImageView mImageView;
        public TextView title;
        public MovieHolder(View itemView) {
            super(itemView);
            movieView = itemView;
            mImageView = (ImageView) itemView.findViewById(R.id.movie_image_item);
            title = (TextView) itemView.findViewById(R.id.movie_title_item);
        }
    }

    private class UsMovieHolder extends RecyclerView.ViewHolder {
        View usMovieView;
        public ImageView usImageView;
        public TextView usTitle;
        public TextView rank;
        public TextView box;
        public UsMovieHolder(View itemView) {
            super(itemView);
            usMovieView = itemView;
            usTitle = (TextView) itemView.findViewById(R.id.movie_us_title_item);
            usImageView = (ImageView) itemView.findViewById(R.id.movie_us_image_item);
            rank = (TextView) itemView.findViewById(R.id.us_rank_text);
            box = (TextView) itemView.findViewById(R.id.us_box_text);
        }
    }

    private void ActionStart(String id, View view) {
        Intent intent = new Intent(view.getContext(), MovieDetailActivity.class);
        intent.putExtra("movie", id);
        view.getContext().startActivity(intent);
    }*/
}
