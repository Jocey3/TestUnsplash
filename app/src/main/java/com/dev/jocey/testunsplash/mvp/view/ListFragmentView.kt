package com.dev.jocey.testunsplash.mvp.view

import com.dev.jocey.testunsplash.api.models.CollectionModel

interface ListFragmentView : BaseView {
    fun showProgress(isShown: Boolean)
    fun showPhotos(list: List<CollectionModel>?)

}