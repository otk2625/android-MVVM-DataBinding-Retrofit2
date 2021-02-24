package com.cos.retrofit2movieapp.model;

import android.media.Image;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.cos.retrofit2movieapp.R;
import com.google.gson.annotations.SerializedName;
import com.makeramen.roundedimageview.RoundedImageView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private long id;
    private String url;
    private String title;
    private long year;
    private double rating;
    private long runtime;
    private String summary;
    @SerializedName("medium_cover_image")
    private String mediumCoverImage;

    @BindingAdapter("bind:mediumCoverImage")
    public static void loadImage(RoundedImageView view, String mediumCoverImage){
        Glide.with(view.getContext())
                .load(mediumCoverImage)
                .into(view);
    }
}
