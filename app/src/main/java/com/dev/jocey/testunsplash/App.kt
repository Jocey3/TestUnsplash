package com.dev.jocey.testunsplash

import android.app.Application
import android.content.Context

class App : Application() {
    companion object {
        var contextApp: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        contextApp = this
    }
}