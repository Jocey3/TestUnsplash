package com.dev.jocey.testunsplash.ui.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.View
import butterknife.ButterKnife
import com.dev.jocey.testunsplash.R

class AppProgressDialog(context: Context) : AlertDialog(context) {

    init {
        val view: View = layoutInflater.inflate(R.layout.dialog_progress, null)
        ButterKnife.bind(this, view)
    }
}