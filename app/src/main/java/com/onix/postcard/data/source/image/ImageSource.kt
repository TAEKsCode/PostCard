package com.onix.postcard.data.source.image

import android.graphics.Bitmap
import android.graphics.drawable.Drawable

interface ImageSource {

    fun getBitmap(name: String): Bitmap

    fun list(): ArrayList<String>

    fun getDrawable(name: String): Drawable
}
