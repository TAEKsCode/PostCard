package com.onix.postcard.ui.setting

import android.graphics.drawable.Drawable
import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.onix.postcard.BR
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class SettingModel(
    private var _name: String = "",
    private var _title: String = "",
    private var _text: String = "",
    private var _imageDrawable: @RawValue Drawable,
    private var _backgroundDrawable: @RawValue Drawable
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


    @get:Bindable
    var imageDrawable: Drawable = _imageDrawable
        set(value) {
            _imageDrawable = value
            field = value
            notifyPropertyChanged(BR.imageDrawable)
        }

    @get:Bindable
    var backgroundDrawable: Drawable = _backgroundDrawable
        set(value) {
            _backgroundDrawable = value
            field = value
            notifyPropertyChanged(BR.backgroundDrawable)
        }

    fun isError() =
        _name.isEmpty() || _title.isEmpty() || _text.isEmpty()

}