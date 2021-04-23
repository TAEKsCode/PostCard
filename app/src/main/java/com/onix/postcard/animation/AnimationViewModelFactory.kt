package com.onix.postcard.animation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onix.postcard.setting.SettingModel
import com.onix.postcard.sources.imagesource.impl.AssetsImageSource

class AnimationViewModelFactory(
    private val model: SettingModel,
    private val imageSource: AssetsImageSource,
    private val backgroundSource: AssetsImageSource
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnimationViewModel::class.java)) {
            return AnimationViewModel(model, imageSource, backgroundSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}