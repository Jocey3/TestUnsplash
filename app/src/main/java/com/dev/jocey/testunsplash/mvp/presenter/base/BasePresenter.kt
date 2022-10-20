package com.dev.jocey.testunsplash.mvp.presenter.base

import com.dev.jocey.testunsplash.mvp.view.BaseView
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<T : BaseView> {
    var compositeDisposable: CompositeDisposable? = null
    var view: T? = null

    fun bind(view: T) {
        compositeDisposable = CompositeDisposable()
        this.view = view
    }

    fun onPause() {
        if (!compositeDisposable?.isDisposed!!) compositeDisposable?.dispose()
        view = null
    }

}