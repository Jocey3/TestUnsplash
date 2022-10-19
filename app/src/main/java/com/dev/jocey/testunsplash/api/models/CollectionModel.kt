package com.dev.jocey.testunsplash.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CollectionModel(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("description")
    @Expose
    var description: String? = null,
    @SerializedName("published_at")
    @Expose
    var published_at: String? = null,
    @SerializedName("updated_at")
    @Expose
    var updated_at: String? = null,
    @SerializedName("curated")
    @Expose
    var curated: Boolean? = null,
    @SerializedName("featured")
    @Expose
    var featured: Boolean? = null,
    @SerializedName("total_photos")
    @Expose
    var total_photos: Int? = null,
    @SerializedName("private")
    @Expose
    var private: Boolean? = null,
    @SerializedName("share_key")
    @Expose
    var share_key: String? = null,
    @SerializedName("user")
    @Expose
    var user: UserModel? = null,
    @SerializedName("urls")
    @Expose
    var urls: UrlsModel? = null
)
