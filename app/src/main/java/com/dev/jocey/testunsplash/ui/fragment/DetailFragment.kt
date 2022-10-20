package com.dev.jocey.testunsplash.ui.fragment

import android.widget.ImageView
import butterknife.BindView
import com.dev.jocey.testunsplash.R
import com.dev.jocey.testunsplash.api.models.CollectionModel
import com.dev.jocey.testunsplash.ui.activity.main.MainActivity
import com.dev.jocey.testunsplash.ui.base.BaseFragment
import com.dev.jocey.testunsplash.util.GlideLoader

class DetailFragment(private val collectionModel: CollectionModel) : BaseFragment() {
    @BindView(R.id.iv_full_size_photo)
    lateinit var ivFullSizePhoto: ImageView

    override fun getFragmentRes(): Int {
        return R.layout.fragment_detail
    }

    override fun initUi() {
        var url = collectionModel.urls?.full
        GlideLoader.showImageInGlide(ivFullSizePhoto, url)
    }

    override fun setCurrentFragment() {
        if (activity != null && activity is MainActivity) {
            (activity as MainActivity?)?.setCurrentFragment(this)
        }
    }
}