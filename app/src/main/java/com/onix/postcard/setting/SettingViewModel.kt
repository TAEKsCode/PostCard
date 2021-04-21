package com.onix.postcard.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.onix.postcard.SingleLiveEvent

class SettingViewModel : ViewModel() {
    private val _navigationLiveEvent = SingleLiveEvent<NavDirections>()
    val navigationLiveEvent: LiveData<NavDirections> = _navigationLiveEvent
    val model = SettingModel()

    private val _errorName = MutableLiveData<Boolean>()
    val errorName: LiveData<Boolean> = _errorName

    private val _errorTitle = MutableLiveData<Boolean>()
    val errorTitle: LiveData<Boolean> = _errorTitle

    private val _errorText = MutableLiveData<Boolean>()
    val errorText: LiveData<Boolean> = _errorText


    fun showAnimationFragment() {
        model.apply {
            _errorName.value = name.isEmpty()
            _errorTitle.value = title.isEmpty()
            _errorText.value = text.isEmpty()
            if (!isError()) {
                _navigationLiveEvent.value =
                    SettingFragmentDirections.actionSettingFragmentToAnimationFragment(model)
            }
        }
    }
}