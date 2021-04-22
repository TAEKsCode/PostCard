package com.onix.postcard.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.onix.postcard.commons.Uroboros
import com.onix.postcard.events.SingleLiveEvent
import com.onix.postcard.sources.imagesource.impl.AssetsImageSource

class SettingViewModel(imageSource: AssetsImageSource) : ViewModel() {
    private val _navigationLiveEvent = SingleLiveEvent<NavDirections>()
    val navigationLiveEvent: LiveData<NavDirections> = _navigationLiveEvent

    val model = SettingModel()

    private val uroborosIterator = Uroboros(imageSource.list(), imageSource.list().first())

    private val _errorName = MutableLiveData<Boolean>()
    val errorName: LiveData<Boolean> = _errorName

    private val _errorTitle = MutableLiveData<Boolean>()
    val errorTitle: LiveData<Boolean> = _errorTitle

    private val _errorText = MutableLiveData<Boolean>()
    val errorText: LiveData<Boolean> = _errorText

    init {
        model.imageName = uroborosIterator.get()
    }

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

    fun getNextBackground() {
        model.imageName = uroborosIterator.next().get()
    }

    fun getPreviousBackground() {
        model.imageName = uroborosIterator.prev().get()
    }

}
