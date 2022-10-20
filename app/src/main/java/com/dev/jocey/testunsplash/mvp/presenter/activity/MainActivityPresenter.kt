package com.dev.jocey.testunsplash.mvp.presenter.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.dev.jocey.testunsplash.R
import com.dev.jocey.testunsplash.api.models.CollectionModel
import com.dev.jocey.testunsplash.ui.fragment.DetailFragment
import com.dev.jocey.testunsplash.ui.fragment.ListFragment
import com.dev.jocey.testunsplash.ui.fragment.MainEnumFragments

class MainActivityPresenter(private val supportFragmentManager: FragmentManager) {

    fun switchFragment(enumFragment: MainEnumFragments, addToStack: Boolean, vararg arg: Any) {
        var fragment: Fragment
        when (enumFragment) {
            MainEnumFragments.LIST_FRAGMENT -> fragment = ListFragment()
            MainEnumFragments.DETAIL_FRAGMENT -> {
                fragment = DetailFragment(arg[0] as CollectionModel)
            }
        }
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (!addToStack) {
            supportFragmentManager.popBackStack()
        }
        fragmentTransaction.replace(R.id.fl_container, fragment, fragment.javaClass.name)
        if (addToStack) {
            fragmentTransaction.addToBackStack(fragment.javaClass.name)
        }
        fragmentTransaction.commit()
    }
}