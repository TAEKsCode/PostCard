package com.onix.postcard.component.initializer.koin

import android.content.Context
import com.onix.postcard.di.repositoryModule
import com.onix.postcard.di.sourceModule
import com.onix.postcard.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinDependency(context: Context) {
    init {
        initializeKoin(context)
    }

    private fun initializeKoin(context: Context) {
        startKoin {
            androidContext(context)
            modules(listOf(repositoryModule, viewModelModule, sourceModule))
        }
    }
}