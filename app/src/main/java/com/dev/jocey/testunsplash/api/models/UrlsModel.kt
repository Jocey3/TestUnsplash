package com.dev.jocey.testunsplash.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UrlsModel(
    @SerializedName("raw")
    @Expose
    var raw: String? = null,
    @SerializedName("full")
    @Expose
    var full: String? = null,
    @SerializedName("regular")
    @Expose
    var regular: String? = null,
    @SerializedName("small")
    @Expose
    var small: String? = null
)
