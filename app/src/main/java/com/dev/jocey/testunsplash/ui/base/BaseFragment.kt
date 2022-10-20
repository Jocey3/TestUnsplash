package com.dev.jocey.testunsplash.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import com.dev.jocey.testunsplash.ui.dialog.AppProgressDialog

abstract class BaseFragment : Fragment() {
    var myRoot: View? = null
    private var progressDialog: AppProgressDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (myRoot == null) {
            myRoot = inflater.inflate(getFragmentRes(), container, false);
        }
        progressDialog = AppProgressDialog(requireContext())
        ButterKnife.bind(this, myRoot!!)
        initUi()
        return myRoot!!
    }

    override fun onStart() {
        super.onStart()
        setCurrentFragment()
    }

    protected abstract fun getFragmentRes(): Int

    protected abstract fun initUi()

    protected abstract fun setCurrentFragment()

    fun showProgress(isShow: Boolean) {
        if (isShow) {
            if (progressDialog != null) {
                if (progressDialog!!.isShowing) {
                    return
                }
                progressDialog!!.show()
            }
        } else {
            if (progressDialog != null && progressDialog!!.isShowing) {
                progressDialog!!.dismiss()
            }
        }
    }
}