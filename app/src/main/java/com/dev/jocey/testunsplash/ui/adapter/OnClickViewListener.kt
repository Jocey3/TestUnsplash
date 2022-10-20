package com.dev.jocey.testunsplash.ui.adapter

import com.dev.jocey.testunsplash.api.models.CollectionModel

interface OnClickViewListener {
    fun click(model: CollectionModel)
}