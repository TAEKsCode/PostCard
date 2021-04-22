package com.onix.postcard.animation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onix.postcard.setting.SettingModel

class AnimationViewModelFactory(private val model: SettingModel) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnimationViewModel::class.java)) {
            return AnimationViewModel(model) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}