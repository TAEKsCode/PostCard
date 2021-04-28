package com.onix.postcard.di

import com.onix.postcard.data.source.image.impl.background.BackgroundImageSource
import com.onix.postcard.data.source.image.impl.image.ImplImagesSource
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val sourceModule = module {
    single<ImplImagesSource> { ImplImagesSource(context = androidApplication()) }

    single<BackgroundImageSource> { BackgroundImageSource(context = androidApplication()) }
}
