package com.onix.postcard.bindingadapter

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.onix.postcard.R

@BindingAdapter("errorMessage")
fun TextInputLayout.errorMessage(errorState: Boolean) {
    error = if (errorState) {
        resources.getString(R.string.field_is_empty)
    } else ""
}