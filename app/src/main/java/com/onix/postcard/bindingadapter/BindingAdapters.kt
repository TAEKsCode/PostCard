package com.onix.postcard.bindingadapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.onix.postcard.BuildConfig
import com.onix.postcard.R

@BindingAdapter("errorMessage")
fun TextInputLayout.errorMessage(errorState: Boolean) {
    error = if (errorState) {
        resources.getString(R.string.field_is_empty)
    } else ""
}

@BindingAdapter("setImageFromAssets")
fun ImageView.setImageFromAssets(imageName: String) {
    setImageDrawable(Drawable.createFromStream(resources.assets.open("${BuildConfig.FOO_STRING}/$imageName"), null))
}
