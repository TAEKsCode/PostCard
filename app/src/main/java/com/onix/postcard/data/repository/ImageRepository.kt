package com.onix.postcard.data.repository

import android.graphics.drawable.Drawable

interface ImageRepository {

    fun getImage(imageName: String): Drawable

    fun getBackground(backgroundName: String): Drawable

}