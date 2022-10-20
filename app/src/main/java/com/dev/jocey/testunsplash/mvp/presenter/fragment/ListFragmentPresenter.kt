package com.dev.jocey.testunsplash.mvp.presenter.fragment

import android.util.Log
import com.dev.jocey.testunsplash.api.ApiHelper
import com.dev.jocey.testunsplash.mvp.presenter.base.BasePresenter
import com.dev.jocey.testunsplash.mvp.view.ListFragmentView
import io.reactivex.disposables.Disposable
import io.reactivex.processors.PublishProcessor

class ListFragmentPresenter() : BasePresenter<ListFragmentView>() {
    var requestOnWay: Boolean = false
    fun getPhotos(pagination: PublishProcessor<Int>) {
        val disposable: Disposable = pagination.onBackpressureDrop()
            .doOnNext {
                requestOnWay = true
                view?.showProgress(true)
            }
            .concatMap { page ->
                Log.d("NAR_HOME", "getPhotos page $page")
                ApiHelper.getPhotos(page, 10)
            }
            .subscribe({
                Log.d("NAR_HOME", "getPhotos ${it.size}")
                view?.showPhotos(it)
                requestOnWay = false
                view?.showProgress(false)
            }, {
                Log.d(
                    "NAR_HOME",
                    "Throwable: $it"
                )
            })
        compositeDisposable?.add(disposable)
    }

}