package com.onix.postcard.di

import com.onix.postcard.data.repository.impl.ImplImageRepository
import com.onix.postcard.data.source.image.impl.background.BackgroundImageSource
import com.onix.postcard.data.source.image.impl.image.ImplImagesSource
import org.koin.dsl.module

val repositoryModule = module {

    single<ImplImageRepository> {
        ImplImageRepository(
            imageSource = get<ImplImagesSource>(),
            backgroundSource = get<BackgroundImageSource>()
        )
    }
}
