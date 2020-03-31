package com.ahmedtikiwa.liam.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.ahmedtikiwa.liam.R
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    Glide.with(imageView.context)
        .load(url)
        .placeholder(R.drawable.ic_flat_mountains)
        .error(R.drawable.ic_flat_mountains)
        .into(imageView)
}