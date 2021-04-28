package com.onix.postcard.di

import com.onix.postcard.data.repository.impl.ImplImageRepository
import com.onix.postcard.ui.animation.AnimationViewModel
import com.onix.postcard.ui.setting.SettingModel
import com.onix.postcard.ui.setting.SettingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { SettingViewModel(repository = get<ImplImageRepository>()) }

    viewModel { (model: SettingModel) ->
        AnimationViewModel(model = model, repository = get<ImplImageRepository>())
    }
}
