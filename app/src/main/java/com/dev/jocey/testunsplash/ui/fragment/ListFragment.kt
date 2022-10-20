package com.dev.jocey.testunsplash.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.dev.jocey.testunsplash.R
import com.dev.jocey.testunsplash.api.models.CollectionModel
import com.dev.jocey.testunsplash.mvp.presenter.fragment.ListFragmentPresenter
import com.dev.jocey.testunsplash.mvp.view.ListFragmentView
import com.dev.jocey.testunsplash.ui.activity.main.MainActivity
import com.dev.jocey.testunsplash.ui.adapter.AdapterPhoto
import com.dev.jocey.testunsplash.ui.adapter.OnClickViewListener
import com.dev.jocey.testunsplash.ui.base.BaseFragment
import com.dev.jocey.testunsplash.util.Pagination
import io.reactivex.processors.PublishProcessor

class ListFragment : BaseFragment(), ListFragmentView {

    @BindView(R.id.rv_photos)
    lateinit var rvPhotos: RecyclerView


    private val presenter = ListFragmentPresenter()

    private var linearLayoutManager: LinearLayoutManager =
        LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    private var publishProcessor: PublishProcessor<Int> = PublishProcessor.create()
    private var scrollListener: RecyclerView.OnScrollListener = object : Pagination(
        linearLayoutManager
    ) {
        override fun onLoadMore(currentPage: Int, totalItemCount: Int, view: View?) {
            var page = currentPage
            if (!presenter.requestOnWay) {
                publishProcessor.onNext(++page)
            }
        }
    }
    private var adapterPhoto: AdapterPhoto = AdapterPhoto(object : OnClickViewListener {
        override fun click(model: CollectionModel) {
            if (activity != null && activity is MainActivity) {
                (activity as MainActivity?)?.presenter?.switchFragment(
                    MainEnumFragments.DETAIL_FRAGMENT,
                    true,
                    model
                )
            }
        }
    })
    private var isf: Boolean = false

    override fun getFragmentRes(): Int {
        return R.layout.fragment_list
    }

    override fun initUi() {
        presenter.bind(this)
        if (!isf) {
            setRecycler()
            startFetchPhotos()
        } else {
            presenter.getPhotos(publishProcessor)
        }
    }


    private fun setRecycler() {
        rvPhotos.layoutManager = linearLayoutManager
        rvPhotos.adapter = adapterPhoto
        rvPhotos.addOnScrollListener(scrollListener)
    }

    private fun startFetchPhotos() {
        presenter.getPhotos(publishProcessor)
        publishProcessor.onNext(1)
    }

    override fun setCurrentFragment() {
        if (activity != null && activity is MainActivity) {
            (activity as MainActivity?)?.setCurrentFragment(this)
        }
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }


    override fun showPhotos(list: List<CollectionModel>?) {
        isf = true
        if (list != null) {
            adapterPhoto.addAll(list)
        }
    }
}