package com.onix.postcard.animation

import androidx.lifecycle.ViewModel
import com.onix.postcard.setting.SettingModel
import com.onix.postcard.sources.imagesource.impl.AssetsImageSource

class AnimationViewModel(
    val model: SettingModel,
    val imageSource: AssetsImageSource,
    val backgroundSource: AssetsImageSource
) : ViewModel()