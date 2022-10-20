package com.dev.jocey.testunsplash.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.dev.jocey.testunsplash.App

class GlideLoader {
    companion object {

        fun showImageInGlide(imageView: ImageView, url: String?) {
            Glide.with(App.contextApp!!)
                .load(url)
                .into(imageView)
        }
    }
}