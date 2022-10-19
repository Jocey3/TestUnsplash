package com.dev.jocey.testunsplash.api

import com.dev.jocey.testunsplash.api.models.CollectionModel
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object ApiHelper {
    private var apiManager: ApiService? = null

    init {
        apiManager = ApiManagerInstance.apiService
    }

    private fun <T> applySchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable: Observable<T> ->
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }


    fun getPhotos(page: Int,perPage: Int): Observable<List<CollectionModel>> {
        return apiManager!!.getPhotos(page,perPage).compose(applySchedulers())
    }
}