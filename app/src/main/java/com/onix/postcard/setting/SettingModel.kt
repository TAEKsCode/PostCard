package com.onix.postcard.setting

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.onix.postcard.BR
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SettingModel(
    private var _name: String = "",
    private var _title: String = "",
    private var _text: String = ""
) : BaseObservable(), Parcelable {

    @get:Bindable
    var name: String = _name
        set(value) {
            _name = value
            field = value
            notifyPropertyChanged(BR.name)
        }


    @get:Bindable
    var title: String = _title
        set(value) {
            _title = value
            field = value
            notifyPropertyChanged(BR.title)
        }


    @get:Bindable
    var text: String = _text
        set(value) {
            _text = value
            field = value
            notifyPropertyChanged(BR.text)
        }

    fun isError() = _name.isEmpty() || _title.isEmpty() || _text.isEmpty()

}