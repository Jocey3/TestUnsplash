package com.dev.jocey.testunsplash.api

import com.dev.jocey.testunsplash.api.models.CollectionModel
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("photos")
    fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Flowable<List<CollectionModel>>
}