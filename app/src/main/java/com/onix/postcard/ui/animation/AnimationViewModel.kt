package com.onix.postcard.ui.animation

import androidx.lifecycle.ViewModel
import com.onix.postcard.data.repository.impl.ImplImageRepository
import com.onix.postcard.ui.setting.SettingModel

class AnimationViewModel(
    val model: SettingModel,
    private val repository: ImplImageRepository
) : ViewModel()