package com.dev.jocey.testunsplash.api

import com.dev.jocey.testunsplash.api.models.CollectionModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object ApiHelper {
    private var apiManager: ApiService? = null

    init {
        apiManager = ApiManagerInstance.apiService
    }

    fun getPhotos(page: Int, perPage: Int): Flowable<List<CollectionModel>> {
        return apiManager!!.getPhotos(page, perPage).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}