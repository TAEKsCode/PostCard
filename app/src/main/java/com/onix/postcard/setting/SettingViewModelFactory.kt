package com.onix.postcard.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onix.postcard.sources.imagesource.impl.AssetsImageSource

class SettingViewModelFactory(private val imageSource: AssetsImageSource, private val backgroundSource: AssetsImageSource) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingViewModel::class.java)) {
            return SettingViewModel(imageSource, backgroundSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}