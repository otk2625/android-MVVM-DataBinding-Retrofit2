package com.cos.retrofit2movieapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.retrofit2movieapp.MainActivity;
import com.cos.retrofit2movieapp.R;
import com.cos.retrofit2movieapp.databinding.CardItemBinding;
import com.cos.retrofit2movieapp.model.Movie;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private static final String TAG = "MovieAdapter";
    private final MainActivity mContext;
    private List<Movie> movies = new ArrayList<>();

    public MovieAdapter(MainActivity mContext) {
        this.mContext = mContext;
    }

    public void setMovies(List<Movie> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }

    public long getMovieId(int position){
        return movies.get(position).getId();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CardItemBinding cardItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.card_item,
                parent,
                false
        );

        return new MyViewHolder(cardItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.cardItemBinding.setMovie(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    // card_item 디자인이 연결!
    public class MyViewHolder extends RecyclerView.ViewHolder{

        // card_item과 바인딩됨!!
        private CardItemBinding cardItemBinding;


        public MyViewHolder(@NonNull CardItemBinding cardItemBinding) {
            super(cardItemBinding.getRoot());
            this.cardItemBinding = cardItemBinding;
        }
    }
}
