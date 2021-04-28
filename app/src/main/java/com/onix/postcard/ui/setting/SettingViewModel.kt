package com.onix.postcard.ui.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.onix.postcard.commons.Uroboros
import com.onix.postcard.arch.livecycler.SingleLiveEvent
import com.onix.postcard.data.repository.impl.ImplImageRepository
import kotlinx.coroutines.launch

class SettingViewModel(
    private val repository: ImplImageRepository
) : ViewModel() {

    private val _navigationLiveEvent = SingleLiveEvent<NavDirections>()
    val navigationLiveEvent: LiveData<NavDirections> = _navigationLiveEvent

    private val imagesIterator = Uroboros(repository.imagesList(), repository.imagesList().first())
    private val backgroundsIterator =
        Uroboros(repository.backgroundsList(), repository.backgroundsList().first())

    private val _errorName = MutableLiveData<Boolean>()
    val errorName: LiveData<Boolean> = _errorName

    private val _errorTitle = MutableLiveData<Boolean>()
    val errorTitle: LiveData<Boolean> = _errorTitle

    private val _errorText = MutableLiveData<Boolean>()
    val errorText: LiveData<Boolean> = _errorText

    val model: SettingModel

    init {
        val backgroundDrawable = repository.getBackground(backgroundsIterator.get())
        val imageDrawable = repository.getImage(imagesIterator.get())
        model = SettingModel("Name", "Title", "Texttexttexttext", imageDrawable, backgroundDrawable)
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
        viewModelScope.launch {
            model.imageDrawable = repository.getImage(imagesIterator.next().get())
        }
    }

    fun getPreviousImage() {
        viewModelScope.launch {
            model.imageDrawable = repository.getImage(imagesIterator.prev().get())
        }
    }

    fun getNextBackground() {
        viewModelScope.launch {
            model.backgroundDrawable =
                repository.getBackground(backgroundsIterator.next().get())
        }
    }

}
