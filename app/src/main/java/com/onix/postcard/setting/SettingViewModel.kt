package com.onix.postcard.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.onix.postcard.commons.Uroboros
import com.onix.postcard.events.SingleLiveEvent
import com.onix.postcard.sources.imagesource.impl.AssetsImageSource

class SettingViewModel(val imageSource: AssetsImageSource, val backgroundSource: AssetsImageSource) :
    ViewModel() {
    private val _navigationLiveEvent = SingleLiveEvent<NavDirections>()
    val navigationLiveEvent: LiveData<NavDirections> = _navigationLiveEvent

    val model = SettingModel("Name", "Title", "Texttexttexttext")

    private val imagesIterator = Uroboros(imageSource.list(), imageSource.list().first())
    private val backgroundsIterator =
        Uroboros(backgroundSource.list(), backgroundSource.list().first())

    private val _errorName = MutableLiveData<Boolean>()
    val errorName: LiveData<Boolean> = _errorName

    private val _errorTitle = MutableLiveData<Boolean>()
    val errorTitle: LiveData<Boolean> = _errorTitle

    private val _errorText = MutableLiveData<Boolean>()
    val errorText: LiveData<Boolean> = _errorText

    init {
        model.imageName = imagesIterator.get()
        model.backgroundName = backgroundsIterator.get()
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

    fun getNextImage() {
        model.imageName = imagesIterator.next().get()
    }

    fun getPreviousImage() {
        model.imageName = imagesIterator.prev().get()
    }

    fun getNextBackground() {
        model.backgroundName = backgroundsIterator.next().get()
    }

}
