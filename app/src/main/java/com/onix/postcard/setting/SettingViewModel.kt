package com.onix.postcard.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.onix.postcard.SingleLiveEvent

class SettingViewModel : ViewModel() {
    private val _navigationLiveEvent = SingleLiveEvent<NavDirections>()
    val navigationLiveEvent: LiveData<NavDirections> = _navigationLiveEvent

    fun showAnimationFragment() {
        _navigationLiveEvent.value =
            SettingFragmentDirections.actionSettingFragmentToAnimationFragment()
    }
}