package com.paf.nytimes

import android.app.Application
import android.content.Context
import com.paf.nytimes.di.initDI

class NYTimesApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: NYTimesApplication

        val appContext: Context
            get() = instance.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    fun applicationContext() : Context {
        return instance.applicationContext
    }
}