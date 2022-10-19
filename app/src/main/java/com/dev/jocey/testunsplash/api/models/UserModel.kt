package com.dev.jocey.testunsplash.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("updated_at")
    @Expose
    var updated_at: String? = null,
    @SerializedName("username")
    @Expose
    var username: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("first_name")
    @Expose
    var first_name: String? = null,
    @SerializedName("last_name")
    @Expose
    var last_name: String? = null,
    )
