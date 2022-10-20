package com.dev.jocey.testunsplash.ui.activity.main

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.dev.jocey.testunsplash.R
import com.dev.jocey.testunsplash.mvp.presenter.activity.MainActivityPresenter
import com.dev.jocey.testunsplash.ui.fragment.DetailFragment
import com.dev.jocey.testunsplash.ui.fragment.ListFragment
import com.dev.jocey.testunsplash.ui.fragment.MainEnumFragments

class MainActivity : AppCompatActivity() {
    @BindView(R.id.fl_container)
    lateinit var fLContainer: LinearLayout

    @BindView(R.id.iv_back)
    lateinit var ivBack: ImageView

    @BindView(R.id.tv_fragment_name)
    lateinit var tvFragmentName: TextView

    val presenter = MainActivityPresenter(supportFragmentManager)
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        presenter.switchFragment(MainEnumFragments.LIST_FRAGMENT, true)


    }

    fun setCurrentFragment(fragment: Fragment) {
        currentFragment = fragment
        if (fragment is ListFragment) {
            ivBack.visibility = View.GONE
            tvFragmentName.text = "List of photos"
        } else if (fragment is DetailFragment) {
            ivBack.visibility = View.VISIBLE
            tvFragmentName.text = "Full size Photo"
        }


    }

    override fun onBackPressed() {
        if (currentFragment is ListFragment) this.finishAndRemoveTask()
        super.onBackPressed()
    }

    @OnClick(R.id.iv_back)
    fun clickOn(view: View) {
        onBackPressed()
    }

}